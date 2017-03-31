package stacks;

import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlants {
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
		// TODO Auto-generated method stub
		int n = getNextInt();
		int[] in = getNextIntegerArray();
		Stack<Integer> s = new Stack<>();
		for(int i=in.length-1; i>=0; --i){
			s.push(in[i]);
		}
		
		Stack<Integer> temp = new Stack<>();
		
		
		int prev = -1;
		int cur= -2;
		int days = 0;
		int _days = days;
		do{
			boolean dead = false;
			while(!s.isEmpty()){
				if(prev == -1){
					prev = s.pop();
					temp.push(prev);
					continue;
				}
				cur = s.pop();
				if(cur > prev){
					//that means more pesticide and hence the plant dies
					//so dont add it to temp stack
					// set dead boolean
					dead = true;
					prev = cur;
					continue;
				}
				prev = cur;
				temp.push(cur);
			}
			if(dead){
				_days = days;
				++days;
			}
			else{
				_days = days;
			}
			//remove contents of s and add back everything in temp into s 
			while(!s.isEmpty()){
				s.pop();
			}
			while(!temp.isEmpty()){
				s.push(temp.pop());
			}
//			s = reverseStack(s);
		}while(_days != days);
		System.out.println(days);

	}
	
	public static Stack<Integer> reverseStack(Stack<Integer> s){
		Stack<Integer> temp = new Stack<Integer>();
		while(!s.isEmpty()){
			temp.push(s.pop());
		}
		return temp;
	}
}
