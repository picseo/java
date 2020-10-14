package d0825;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

/*
 * N���� ��, M���� �� (�����)
 * 
 * �渶�� ������ -> ����ġ�� �����Ƿ� bfs�� �ȵȰŰ���
 * 
 * ������ �ΰ��� ������, �ּ� ���д� Ʈ��?? �׷����� 2���� �и��ؼ� �ּ� ���д� Ʈ��?
 * 
 * �ٵ� ���� �ȿ����� ���� ���ټ����ְ�? -> ���д�Ʈ��
 * 
 * �ּҽ��д� Ʈ���� �����, ���߿��� ���� ������ ū ���� ���ּ� �ΰ��� ������ ���鵵�� �ؾ߰ڴ�.
 *  -> �ƴϸ� ũ�罺Į�� �̿��ؼ� n-2�� ���ص� ���� �ȴ�.
 *  
 * ���д�Ʈ��
 * 1. ���ͽ�Ʈ�� �˰��� -> �������� �ٸ� ��� ��ΰ��z �ּ� ��
 * 2. �����˰��� : ���� �׷����� ���� ����� ���Ե�� ���� ���� ok
 * 3. ũ�罺Į �˰��� : ��� ���� �� ���� ����� ���� ���� �߰��Ѵ�.
 * 
 * */
public class BJ_1647_���ú��Ұ�ȹ_prim {
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
		
		//���� �׷����� ����� ���� �߿��� ���� ���� �������� ����.
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
