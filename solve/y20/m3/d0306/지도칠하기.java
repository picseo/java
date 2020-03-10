package d0306;

import java.util.Scanner;

public class ÁöµµÄ¥ÇÏ±â {
	static boolean[][] graph = null;
	static int[] colors_f = null;
	static int result = 0;
	public static void main(String[] args) throws Exception{
		Scanner sc= new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			colors_f = new int[n];
			for(int i =0 ; i < n ; i++) {
				colors_f[i] = sc.nextInt();
			}
			result = Integer.MAX_VALUE;
			
			graph = new boolean[n][n];
			for(int i = 0; i < n ; i++) {
				for(int j = 0; j < n ; j++) {
					if(sc.nextInt() == 1) {
						graph[i][j] = true;
					}else {
						graph[i][j] = false;
					}
				}
			}
			
			findcolor(n, 0, new int[n]);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void findcolor(int n, int cur, int[] tmp) {
		
		if(n == cur) {
			for(int i =0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(graph[i][j]) {
						if(tmp[i] == tmp[j]) {
							return;
						}
					}
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < n ; i++) {
				if(colors_f[i] != tmp[i]) {
					cnt++;
				}
			}
			
			if(result > cnt) {
				result = cnt;
			}
			return;
		}else {
			for(int i = 1; i <= n; i++) {
				tmp[cur] = i;
				findcolor(n, cur+1, tmp);
			}
		}
	}
	
	private static String src = "3\r\n" + 
			"4\r\n" + 
			"1 2 3 4\r\n" + 
			"0 1 1 1\r\n" + 
			"1 0 1 1\r\n" + 
			"1 1 0 1\r\n" + 
			"1 1 1 0\r\n" + 
			"4\r\n" + 
			"1 2 2 1\r\n" + 
			"0 1 0 0\r\n" + 
			"1 0 1 0\r\n" + 
			"0 1 0 1\r\n" + 
			"0 0 1 0\r\n" + 
			"4\r\n" + 
			"1 1 2 2\r\n" + 
			"0 1 0 0\r\n" + 
			"1 0 1 0\r\n" + 
			"0 1 0 1\r\n" + 
			"0 0 1 0";
}
