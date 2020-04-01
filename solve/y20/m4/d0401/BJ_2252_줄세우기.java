package d0401;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2252_줄세우기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] in = new int[N+1];
		List<Integer>[] graph = new List[N+1];
		for(int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList();
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			graph[from].add(to);
			in[to]++;
		}
		
		Queue<Integer> q = new LinkedList();
		for(int i = 1; i < N+1; i++) {
			if(in[i] == 0) {
				q.add(i);
			}
		}

		int cnt = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			cnt++;
			for(int next: graph[now]) {
				in[next]--;
				if(in[next] == 0) {
					q.add(next);
				}
			}
		}
		
		System.out.println(sb);		
	}

}
