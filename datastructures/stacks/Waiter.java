package stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Waiter {
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

	public static void main(String[] args) {
		List<Stack<Integer>> B = new ArrayList<Stack<Integer>>();
		Stack<Integer> residue = new Stack<>();
		int[] arr = getNextIntegerArray();
		int n = arr[0];
		int q = arr[1];
		arr = getNextIntegerArray();
		for(int i: arr){
			residue.push(i);
		}
		Prime p = new Prime();
		for(int i=1; i<= q;++i){
			Stack<Integer> btemp = new Stack<>();
			Stack<Integer> atemp = new Stack<>();
			int aPrime = p.get(i);
			while(!residue.isEmpty()){
				int a = residue.pop();
				if(a%aPrime == 0){
					btemp.push(a);
				}else{
					atemp.push(a);
				}
			}
			residue = atemp;
			B.add(btemp);
		}
		B.add(residue);
		for(Stack<Integer>s : B){
			while(!s.isEmpty()){
				System.out.println(s.pop());
			}
		}
	}
}

class Prime{
	Map<Integer,Integer> map;
	int lastPrime = 0;
	int lastPrimeIndex = 0;
	
	public Prime(){
		map = new HashMap<Integer,Integer>();
		map.put(1, 2);
		lastPrime = 2;
		lastPrimeIndex = 1;
	}
	public int get(int index ){
		int cur = map.get(index);
		if(map.get(index) == null){
			//that means that the last prime number found is less than the current number required
			for(int i=lastPrime+1; lastPrimeIndex<= index; ++i){
				if(isPrime(i)){
					++lastPrimeIndex;
					lastPrime = i;
					map.put(lastPrimeIndex, lastPrime);
				}
			}
		}
		
		return map.get(index);
	}
	private boolean isPrime(int ii) {
		for(int i=0; i<= lastPrimeIndex; ++i){
			if(ii%(map.get(i))==0){
				//that means it is divisible by it
				return false;
			}
		}
		return true;
	}
}












