package d0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리_Kruskal {
	static int[] parents, rank;
	
	static void makeSet() {
		for(int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(x == parents[x]) {
			return x;
		}else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] < rank[py]) {
			parents[px] = py;
		}else {
			parents[py] = px;
			if(rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}
	
	public static class Line implements Comparable<Line>{
		int from;
		int to;
		int val;
		public Line(int from, int to, int val) {
			this.from = from;
			this.to = to;
			this.val = val;
		}
		@Override
		public int compareTo(Line o) {
			return Integer.compare(this.val,  o.val);
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parents = new int[V+1];
		rank = new int[V+1];
		
		makeSet();
		
		PriorityQueue<Line> pq = new PriorityQueue<Line>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			pq.add(new Line(from, to, val));
		}
		
		int result = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Line now = pq.poll();
			
			if(findSet(now.from)== findSet(now.to)) {
				continue;
			}
			
			union(now.from, now.to);
			result += now.val;
			cnt++;
			
			if(cnt == V-1) {
				break;
			}
		}
		
		System.out.println(result);
	}

}
