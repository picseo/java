package d1003;

import java.util.Scanner;

public class nqueen {
	static boolean[][] visited = new boolean[11][11];
	static int result= 0;
	static int N = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			visited = new boolean[11][11];
			result = 0;
			N = sc.nextInt();
			
			for(int i = 0; i < N; i++) {
				visited[0][i] = true;
				find(1, N-1);
				visited[0][i] = false;
			}
			sb.append("#"+t+" "+result+"\n");
		}

		System.out.println(sb.toString());
	}

	private static void find(int row, int n) {
		if(row == N) {
			result++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(check(row, i)) {
				visited[row][i] = true;
				find(row+1,n-1);
				visited[row][i] = false;
			}
		}
	}

	private static boolean check(int row, int col) {
		int idx = 1;
		for(int i = row-1; i >=0; i--) {
			if(visited[i][col]) {
				return false;
			}
			if(col - idx >= 0) {
				if(visited[i][col-idx]) {
					return false;
				}
			}
			if(col+idx < N) {
				if(visited[i][col+idx]) {
					return false;
				}
			}
			idx++;
		}		
		
		return true;
	}

}
