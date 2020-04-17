package d0416;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
//타일을 어떻게 세지??
//메모리 초과가 발생한다.....
public class BJ_5213_과외맨 {
	static int[][] map;
	static int[][] tile_num;
	
	static int N;
	static boolean[][] visited;
	static int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}};
	static int[] pre_tile;
	static int[] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][2*N];
		tile_num = new int[N][2*N];
		visited = new boolean[N][2*N];
		
		int total = N*N-(N/2);
		pre_tile = new int[total+1];
		count = new int[total+1];
		
		int idx = 0;
		int num = 1;
		for(int i = 0; i < total; i++) {
			int x = idx/(2*N);
			int y = idx%(2*N);
			if((x)%2 == 1 && idx%(2*N) == 0) {
				map[x][y] = -1;
				visited[x][y] = false;
				idx++;
			}else if((x)%2 == 1 && y == 2*N-1) {
				map[x][y] = -1;
				visited[x][y] = false;
				idx++;
			}
			map[idx/(2*N)][idx%(2*N)] = sc.nextInt();
			tile_num[idx/(2*N)][idx%(2*N)] = num;
			idx++;
			map[idx/(2*N)][idx%(2*N)] = sc.nextInt();
			tile_num[idx/(2*N)][idx%(2*N)] = num++;
			idx++;			
		}

		visited[0][0] = true;
		pre_tile[1] = -1;
		count[1] = 1;
		bfs(0, 1);//
		
		Stack<Integer> st = new Stack<>();
		int max = 0;
		for(int i = total; i >= 0; i++) {
			if(pre_tile[total]  != 0) {
				max = i;
				break;
			}
		}
		System.out.println(count[max]);
		st.add(max);
		while(pre_tile[max] != -1) {
			st.add(pre_tile[max]);
			max = pre_tile[max];
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
		System.out.println();
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList();
		visited[x][y] = true;
		queue.add(new Point(x, y));
		int cnt = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Point now = queue.poll();
				int nowtile = tile_num[now.x][now.y];
				if(now.x == N-1 && (now.y == 2*N-1 || now.y == 2*N-2)) {
					return;
				}

				for(int d = 0; d < 3; d++) {
					int nx = now.x + dirs[d][0];
					int ny = now.y + dirs[d][1];

					if(isIn(nx, ny) && !visited[nx][ny] && map[now.x][now.y]== map[nx][ny]) {
						visited[nx][ny] = true;
						pre_tile[tile_num[nx][ny]] =nowtile;
						count[tile_num[nx][ny]] = cnt+1;
						queue.add(new Point(nx, ny));

						//같은 타일에 있는 값도 넣어준다.
						if(nx%2 == 0) {//짝수 줄에 있을 때
							if(ny%2 == 0) {//짝수번째
								visited[nx][ny+1] = true;
								queue.add(new Point(nx, ny+1));
							}else {
								visited[nx][ny-1] = true;
								queue.add(new Point(nx, ny-1));
							}
						}else {
							if(ny%2 == 0) {//짝수번째
								visited[nx][ny-1] = true;
								queue.add(new Point(nx, ny-1));
							}else {
								visited[nx][ny+1] = true;
								queue.add(new Point(nx, ny+1));
							}
						}
					}
				}
			}
			cnt++;
		}


	}
	static class Point{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "["+x+","+y+"]";
		}		
	}

	static boolean isIn(int x, int y) {
		if(x >=0 && x < N && y >=0 && y < 2*N) {
			return true;
		}
		return false;
	}
}
