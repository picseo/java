package fail;

import java.util.Scanner;

/*
 * 완탐과 비슷하긴 한데 재귀를 사용해서 가지치기를 몇개 추가해야 풀리는 문제로 배웠다.
 * 
 * 1. 주어진 조건이 만족하는지 확인
 * 2. 이전에 구한 값을 이용한다면 메모이제이션을 이용
 * */
public class SWEA_5987_달리기 {
	static int N, M;
	static long[] needs;
	static long[] memo;
	static long result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			needs = new long[N];//뒤에 와야하는 사람들을 표시한다.
			memo = new long[(1<<N)];
			
			for(int i = 0; i < M; i++) {
				int x = sc.nextInt() -1;
				int y = sc.nextInt() -1;
				
				needs[x] |= (1<<y); //x는 y가 뒤에 있어야 한다.
			}
			
			result = dfs(0);
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static long dfs(int visit) {
		if(memo[visit] != 0) {
			return memo[visit];
		}
		
		if(visit == (1<<N)-1) {//사람들을 모두 나열함
			return 1;
		}else {//아직 사람들을 나열해야 한다.
			
			for(int i = 0; i < N; i++) {
				if((visit & (1<<i)) == 0) { //아직 i번째 사람을 선택하지 않았다면
					if((visit & needs[i]) == needs[i]) { //i번째 사람보다 뒤에 있어야 하는 사람을 모두 뒤에 세워놓음
						memo[visit] += dfs(visit|(1<<i));//새로운 사람을 추가한다.
					}
				}
			}
		}
		
		return memo[visit];
	}
	
	
	private static String src = "3\r\n" + 
			"3 2\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"5 5\r\n" + 
			"1 2\r\n" + 
			"2 5\r\n" + 
			"1 3\r\n" + 
			"3 4\r\n" + 
			"4 5\r\n" + 
			"16 1\r\n" + 
			"5 9";
}
