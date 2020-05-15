package d0514;
/*
 불과 사람을 따로 나누어서 진행을 하는거!
 while나오고 싶을때 break 라벨명;!
 map을 바꾸어도 될땐 map을 visited대신 사용하는게 메모리를 아끼는 법이다
 불부터 진행하는게 이문제의 포인트인가보다
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_4179_불 {
	static int N, M;
	static char[][] map = new char[1003][1003];
	static int[][] dirs= {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		Queue<Integer> fires = new LinkedList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'J') {
					map[i][j] = '.';
					queue.add(i);
					queue.add(j);
				}else if(map[i][j] == 'F') {
					fires.add(i);
					fires.add(j);
				}
			}
		}

		int result = -1;
		int cnt = 0;
		out : while(!queue.isEmpty()) {
			cnt++;
			//불
			int size = fires.size()/2;
			for(int i =0; i < size; i++) {
				int x = fires.poll();
				int y = fires.poll();

				for(int d= 0; d < 4; d++) {
					int nx = x + dirs[d][0];
					int ny = y + dirs[d][1];

					if(isIn(nx,ny)) {
						if(map[nx][ny] == '.' || map[nx][ny] == 'J') {
							map[nx][ny] = 'F';
							fires.add(nx); fires.add(ny);
						}
					}
				}
			}
			
			//사람
			size = queue.size()/2;
			for(int i =0; i < size; i++) {
				int x = queue.poll();
				int y = queue.poll();

				if(x == 0 || x == N-1 || y == 0 || y == M-1) {
					result = cnt;
					break out;
				}
				
				for(int d= 0; d < 4; d++) {
					int nx = x + dirs[d][0];
					int ny = y + dirs[d][1];

					if(isIn(nx,ny)) {
						if(map[nx][ny] == '.') {
							map[nx][ny] = 'J';
							queue.add(nx); queue.add(ny);
						}
					}
				}
			}
		}

		if(result == -1) {
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(result);
		}

	}

	static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
