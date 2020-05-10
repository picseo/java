package d0510;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
//result값을 구하는 부분에서 if문에 ;가 들어가는 바람에 최대 값을 출력하지 않고, 매번 마지막 값을 출력해서 틀렸다.
//진짜 오타 으으으으으으허탈하다
//dist배열을 Point배열로 하였고, visited배열을 사용하였다.
public class BJ_1238_파티_dijkstra_check {
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

		@Override
		public String toString() {
			return "Point [to=" + to + ", val=" + val + "]";
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
			//System.out.println("res["+i+"] : " + res[i]);
			if(result < res[i])
				result = res[i];
			//System.out.println("result : " + result);
		}
		
		System.out.println(result);
	}

	private static void toX(int start) {
		Point[] dist = new Point[N+1];
		PriorityQueue<Point> pq = new PriorityQueue();
		boolean[] visited = new boolean[N+1];
		
		for(int i =1 ; i < N+1; i++) {
			if(i == start) {
				dist[i] = new Point(i, 0);
			}else {
				dist[i] = new Point(i, MAX);
			}
			pq.add(dist[i]);
		}
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			
			for(Point next : list[now.to]) {
				if(!visited[next.to] && dist[next.to].val > dist[now.to].val + next.val) {
                    int nextdist = dist[now.to].val + next.val;
					dist[next.to].val = nextdist;
					
					pq.remove(dist[next.to]);
					pq.add(dist[next.to]);
				}
			}
			visited[now.to] = true;			
		}
		
		
		if(start != X) {
			int tmp = dist[X].val;
			res[start] += tmp;
		}else {
			for(int i = 1; i <= N; i++) {
				int tmp = dist[i].val;
				res[i] += tmp;
			}
		}
	}

}