package swea.d0210;

import java.io.FileInputStream;
import java.util.Scanner;
/**
 * sc.next().toCharArray();
 * 이거 완전 좋다.
 * **/
public class Solution1873_상호의배틀필드_서승희 {
	private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	private static char[] jun_dirs = {'^','>','v','<'};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1873.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			char[][] field  = new char[n][m];
			int j_x = 0;
			int j_y = 0;
			int j_dir = 0;
			
			//input 
			for(int i = 0; i <n ; i++) {
				//String input = sc.next();
				field[i] = sc.next().toCharArray();//********완전좋군
				for(int j = 0; j < m ; j++) {
					//field[i][j] = input.charAt(j);
					if(field[i][j] == '>') {//찾는 방법
						j_x = i;
						j_y = j;
						j_dir = 1; 
					}else if(field[i][j] == '<') {
						j_x = i;
						j_y = j;
						j_dir = 3; 
					}else if(field[i][j] == 'v') {
						j_x = i;
						j_y = j;
						j_dir = 2; 
					}else if(field[i][j] == '^') {
						j_x = i;
						j_y = j;
						j_dir = 0; 
					}
				}
			}
			
			int ad_len = sc.nextInt();
			String ad = sc.next();
			
			for(int ad_n = 0; ad_n < ad_len; ad_n++) {
				char now = ad.charAt(ad_n);
				int dir = 0;
				int j_nx = j_x;
				int j_ny = j_y;
				
				if(now == 'S') {
					j_nx = j_x + dirs[j_dir][0];
					j_ny = j_y + dirs[j_dir][1];
					
					while(isIn(j_nx, j_ny, m, n)) {
						if(field[j_nx][j_ny] == '*') {
							field[j_nx][j_ny] = '.';
							break;
						}else if(field[j_nx][j_ny] == '#'){
							break;
						}
						j_nx += dirs[j_dir][0];
						j_ny += dirs[j_dir][1];
					}
				}else {
					if(now == 'U') {
						dir = 0;
					}else if(now == 'D') {
						dir = 2;
					}else if(now == 'L') {
						dir = 3;
					}else if(now == 'R') {
						dir = 1;
					}
					
					j_nx = j_x + dirs[dir][0];
					j_ny = j_y + dirs[dir][1];
					j_dir = dir;
					
					if(isIn(j_nx, j_ny, m, n) && field[j_nx][j_ny] == '.') {
						field[j_x][j_y] = '.';
						j_x = j_nx;
						j_y = j_ny;
					}
					
					field[j_x][j_y] = jun_dirs[j_dir];

				}
			}
			
			System.out.print("#"+t+" ");
			for(int i =0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}//testcase
	}
	
	private static boolean isIn(int x, int y, int w, int h) {
		if(x >= 0 && x < h && y>= 0 & y < w) {
			return true;
		}else {
			return false;
		}
	}

}
