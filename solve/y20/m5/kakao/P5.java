package kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 9	[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]]	[[8,5],[6,7],[4,1]]	true
9	[[8,1],[0,1],[1,2],[0,7],[4,7],[0,3],[7,5],[3,6]]	[[4,1],[5,2]]	true
9	[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]]	[[4,1],[8,7],[6,5]]	false
 */
public class P5 {
	static int N;
	static List<Integer>[] graph;
	static List<Integer>[] tree;
	static List<Integer>[] pre;
	static boolean[] visited;
	static int count;
	
	static Queue<Integer> queue;
	
	static class Point{
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}
	
	public static void main(String[] args) {
		N = 9;
		int[][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
		int[][] order = {{8,5},{6,7},{4,1}};
		
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
        pre = new List[n+1];
        visited = new boolean[n+1];
        
        for(int i= 0; i < n+1 ; i++) {
        	graph[i] = new ArrayList();
        	tree[i] = new ArrayList();
        	pre[i] = new ArrayList();
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
        	
        	pre[to].add(from);
        }
        
        count = n;
        int pre_count = 0;
        
        while(count != pre_count) {
        	pre_count = count;

        	if(visited[0]) {
				check(0);
			}else {
				if(pre[0].isEmpty()) {
					count--;
					visited[0] = true;
					check(0);
				}
			}       	
        }
        
        if(count == 0) {
        	answer = true;
        }else {
        	answer = false;
        }
        return answer;
    }

	private static void check(int root) {
		
		for(int next : tree[root]) {
			if(visited[next]) {
				check(next);
			}else {
				if(pre[next].isEmpty()) {
					count--;
					visited[next] = true;
					check(next);
				}else {
					boolean check_pre = true;
					int size = pre[next].size();
					for(int i = 0; i < size; i++) {
					//for(int pres : pre[next]) {
						int pres = pre[next].get(i);
						if(!visited[pres]) {
							check_pre = false;
							break;
						}else {
							pre[next].remove(i);
							//i--;
						}
					}
					if(check_pre) {
						count--;
						visited[next] = true;
						check(next);
					}
				}
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
