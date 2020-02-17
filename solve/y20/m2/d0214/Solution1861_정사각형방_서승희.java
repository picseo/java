package swea.d0214;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution1861_정사각형방_서승희 {
	private static int[][] rooms = null;
	private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//상우하좌
	private static int N = 0;
	private static int Max = Integer.MIN_VALUE;
	private static int num = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res\\sinput.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			rooms = new int[N][N];
			Max = Integer.MIN_VALUE;
			num = Integer.MAX_VALUE;
			
			for(int i = 0; i <N ; i++) {
				for(int j =0; j < N; j ++) {
					rooms[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i <N ; i++) {
				for(int j =0; j < N; j ++) {
					int now_max = dfs(i, j, 1);
					if(now_max > Max) {
						Max = now_max;
						num = rooms[i][j];
					}else if(Max == now_max){
						if(num > rooms[i][j])
							num = rooms[i][j];
					}
				}
			}
			System.out.println("#"+t+" "+num+" "+Max);
		}
	}

	private static int dfs(int x, int y, int len) {
		boolean stop = true;
		int tmp = 0;
		int max = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if(isIn(nx, ny) && (rooms[nx][ny] == (rooms[x][y] + 1))) {
				stop = false;
				tmp = dfs(nx, ny, len+1);	
				if(tmp > max) {
					max = tmp;
				}
			}
		}
		
		if(stop) {//아무곳도 안들거간곳 == 마지막위치 == 현재위치를 return
			return len;
		}else {//4방향중 가장 긴 값을 return 
			return max;
		}		
	}
	private static boolean isIn(int x, int y) {
		if(x >= 0 && x <N && y >=0 && y< N) {
			return true;
		}else {
			return false;
		}
	}
}
