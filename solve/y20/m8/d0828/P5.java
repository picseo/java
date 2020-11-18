package d0828;

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
	static boolean result = true;
	
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
        visited = new boolean[n+1];
        
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
        
        for(int i = 0; i < tree.length; i++) {
        	System.out.println("from " + i + " : ");
        	System.out.println(tree[i]);	
        	System.out.println();
        }
        
        for(int i = 0; i < tree.length; i++) {
        	visited[i] = true;
        	dfs(i, i);
        }
        
        answer = result;
        return answer;
    }

	private static void dfs(int now, int st) {
		
		for(int next  : tree[now]) {
			if(next == now) {
				result = false;
				return;
			}
			
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, st);
			}
		}
		
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
