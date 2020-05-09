package d0506;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ_2533_사회망서비스 {
	static int N;
	static List<Integer>[] graph, tree;
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		graph = new List[N+1];
		tree = new List[N+1];
		memo = new int[N+1][2];
		
		boolean[] visited = new boolean[N+1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList();
			tree[i] = new ArrayList();
		}
		
		//graph 생성
		for(int i = 0; i < N-1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		for(int i =0; i <= N; i++) {
			Arrays.fill(memo[i],  -1);
		}
		//단방향 그래프, tree로 만들기
		make_tree(1, 0);
		
		//dfs, memo를 이용해서 건너건너 찾기
		int result = Math.min(find(1, 0), find(1, 1));
		System.out.println(result);
	}

	private static void make_tree(int now, int parent) {
		if(parent != 0) {
			tree[parent].add(now);
		}
		
		for(int next : graph[now]) {
			if(next == parent) {
				continue;
			}
			make_tree(next, now);
		}
	}

	private static int find(int id, int isE) {		
		if(tree[id].isEmpty()) {
			if(isE == 1) {
				return 1;
			}else {
				return 0;
			}
		}
		
		if(memo[id][isE] != -1) {
			return memo[id][isE];
		}
		
		int tmp = 0;
		if(isE == 1) {
			tmp += 1;
			for(int i = 0; i < tree[id].size(); i++) {
				tmp += Math.min(find(tree[id].get(i), 1), find(tree[id].get(i), 0));
			}
		}else {
			for(int i = 0; i < tree[id].size(); i++) {
				tmp += find(tree[id].get(i), 1);
			}
		}
		
		memo[id][isE] = tmp;
		return tmp;
	}

}
