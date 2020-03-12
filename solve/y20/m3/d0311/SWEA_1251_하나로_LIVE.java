package d0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251_하나로_LIVE {
	static int N;
	static double E;
	static long[][] islands;
	static long[][] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			StringTokenizer stx = new StringTokenizer(br.readLine());
			StringTokenizer sty= new StringTokenizer(br.readLine());
			islands = new long[N][2];
			for (int i = 0; i < islands.length; i++) {				
				islands[i][0] = Long.parseLong(stx.nextToken());
				islands[i][1] = Long.parseLong(sty.nextToken());				
			}
			E = Double.parseDouble(br.readLine());
			// 입력된 자료를 기반으로 섬 간의 가중치 그래프를 구해봅시다.
			graph = new long[N][N];
			long[] from, to;
			for (int r = 0; r < N; r++) {
				from = islands[r];
				for (int c = r+1; c < N; c++) {
					to = islands[c];
					graph[r][c] = graph[c][r] = (from[0] - to[0]) * (from[0] - to[0]) + (from[1]-to[1]) * (from[1]-to[1]);
				}
			}
			
			double cost = prim(0) * E;
			sb.append(Math.round(cost)).append("\n");
		}
		System.out.println(sb);
	}

	static long prim(int start) {
		// MST에 들어가지 않은 녀석들.
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		// 모든 정점들을 다 관리....
		Edge[] dynamicGraph = new Edge[N];
		
		// 아래 코드가 잘못된 점을 찾아보자...
		for (int n = 0; n < dynamicGraph.length; n++) {
			dynamicGraph[n] = new Edge(n, Long.MAX_VALUE);
			//pq.add(dynamicGraph[n]);
			if(n==start) {
				dynamicGraph[n].cost = 0;
			}
			pq.add(dynamicGraph[n]);
		}
		
		long cost = 0;
		
		while(!pq.isEmpty()) {
			Edge front = pq.poll(); // MST에 포함되는 녀석
			cost += front.cost;
			
			// 자식 탐색
			for (int i = 0; i < dynamicGraph.length; i++) {
				Edge child = dynamicGraph[i];
				// pq: 비 MST 
				if(pq.contains(child)) {
					long tempCost = graph[front.idx][child.idx];
					if(tempCost < child.cost) {
						child.cost = tempCost;
						// pq는 add시에 순서가 이미 정해지기때문에
						pq.remove(child);
						pq.add(child);
					}
				}
			}
		}		
		
		return cost;
	}
	
	static class Edge implements Comparable<Edge>{
		int idx;
		long cost;
		public Edge(int idx, long cost) {
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}		
	}
	
}
