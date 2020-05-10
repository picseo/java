package d0510;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
//이전에는 다익스트라는 정점의 갯수만큼 수행했는데, 
//2번만 수행하면 풀 수 있는 방법이 있었다.
//입력되는 선들을 반대로 저장하는 list를 하나 더 만들어서 
//그 값들을 가지고, x를 시작점으로 하는 다익스트라를 수행해주면
//결국에는 다른 정점들에서 x로 오는 길의 최소값을 알 수 있게 된다.

public class BJ_1238_파티_dijkstra_update {
	static int N, M, X;
	static int[] res;
	static final int MAX = 200000;
	
	static class Point implements Comparable<Point>{
		int to, val;

		public Point(int to, int val) {
			this.to = to;
			this.val = val;
		}		

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.val,  o.val);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		
		res = new int[N+1];
		List<Point>[] list = new List[N+1];
		List<Point>[] back = new List[N+1];
		
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList();
			back[i] = new ArrayList();
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int val = sc.nextInt();
			
			list[from].add(new Point(to, val));
			back[to].add(new Point(from, val));
		}
		
		toX(X, list);
		toX(X, back);
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			result = Math.max(result,  res[i]);
		}
		
		System.out.println(result);
	}

	private static void toX(int start, List<Point>[] list) {
		int[] dist = new int[N+1];
		PriorityQueue<Point> pq = new PriorityQueue();
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(dist, MAX);
		dist[start] = 0;
		
		for(int i =1 ; i < N+1; i++) {
			if(i == start) {
				pq.add(new Point(i, 0));
			}else {
				pq.add(new Point(i, MAX));
			}
		}
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
 
//			if(dist[now.to] < now.val) {
//				continue;
//			}
			
			for(Point next : list[now.to]) {
				if(!visited[next.to] && dist[next.to] > dist[now.to] + next.val) {
					dist[next.to] = dist[now.to] + next.val;
					pq.add(new Point(next.to, dist[next.to]));
				}
			}
			visited[now.to] = true; 
		}
		
		if(start != X) {
			res[start] += dist[X];
		}else {
			for(int i = 1; i <= N; i++) {
				res[i] += dist[i];
			}
		}
	}

}
