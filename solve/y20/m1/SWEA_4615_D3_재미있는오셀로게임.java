package algo_basic.SWEA.mon1;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4615_D3_재미있는오셀로게임 {
	public static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};//8방향
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t= 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] pan = new int[n][n];
			
			//초기 돌들을 설정(4개)
			int x = n/2 -1;
			int y = n/2 -1;
			
			pan[x][y] = 2;
			pan[x][y+1] = 1;
			pan[x+1][y] = 1;
			pan[x+1][y+1] = 2;
			
			for(int a = 0; a < n ; a++) {
				System.out.println(Arrays.toString(pan[a]));
			}
			System.out.println();
			
			//돌을 두기 시작
			int dol_num = 4;
			for(int i = 0; i < m ; i++) {
				x = sc.nextInt() -1;
				y = sc.nextInt() -1;
				int color = sc.nextInt();
				int stop = 0;// 두지못하게 되면 1, 1일때도 두지 못하면 2끝내기, 1일때 두었다면 다시 0으로 초기화
				boolean now = false;
				boolean ban = false;
				boolean check = false;
				
				if(!isIn(x, y, n) || pan[x][y] != 0) {
					stop++;
					continue;
				}
				
				for(int j = 0; j <8; j++) {
					ban = false;
					now = false;
					int nx = x + dirs[j][0];
					int ny = y + dirs[j][1];
					int nnx = 0;
					int nny = 0;
					
					if(isIn(nx, ny, n)) {
						//반대색 돌만 찾기
						if(pan[nx][ny] != 0 && pan[nx][ny] != color) {
							//반대색 돌을 찾음
							ban = true;
							
							nnx = nx + dirs[j][0];
							nny = ny + dirs[j][1];
							
							while(isIn(nnx, nny, n)) {
								if(pan[nnx][nny] == color) {
									//같은색 돌을 만남 - >  여기에는 돌을 둘수 있다.
									now = true;
									break;
								}else if(pan[nnx][nny] == 0) {
									break;
								}
								
								nnx += dirs[j][0];
								nny += dirs[j][1];
							}
							
						}
						
						if(ban && now) {
							//조건에 맞으면 색을 바꾸어줌
							if(!check) {
								check = true;
							}

							while(true) {
								pan[nnx][nny] = color;
								nnx -= dirs[j][0];
								nny -= dirs[j][1];
								
								if(nnx == x-dirs[j][0] && nny == y-dirs[j][1]) {
									break;
								}
							}
						}						
					}
				}//8방탐색
				
				for(int a = 0; a < n ; a++) {
					System.out.println(Arrays.toString(pan[a]));
				}
				System.out.println();
				
				if(!check) {
					stop++;
				}else {
					dol_num++;
					stop = 0;
				}
				
				//둘 다 놓지 못했다면
				if(stop == 2) {
					break;
				}
				
				//바둑판이 가득차면
				if(dol_num == n*n) {
					break;
				}
			}//input positions
			
			
			int b_num = 0;
			int w_num = 0;
			for(int i = 0; i < n ; i++) {
				for(int j = 0; j < n; j++) {
					if(pan[i][j] == 1) {
						b_num++;
					}else if(pan[i][j] == 2) {
						w_num++;
					}
				}
			}
			
			System.out.println("#"+t+" "+b_num+" "+w_num);
		}
	}
	
	private static boolean isIn(int x, int y, int n) {
		if(x >= 0 && x < n && y >= 0 && y < n) {
			return true;
		}else {
			return false;
		}		
	}
	
	private static String src = "\r\n" + 
			"1\r\n" + 
			"4 12\r\n" + 
			"1 2 1\r\n" + 
			"1 1 2\r\n" + 
			"4 3 1\r\n" + 
			"4 4 2\r\n" + 
			"2 1 1\r\n" + 
			"4 2 2\r\n" + 
			"3 4 1\r\n" + 
			"1 3 2\r\n" + 
			"2 4 1\r\n" + 
			"1 4 2\r\n" + 
			"4 1 2\r\n" + 
			"3 1 2";
}
