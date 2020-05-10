package d0509;

import java.util.Arrays;
import java.util.Scanner;
//플로이드 와샬?은 c++일때만 시간안에 들어가나보다.....
//다익스트라로 풀어야겠다.
public class BJ_1238_파티_fluid {
	static int N, M, X;
	static int[][] graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		
		graph = new int[N+1][N+1];
		for(int i = 0; i < N+1; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
			graph[i][i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int val = sc.nextInt();
			
			graph[from][to] = val;
		}
		
		for(int m = 1; m <= N; m++) {//중간값
			for(int s = 1; s <= N; s++) {//시작값
				for(int e = 1; e <= N; e++) {//끝값
					if(graph[s][m] != Integer.MAX_VALUE && graph[m][e] != Integer.MAX_VALUE)
						graph[s][e] = Math.min(graph[s][e], graph[s][m] + graph[m][e]);
				}
			}
		}
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			int tmp = graph[i][X] + graph[X][i];
			if(result < tmp);
				result = tmp;
		}
		
		System.out.println(result);
	}

}
