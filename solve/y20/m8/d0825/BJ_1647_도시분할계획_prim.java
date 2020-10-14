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
public class BJ_1647_도시분할계획_prim {
	static int N, M;
	static ArrayList<Line>[] graph;
	
	static class Line implements Comparable<Line>{
		int to;
		long value;
		public Line(int to, long value) {
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
		
		//make graph
		graph = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList();
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			long value = sc.nextLong();
			
			graph[from].add(new Line(to, value));
			graph[to].add(new Line(from, value));
		}
		
		//find_min_value
		System.out.println(Prim());
		return; 
	}

	private static long Prim() {
		int start = 1;
		boolean[] visited = new boolean[N+1];
		long result = 0;
		long max = Long.MIN_VALUE;
		
		//현재 그래프와 연결된 선들 중에서 값이 가장 작은것을 고른다.
		PriorityQueue<Line> pq = new PriorityQueue<>();
		pq.add(new Line(start, 0));
		
		while(!pq.isEmpty()) {
			Line now = pq.poll();
			if(visited[now.to]) {
				continue;
			}
			
			if(max < now.value) {
				max = now.value;
			}
			
			result += now.value;
			visited[now.to] = true; 
			
			/*for(Line next : graph[now.to]) {
				if(!visited[next.to]) {
					int to = next.to;
					long value = next.value;
					
					pq.add(new Line(to, value));
				}
			}*/
			
			for(int i = 0; i < graph[now.to].size(); i++) {
				Line next = graph[now.to].get(i);
				if(visited[next.to]) {
					continue;
				}
				pq.add(next);
			}
			
		}
		
		result -= max;
		return result;
		
	}

}
