package d0902;

import java.util.*;

public class BJ_14238_출근기록 {
	static int[][][][][] memo = new int[51][51][51][3][3];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 String input = sc.next();
		 
		 int len = input.length();
		 int[] cnt = new int[3];
		 for(int i = 0; i < len; i++) {
			 cnt[input.charAt(i) - 'A'] ++;
		 }
		 
		 for(int[][][][] a : memo) {
			 for(int[][][] b : a) {
				 for(int[][] c : b) {
					 for(int[] d : c) {
						 Arrays.fill(d,  -1);
					 }
				 }
			 }
		 }
		 
		 if(find(cnt[0], cnt[1], cnt[2], 0, 0) == 1) {
			 System.out.println(one(cnt[0], cnt[1], cnt[2], 0, 0));
		 }else {
			 System.out.println(-1);
		 }
		 
		 return;
	}

	private static String one(int a, int b, int c, int p1, int p2) {
		if(a+b+c == 0) {
			return "";
		}
		
		memo[a][b][c][p1][p2] = 0;
		if(a > 0 && find(a-1, b, c, 0, p1) == 1) {
			return "A" + one(a-1, b, c, 0, p1);
		}
		
		if(b > 0 && p1 != 1 && find(a, b-1, c, 1, p1) == 1) {
			return "B" + one(a, b-1, c, 1, p1);
		}
		
		if(c > 0 && p1 != 2 && p2 != 2 && find(a, b, c-1, 2, p1) == 1) {
			return "C" + one(a, b, c-1, 2, p1);
		}		
		return "";
	}

	private static int find(int a, int b, int c, int p1, int p2) {
		if(memo[a][b][c][p1][p2] != -1) {
			return memo[a][b][c][p1][p2];
		}
		
		if(a+b+c == 0) {
			return 1;
		}
		
		memo[a][b][c][p1][p2] = 0;
		if(a > 0 && find(a-1, b, c, 0, p1) == 1) {
			memo[a][b][c][p1][p2] = 1;
			return memo[a][b][c][p1][p2];
		}
		
		if(b > 0 && p1 != 1 && find(a, b-1, c, 1, p1) == 1) {
			memo[a][b][c][p1][p2] = 1;
			return memo[a][b][c][p1][p2];
		}
		
		if(c > 0 && p1 != 2 && p2 != 2 && find(a, b, c-1, 2, p1) == 1) {
			memo[a][b][c][p1][p2] = 1;
			return memo[a][b][c][p1][p2];
		}		
		
		return memo[a][b][c][p1][p2];
	}

}
