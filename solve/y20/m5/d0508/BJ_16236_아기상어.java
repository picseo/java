package d0508;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BJ_16236_아기상어 {
	static int N, M;
	static int[][] map;
	static List<Fish> fishes;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static Fish shark;

	static class Fish implements Comparable<Fish>{
		int x, y, size;
		int eat = 0;
		int len = 0;

		Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		Fish(int x, int y, int size, int len) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.len = len;
		}

		public int compareTo(Fish o) {
			if(this.len == o.len) {
				if(this.x == o.x) {
					return Integer.compare(this.y, o.y);
				}else {
					return Integer.compare(this.x, o.x);
				}
			}else {
				return Integer.compare(this.len, o.len);
			}
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", size=" + size + ", len=" + len + "]";
		}


	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		shark = new Fish(0, 0, 2);

		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					shark.x = i;
					shark.y = j;
					map[i][j] = 0;
				}
			}
		}

		boolean check = true;
		int result = 0;

		while(check) {
			//System.out.println("----------------------------------------------------");
			int pre_size = shark.size;
			int pre_eat = shark.eat;

//			System.out.println("pre : " + shark+ " eat : " + shark.eat);
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}

			bfs(shark);

			//System.out.println("post  :" + shark + " eat : " + shark.eat);

			if(pre_size == shark.size && pre_eat == shark.eat) {
				//System.out.println("same");
				check = false;
			}else {
				//System.out.println("diff");
				result += shark.len;
				check = true;
			}
		}

		System.out.println(result);		
	}

	private static void bfs(Fish shark) {
		Queue<Fish> q = new LinkedList();
		PriorityQueue<Fish> pq = new PriorityQueue();
		q.add(new Fish(shark.x, shark.y, shark.size));
		boolean[][] visited = new boolean[N][N];
		visited[shark.x][shark.y]= true; 
		int len = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Fish now = q.poll();

				for(int d= 0; d < 4; d++) {
					int nx = now.x+dirs[d][0];
					int ny = now.y+dirs[d][1];

					if(isIn(nx, ny) && !visited[nx][ny]) {
						visited[nx][ny] = true;
						if(map[nx][ny] == shark.size || map[nx][ny] == 0) {
							q.add(new Fish(nx, ny, map[nx][ny]));
						}else if(map[nx][ny] > 0 && map[nx][ny] < shark.size) {
							q.add(new Fish(nx, ny, map[nx][ny]));
							pq.add(new Fish(nx, ny, map[nx][ny], len));
						}
					}
				}
			}

			len++;
		}

//		for(Fish next : pq) {
//			System.out.println(next);
//		}

		if(!pq.isEmpty()) {
			//System.out.println("size : " + shark.size + ", eat : " + shark.eat);
			Fish bate = pq.poll();
			map[bate.x][bate.y]=0; 
			int eat = shark.eat +1;
			if(eat >= shark.size) {
				int nexteat = eat - shark.size;
				shark.size++;
				shark.eat = nexteat;
			}else {
				shark.eat = eat;
			}
			shark.len = bate.len;
			shark.x = bate.x;
			shark.y = bate.y;
		}

	}

	static boolean isIn(int x, int y) {
		return x >=0 && x < N && y >=0 && y < N;
	}
}
