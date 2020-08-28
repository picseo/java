package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1, v1, v2�� �������� ���ͽ�Ʈ�� ������ ������ 
 *  (1->v1) + (v1->v2) +(v2->N) �̶� (1->v2) + (v2->v1) + (v1->N)
 * �� ���� ���� ���� �� ����Ѵٰ� �����ߴ�.
 * 
 * ���ͽ�Ʈ�� �˰���
 * �� �������� �ٸ� ��� ���������� �ִ� �Ÿ��� ���ϴ� �˰���
 * 
 * ������ ���� ���� pq�� �����ϴٰ� �Ѵ�
 * ������ Ž�����ص� �Ǵϱ� �׷��ǰ�
 * 
 * �� �ڵ�� pq�� ������� �ʰ� Ǯ����.
 * 
 * 
 */
public class BJ_1504_Ư�����ִܰ��_Dijkstra {
	static class Node{
		int point, value;

		public Node(int point, int value) {
			this.point = point;
			this.value = value;
		}		
	}
	
	static int N, E;
	static ArrayList<Node>[] graph;
	static int[][] dijkstra;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		dijkstra = new int[3][N+1];
		
		for(int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to, value));
			graph[to].add(new Node(from, value));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		fill_dijkstra(1, 0);
		fill_dijkstra(v1, 1);
		fill_dijkstra(v2, 2);
		
		//for(int i = 0; i < 3; i++)
		//	System.out.println(Arrays.toString(dijkstra[i]));
		
		int one = Integer.MAX_VALUE;
		if(dijkstra[0][v1] != Integer.MAX_VALUE &&
				dijkstra[1][v2] != Integer.MAX_VALUE &&
				dijkstra[2][N] != Integer.MAX_VALUE) {
			one = dijkstra[0][v1] + dijkstra[1][v2] + dijkstra[2][N];
		}
		
		int two = Integer.MAX_VALUE;
		if(dijkstra[0][v2] != Integer.MAX_VALUE &&
				dijkstra[2][v1] != Integer.MAX_VALUE &&
				dijkstra[1][N] != Integer.MAX_VALUE) {
			two = dijkstra[0][v2] + dijkstra[2][v1] + dijkstra[1][N];
		}
		
		int result = (one < two) ? one : two;
		if(result == Integer.MAX_VALUE)
			result = -1;
		
		System.out.println(result);
	}

	private static void fill_dijkstra(int start, int idx) {
		Arrays.fill(dijkstra[idx], Integer.MAX_VALUE);
		dijkstra[idx][start] = 0;
		boolean[] visited = new boolean[N+1];
		
		for(int j = 0; j < N; j++) {
			int index = -1;
			int min = Integer.MAX_VALUE;
			for(int i = 1; i <= N ; i++) {
				if(min > dijkstra[idx][i] && !visited[i]) {
					min = dijkstra[idx][i];
					index = i;
				}
			}
			
			if(index == -1) {
				break;
			}
					
			visited[index] = true;
			
			for(int i = 0; i < graph[index].size(); i++) {
				Node next = graph[index].get(i);
				
				if(!visited[next.point] && dijkstra[idx][index] + next.value < dijkstra[idx][next.point] )
					dijkstra[idx][next.point] = dijkstra[idx][index] + next.value;
			}
		}
	}
}
