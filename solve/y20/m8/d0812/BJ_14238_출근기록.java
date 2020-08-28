package d0812;

import java.util.Arrays;
import java.util.Scanner;
//재귀를 사용하지만 반복을 줄이기 위해 memoization을 사용하였다.
public class BJ_14238_출근기록 {
	static int[] cnt = new int[3];
	static int[][][][][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		for(int i = 0; i < input.length(); i++) {
			cnt[input.charAt(i) - 'A']++;
		}
		
		memo = new int[51][51][51][3][3];
		for(int i = 0; i < 51; i++) {
			for(int j = 0; j < 51; j++) {
				for(int k = 0; k < 51; k++) {
					for(int l = 0; l < 3; l++) {
						Arrays.fill(memo[i][j][k][l], -1);
					}
				}
			}
		}
		
		if(find(cnt[0], cnt[1], cnt[2], 0, 0) != 1) {
			System.out.println(-1);
		}else {
			System.out.println(find_result(cnt[0], cnt[1], cnt[2], 0, 0));
		}
		
		return;
	}

	private static String find_result(int a, int b, int c, int p1, int p2) {
		if(a + b+ c == 0) {
			return "";
		}
		if(a >0 && memo[a-1][b][c][0][p1] == 1) {
			return "A" + find_result(a-1, b, c, 0, p1);
		}
		
		if(b >0 && memo[a][b-1][c][1][p1] == 1) {
			return "B" + find_result(a, b-1, c, 1, p1);
		}
		
		if(c >0 && memo[a][b][c-1][2][p1] == 1) {
			return "C" + find_result(a, b, c-1, 2, p1);
		}
		
		return "";
	}

	private static int find(int a, int b, int c, int p1, int p2) {
		int now = memo[a][b][c][p1][p2];
		
		if(a + b + c == 0) {
			memo[a][b][c][p1][p2] = 1;
			return memo[a][b][c][p1][p2];
		}
		
		if(now != -1) {
			return now;
		}
		
		//a가 일을 한다.
		if(a > 0 && find(a-1, b, c, 0, p1) == 1) {
			memo[a][b][c][p1][p2] = 1;
			return memo[a][b][c][p1][p2];
		}
		
		//b가 일을 한다.
		if(b > 0 && p1 != 1 && find(a, b-1, c, 1, p1) == 1) {
			memo[a][b][c][p1][p2] = 1;
			return memo[a][b][c][p1][p2];
		}
		
		//c가 일을 한다.
		if(c > 0 && p1 != 2 && p2 != 2) {
			if(find(a, b, c-1, p1, p2) == 1) {
				memo[a][b][c][p1][p2] = 1;
				return memo[a][b][c][p1][p2];
			}
		}
		
		memo[a][b][c][p1][p2] = 0;
		return memo[a][b][c][p1][p2];
	}
	
	
}
