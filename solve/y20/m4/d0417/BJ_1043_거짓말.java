package d0417;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 파티에 참여하는 사람들 정보로 그래프를 생성한 다음에 
 * bfs를 돌려 진실만 들어야 하는 사람들을 visited -> true로 표시한다.
 * 그 후 파티에 참여하는 사람 정보를 체크해서 하나도 진실을 안들어도 되는 사람들만 있을 때만 
 * 과장을 할 수있다고 할 수 있으므로 그때만 result를 ++한다.
 * */
public class BJ_1043_거짓말 {
	static int N, M;
	static boolean[][] graph;
	static boolean[] visited;
	static boolean[] check;
	static int[][] parties;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		graph = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		check = new boolean[N+1];//사실을 아는 사람
		parties = new int[M][N+1];
		
		int num = sc.nextInt();
		for(int i = 0; i < num; i++) {
			int n = sc.nextInt();
			check[n] = true;
		}

		for(int i = 0; i < M; i++) {
			num = sc.nextInt();
			parties[i][0] = num;
			for(int j = 1;  j <= num; j++) {
				parties[i][j] = sc.nextInt();
			}
		}
		
		//graph생성
		for(int i = 0; i < M; i++) {
			for(int j = 1; j <= parties[i][0]-1; j++) {
				for(int k = j+1; k <= parties[i][0]; k++) {
					graph[parties[i][j]][parties[i][k]] = true;
					graph[parties[i][k]][parties[i][j]] = true;
				}
			}
		}
		
		for(int i = 1; i < N+1; i++) {
			if(check[i] && !visited[i]) {
				bfs(i);
			}
		}
		
		int result = 0;
		for(int i = 0; i < M; i++) {
			boolean check = true;
			for(int j = 1; j <= parties[i][0]; j++) {
				if(visited[parties[i][j]]) {
					check = false;
					break;
				}
			}
			
			if(check) {
				result++;
			}
		}
		
		System.out.println(result);
	}

	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList();
		visited[num] = true;
		queue.add(num);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i = 1; i <= N; i++) {
				if(graph[now][i]) {
					if(!visited[i]) {
						visited[i] = true;
						queue.add(i);
					}
				}
			}
		}
	}
}
