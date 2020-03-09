package d0308;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * ���� ����� ����������
 * 
 * N == K�϶��� ������� �ʾƼ� ��� Ʋ�ȴ�.
 * �ش� ������ �߰��ϴ� pass�� �� �־���.
 * (������ ���� N�� K�� �ٸ��ٴ� �̾߱Ⱑ ������.)
 * bfs�� �̿��Ҷ� �����ؾ߰ڴ�.
 * */
public class BJ_13913 {
	static int N, K;
	static int[] memo = new int[100001];
	//static int[] len = new int[100001];
	
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		K = sc.nextInt();

		Arrays.fill(memo,  -1);
		result = bfs();

		Stack<Integer> st = new Stack<>();
		int start = K;
		while(memo[start] != start) {
			st.push(start);
			start = memo[start];
		}
		
		sb.append(result).append("\n").append(N).append(" ");
		while(!st.isEmpty()) {
			sb.append(st.pop()).append(" ");
		}
		System.out.println(sb);
	}

	public static int bfs() {
		Queue<Integer> queue = new LinkedList();
		queue.add(N);
		if(memo[N] == -1)
			memo[N] = N;
		int cnt =0;
		//len[N] = 0;
		if(N == K)
			return cnt;
		while(!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			for(int i = 0; i < size; i++) {
				int now = queue.poll();

				int next = now*2;
				if(next <= 100000 && memo[next] == -1) {
					memo[next] = now;
					//len[next] = len[now] + 1;
					queue.add(next);
				}
				if(next == K)
					return cnt;
				
				next = now-1;
				if(next >= 0 && memo[next] == -1) {
					memo[next] = now;
					//len[next] = len[now] + 1;
					queue.add(next);
				}
				if(next == K)
					return cnt;
				
				next = now+1;
				if(next <= 100000 && memo[next] == -1) {
					memo[next] = now;
					//len[next] = len[now] + 1;
					queue.add(next);
				}
				if(next == K)
					return cnt;
			}
		}
		
		return -1;
	}
	
	private static String src = "5 17";

}
