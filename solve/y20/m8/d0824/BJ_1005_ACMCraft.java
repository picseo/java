package d0824;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1005_ACMCraft {
	static int N, K, W;
	static int[] times;
	static boolean[][] line;
	static int[] ingreed;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while((T--) > 0) {
			N = sc.nextInt();
			K = sc.nextInt();

			times = new int[N+1];
			ingreed = new int[N+1];
			int[] result = new int[N+1];
			for(int i = 1; i <= N; i++) {
				times[i] = sc.nextInt();
			}
			
			line = new boolean[N+1][N+1];
			
			for(int i = 0; i < K; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				line[from][to] = true;
				ingreed[to]++;
			}

			W = sc.nextInt();
			
			Queue<Integer> q = new LinkedList();
			
			for(int i = 1; i <= N; i++) {
				if(ingreed[i] == 0) {
					q.add(i);
					result[i] = times[i];
				}
			}
			
			while(!q.isEmpty()) {
				int now = q.poll();
				if(now == W) {
					break;
				}
				for(int i = 1; i <= N; i++) {
					if(line[now][i]) {
						result[i] = Math.max(result[i], result[now] + times[i]);
						if(--ingreed[i] == 0) {
							q.add(i);
						}
					}
				}
			}
			
			System.out.println(result[W]);
		}//while testcase

	}//main

}//class
