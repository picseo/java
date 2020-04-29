package d0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//인접 행렬로 풀었더니 메모리 초과가 난다.
public class BJ_1197_최소스패닝트리_Prim_인접리스트 {
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
		
		
		PriorityQueue<Line> pq = new PriorityQueue<Line>();
		List<int[]>[] list = new List[V];
		for(int i = 0; i < V; i++) {
			list[i] = new ArrayList();
		}
		
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			
			list[from].add(new int[] {to, val});
			list[to].add(new int[] {from, val});
		}
		
		int result = 0;
		int cnt = 0;
		boolean[] check = new boolean[V];
		
		//0부터 시작
		for(int i = 0; i < list[0].size(); i++) {
			pq.add(new Line(0, list[0].get(i)[0], list[0].get(i)[1]));
		}
		check[0] = true;
		
		while(!pq.isEmpty()) {
			Line now = pq.poll();
			
			if(check[now.to]) {
				continue;
			}
			
			int next = now.to;
			check[now.to]= true;
			result += now.val;
			cnt++;
			
			for(int i = 0; i < list[next].size(); i++) {
				if(check[list[next].get(i)[0]]) {
					continue;
				}
				pq.add(new Line(next, list[next].get(i)[0], list[next].get(i)[1]));
			}
			
			if(cnt == V-1) {
				break;
			}
		}
		System.out.println(result);
	}
}
