package d0509;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//위상 정렬 문제인데, 위아래 모두 확인해야 하는게 다른 점이었다.
//그래서 위아래 정보를 따로 저장한 뒤 위아래작업을 각각 해야한다.
public class BJ_17616 {
	static int N, M, X;
	static List<Integer>[] pres, posts;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		
		pres = new List[N+1];
		posts = new List[N+1];
		
		for(int i = 0; i < N+1; i++) {
			pres[i] = new ArrayList();
			posts[i] = new ArrayList();
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			pres[to].add(from);
			posts[from].add(to);
		}
		
		int front = 0;		
		boolean[] visited = new boolean[N+1];
		visited[X] = true;
		Queue<Integer> q = new LinkedList();
		q.add(X);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			front++;
			
			for(int next : pres[now]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		

		int back = 0;
		visited = new boolean[N+1];
		visited[X] = true;
		q = new LinkedList();
		q.add(X);
		
		while(!q.isEmpty()) {
			int now = q.poll();			
			for(int next : posts[now]) {
				if(!visited[next]) {
					visited[next] = true;
					back++;
					q.add(next);
				}
			}
		}
		
		back = N - back;
		System.out.println(front + " " + back);
		
	}

}
