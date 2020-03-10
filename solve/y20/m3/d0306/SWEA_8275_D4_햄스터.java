package d0306;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 함수 나눌때는 자기가 할 일만 넣어주자
 * 다른 일도 같이하게 되면 이상한 값이 나와 오류가 나오나보다
 * */
public class SWEA_8275_D4_햄스터 {
	static int N, X, M;
	static int[][] dodo = null;
	static int[] result = null;
	static int sum = 0;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1;t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = sc.nextInt();
			X = sc.nextInt();
			M = sc.nextInt();
			
			dodo = new int[M][3];
			for(int i = 0; i < M; i++) {
				dodo[i][0] = sc.nextInt()-1;
				dodo[i][1] = sc.nextInt()-1;
				dodo[i][2] = sc.nextInt();
			}
			
			result = new int[N];
			sum = -1;
			dfs(0, new int[N], 0);
			
			if(sum == -1) {
				sb.append(-1).append("\n");
			}else {
				for(int i = 0; i < N; i++) {
					sb.append(result[i]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static boolean check(int[] tmp) {
		for(int i = 0; i < M ; i++) {
			int tsum = 0;
			for(int j = dodo[i][0]; j <= dodo[i][1]; j++) {
				tsum += tmp[j];
			}
			if(tsum != dodo[i][2]) {
				return false;
			}
		}		
		
		return true;
	}
	
	
	private static void dfs(int cur, int[] tmp, int sumtmp) {
		
		if(N == cur) {			
			if(check(tmp)) {
				if(sum < sumtmp) {
					for(int i = 0; i < N ; i++) {
						int tt = tmp[i];
						result[i] = tt;
					}
					sum = sumtmp;
				}
			}
			
		}else {
			for(int i = 0; i <= X; i ++) {
				tmp[cur] = i;
				dfs(cur+1, tmp, sumtmp+i);
			}
		}
	}
	
	private static String src = "\r\n" + 
			"3\r\n" + 
			"3 5 1\r\n" + 
			"1 2 5\r\n" + 
			"3 5 2\r\n" + 
			"1 2 6\r\n" + 
			"2 3 7\r\n" + 
			"4 5 2\r\n" + 
			"1 3 15\r\n" + 
			"3 4 4";
}