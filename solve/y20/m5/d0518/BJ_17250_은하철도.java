package d0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//최대값을 항상 result에 저장하고 출력해주는 방법을 했었는데, 이렇게 할 경우 이전과 다른 집합의 합이 이전
//값보다 작은 경우 이전 집합의 합이 나오는 오류가 생긴다.
//항상 작은 값을 앞으로 하면 조금더 빠르다
//union-find문제
public class BJ_17250_은하철도 {
	static int M, N;
	static int[] parent, nums;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nums = new int[N+1];
		parent = new int[N+1];
		for(int i = 1; i <= N ; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			parent[i] = i;//일단은 자기자신이 부모
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			int fp = find_parent(from);
			int tp = find_parent(to);
			
			if(fp != tp) {//무조건 앞의 fp에 저장한다.
//				if(fp > tp) {
//					int tmp = fp;
//					fp = tp;
//					tp = tmp;
//				} -> 항상 작은 값을 fp에 넣는 걸 없어도 답은 나오지만 탐색시간이 늘어난다
				
				parent[tp] = fp;
				nums[fp] += nums[tp];
			}
			
			sb.append(nums[fp]).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int find_parent(int now) {
		if(parent[now] == now) {
			return now;
		}else {
			parent[now] = find_parent(parent[now]);
		}
		return parent[now];
	}
	
	

}
