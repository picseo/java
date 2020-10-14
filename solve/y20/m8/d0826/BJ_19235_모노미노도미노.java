package d0826;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_19235_모노미노도미노 {	
	static boolean[][] gmap = new boolean[6][4];
	static boolean[][] bmap = new boolean[4][6];

	static int[][] dirs = {{0, 0}, {0, 1}, {1, 0}};
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for(int i = 0; i < N; i++) {			
			int t = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			green(0, y, t);
			/*
			if(t == 1) {
				blue(x, 0, t);
				green(0, y);
			}else if(t==2) {
				//(x, y), (x, y+1)
				blue(x, 0, x, 1);
				gree(0, y, 0, y+1);
			}else {//t==3
				//(x, y), (x+1, y)
				blue(x, 0, x+1, 0);
				green(0, y, 1, y);				
			}*/
		}

	}

	private static void green(int x, int y, int type) {
		int[][] block = new int[2][2];
		block[0][0] = x;
		block[0][1] = y;

		block[1][0] = x + dirs[type-1][0];
		block[1][1] = y + dirs[type-1][1];

		/*for(int i = 0; i < 2; i++) {
			System.out.println(Arrays.toString(block[i]));
		}*/


		//조각의 모든 부분이 내려갈 수 있는지를 확인한다 : 모두 내려갈 수 있으면 반복, 아니면 stop -> while
		//(0, 1)
		while(true) {
			boolean check = false;
			for(int i = 0; i < 2; i++) {
				int nowx = block[i][0];
				int nowy = block[i][1];

				//blue, green다른점
				int nx = nowx + 1;
				int ny = nowy + 0;

				if(isIn(nx, ny)) {//범위내라면
					//겹치는지확인한다.
					if(gmap[nx][ny]) {//겹치면 나가기
						check = true;
						break;
					}					
				}
			}

			if(check) {
				break;
			}else {
				for(int i = 0; i < 2; i++) {
					block[i][0] += 1;
				}
			}
		}

		//5열부터 꽉찬 열이 있는지 확인하고, 없으면 다음 열을 확인
		//꽉찼다면 지운다음에 하나씩 당겨온다. 그리고 다시 해당 열에서부터 확인시작
		for(int i = 5; i >= 2; i--) {
			boolean check = true;
			for(int j = 0; j < 4; j++) {
				if(!gmap[i][j]) {
					check = false;
					break;
				}
			}

			if(check) {
				result++;
				//4부터 0까지 땡겨온다.
				for(int r = 4; r <=1; r--) {
					for(int c = 0; c < 4; c++) {
						if(gmap[r][c]) {
							gmap[r+1][c] = true;
						}else {
							gmap[r+1][c] = false;
						}
					}
				}

				Arrays.fill(gmap[0], false);
				i++;//다시 그줄부터 확인
			}			
		}

		//2열까지 모두 확인이 되었다면 0, 1열을 확인한다.
		//0열에만 있다면 5열을 없애고 당기고, 0,1 모두 있다면 4, 5열을 없애고 당긴다.
		for(int r = 0; r < 2; r++) {
			boolean check = false;
			for(int i = 0; i <4 ;i++) {
				if(gmap[0][i]) {
					check = true;
					break;
				}
			}

			if(check = true) {
				for(int rr = 4; rr <=2; rr--) {
					for(int c = 0; c < 4; c++) {
						if(gmap[rr][c]) {
							gmap[rr+1][c] = true;
						}else {
							gmap[rr+1][c] = false;
						}
					}
				}

				Arrays.fill(gmap[2], false);
			}
		}
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				if(gmap[i][j]) {
					System.out.print(1);
				}else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
	}

	private static boolean isIn(int x, int y) {
		if(x >= 0 && x <6 && y >=0 && y < 4) {
			return true;
		}
		return false;
	}



}
