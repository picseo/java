package d0318;

import java.util.Arrays;
import java.util.Scanner;
/*��Ž���� �ϸ� Ǯ�� ���� �� ������ ������
 * ������ ������� �����ؾ� ���� �𸣰ڴ�.
 * 
 * 
 * �ٸ� ����� �ڵ带 �ôµ� 
 * �ϴ� �� �ٿ� Ȧ���� ������ 3������ ������ �ϴ� �ʿ��� ���� 3���� �Ѱ� �ǹǷ� ������ -1�� �ȴ�. -> ����ġ�� 1
 * 
 * ��ǥ�� ������ dfs�� �� ����, x, y��ġ�� ������ �ִ°� ���� �κ� Ž���� ���� ���� �� �־ ���� �Ͱ���.
 *
 * ���ľ� �ȴ�. ���ϰ� �ִ�........�Ф� �� ���� �ΰ� �����ϴµ� �ȵ���.....
 * 
 * */
public class BJ_15684_2 {
	static int N, M, H;
	static int[][] ladder, tmp;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		N = sc.nextInt();
		H = sc.nextInt();
		M = sc.nextInt();
		
		ladder = new int[N+1][M+1];
		for(int i = 0; i < H; i++) {
			int floor =sc.nextInt();
			int from = sc.nextInt();
			
			ladder[from][floor] = from+1;
			ladder[from+1][floor] = from;
		}
		
		for(int i = 0; i < N+1; i++) {
			System.out.println(Arrays.toString(ladder[i]));
		}
		System.out.println();
		
		tmp = ladder.clone();
		result = -1;
		if(FindOddNum() > 3) {
			result = -1;
		}else {
			for(int i = 0; i < 4; i++) {
				if(ndfs(0, i, 1, 1)) {
					result = i;
					break;
				}
			}
		}
		
		System.out.println(result);
	}

	private static int FindOddNum() {
		int res =0;
		for(int i = 1 ; i < N ; i++) {
			int tmp = 0;
			for(int j = 1 ; j < M+1 ; j++) {
				if(ladder[i][j] > i) {//������ 0�� �ƴҶ��� �ƴ϶� �ڽź��� ū ������ ������ �����־�� �ߺ��� ���� �ʴ´�.
					tmp++;
				}
			}
			if(tmp%2 != 0) {
				res++;
			}
		}
		return res;
	}

	private static boolean dfs(int cur, int num) {
		if(cur == num) {			
			if(check()) {
				return true;
			}
			return false;
		}else {
			for(int i = 1 ; i < N ; i++) {
				for(int j = 1 ; j < M+1 ; j++) {
					if(tmp[i][j] != 0 || tmp[i+1][j] != 0) {
						continue;
					}else {
						tmp[i][j] = i+1;
						tmp[i+1][j] = i;
						if(dfs(cur+1, num)) {
							return true;
						}
						tmp[i][j] = 0;
						tmp[i+1][j] = 0;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean ndfs(int cur, int num, int x, int y) {
		if(cur == num) {
			for(int i = 0; i < N+1; i++) {
				System.out.println(Arrays.toString(tmp[i]));
			}
			System.out.println();
			
			if(check()) {
				return true;
			}
			return false;
		}else {
			for(int i = x ; i < N ; i++) {
				for(int j = y ; j < M+1 ; j++) {
					if(tmp[i][j] != 0 || tmp[i+1][j] != 0) {
						continue;
					}else {
						tmp[i][j] = i+1;
						tmp[i+1][j] = i;
						if(ndfs(cur+1, num, i, j+1)) {
							return true;
						}
						tmp[i][j] = 0;
						tmp[i+1][j] = 0;
					}
				}
				y = 1;
			}
		}
		return false;
	}
	
	private static boolean check() {
		for(int i = 1; i < N+1; i++) {
			int now = i;
			for(int j = 1; j < M+1; j++) {
				int next = now;
				if(tmp[now][j] != 0) {
					next = tmp[now][j];
				}
				
				now = next;
			}
			
			if(now != i) {
				return false;
			}
		}
		return true;
	}
	
	
	private static String src = "6 5 6\r\n" + 
			"1 1\r\n" + 
			"3 2\r\n" + 
			"1 3\r\n" + 
			"2 5\r\n" + 
			"5 5";
}
