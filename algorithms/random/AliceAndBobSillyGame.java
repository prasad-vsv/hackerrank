package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AliceAndBobSillyGame {
	static Scanner s = new Scanner(System.in);
	static List<Integer> list = new ArrayList<>();
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
		//https://www.hackerrank.com/challenges/alice-and-bobs-silly-game
		int n = getNextInt();
		for(int i=0; i<n;++i){
			System.out.println(getWinner(getNextInt()));
		}
	}

	private static String getWinner(int a) {
		int n = getPrimes(a);
		if(n%2==0){
			return "Bob";
		}else{
			return "Alice";
		}
	}

	private static int getPrimes(int a) {
		if(list.isEmpty()){
			list.add(2);
		}
		int max = list.get(list.size()-1);
		int currentSize = list.size();
		if(max>a){
			int count = 0;
			for(int i=0; i<list.size(); ++i){
				if(list.get(i)>a){
					return count;
				}
				++count;
			}
		}else{
			int count = 0;
			for(int i=max+1;i<=a;++i){
				if(isPrime(i)){
					list.add(i);
					++count;
				}
			}
			return count + currentSize;
		}
		return 0;
	}

	private static boolean isPrime(int a) {
		for(int i:list){
			if(a%i ==0){
				return false;
			}
		}
		return true;
	}
}
