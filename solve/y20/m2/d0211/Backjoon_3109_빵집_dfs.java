package swea.d0211;

import java.util.Arrays;
import java.util.Scanner;
//시간초과 --> 갖던길은 이제 다른 지점에서 도달할 수 없으니까 x를 유지해야 했다.
//막힌길도 x로 유지해놔야 다음에 출발하는 점이 다시 반복하지 않게 해줘서
//시간을 아낄수 있다.
//
public class Backjoon_3109_빵집_dfs {
	private static int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}};
	private static int r = 0;
	private static int c = 0;
	private static char[][] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		
		input = new char[r][c];
		for(int i = 0; i < r; i++) {
			input[i] = sc.next().toCharArray();
		}
		
		int result = 0;
		for(int i = 0; i < r; i++) {
			input[i][0] = 'x';
			if(dfs(c-1, i, 0)) {
				result++;
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean dfs(int n, int x, int y) {
    	if(n == y) {
			return true;
		}else {
			for(int i = 0; i < 3; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];

				if(nx >= 0 && nx < r && input[nx][ny] == '.') {
					input[nx][ny] = 'x';
					if(dfs(n, nx, ny)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}