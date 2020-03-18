package d0317;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/*
 * dfs, bfs 기본 문제였다.
 * */
public class BJ_1260 {
	static int N, M, V;
	static List<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt()-1;

		graph = new List[N];
		for(int i = 0;i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt()-1;
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		for(int i = 0; i < N; i++) {
			graph[i].sort(null);
		}
		
		visited = new boolean[N];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N];
		bfs(V);
		System.out.println(sb);
	}

	private static void dfs(int start) {
		visited[start] = true;
		sb.append(start+1).append(" ");
		
		for(int i = 0; i < graph[start].size(); i++) {
			int next = graph[start].get(i);
			if(!visited[next]) {
				dfs(next);
			}
		}
		return ;
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		sb.append(start+1).append(" ");
		visited[start] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i =0 ; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
					sb.append(next+1).append(" ");
				}
			}
		}	
	}
	
	private static String src = "1000 1 1000\r\n" + 
			"999 1000";
}
