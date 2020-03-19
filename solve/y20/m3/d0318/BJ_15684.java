package d0318;

import java.util.Arrays;
import java.util.Scanner;
/*완탐으로 하면 풀수 있을 것 같은데 문제는
 * 정보를 어떤식으로 저장해야 할지 모르겠다.
 * 
 * 
 * 다른 사람의 코드를 봤는데 
 * 일단 각 줄에 홀수인 갯수가 3개보다 많으면 일단 필요한 수가 3개가 넘게 되므로 무조건 -1이 된다. -> 가지치기 1
 * 
 * 좌표를 가지고 dfs를 할 때는, x, y위치를 가지고 있는게 이전 부분 탐색을 하지 않을 수 있어서 좋은 것같아.
 *
 * 고쳐야 된다. 못하고 있다........ㅠㅠ 왜 위에 두개 적용하는데 안되지.....
 * 
 * */
public class BJ_15684 {
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
		
//		for(int i = 0; i < N+1; i++) {
//			System.out.println(Arrays.toString(ladder[i]));
//		}
//		System.out.println();
		
		tmp = ladder.clone();
		result = -1;
		if(FindOddNum() > 3) {
			result = -1;
		}else if(dfs(0, 0)) {
			result = 0;
		}else if(dfs(0, 1)) {
			result = 1;
		}else if(dfs(0, 2)) {
			result = 2;
		}else if(dfs(0, 3)) {
			result = 3;
		}else {
			result = -1;
		}
		
		System.out.println(result);
	}

	private static int FindOddNum() {
		int result =0;
		for(int i = 1 ; i < N ; i++) {
			int tmp = 0;
			for(int j = 1 ; j < M+1 ; j++) {
				if(ladder[i][j] != 0) {
					tmp++;
				}
			}
			if(tmp%2 != 0) {
				result++;
			}
		}
		return result;
	}

	private static boolean dfs(int cur, int num) {
		if(cur == num) {
//			for(int i = 0; i < N+1; i++) {
//				System.out.println(Arrays.toString(tmp[i]));
//			}
//			System.out.println();
			
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
