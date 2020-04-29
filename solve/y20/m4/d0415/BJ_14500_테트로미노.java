package d0415;

import java.util.Scanner;

/*
 * 전체 맵이 500*500이고 23개니까 1250000
 * 백만 몇개니까 다 구하는 방향으로 했고
 * 미리 도형을 만들어서 칸 마다 둘수 있는지 여부를 확인한 후 
 * 놓을 수 있으면 계산을 해서 최대값이 되는 경우 업데이트
 * 완탐했다. 
 * */
public class BJ_14500_테트로미노 {
	static int N, M;
	static int[][][] tetrominos = {
			//길쭉이
			{{0, 0}, {0, 1}, {0, 2}, {0,3}}, {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
			//사각이
			{{0, 0}, {0, 1}, {1, 0}, {1, 1}},
			//엘자형
			{{0, 0}, {1, 0}, {2, 0}, {2, 1}}, {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
			{{0, 0}, {-1, 0}, {-2, 0}, {-2, -1}}, {{0, 0}, {0, -1}, {0, -2}, {1, -2}},
			//엘자형 대칭
			{{0, 0}, {1, 0}, {2, 0}, {2, -1}}, {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
			{{0, 0}, {-1, 0}, {-2, 0}, {-2, 1}}, {{0, 0}, {0, -1}, {0, -2}, {-1, -2}},
			//꼬불이
			{{0, 0}, {1, 0}, {1, 1}, {2, 1}}, {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
			{{0, 0}, {-1, 0}, {-1, -1}, {-2, -1}}, {{0, 0}, {0, -1}, {1, -1}, {1, -2}},
			//꼬불이 대칭
			{{0, 0}, {1, 0}, {1, -1}, {2, -1}}, {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
			{{0, 0}, {-1, 0}, {-1, 1}, {-2, 1}}, {{0, 0}, {0, -1}, {-1, -1}, {-1, -2}},
			//탁자형
			{{0, 0}, {0, 1}, {0, 2}, {1, 1}}, {{0, 0}, {-1, 0}, {-2, 0}, {-1, 1}},
			{{0, 0}, {0, -1}, {0, -2}, {-1, -1}}, {{0, 0}, {1, 0}, {2, 0}, {1, -1}}
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] map = new int[N][M];
		int result = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int t = 0; t < tetrominos.length; t++) {
					int tmp = 0;
					for(int n = 0; n < 4; n++) {
						int nx = i + tetrominos[t][n][0];
						int ny = j + tetrominos[t][n][1];
						if(isIn(nx, ny)) {
							tmp += map[nx][ny];
						}else {
							tmp = -1;
							break;
						}
					}
					if(result < tmp) {
						result = tmp;
					}
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean isIn(int x, int y) {
		if(x >=0 && x < N && y >=0 && y < M) {
			return true;
		}
		return false;
	}
}
