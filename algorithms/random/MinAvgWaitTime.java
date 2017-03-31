//package random;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.math.BigInteger;
//import java.util.*;
//
//public class MinAvgWaitTime {
//	static File f = new File("W:\\temp\\1.txt");
//	static Scanner s = null;
//
//	public static int getNextInt() {
//		return Integer.parseInt(s.nextLine());
//	}
//
//	public static long getNextLong() {
//		return Long.parseLong(s.nextLine());
//	}
//
//	public static int[] getNextIntegerArray() {
//		String line = s.nextLine();
//		String[] tokens = line.split(" ");
//		int[] input = new int[tokens.length];
//		for (int i = 0; i < tokens.length; ++i) {
//			input[i] = Integer.parseInt(tokens[i]);
//		}
//		return input;
//	}
//
//	public static long[] getNextLongArray() {
//		String line = s.nextLine();
//		String[] tokens = line.split(" ");
//		long[] input = new long[tokens.length];
//		for (int i = 0; i < tokens.length; ++i) {
//			input[i] = Long.parseLong(tokens[i]);
//		}
//		return input;
//	}
//
//	public static String getNextLine() {
//		return s.nextLine();
//	}
//
//	public static String[] getNextStringArray() {
//		String line = s.nextLine();
//		String[] tokens = line.split(" ");
//		return tokens;
//	}
//
//	public static void printArray(Object[] objs) {
//		for (Object o : objs) {
//			System.out.println(o);
//		}
//	}
//
//	public static int max(int i, int j) {
//		if (i > j) {
//			return i;
//		}
//		return j;
//	}
//
//	public static String max(String s1, String s2) {
//		if (s1.length() > s2.length()) {
//			return s1;
//		}
//		return s2;
//	}
//
//	public static int max(int i, int j, int k) {
//		if (i > j) {
//			if (i > k) {
//				return i;
//			} else {
//				return k;
//			}
//		}
//		if (j > k) {
//			return j;
//		} else {
//			return k;
//		}
//
//	}
//
//	public static String max(String s1, String s2, String s3) {
//		int i = s1.length(), j = s2.length(), k = s3.length();
//		if (i > j) {
//			if (i > k) {
//				return s1;
//			} else {
//				return s3;
//			}
//		}
//		if (j > k) {
//			return s2;
//		} else {
//			return s3;
//		}
//	}
//
//	public static int min(int i, int j) {
//		if (i < j) {
//			return i;
//		}
//		return j;
//	}
//
//	public static String min(String s1, String s2) {
//		if (s1.length() < s2.length()) {
//			return s1;
//		}
//		return s2;
//	}
//
//	public static int min(int i, int j, int k) {
//		if (i < j) {
//			if (i < k) {
//				return i;
//			} else {
//				return k;
//			}
//		}
//		if (j < k) {
//			return j;
//		} else {
//			return k;
//		}
//
//	}
//
//	public static String min(String s1, String s2, String s3) {
//		int i = s1.length(), j = s2.length(), k = s3.length();
//		if (i < j) {
//			if (i < k) {
//				return s1;
//			} else {
//				return s3;
//			}
//		}
//		if (j < k) {
//			return s2;
//		} else {
//			return s3;
//		}
//	}
//
//	public static void main(String[] args) {
//		try {
//			s = new Scanner(f);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int n = getNextInt();
//		List<order> finished = new ArrayList<>();
//		List<order> orders = new ArrayList<>();
//		Map<Integer,order> map = new HashMap<>();
//		PriorityQueue<order> pq = new PriorityQueue<>(8,new orderComparator());
//		for(int i=0; i<n; ++i){
//			int[] t = getNextIntegerArray();
//			order o = new order(new BigInteger(t[0]+""),new BigInteger(t[1]+""));
//			map.put(Integer.parseInt(o.arrtime.toString()), o);
//			orders.add(o);
//		}
//		Collections.sort(orders,new orderArrComparator());
//		
//		
//		BigInteger time = new BigInteger("0");
//		boolean isCooking = false;
//		BigInteger finishTime = new BigInteger(-1+"");
//		
//		while(!orders.isEmpty()){
////			System.out.println(time);
//			if(time.equals(finishTime)){
//				isCooking = false;
//			}
//			if(map.get(time)!= null){
//				pq.add(map.get(time));
//			}
//			if(isCooking){
//				time = time.add(new BigInteger("1"));
//				continue;
//			}
//			order o = pq.poll();
//			if(o!=null){
//				o.servEndTime = time.add( o.preptime);
//				orders.remove(o.arrtime);
//				isCooking =  true;
//				finishTime = time.add(o.preptime);
//				finished.add(o);
//				
//			}
//			time = time.add(new BigInteger("1"));
//		}
//		
//		BigInteger avg = new BigInteger("0");
//		for(order o : finished){
//			BigInteger wait = o.servEndTime.subtract(o.arrtime);
//			avg = avg.add(wait);
//		}
//		
//		System.out.println(avg.divide(new BigInteger(finished.size()+"")).toString());
//		
//	}
//
//
//
//}
///*
//class order{
//	BigInteger preptime ;
//	BigInteger arrtime;
//	BigInteger servEndTime;
//	BigInteger waitingTime = new BigInteger("0");
//	
//	
//	public order(BigInteger a, BigInteger p){
//		this.arrtime = a;
//		this.preptime = p;
//	}
//	
//	public String toString(){
//		return "arr:" + arrtime + " prep:"+ preptime + " end:" + servEndTime;
//	}
//
//	@Override
//	public boolean equals(Object a) {
//		if(!(a instanceof order)){
//			return false;
//		}
//		order b = (order)a;
//		if((this.arrtime != b.arrtime)|| (this.preptime!= b.preptime)){
//			return false;
//		}
//		return true;
//	}
//	
//	
//}
//
//class orderComparator implements Comparator<order>{
//
//	@Override
//	public int compare(order a, order b) {
//		return a.preptime.compareTo(b.preptime);
//	}
//	
//}
//
//class orderArrComparator implements Comparator<order>{
//
//	@Override
//	public int compare(order a, order b) {
//		return a.arrtime.compareTo(b.arrtime);
//	}
//	
//}*/