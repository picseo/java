package d0310;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5656_벽돌깨기 {
	static int N, n, m;
	static int[][] map;
	static int[][] tmp_map;
	static int result = 0;
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			m = sc.nextInt();
			n = sc.nextInt();
			
			map = new int[n][m];
			tmp_map = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			result = Integer.MAX_VALUE;
			
			make_nums(0, new int[N]);
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < m; j++) {
//					tmp_map[i][j] = map[i][j];
//				}
//			}
//			int[] sss = {2, 2, 6};
//			destroy(sss);
			sb.append("#").append(t).append(" ").append(result).append("\n");			
		}
		System.out.print(sb);
	}

	private static void make_nums(int cur, int[] tmp) {
		if(cur == N) {
			//계속  map을 반복 사용해야 하므로 
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					tmp_map[i][j] = map[i][j];
				}
			}
			destroy(tmp);
		}else {
			for(int i = 0; i < m; i++) {
				tmp[cur] = i;
				make_nums(cur+1, tmp);
				
				if(result == 0) {//이미 result가 0이라면 더이상 찾을필요가 없다 (최소값이니까)
					return;
				}
			}
		}
	}
	
	private static void destroy(int[] where) {		
		//System.out.println(Arrays.toString(where));
		//int[] del_nums = new int[m];
		for(int y = 0; y < N; y++) {
			//처음 터지는 벽돌을 찾음
			boolean one = false;
			int x = 0;
			for(int j = 0; j <n; j++) {
				if(tmp_map[j][where[y]] != 0) {
					x = j;
					if(tmp_map[j][where[y]]==1) {
						tmp_map[j][where[y]] = 0;
						one = true;
					}
					break;
				}
			}
			
			//돌의 연쇄 파괴
			if(one)
				continue;
			else {
				//Arrays.fill(del_nums,  0);
				bfs(x, where[y]);//, del_nums);
			}
			
			//System.out.println(Arrays.toString(del_nums));
//			for(int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(tmp_map[i]));
//			}
//			System.out.println();
			//돌이 내려옴
			
			for(int j = 0; j < m; j++) {
				for(int i = n-1; i >0; i--) {
					if(tmp_map[i][j] == 0) {
						for(int ii = i-1; ii>=0; ii--) {
							if(tmp_map[ii][j] != 0) {
								tmp_map[i][j] = tmp_map[ii][j];
								tmp_map[ii][j] = 0;
								break;
							}
						}
					}
				}
			}
			
//			for(int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(tmp_map[i]));
//			}
//			System.out.println();
		}
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(tmp_map[i][j] != 0) {
					sum++;
				}
			}
		}
		//System.out.println("sum : " + sum);
		
		if(result > sum) {
			result = sum;
		}
	}
	
	
	private static void bfs(int x, int y) {//, int[] del) {
		Queue<Point> queue = new LinkedList();
		queue.add(new Point(x, y));
		boolean[][] visited = new boolean[n][m];
		visited[x][y] = true;
		//del[y]++;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int len = tmp_map[now.x][now.y];
			tmp_map[now.x][now.y] = 0;
			
			for(int i = 0; i < 4; i++) {
				for(int l = 1; l < len; l++) {
					int nx = now.x + dirs[i][0]*l;
					int ny = now.y + dirs[i][1]*l;
					if(isIn(nx, ny) && tmp_map[nx][ny] != 0 && !visited[nx][ny]) {
						int next_len = tmp_map[nx][ny];
						if(next_len == 1) {
							tmp_map[nx][ny] = 0;
							visited[nx][ny] = true;
							//del[ny]++;
						}else {
							visited[nx][ny] = true;
							queue.add(new Point(nx, ny));
							//del[ny]++;
						}
					}
				}
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		if(x >=0 && x < n && y >=0 && y < m) {
			return true;
		}else {
			return false;
		}
	}
	
	private static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	private static String src = "5\r\n" + 
			"3 10 10\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 1 0 1 0 0 0 0 0\r\n" + 
			"1 0 3 0 1 1 0 0 0 1\r\n" + 
			"1 1 1 0 1 2 0 0 0 9\r\n" + 
			"1 1 4 0 1 1 0 0 1 1\r\n" + 
			"1 1 4 1 1 1 2 1 1 1\r\n" + 
			"1 1 5 1 1 1 1 2 1 1\r\n" + 
			"1 1 6 1 1 1 1 1 2 1\r\n" + 
			"1 1 1 1 1 1 1 1 1 5\r\n" + 
			"1 1 7 1 1 1 1 1 1 1\r\n" + 
			"2 9 10\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 1 0 0 0 0\r\n" + 
			"1 1 0 1 1 1 0 1 0\r\n" + 
			"1 1 0 1 1 1 0 1 0\r\n" + 
			"1 1 1 1 1 1 1 1 0\r\n" + 
			"1 1 3 1 6 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 1 1 1\r\n" + 
			"3 6 7\r\n" + 
			"1 1 0 0 0 0\r\n" + 
			"1 1 0 0 1 0\r\n" + 
			"1 1 0 0 4 0\r\n" + 
			"4 1 0 0 1 0\r\n" + 
			"1 5 1 0 1 6\r\n" + 
			"1 2 8 1 1 6\r\n" + 
			"1 1 1 9 2 1\r\n" + 
			"4 4 15\r\n" + 
			"0 0 0 0 \r\n" + 
			"0 0 0 0 \r\n" + 
			"0 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 5 0 \r\n" + 
			"1 1 1 0 \r\n" + 
			"1 1 1 9 \r\n" + 
			"1 1 1 1 \r\n" + 
			"1 6 1 2 \r\n" + 
			"1 1 1 5 \r\n" + 
			"1 1 1 1 \r\n" + 
			"2 1 1 2 \r\n" + 
			"4 12 15\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9";
}
