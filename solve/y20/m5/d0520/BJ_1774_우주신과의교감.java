package d0520;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
//간적프 간만크 -> 점들이 주어지는 경우 크루스칼이 유리!
//좌표들을 int로 받아서 계속 틀렸었다. 이런 문제는 꼭 좌표를 double형으로 받자 ㅠㅅㅠ

//그리고 유니언할때 미리 부모값을 줄지, 아님 현재값을 줘서 나중에 부모값을 구하는 방법을 할지 확실히 정해야 겠다 나중에는 막 섞여서 이도저도아닌 코드가 나왔다.
//그냥 현재 값을 주는 걸로 정하자
public class BJ_1774_우주신과의교감 {
	static int N, M;
	static int[] parent;
	static double[] X, Y;

	static PriorityQueue<Connec> pq;
	static double result = 0;

	static class Connec implements Comparable<Connec>{
		int a, b;
		double len;
		public Connec(int a, int b, double len) {
			this.a = a;
			this.b = b;
			this.len = len;
		}
		@Override
		public int compareTo(Connec o) {
			return Double.compare(this.len , o.len);
		}	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		X = new double[N+1];
		Y = new double[N+1];
		parent = new int[N+1];
		pq = new PriorityQueue<Connec>();
		//0~N-1
		for(int i = 1; i <= N; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			X[i] = x;
			Y[i] = y;

			for(int j = i-1; j >= 1; j--) {
				pq.add(new Connec(i, j, Math.sqrt((X[i]-X[j])*(X[i]-X[j]) + (Y[i]-Y[j])*(Y[i]-Y[j]))));
			}
		}

		for(int i = 0; i < N+1; i++) {
			parent[i] = i;
		}

		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			union(from, to);	
		}

		while(!pq.isEmpty()) {
			Connec now = pq.poll();

			if(find_parent(now.a) == find_parent(now.b)) {
				continue;
			}
			
			union(now.a, now.b);
			result+=now.len;
		}

		System.out.printf("%.2f", result);
	}

	public static int find_parent(int now) {
		if(now == parent[now]) {
			return now;
		}else {
			parent[now] = find_parent(parent[now]);
		}
		return parent[now];
	}

	public static void union(int a, int b) {
		int pa = find_parent(a);
		int pb = find_parent(b);
		if(pa > pb) {
			int tmp = pa;
			pa = pb;
			pb = tmp;
		}
		parent[pb] = pa;	
	}

}
