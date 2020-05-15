package d0514;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//위상정렬 방식을 위 아래로 진행한 다음에 지금 나의 위와 아래의 갯수를 모두 합쳐서

public class BJ_2458_키순서 {
	static int N;
	static List<Integer>[] up, down;
	static int[] u, d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

			N = sc.nextInt();
			up = new List[N+1];
			down = new List[N+1];
			for(int i = 0; i < N+1; i++) {
				up[i] = new ArrayList<>();
				down[i] = new ArrayList<>();
			}
			
			int M = sc.nextInt();
			for(int j = 0; j < M ; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				up[a].add(b);
				down[b].add(a);
			}
			
			int result = 0;
			for(int i = 1; i < N+1; i++) {
				int lcount = find_down(i);
				int ucount = find_up(i);
				if(lcount+ucount == N-1) {
					result++;
				}
			}
			
		System.out.println(result);
	}

	private static int find_up(int now) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList();
		
		int level = 0;
		visited[now] = true;
		queue.add(now);
		while(!queue.isEmpty()) {
			int n = queue.poll();
			for(int i = 0; i < up[n].size(); i++) {
				if(!visited[up[n].get(i)]) {
					visited[up[n].get(i)] = true;
					level++;
					queue.add(up[n].get(i));
				}
			}
		}
		
		return level;
	}

	private static int find_down(int now) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList();
		
		int level = 0;
		visited[now] = true;
		queue.add(now);
		while(!queue.isEmpty()) {
			int n = queue.poll();
			for(int i = 0; i < down[n].size(); i++) {
				if(!visited[down[n].get(i)]) {
					visited[down[n].get(i)] = true;
					level++;
					queue.add(down[n].get(i));
				}
			}
		}
		
		return level;		
	}

}
