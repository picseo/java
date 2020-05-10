package d0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 최단 경로중 최대인 경우를 구하기 위해 일단 다 해봐야 한다.
 
 그런데 graph의 모든 간선들에 대해 확인하기에는 시간이 초과된다.
 
 방법은 일단 graph에서 dijkstra를 실행하여 최단 경로를 알아낸다.
 
 그후 최단 경로에 속하는 선들을 하나씩 없앤 상태에서 dijkstra를 돌리면서 최단 경로의 값을 알아내도
 그것을 매번 비교하여 최대값이 될때를 저장한다.
 * */
public class BJ_2325_개코전쟁_again {
	static int N, M;
	static List<Point>[] graph;
	static int[] parents;
	static final int MAX = 987654321;

	static class Point implements Comparable<Point>{
		int to, val;

		Point(int to, int val) {
			this.to = to;
			this.val = val;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.val, o.val);
		}		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//입력 정보로 그래프 생성
		graph = new List[N+1];
		for(int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			graph[from].add(new Point(to, val));
			graph[to].add(new Point(from,val));
		}

		//최단 경로 를 구함
		parents = new int[N+1];

		dijkstra(0, 0);
		//System.out.println(Arrays.toString(parents));
		//완탐
		int result = 0;
		int start = N;
		while(parents[start] != 0) {
			int tmp = dijkstra(start, parents[start]);
			result = Math.max(result,  tmp);
			start = parents[start];
		}

		System.out.println(result);
	}

	private static int dijkstra(int start, int to) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Point> pq = new PriorityQueue();
		int[] dist = new int[N+1];

		Arrays.fill(dist, MAX);
		dist[1] = 0;

		pq.add(new Point(1, 0));
		while(!pq.isEmpty()) {
			Point now = pq.poll();

			for(Point next : graph[now.to]) {
				if(next.to == start && now.to == to) {
					continue;
				}
				if(next.to == to && now.to == start) {
					continue;
				}

				if(!visited[next.to] && dist[next.to] > dist[now.to] + next.val) {
					if(start == 0 && to == 0) {
						parents[next.to] = now.to; 
					}
					dist[next.to] = dist[now.to] + next.val;
					pq.add(new Point(next.to, dist[next.to]));
				}
			}

			visited[now.to]= true; 
		}

		return dist[N];
	}

}
