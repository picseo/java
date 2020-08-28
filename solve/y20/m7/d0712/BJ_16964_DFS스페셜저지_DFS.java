package algo;

import java.io.*;
import java.util.*;
/*
 DFS로 나올 수 있는 탐색 결과인지 확인하는 문제였다.
 
 DFS이므로 stack을 이용해서 탐색이 가능한지 확인하였다.
 
 현재 top애 연결된 값중에 input배열의 idx위치의 값과 같은 값이 있으면 push, 없는 경우 pop을 해서
 input배열을 따라가면서 탐색을 한 뒤
 idx의 값이 마지막 값에 도달하지 못하면 어딘가에서 막힌 것이므로
 false
 idx값이 N과 같으면 모든 탐색을 했다고 생각해서 true를 주었다.
 * */
public class BJ_16964_DFS스페셜저지_DFS {
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
