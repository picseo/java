package d0303;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 재귀
 * dfs에서 중복되는 계산을 방지 하고 싶다면 값을 저장해두는 배열을 만들어서 
 * 해당 위치에 값이 존재하면 계산을 하지않고 값을  return해 주는 부분을 추가한다.
 * 
 * memoization을 해서 중복되는 계산을 방지해야 한다.
 * */
public class SWEA_4534_D5_트리흑백색칠_복습 {
	public static List<Integer>[] graph = null;
	public final static int MOD = 1000000007;
	static long[][] memo;//색상, 정점 번호
	
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
		//현재 컬러가 0(흰), 1(검)
		if(memo[color][now]!=0) {
			return memo[color][now];
		}
		
		long result = 1;
		
		//현재 컬러가 (검)경우
		if(color == 1) {
			// 자식 노드들은 하얗다
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
