package d0522;

import java.util.*;
//다익스트라!!!!!잊지말기!!!!!!!
//중간값을 class값으로 저장하자
public class BJ_1916_최소비용구하기_Dijkstra_PQ {
	static int N, M;
	static List<Point>[] list;
	static Point[] result;
	
	static class Point implements Comparable<Point>{
		int to;
		long len;
		Point(int to, long len) {
			this.to = to;
			this.len = len;
		}		
		
		public int compareTo(Point o) {
			return Long.compare(this.len, o.len);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
	//4013 swea
	//	3234 swea
	
		list = new List[N+1];
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Point>();
		}
		
		for(int i = 0; i < M ; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			long len = sc.nextLong();
			
			list[start].add(new Point(end, len));
		}
		
		int st = sc.nextInt();
		int ed = sc.nextInt();
		
		boolean[] visited = new boolean[N+1];
		result = new Point[N+1];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) {
			if(st == i) {
				result[i] = new Point(i, 0);
			}else {
				result[i] = new Point(i, Long.MAX_VALUE);
			}
			pq.add(result[i]);
		}
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();

			visited[now.to]= true; 
			for(Point next : list[now.to]) {
				int nto = next.to;
				long plus = next.len;
				
				if(!visited[nto] && result[nto].len > result[now.to].len + plus) {
					result[nto].len = result[now.to].len + plus; 
					pq.remove(result[nto]);
					pq.add(result[nto]);
				}
			}
		
		}
		
		System.out.println(result[ed].len);
	}

}
