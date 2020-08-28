package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 그래프 생성하기 -> LinkedList를 이용
 * 
 * 그래프 만드는 방법
 * List[] graph : List배열을 만든다
 * 
 * for문을 돌면서 각 값마다 ArrayList를 할당해준다.
 * 
 * dfs는 함수 시작부분에서 처리를 하면 된다.(문제마다 다르긴하지만)
 */
public class BJ_1260_DFS와BFS_복습 {
	static int N, M;
	static List[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		int V = Integer.parseInt(tokens.nextToken());
		
		//그래프 할당
		graph = new List[N+1];
		for(int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		//그래프 생성
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		for(int i = 1; i <= N; i++) {
			graph[i].sort(null);
		}
		
		//DFS
		visited = new boolean[N+1];
		dfs(V);
		
		sb.append("\n");
		//BFS
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb.toString());
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			sb.append(next+" ");
			
			for(int i = 0; i < graph[next].size(); i++) {
				int nnext = (int)graph[next].get(i);
				
				if(!visited[nnext]) {
					visited[nnext] = true;
					queue.add(nnext);
				}
			}
		}		
	}

	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v+" ");
		
		for(int i = 0; i < graph[v].size(); i++) {
			int next = (int) graph[v].get(i);
			
			if(!visited[next]) {
				dfs(next);
			}
		}
	}

	
}
