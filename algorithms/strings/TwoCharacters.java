package strings;

import java.util.Scanner;

public class TwoCharacters {
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
		//https://www.hackerrank.com/challenges/two-characters?h_r=next-challenge&h_v=zen
		int len = getNextInt();
		String s = getNextLine();
		int[] c = new int[26];
		for(int cc:s.toCharArray()){
			char ccc =(char) cc;
			c[ccc-'a']+=1;
		}
		int max = Integer.MIN_VALUE;
		String residue = "";
		for(int i=0; i<26;++i){
			for(int j=0; j<26&& i!=j;++j){
				StringBuilder sb = new StringBuilder("");
				int a = i;
				int b = j;
				for(int k=0; k<s.length(); ++k){
					int sub = s.charAt(k)-'a';
					if(sub == a || sub == b){
						char cc = (char) ('a'+ sub);
						sb.append(cc);
					}
				}
				if(isAlternate(sb.toString()) && (max<sb.toString().length())){
					max = sb.toString().length();
					residue = sb.toString();
				}
			}
		}
		if(Integer.MIN_VALUE == max){
			System.out.println(0);
		}
		else{
			System.out.println(max);
			System.out.println(residue);
		}
		
	}

	private static boolean isAlternate(String string) {
		// TODO Auto-generated method stub
		if(string == null || "".equals(string) || string.length() ==1){
			return false;
		}
		int a = string.charAt(0);
		int b = string.charAt(1);
		int check = a;
		for(int i=2; i<string.length(); ++i){
			int x = string.charAt(i);
			if(check!=x){
				return false;
			}else{
				check = check ==a ?b:a; 
			}
		}
		return true;
	}
}












