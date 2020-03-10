package d0303;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 이 문제는 모래탑이 아니라 파도를 기준으로 진행해야 했다.
 * 모래탑을 기준으로 할 경우 시간초과가 발생한다.
 * 
 * 
 * */
public class SWEA_1907_D5_모래성쌓기_복습 {
	public static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	private static int n;
	private static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");


			n = sc.nextInt();
			m = sc.nextInt();
			int[][] map = new int[n][m];

			for(int i =0 ; i < n ; i++) {
				char[] tmp = sc.next().toCharArray();
				for(int j = 0; j < m ; j++) {
					if(tmp[j] != '.') {
						map[i][j] = tmp[j]-'0';
					}
				}
			}

			Queue<Point> queue = new LinkedList();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 0) {
						for(int d = 0; d < 8; d++) {
							int nx = i + dirs[d][0];
							int ny = j + dirs[d][1];

							if(isIn(nx, ny)) {
								if(map[nx][ny] != 0) {
									if(map[nx][ny] > 0) {
										map[nx][ny]--;
									}

									if(map[nx][ny] == 0) {
										map[nx][ny] = -1;
										queue.add(new Point(nx, ny));
									}
								}
							}
						}
					}
				}
			}

			int cnt = 0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				for(int i = 0; i < size; i++) {
					Point now = queue.poll();
					int x = now.x;
					int y = now.y;
					for(int d = 0; d < 8; d++) {
						int nx = x + dirs[d][0];
						int ny = y + dirs[d][1];

						if(isIn(nx, ny)) {
							if(map[nx][ny] != 0) {
								if(map[nx][ny] > 0) {
									map[nx][ny]--;
								}

								if(map[nx][ny] == 0) {
									map[nx][ny] = -1;
									queue.add(new Point(nx, ny));
								}
							}
						}
					}

				}
				cnt++;				
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	private static boolean isIn(int x, int y) {
		if(x >= 0 && x < n && y >=0 && y < m) {
			return true;
		}else {
			return false;
		}
	}

	private static String src = "2\r\n" + 
			"5 6\r\n" + 
			"......\r\n" + 
			".939..\r\n" + 
			".3428.\r\n" + 
			".9393.\r\n" + 
			"......\r\n" + 
			"10 10\r\n" + 
			"..........\r\n" + 
			".99999999.\r\n" + 
			".9.323239.\r\n" + 
			".91444449.\r\n" + 
			".91444449.\r\n" + 
			".91444449.\r\n" + 
			".91444449.\r\n" + 
			".91232329.\r\n" + 
			".99999999.\r\n" + 
			"..........";
}
