	package algo_basic.day2;
	
	import java.util.Scanner;
	
	public class SWEA_1210_D4_Ladder1 {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int[][] arr = new int[100][100];
			int dirs[][] = {  { 0, 1 }, { 0, -1 },{ -1, 0 } };
			int end_x=0,end_y=0;
			for (int i = 0; i < 10; i++) {
				int end = -1;
				int tc = sc.nextInt();

				for (int x = 0; x < 100; x++) {
					for (int y = 0; y < 100; y++) {
						arr[x][y] = sc.nextInt();
						if(arr[x][y]==2) {
							end_x=x;
							end_y=y;
						}
					}
				}
	
				end=find(end_x-1,end_y, arr, dirs);
				System.out.printf("#%d %d\n", tc, end);
				}	
				
				
			}
		
	
		public static int find(int x,int y, int[][] arr, int[][] dirs) {
			int end = -1;
			
			while(x>0) {	
					for (int d = 0; d < dirs.length; d++) {
						int nx = dirs[d][0] + x;
						int ny = dirs[d][1] + y;
	
						if (isIn(nx, ny, arr)) {
							if (arr[nx][ny] == 1) {
								arr[x][y] = 0;
								x = nx;
								y = ny;
								break;
							}
						}
					}
			}
				
			
			return y;
	
		}
	
		public static boolean isIn(int x, int y, int[][] arr) {
			return (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length);
		}
	
		public static boolean isEnd(int x) {
			return (x < 100);
		}
	
	}
