package d0901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 9	{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}}	{{8,5},{6,7},{4,1}}	true
9	{{8,1},{0,1},{1, 2},{0, 7},{4, 7},{0, 3},{7, 5},{3, 6}}	{{4,1}, {5, 2}}	true
9	{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}}	{{4,1},{8,7},{6,5}}	false
 */
public class P5 {
	static int N;
	static List<Integer>[] graph;
	static List<Integer>[] tree;
	static boolean[] visited;
	static int[] check;
	
	public static void main(String[] args) {
		N = 9;
		int[][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
		int[][] order = {{4,1},{8,7},{6,5}};
		
		if(solution(N, path, order)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	
	public static boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        graph = new List[n+1];
        tree = new List[n+1];
        
        for(int i= 0; i < n+1 ; i++) {
        	graph[i] = new ArrayList();
        	tree[i] = new ArrayList();
        }
        
        for(int i = 0; i < n-1; i++) {
        	int from = path[i][0];
        	int to = path[i][1];
        	
        	graph[from].add(to);
        	graph[to].add(from);
        }
        
        //make_tree
        make_tree(0, -1);
      
        //oder
        int orderlen = order.length;
        for(int i = 0; i < orderlen; i++) {
        	int from = order[i][0];
        	int to = order[i][1];
        	
        	tree[from].add(to);
        }
        
//        for(int i = 0; i < tree.length; i++) {
//        	System.out.println("from " + i + " : ");
//        	System.out.println(tree[i]);	
//        	System.out.println();
//        }
        
        visited = new boolean[n+1];
        check = new int[n+1];
        int res = dfs(0);
        
        if(res == 1) answer = false;
        return answer;
    }

	private static int dfs(int now) {
		if(visited[now]) return 1;
		if(check[now] != 0) return 0;
		
		check[now] = 1;
		visited[now] = true;
		
		for(int i = 0; i < tree[now].size(); i++) {
			if(dfs( tree[now].get(i) ) == 1) {
				return 1;
			}
		}
		
		visited[now] = false;
		return 0;		
	}

	private static void make_tree(int now, int root) {
		if(root != -1) {
			tree[root].add(now);
		}
		
		for(int next : graph[now]) {
			if(next != root) {
				make_tree(next, now);
			}
		}
	}
	
	
}
