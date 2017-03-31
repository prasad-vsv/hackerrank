package random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CopyOfMinAvgWaitTime {
	static File f = new File("W:\\temp\\1.txt");
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
//		try {
//			s = new Scanner(f);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		int n = getNextInt();
		List<order> orders = new ArrayList<>();
		List<order> finished = new ArrayList<>();
		Map<Integer,order> map = new HashMap<>();
//		PriorityQueue<order> pq = new PriorityQueue<order>(8,new orderComparator());
		TreeSet<order> ts = new TreeSet<>(new orderComparator());
		for(int i=0; i<n; ++i){
			int[] t = getNextIntegerArray();
			order o = new order(t[0],t[1]);
			orders.add(o);
			map.put(o.arrtime, o);
//			pq.add(o);
		}long start = System.currentTimeMillis();
		Collections.sort(orders, new orderArrComparator());
		
		int time = 0;
		boolean isCooking = false;
		int finishTime = -1;
		order current = null;
		
		while(!orders.isEmpty()){
			if(time == finishTime){
				isCooking = false;
			}
			if(map.get(time)!= null){
				ts.add(map.get(time));
				
			}
			if(isCooking){
				++time;
				continue;
			}
			order o = ts.pollFirst();
//			order o = ts.poll();
			if(o!= null){
				o.servStartTime = time;
				o.servEndTime = o.servStartTime + o.preptime;
				orders.remove(o);
				current = o;
				isCooking =  true;
				finishTime = time + o.preptime;
	
				finished.add(current);
			}
			++time;
		}
		
		int avg = 0;
		for(order o : finished){
			int wait = o.servEndTime - o.arrtime;
			avg+= wait;
		}
		System.out.println(avg/finished.size());
		long end = System.currentTimeMillis();
		System.out.println("time taken :" + (end-start));
	}



}

class order{
	int preptime ;
	int arrtime;
	int servStartTime;
	int servEndTime;
	int waitingTime = 0;
	
	
	public order(int a, int p){
		this.arrtime = a;
		this.preptime = p;
	}
	
	public String toString(){
		return "arr:" + arrtime + " prep:"+ preptime + " start:" + servStartTime + " end:" + servEndTime;
	}

	@Override
	public boolean equals(Object a) {
		if(!(a instanceof order)){
			return false;
		}
		order b = (order)a;
		if((this.arrtime != b.arrtime)|| (this.preptime!= b.preptime)){
			return false;
		}
		return true;
	}
	
	
}

class orderComparator implements Comparator<order>{

	@Override
	public int compare(order a, order b) {
		if(a.preptime > b.preptime){
			return 1;
		}else if(a.preptime < b.preptime){
			return -1;
		}
		return 0;
	}
	
}

class orderArrComparator implements Comparator<order>{

	@Override
	public int compare(order a, order b) {
		if(a.arrtime > b.arrtime){
			return 1;
		}else if(a.arrtime < b.arrtime){
			return -1;
		}
		return 0;
	}
	
}