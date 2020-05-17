package d0517;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 최소 동작 횟수 : bfs

통나무의 가운데를 기준으로 bfs를 했다.

도달할 수 없는 경우 0을 출력하는 걸 빼먹어서 틀렸다 - > 잘 읽자

 */
public class BJ_1938_통나무옮기기 {
	static int N;
	static int[][] map;//0빈칸, 1나무, 2도착칸
	static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	
		map = new int[N][N];
		visited = new boolean[N][N][2];
		Queue<Integer> q = new LinkedList();
		int cnt = 0;

		for(int i = 0; i < N; i++) {
			String input = sc.next();
			for(int j = 0; j < input.length(); j++) {
				char now = input.charAt(j);

				if(now == 'B') {
					map[i][j] = 0;
					cnt++;
					if(cnt==2) {
						q.add(i);
						q.add(j);

					}else if(cnt==3) {
						if(q.peek() == i) {
							q.add(0);
							visited[i][j-1][0] = true;
						}else {
							q.add(1);
							visited[i-1][j][1] = true;
						}
					}
				}else if(now =='0') {
					map[i][j] = 0;
				}else if(now == '1') {
					map[i][j] = 1;
				}else if(now == 'E') {
					map[i][j] = 2;
				}
			}
		}

		int result =0;
		boolean yes = false;
		out : while(!q.isEmpty()) {
			int size = q.size()/3;

			for(int s = 0; s < size; s++) {
				int x = q.poll();
				int y = q.poll();
				int verti = q.poll();

				if(check2(x, y, verti)) {
					yes = true;
					break out;
				}
				//이동
				for(int i = 0; i < 4; i++) {
					int nx = x + dirs[i][0];
					int ny = y + dirs[i][1];

					if(isIn(nx, ny, verti) && check1(nx, ny, verti) && !visited[nx][ny][verti]) {
						visited[nx][ny][verti] = true;
						q.add(nx); q.add(ny); q.add(verti);
					}
				}

				//회전
				if(isIns(x, y) && check1s(x, y) && !visited[x][y][(verti+1)%2]) {
					visited[x][y][(verti+1)%2] = true;
					q.add(x); q.add(y); q.add((verti+1)%2);
				}
			}
			result++;
		}

		if(yes) {
			System.out.println(result);
		}else {
			System.out.println(0);
		}
	}

	private static boolean check1s(int x, int y) {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				if(map[x+i][y+j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean check1(int x, int y, int verti) {
		if(verti == 0) {
			if(map[x][y-1] == 1 || map[x][y] == 1 || map[x][y+1] == 1) {
				return false;
			}
		}else {
			if(map[x-1][y] == 1 || map[x][y] == 1 || map[x+1][y] == 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean check2(int x, int y, int verti) {
		if(verti == 0) {
			if(map[x][y-1] == 2 && map[x][y] == 2 && map[x][y+1] == 2) {
				return true;
			}
		}else {
			if(map[x-1][y] == 2 && map[x][y] == 2 && map[x+1][y] == 2) {
				return true;
			}
		}
		return false;
	}

	private static boolean isIns(int x, int y) {
		if(x-1 >= 0 && x+1 < N) {
			if(y-1 >= 0 && y+1 < N) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	private static boolean isIn(int x, int y, int verti) {
		
		if(verti == 0) {
			if(x >= 0 && x < N) {
				if(y-1 >= 0 && y+1 < N) {
					return true;
				}else {
					return false;
				}
			}
		}else {
			if(y >= 0 && y < N) {
				if(x-1 >= 0 && x+1 < N) {
					return true;
				}else {
					return false;
				}
			}
		}
		
		return false;
	}

	

}
