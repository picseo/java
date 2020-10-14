package d0825;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_1005_ACMCraft_recur {	
	static int N, K, W;
	static int[] times;
	static ArrayList<Integer>[] needs;
	static int[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while((T--) > 0) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			times = new int[N+1];
			needs = new ArrayList[N+1];
			
			for(int i = 1; i < N+1; i++) {
				times[i] = sc.nextInt();
				needs[i] = new ArrayList();
			}
			
			for(int i = 0; i < K; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				needs[to].add(from);
			}
			
			W = sc.nextInt();
			memo = new int[N+1];
			Arrays.fill(memo, -1);
			
			System.out.println(find(W));						
		}
		
	}

	private static int find(int w) {
		if(memo[w] != -1) {
			return memo[w];
		}
		
		int ret = 0;
		for(int need : needs[w]) {
			ret = Math.max(ret, find(need));
		}
		
		ret += times[w];
		memo[w] = ret;
		return memo[w];
	}
}
