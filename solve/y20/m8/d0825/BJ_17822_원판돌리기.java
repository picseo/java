package d0825;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 시뮬레이션
 * 
 * 회전을 구현하는건 쉬운데
 * 
 * 인접한 숫자를 확인하려면 인접하다고 바로 숫자를 지우면 그 주변을 못지우니까
 * boolean배열을 이용해서 true일때는 무시, false일대는 true로 바꾸는 걸 이용해야 겠다. 고생각했는데 이것도 같은 문제아닌가
 * 
 * int 배열을 이용해서 -1 존재, 0 이번 이후로 지워짐 , 1 이제 무시바람 으로 해야겠다
 * 그런데 이렇게 하면 칸을 같이 돌려야 한다.
 * 50*50*1000이니까 해도 되긴한데 완전 귀찮다.
 * 
 * */
public class BJ_17822_원판돌리기 {
	static int N, M, T;
	static int[][] circles;
	static int[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();

		circles = new int[N+1][M];
		visited = new int[N+1][M];

		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				circles[i][j] = sc.nextInt();
			}
		}

		while((T--) > 0) {
			int cnum = sc.nextInt();
			int dir = sc.nextInt();//0 : 시계, 1 : 반시계
			int len = sc.nextInt();

			//원판 돌리기
			int gob = 1;
			while(gob*cnum <= N) {
				turn(gob*cnum, dir, len);
				gob++;
			}

			//겹치는 수 제외
			int[][] dirs = {{0, 1}, {1, 0}, {0, M-1}, {-1, 0}};

			//겹치는 수 갯수
			int cnt = 0;
			//겹치면 -로 표시, 0은 무시
			for(int i = 1; i <= N; i++) {
				for(int j = 0; j < M; j++) {
					if(circles[i][j] == 0) continue;

					int now = Math.abs(circles[i][j]);

					for(int d = 0; d < 4; d++) {
						int ni = i + dirs[d][0];
						int nj = (j + dirs[d][1])%M;

						if(ni > 0 && ni <= N) {//범위내에 존재할때
							if(now == Math.abs(circles[ni][nj])) {
								circles[i][j] = now*-1;
								circles[ni][nj] = now*-1;
								cnt++;
							}
						}
					}
				}
			}

			if(cnt != 0) {
				//-로 표시된 수는 0으로 바꾸어주기
				for(int i = 1; i <= N; i++) {
					for(int j = 0; j < M; j++) {
						if(circles[i][j] < 0) {
							circles[i][j] = 0;
						}
					}
				}
				
			}else {//각원판내에서 값 바꿔주기
				double mid = 0;
				double last = 0;
				for(int i = 1; i <= N; i++) {
					for(int j = 0; j < M; j++) {
						if(circles[i][j] != 0) {
							mid += circles[i][j];
							last++;
						}
					}
				}
				
				mid /= last;
				
				for(int i = 1; i <= N; i++) {
					for(int j = 0; j < M; j++) {
						if(circles[i][j] != 0) {
							if(circles[i][j] < mid) {
								circles[i][j] += 1;
							}else if(circles[i][j] > mid) {
								circles[i][j] -= 1;
							}
						}
					}
				}
				
			}
		}

		int result= 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				result += circles[i][j];
			}
		}
		
		System.out.println(result);
	}

	private static void turn(int cnum, int dir, int len) {
		int plus = 0;
		if(dir == 0) {
			plus = 1;
		}else {
			plus = M-1;
		}

		while((len--)>0) {
			int tmp = circles[cnum][0];
			int i = 0;
			int idx = 0;
			while((i++) < M) {
				int next = (idx + plus) % M;

				int ntmp = circles[cnum][next];
				circles[cnum][next] = tmp;

				tmp = ntmp;

				idx = next;
			}
		}		
	}



}
