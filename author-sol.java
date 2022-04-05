import java.io.*;
import java.util.*;

public class Main {
	
	static FastReader in; 
	
	public static void main(String[] args) {
		in = new FastReader();
		int tc = 1;
		tc = in.nextInt();
		for(int t = 0; t < tc; t++) {
			new Solver();
		}
	}
	
	static class Solver {
		Solver() {
			// input
			long A = in.nextLong();
			
			long d1, d2, profit, maxProfit;
			d1 = d2 = profit = maxProfit = 0;
			
			// brute-force approach
			// on every iteration (day), keep on checking if the profit (friend - chef)
			// is still greater than or equal to 0 and save the day wherein the maximum profit was produced
			// note: the value that chef gives does not accumulate
			for(d1 = 0; ;d1++) {
				profit -= (1L << d1);
				profit += A;
				if(profit <= 0) {
					break;
				}
				if(profit > maxProfit) {
					maxProfit = profit;
					d2 = d1;
				}
			}
			
			// output
			System.out.println(d1 + " " + (d2 + 1));
		}
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
