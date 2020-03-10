package d0303;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * ���
 * dfs���� �ߺ��Ǵ� ����� ���� �ϰ� �ʹٸ� ���� �����صδ� �迭�� ���� 
 * �ش� ��ġ�� ���� �����ϸ� ����� �����ʰ� ����  return�� �ִ� �κ��� �߰��Ѵ�.
 * 
 * memoization�� �ؼ� �ߺ��Ǵ� ����� �����ؾ� �Ѵ�.
 * */
public class SWEA_4534_D5_Ʈ������ĥ_���� {
	public static List<Integer>[] graph = null;
	public final static int MOD = 1000000007;
	static long[][] memo;//����, ���� ��ȣ
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			graph = new List[n+1];
			for(int i = 0;i < n+1 ; i++) {
				graph[i] = new ArrayList();
			}
			memo = new long[2][n+1];
			
			for(int i =0 ; i < n-1 ; i++) {
				int first = sc.nextInt();
				int seconde = sc.nextInt();
				
				graph[first].add(seconde);
				graph[seconde].add(first);
			}
			
			long result = (dfs(1, 0, -1) + dfs(1, 1, -1))%MOD;
			System.out.println("#"+t+" "+result);
		}
	}
	
	public static long dfs(int now, int color, int parent) {
		//���� �÷��� 0(��), 1(��)
		if(memo[color][now]!=0) {
			return memo[color][now];
		}
		
		long result = 1;
		
		//���� �÷��� (��)���
		if(color == 1) {
			// �ڽ� ������ �Ͼ��
			for(int i = 0;i < graph[now].size(); i++) {
				int cur = graph[now].get(i);
				if(cur == parent) {
					continue;
				}
				result *= dfs(cur, 0, now);
				result %= MOD;
			}
		}else{
			for(int i = 0;i < graph[now].size(); i++) {
				int cur = graph[now].get(i);
				if(cur == parent) {
					continue;
				}
				
				result *= (dfs(cur, 1, now) + dfs(cur, 0, now));
				result %= MOD;
			}
		}
		
		memo[color][now] = result;
		return result;
	}
	
	

	private static String src = "2\r\n" + 
			"2\r\n" + 
			"1 2\r\n" + 
			"5\r\n" + 
			"1 3\r\n" + 
			"2 3\r\n" + 
			"3 4\r\n" + 
			"4 5";
}
