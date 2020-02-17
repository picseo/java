package swea.d0211;

import java.util.Arrays;
import java.util.Scanner;
//시간초과
//
public class Backjoon_3109_빵집 {
	private static int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}};
	private static int r = 0;
	private static int c = 0;
	private static char[][] input;
	private static boolean[][] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		r = sc.nextInt();
		c = sc.nextInt();
		
		input = new char[r][c];
		check = new boolean[r][c];
		for(int i = 0; i < r; i++) {
			input[i] = sc.next().toCharArray();
		}
		
		int result = 0;
		for(int i = 0; i < r; i++) {
			input[i][0] = 'x';
			if(!check[i][0] && dfs(c-1, i, 0)) {
				result++;
			}else {
				break;
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean dfs(int n, int x, int y) {
		if(check[x][y]) {
			return false;
		}
		
		if(n == y) {
			return true;
		}else {
			for(int i = 0; i < 3; i++) {
				int nx = x + dirs[i][0];
				int ny = y + dirs[i][1];

				if(nx >= 0 && nx < r && input[nx][ny] == '.') {
					input[nx][ny] = 'x';
					if(!check[nx][ny] && dfs(n, nx, ny)) {
						check[nx][ny] = true;
						return true;
					}else {
					}
					input[nx][ny] = '.';//이미지난 길은 지나지 못한다는 조건때문에 이게 불필요하다. 시간초과의주범
				}
			}
		}
		check[x][y] = true;
		return false;
	}
	
	private static String src = "5 5\r\n" + 
			".xx..\r\n" + 
			"..x..\r\n" + 
			".....\r\n" + 
			"...x.\r\n" + 
			"...x.";
}
