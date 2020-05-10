package d0510;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
//플로이드 와샬?은 c++일때만 시간안에 들어가나보다.....
//다익스트라로 풀어야겠다.
//dist를 int배열, visited배열을 사용하였다.
public class BJ_1238_파티_dijkstra2 {
	static int N, M, X;
	static int[] res;
	static List<Point>[] list;
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
		list = new List[N+1];
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList();
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int val = sc.nextInt();
			
			list[from].add(new Point(to, val));
		}
		
		for(int i = 1; i < N+1; i++) {
			toX(i);
		}
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			result = Math.max(result,  res[i]);
		}
		
		System.out.println(result);
	}

	private static void toX(int start) {
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
