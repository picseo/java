package d0826;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_19235_���̳뵵�̳� {	
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


		//������ ��� �κ��� ������ �� �ִ����� Ȯ���Ѵ� : ��� ������ �� ������ �ݺ�, �ƴϸ� stop -> while
		//(0, 1)
		while(true) {
			boolean check = false;
			for(int i = 0; i < 2; i++) {
				int nowx = block[i][0];
				int nowy = block[i][1];

				//blue, green�ٸ���
				int nx = nowx + 1;
				int ny = nowy + 0;

				if(isIn(nx, ny)) {//���������
					//��ġ����Ȯ���Ѵ�.
					if(gmap[nx][ny]) {//��ġ�� ������
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

		//5������ ���� ���� �ִ��� Ȯ���ϰ�, ������ ���� ���� Ȯ��
		//��á�ٸ� ��������� �ϳ��� ��ܿ´�. �׸��� �ٽ� �ش� ���������� Ȯ�ν���
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
				//4���� 0���� ���ܿ´�.
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
				i++;//�ٽ� ���ٺ��� Ȯ��
			}			
		}

		//2������ ��� Ȯ���� �Ǿ��ٸ� 0, 1���� Ȯ���Ѵ�.
		//0������ �ִٸ� 5���� ���ְ� ����, 0,1 ��� �ִٸ� 4, 5���� ���ְ� ����.
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
