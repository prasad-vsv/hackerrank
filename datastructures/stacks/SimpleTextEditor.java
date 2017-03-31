package stacks;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
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

	public static void printArray(Object[] objs){
		for(Object o:objs){
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
	static Stack<Operation> lastOps = new Stack<Operation>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int ops = Integer.parseInt(s.nextLine());
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i< ops ;++i){
            String[] in = s.nextLine().split(" ");
            if("1".equals(in[0])){
                char[] _in = push(stack, in[1]);
                Operation o = new Operation();
                o.lastIn = _in;
                o.lastOpCode = 1;
                lastOps.push(o);
            }
            else if ("2".equals(in[0])){
                char[] _in = pop(stack, in[1]);
                Operation o = new Operation();
                o.lastIn = _in;
                o.lastOpCode = 2;
                lastOps.push(o);
            }
            else if("3".equals(in[0])){
                char c = print(stack, in[1]);
                System.out.println(c+"");
            }
            else{
            	//revert ops
            	Operation o = lastOps.pop();
            	if(o.lastOpCode == 1){
            		//it was added. now remove
            		pop(stack, o.lastIn.length+ "");
            	}
            	else if(o.lastOpCode == 2){
            		//it was removed, now add
            		char[] temp = new char[o.lastIn.length];
            		for(int a=0; a<temp.length; ++a  ){
            			temp[a] = o.lastIn[temp.length -a -1];
            		}
            		String in_ = new String(temp);
            		push(stack, in_);
            	}
            }
        }
	}
	
    public static char[] push(Stack<Character> stack, String in){
        for(Character c : in.toCharArray()){
            stack.push(c);
        }
        return in.toCharArray();
    }
    
    public static char[] pop(Stack<Character> stack, String in){
        int toDelete = Integer.parseInt(in);
        char[] c = new char[toDelete];
        for(int i=0; i< toDelete;++i){
            c[i] = stack.pop();
        }
        return c;
    }
    
    public static char print(Stack<Character> stack, String in){
    	return stack.elementAt(Integer.parseInt(in) -1);
    }
    
    
}

class Operation {
    int lastOpCode;
    char[] lastIn;
}