package d0825;

import java.util.Arrays;
import java.util.Scanner;

/*
 * �ùķ��̼�
 * 
 * ȸ���� �����ϴ°� ���
 * 
 * ������ ���ڸ� Ȯ���Ϸ��� �����ϴٰ� �ٷ� ���ڸ� ����� �� �ֺ��� ������ϱ�
 * boolean�迭�� �̿��ؼ� true�϶��� ����, false�ϴ�� true�� �ٲٴ� �� �̿��ؾ� �ڴ�. ������ߴµ� �̰͵� ���� �����ƴѰ�
 * 
 * int �迭�� �̿��ؼ� -1 ����, 0 �̹� ���ķ� ������ , 1 ���� ���ùٶ� ���� �ؾ߰ڴ�
 * �׷��� �̷��� �ϸ� ĭ�� ���� ������ �Ѵ�.
 * 50*50*1000�̴ϱ� �ص� �Ǳ��ѵ� ���� ������.
 * 
 * */
public class BJ_17822_���ǵ����� {
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
			int dir = sc.nextInt();//0 : �ð�, 1 : �ݽð�
			int len = sc.nextInt();

			//���� ������
			int gob = 1;
			while(gob*cnum <= N) {
				turn(gob*cnum, dir, len);
				gob++;
			}

			//��ġ�� �� ����
			int[][] dirs = {{0, 1}, {1, 0}, {0, M-1}, {-1, 0}};

			//��ġ�� �� ����
			int cnt = 0;
			//��ġ�� -�� ǥ��, 0�� ����
			for(int i = 1; i <= N; i++) {
				for(int j = 0; j < M; j++) {
					if(circles[i][j] == 0) continue;

					int now = Math.abs(circles[i][j]);

					for(int d = 0; d < 4; d++) {
						int ni = i + dirs[d][0];
						int nj = (j + dirs[d][1])%M;

						if(ni > 0 && ni <= N) {//�������� �����Ҷ�
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
				//-�� ǥ�õ� ���� 0���� �ٲپ��ֱ�
				for(int i = 1; i <= N; i++) {
					for(int j = 0; j < M; j++) {
						if(circles[i][j] < 0) {
							circles[i][j] = 0;
						}
					}
				}
				
			}else {//�����ǳ����� �� �ٲ��ֱ�
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
