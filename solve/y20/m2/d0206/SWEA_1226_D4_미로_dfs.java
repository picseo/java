package algo_basic.day6.permutation;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1226_D4_미로_dfs {
	private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	private static int[][] map;
	private static boolean[][] check;
	//private static int result = 0;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1226.txt"));
		Scanner sc = new Scanner(System.in);

		for(int t = 1; t<=10; t++) {
			int num = sc.nextInt();

			int sx = 0, sy = 0, ex= 0, ey= 0;
			map = new int[16][16];
			check = new boolean[16][16];

			for(int i = 0; i < 16; i ++) {
				String map_row = sc.next();
				for(int j = 0; j < 16; j++) {
					map[i][j] = map_row.charAt(j)-'0';
					if(map[i][j] == 2) {
						sx = i;
						sy = j;
					}else if(map[i][j] == 3) {
						ex = i;
						ey = j;
					}
				}
			}

			//인풋 받음 
			boolean result = dfs(sx, sy, ex, ey);
			System.out.print("#"+num+" ");
			if(result) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			/*result = 0;
			dfs(sx, sy, ex, ey);
			System.out.print("#"+num+" "+result);*/

		}
	}

	/*private static void dfs(int sx, int sy, int ex, int ey) {
		check[sx][sy] = true;
		if(sx == ex && sy == ey)
			result = 1;

		for(int i = 0; i < 4; i ++) {
			int nx = sx + dirs[i][0];
			int ny = sy + dirs[i][1];

			if(map[nx][ny] != 1 && !check[nx][ny]) {
				dfs(nx, ny, ex, ey);
			}
		}
	}*/
	
	private static boolean dfs(int sx, int sy, int ex, int ey) {
		check[sx][sy] = true;
		if(sx == ex && sy == ey)
			return true;

		for(int i = 0; i < 4; i ++) {
			int nx = sx + dirs[i][0];
			int ny = sy + dirs[i][1];

			if(map[nx][ny] != 1 && !check[nx][ny]) {
				if(dfs(nx, ny, ex, ey))
					return true;
			}
		}
		return false;
	}
}
