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
public class BJ_1647_���ú��Ұ�ȹ_kruskal {
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
