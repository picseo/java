package d0820;

import java.util.Arrays;
import java.util.Scanner;

/*
a, b, c의 갯수, 전날, 전전날 누가 나왔는지 를 기록해야 한다. -> 5차원 배열을 사용
상태는 확인안된거/ 확인 됨(불가능, 가능) -> 3가지 상태가 존재하므로 int배열을 이용한다.

50*50*50*3*3*4byte

*/
public class BJ_14238_출근기록_repeat {
	private static int[][][][][] memo = new int[51][51][51][3][3];
	private static int[] cnt = new int[3];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		//배열 초기화
		for(int[][][][] a : memo) {
			for(int[][][] b : a) {
				for(int[][] c : b) {
					for(int[] d : c) {
						Arrays.fill(d, -1);
					}
				}
			}
		}
		
		//갯수를 센다.
		for(int i = 0; i < input.length(); i++) {
			cnt[input.charAt(i)-'A']++;
		}
		
		find(cnt[0], cnt[1], cnt[2], 0, 0);
		
		if(memo[cnt[0]][cnt[1]][cnt[2]][0][0] == 1) {
			System.out.println(find_result(cnt[0], cnt[1], cnt[2], 0, 0));
		}else {
			System.out.println(-1);
		}
		
	}

	private static String find_result(int a, int b, int c, int p1, int p2) {
		
		if(a > 0) {
			if(find(a-1, b, c, 0, p1) == 1) {
				return "A" + find_result(a-1, b, c, 0, p1);
			}
		}
		
		if(b > 0 && p1 != 1) {
			if(find(a, b-1, c, 1, p1) == 1) {
				return "B" + find_result(a, b-1, c, 1, p1);
			}
		}
		
		if(c > 0 && p1 != 2 && p2 != 2) {
			if(find(a, b, c-1, 2, p1) == 1) {
				return "C" + find_result(a, b, c-1, 2, p1);
			}
		}		
		
		return "";
	}

	private static int find(int a, int b, int c, int p1, int p2) {
		//이미 계산 되었거나, 끝에 도달한건 계산까지 하지 않는다.
		int now = memo[a][b][c][p1][p2];
		
		if(a + b + c == 0) {
			memo[a][b][c][p1][p2] = 1;
			return memo[a][b][c][p1][p2];
		}
		
		if(now != -1) {
			return now;
		}
		
		//아직 확정되지 않았다면 계산을 한다.
		
		if(a > 0) {
			if(find(a-1, b, c, 0, p1) == 1) {
				memo[a][b][c][p1][p2] = 1;
				return memo[a][b][c][p1][p2];
			}
		}
		
		if(b > 0 && p1 != 1) {
			if(find(a, b-1, c, 1, p1) == 1) {
				memo[a][b][c][p1][p2] = 1;
				return memo[a][b][c][p1][p2];
			}
		}
		
		if(c > 0 && p1 != 2 && p2 != 2) {
			if(find(a, b, c-1, 2, p1) == 1) {
				memo[a][b][c][p1][p2] = 1;
				return memo[a][b][c][p1][p2];
			}
		}
		
		memo[a][b][c][p1][p2] = 0;
		return 0;
	}
	
	
	
}


