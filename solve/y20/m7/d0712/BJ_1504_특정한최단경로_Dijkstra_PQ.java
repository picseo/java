package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 1, v1, v2를 기준으로 다익스트라를 진행한 다음에 
 *  (1->v1) + (v1->v2) +(v2->N) 이랑 (1->v2) + (v2->v1) + (v1->N)
 * 중 에서 값이 작은 걸 출력한다고 생각했다.
 * 
 * 다익스트라 알고리즘
 * 한 정점에서 다른 모든 정점까지의 최단 거리를 구하는 알고리즘
 * 
 * 간선이 많을 때는 pq가 유리하다고 한다
 * 여러번 탐색안해도 되니까 그런건가
 * 
 * 이 코드는 pq를 사용하고 풀었다.
 * 
 * pq 복습해야겠다 이거 너무 복잡해 ㅠㅠ
 */
public class BJ_1504_특정한최단경로_Dijkstra_PQ {
	static class Node implements Comparable<Node>{
		int point, value;

		public Node(int point, int value) {
			this.point = point;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.value, o.value);
		}		
	}
	
	static int N, E;
	static ArrayList<Node>[] graph;
	static int[][] dijkstra;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		dijkstra = new int[3][N+1];
		
		for(int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to, value));
			graph[to].add(new Node(from, value));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		fill_dijkstra(1, 0);
		fill_dijkstra(v1, 1);
		fill_dijkstra(v2, 2);
		
		for(int i = 0; i < 3; i++)
		System.out.println(Arrays.toString(dijkstra[i]));
		
		int one = Integer.MAX_VALUE;
		if(dijkstra[0][v1] != Integer.MAX_VALUE &&
				dijkstra[1][v2] != Integer.MAX_VALUE &&
				dijkstra[2][N] != Integer.MAX_VALUE) {
			one = dijkstra[0][v1] + dijkstra[1][v2] + dijkstra[2][N];
		}
		
		int two = Integer.MAX_VALUE;
		if(dijkstra[0][v2] != Integer.MAX_VALUE &&
				dijkstra[2][v1] != Integer.MAX_VALUE &&
				dijkstra[1][N] != Integer.MAX_VALUE) {
			two = dijkstra[0][v2] + dijkstra[2][v1] + dijkstra[1][N];
		}
		
		int result = (one < two) ? one : two;
		if(result == Integer.MAX_VALUE)
			result = -1;
		
		System.out.println(result);
	}

	private static void fill_dijkstra(int start, int idx) {
		Arrays.fill(dijkstra[idx], Integer.MAX_VALUE);
		dijkstra[idx][start] = 0;
		boolean[] visited = new boolean[N+1];
		Node[] D = new Node[N+1];
		
		PriorityQueue<Node> queue = new PriorityQueue();
		for(int i = 1; i < N+1; i++) {
			if(i == start) {				D[i] = new Node(start, 0);
			}else {
				D[i] = new Node(i, Integer.MAX_VALUE);
			}
			queue.add(D[i]);
		}
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for(Node next : graph[now.point]) {
				if(!visited[next.point] && D[next.point].value > D[now.point].value + next.value) {
					D[next.point].value = D[now.point].value + next.value;
					queue.remove(D[next.point]);
					queue.add(D[next.point]);
				}
			}
			visited[now.point]= true; 
		}		
		
		for(int i = 1; i < N+1; i++) {
			dijkstra[idx][i] = D[i].value;
		}
	}
}
