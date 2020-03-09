package d0309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 가중치가 1,0인 그래프 탐색에서 최소값을 원하는 문제라서 bfs를 생각했고
 * 악마와 수연이에게 각각 queue를 배정해주었다.
 * 
 * 문제에서 악마가 하나가 아닐수도 있다는 것을 알아냈지만
 * 
 * queue2개를 탐색하는 조건을 처음에 Dqueue가 비지 않았을 때로 했더니
 * 악마가 돌로 감쌓여있을때 수연이의 진행을 할 수 가 없었다.
 * 그래서 조건을 !Dqueue.isEmpty() && !Squeue.isEmpty()로 바꾸었더니 pass가 되었다.
 * -> 우리가 중요하게 여기는 것은 수연이의 위치이므로 Squeue를 while문을 돌게하는 기준으로 하면 되는 거였다.
 * 
 *  이런 돌맹이가 나오는 문제는 감쌓여있는 상황을 생각해야겠다.
 * 
 * */
public class SWEA_7793_D5_오나의여신님 {
	static int N, M;
	static char[][] map = null;
	static int sx, sy, dx, dy;
	static int result = 0;
	static boolean[][] visited = null;
	static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	static Queue<Point> Dqueue = new LinkedList();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int t= 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visited = new boolean[N][M];
			Dqueue.clear();
			
			for(int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 'D') {
						dx = i;
						dy = j;
					}else if(map[i][j] == 'S') {
						sx = i;
						sy = j;
						map[i][j] = '.';
					}else if(map[i][j] == '*') {
						Dqueue.add(new Point(i, j));
					}
				}
			}
			bfs();			
			sb.append((result != -1)?result:"GAME OVER").append("\n");
		}
		System.out.print(sb);
	}
	
	private static void bfs() {
		//수연 queue
		Queue<Point> Squeue = new LinkedList();
		Squeue.add(new Point(sx, sy));
		visited[sx][sy] = true;
		result = 0;
		boolean find = false;
		while(!Squeue.isEmpty()) {//!Dqueue.isEmpty() || 
			int size = Dqueue.size();
			for(int i = 0; i < size; i++) {
				Point dnow = Dqueue.poll();
				for(int d = 0; d < 4; d++) {
					int nx = dnow.x + dirs[d][0];
					int ny = dnow.y + dirs[d][1];
					if(isIn(nx, ny)) {
						if(map[nx][ny] == '.' ) {
							map[nx][ny] = '*';
							Dqueue.add(new Point(nx, ny));
						}
					}
				}
			}//악마 확장
			
			size = Squeue.size();
			for(int i = 0 ;i < size; i++) {
				Point snow = Squeue.poll();
				for(int d = 0; d < 4; d++) {
					int nx = snow.x + dirs[d][0];
					int ny = snow.y + dirs[d][1];
					if(isIn(nx, ny)) {
						if(map[nx][ny] == '.' && !visited[nx][ny]) {
							visited[nx][ny] = true;
							Squeue.add(new Point(nx, ny));
						}else if(map[nx][ny] == 'D' && !visited[nx][ny]) {
							find = true;
							break;
						}
					}
				}
				if(find)
					break;
			}
			result++;
			if(find)
				break;
		}
		if(!find)
			result = -1;
		return;
	}
	
	private static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}
	
	private static boolean isIn(int x, int y) {
		if(x >=0 && x <N && y >=0 && y < M) {
			return true;
		}else {
			return false;
		}
	}
	private static String src = "2\r\n" + 
			"5 3\r\n" + 
			"X*X\r\n" + 
			"DXS\r\n" + 
			".X.\r\n" + 
			"...\r\n" + 
			"...\r\n" + 
			"2 3\r\n" + 
			"S.*\r\n" + 
			"..D";
}
