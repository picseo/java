package d0927;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ACMcraft_복습 {
	static int N, K;
	static int[] times;
	static boolean[][] lines;
	static int[] cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		while((T--)>0) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			times = new int[N+1];
			for(int i = 1; i < N+1; i++) {
				times[i] = sc.nextInt();
			}
			
			lines = new boolean[N+1][N+1];
			cnt = new int[N+1];
			
			for(int i = 0; i < K; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				lines[to][from] = true; // from -> to, to를 지으려면 from을 먼저 지어야 한다.
				cnt[from]++;
			}
			
			int start = sc.nextInt();
			
			Queue<Integer> que = new LinkedList<Integer>();
			que.add(start);
			int result = times[start];
			
			
			while(!que.isEmpty()) {
				int now = que.poll();
				
				int maxt = 0;
				for(int i = 1; i < N+1; i++) {
					if(lines[now][i]) {
						maxt = Math.max(maxt, times[i]);
					}
					que.add(i);
				}
				result += maxt;
			}
			
			sb.append(result).append('\n');
		}
		
		System.out.println(sb.toString());
		
	}
}
