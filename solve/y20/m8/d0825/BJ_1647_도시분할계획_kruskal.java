package d0825;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

/*
 * N개의 집, M개의 길 (양방향)
 * 
 * 길마다 유지비 -> 가중치가 있으므로 bfs는 안된거같다
 * 
 * 마을을 두개로 나누고, 최소 스패닝 트리?? 그렇지만 2개로 분리해서 최소 스패닝 트리?
 * 
 * 근데 마을 안에서는 길을 없앨수도있고? -> 스패닝트리
 * 
 * 최소스패닝 트리를 만들고, 그중에서 가장 유지비가 큰 길을 없애서 두개의 마을을 만들도록 해야겠다.
 *  -> 아니면 크루스칼을 이용해서 n-2만 구해도 답이 된다.
 *  
 * 스패닝트리
 * 1. 다익스트라 알고리즘 -> 한점에서 다른 모든 길로가틑 최소 값
 * 2. 프림알고리즘 : 현재 그래프와 가장 비용이 적게드는 점을 연결 ok
 * 3. 크루스칼 알고리즘 : 모든 점들 중 가장 비용이 적은 선을 추가한다.
 * 
 * */
public class BJ_1647_도시분할계획_kruskal {
	static int N, M;
	static int[] parents;
	static PriorityQueue<Line> pq = new PriorityQueue<>();
	
	static class Line implements Comparable<Line>{
		int from;
		int to;
		long value;
		public Line(int from, int to, long value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}
		@Override
		public int compareTo(Line o) {
			return Long.compare(this.value, o.value);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		parents = new int[N+1];
		for(int i = 0; i < N+1; i++) {
			parents[i] = i;
		}
				
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			long value = sc.nextLong();
			
			pq.add(new Line(from, to, value));
			pq.add(new Line(to, from, value));
		}
		
		//find_min_value
		System.out.println(Kruskal(0));
		return; 
	}

	
	private static int find_parents(int x) {
		if(parents[x] == x) {
			return x;
		}
		
		parents[x] = find_parents(parents[x]);
		return parents[x];
	}


	private static int Kruskal(int n) {
		int result = 0;
		
		while(!pq.isEmpty()) {
			Line now = pq.poll();
			
			if(find_parents(now.from) != find_parents(now.to)) {
				
				union(now.from, now.to);
				result += now.value;
				n++;
				
				if(n == N-2) {
					return result;
				}
			}
			
		}
		
		return result;
	}


	private static void union(int from, int to) {
		int px = find_parents(from);
		int py = find_parents(to);
		
		parents[px] = py;
	}

}
