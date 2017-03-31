package trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;
public class KittyCalcs {
	static Scanner s = new Scanner(System.in);

	public static int getNextInt() {
		return Integer.parseInt(s.nextLine());
	}

	public static long getNextLong() {
		return Long.parseLong(s.nextLine());
	}

	public static int[] getNextIntegerArray() {
		String line = s.nextLine();
		String[] tokens = line.split(" ");
		int[] input = new int[tokens.length];
		for (int i = 0; i < tokens.length; ++i) {
			input[i] = Integer.parseInt(tokens[i]);
		}
		return input;
	}

	public static long[] getNextLongArray() {
		String line = s.nextLine();
		String[] tokens = line.split(" ");
		long[] input = new long[tokens.length];
		for (int i = 0; i < tokens.length; ++i) {
			input[i] = Long.parseLong(tokens[i]);
		}
		return input;
	}

	public static String getNextLine() {
		return s.nextLine();
	}

	public static String[] getNextStringArray() {
		String line = s.nextLine();
		String[] tokens = line.split(" ");
		return tokens;
	}

	public static void printArray(Object[] objs) {
		for (Object o : objs) {
			System.out.println(o);
		}
	}

	public static int max(int i, int j) {
		if (i > j) {
			return i;
		}
		return j;
	}

	public static String max(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		}
		return s2;
	}

	public static int max(int i, int j, int k) {
		if (i > j) {
			if (i > k) {
				return i;
			} else {
				return k;
			}
		}
		if (j > k) {
			return j;
		} else {
			return k;
		}

	}

	public static String max(String s1, String s2, String s3) {
		int i = s1.length(), j = s2.length(), k = s3.length();
		if (i > j) {
			if (i > k) {
				return s1;
			} else {
				return s3;
			}
		}
		if (j > k) {
			return s2;
		} else {
			return s3;
		}
	}

	public static int min(int i, int j) {
		if (i < j) {
			return i;
		}
		return j;
	}

	public static String min(String s1, String s2) {
		if (s1.length() < s2.length()) {
			return s1;
		}
		return s2;
	}

	public static int min(int i, int j, int k) {
		if (i < j) {
			if (i < k) {
				return i;
			} else {
				return k;
			}
		}
		if (j < k) {
			return j;
		} else {
			return k;
		}

	}

	public static String min(String s1, String s2, String s3) {
		int i = s1.length(), j = s2.length(), k = s3.length();
		if (i < j) {
			if (i < k) {
				return s1;
			} else {
				return s3;
			}
		}
		if (j < k) {
			return s2;
		} else {
			return s3;
		}
	}
	static Map<Integer,node> map = new HashMap<>();
	static node root = null;
	static int[][] distances ;
	public static void main(String[] args) {
		
		//https://www.hackerrank.com/challenges/kittys-calculations-on-a-tree
		try {
			s= new Scanner(new File("W:\\temp\\1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] t = getNextIntegerArray();
		int n = t[0];
		int k = t[1];
//		distances = new int[n][n];
		//construct the tree
		for(int i=0; i<n-1&&s.hasNext(); ++i){
			t = getNextIntegerArray();
			if(root == null){
				root = new node(null,t[0]);
				node temp = new node(root,t[1]);
				root.children.add(temp);
				map.put(t[0], root);
				map.put(t[1], temp);
				continue;
			}
			node parent = null;
			node child = null;
//			parent = map.get(t[0]);
//			child = new node(parent,t[1]);
//			parent.children.add(child);
//			map.put(t[1], child);
			if(map.get(t[0])!= null){
				parent = map.get(t[0]);
				child = new node(parent,t[1]);
				parent.children.add(child);
				map.put(t[1], child);
			}else{
				parent = map.get(t[1]);
				child = new node(parent,t[0]);
				parent.children.add(child);
				map.put(t[0],child);
			}
		}
		//fill the matrix
		
//		filldistances(distances);
		
		//now calculate
		for(int i=0; i<k; ++i){
			int m = getNextInt();
			int[] arr = getNextIntegerArray();
			System.out.println(calculate(arr,distances));
		}

	}
	static final int modulus = (int) (Math.pow(10, 9)+7);
	private static String calculate(int[] arr, int[][] distances) {
		int value =0;
		
		for(int i=0; i<arr.length;++i){
			int a = arr[i];
			for(int j=i+1; j<arr.length;++j){
				int b = arr[j];
				if(i!=j && a!=b){
					int distance = findlca(map.get(a-1),map.get(b-1));
					int temp = (a*b*distance)%modulus; 
					value += temp;
					value = value %modulus;
				}
			}
		}

		return value+"";
	}

	private static int getDistance(int i, int j) {
		if(i>j){
			int temp = i;
			i = j;
			j =i;
		}
		if(distances[i][j]== 0&& i!=j){
			int dist = findlca(map.get(i),map.get(j));
			distances[i][j] = dist;
			return dist;
		}else{
			return distances[i][j];
		}
	}

	private static List<Integer[]> getPossibleSets(int[] arr) {
		List<Integer[]> sets = new ArrayList<>();
		for(int i=0; i<arr.length;++i){
			int a = arr[i];
			for(int j=i+1; j<arr.length;++j){
				int b = arr[j];
				if(i!=j && a!=b){
					Integer[] z = new Integer[2];
					z[0]=a;
					z[1]=b;
					sets.add(z);
				}
			}
		}
		return sets;
	}

	private static void filldistances(int[][] distances) {
		
		for(int i=0; i<distances.length;++i){
			node n1 = map.get(i+1);
			for(int j=i; j<distances.length;++j){
				node n2 = map.get(j+1);
				if(n1.equals(n2)){
					distances[n1.value-1][n2.value-1] = 0;
					continue;
				}
//				node lca = findlca(n1,n2);
//				int d1 = findDistance(lca,n1);
//				int d2 = findDistance(lca,n2);
				int dist = findlca(n1,n2);
				distances[n1.value-1][n2.value-1] = dist;
//				distances[n1.value-1][n2.value-1] = d1+d2;
			}
		}
	}

//	private static int findDistance(node lca, node a) {
//		node temp = a;
//		int distance=0;
//		while(null!= temp && !temp.equals(lca)){
//			temp = temp.parent;
//			++distance;
//		}
//		return distance;
//	}

	private static int findlca(node n1, node n2) {
		int dist =0;
		node temp = n1;
		Stack<node> s1 = new Stack<>();
		Stack<node> s2 = new Stack<>();
		int x1 = 0;
		int x2 =0;
		while(null!= temp){
			s1.push(temp);
			temp = temp.parent;
			++x1;
		}
		temp = n2;
		while(null!=temp){
			s2.push(temp);
			temp = temp.parent;
			++x2;
		}
		node prev = root;
		int x= 0;
		while(!s1.isEmpty()&& !s2.isEmpty()){
			node t1 = s1.pop();
			node t2 = s2.pop();
			if(t1.equals(t2)){
				prev = t1;
				++x;
			}else{
				break;
			}
			
		}
		return x1+x2-(2*x);
	}
}

class node{
	node parent;
	List<node> children = new ArrayList<>();
	int value;
	
	public node(node parent,int value){
		this.parent = parent;
		this.value = value;
	}
	
	@Override
	public boolean equals(Object a) {
		if(!(a instanceof node)){
			return false;
		}
		node b = (node)a;
		if( this.value!= b.value ){
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "parent: " + parent + " value: "+ value + " children: " + children.toString();
	}
	
}
























