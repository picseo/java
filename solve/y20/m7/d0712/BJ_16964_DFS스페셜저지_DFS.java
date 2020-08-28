package algo;

import java.io.*;
import java.util.*;
/*
 DFS�� ���� �� �ִ� Ž�� ������� Ȯ���ϴ� ��������.
 
 DFS�̹Ƿ� stack�� �̿��ؼ� Ž���� �������� Ȯ���Ͽ���.
 
 ���� top�� ����� ���߿� input�迭�� idx��ġ�� ���� ���� ���� ������ push, ���� ��� pop�� �ؼ�
 input�迭�� ���󰡸鼭 Ž���� �� ��
 idx�� ���� ������ ���� �������� ���ϸ� ��򰡿��� ���� ���̹Ƿ�
 false
 idx���� N�� ������ ��� Ž���� �ߴٰ� �����ؼ� true�� �־���.
 * */
public class BJ_16964_DFS���������_DFS {
	static int N, idx;
	static ArrayList<Integer>[] graph;
	static int[] input;
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		input = new int[N+1];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {			
			input[i] = Integer.parseInt(st.nextToken());
		}
		input[N] = Integer.MAX_VALUE;
		
		visited[1] = true;
		stack.add(1);
		idx = 1;
		find_dfs();
				
		System.out.println((idx == N)?1:0);
	}

	private static void find_dfs() {
		if(stack.isEmpty()) {
			return ;
		}
		
		boolean find = false;
		int now = stack.peek();
		for(int i = 0; i < graph[now].size(); i++) {
			int next = graph[now].get(i);
			if(!visited[next] && idx < N && input[idx] == next) {
				idx++;
				find = true;
				visited[next] = true;
				stack.add(next);
				break;
			}
		}
		
		if(!find) {
			stack.pop();
		}
		find_dfs();			
	}
	
}
