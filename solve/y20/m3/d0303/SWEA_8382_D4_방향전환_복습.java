package d0303;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * visited를 만들때 방향도 고려해야 한다는게 이문제의 중요 포인트였다.
 * 근데 나는 이걸 생각했는데도 왜 못했을까....
 * */
public class SWEA_8382_D4_방향전환_복습 {
	public static int sx;
	public static int sy;
	public static int ex;
	public static int ey;
	public static boolean dir;
	public static boolean[][][] visited;
	public static int result = 0;
	public static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T; t++) {
			sx = sc.nextInt()+100;
			sy = sc.nextInt()+100;
			ex = sc.nextInt()+100;
			ey = sc.nextInt()+100;
			
			visited = new boolean[201][201][2];
			result = Integer.MAX_VALUE;
			visited[sx][sy][0] = true;
			visited[sx][sy][1] = true;
						
			bfs(sx, sy, false);
			bfs(sx, sy, true);
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	public static void bfs(int x, int y, boolean dir) {
		Queue<Point> queue = new LinkedList();
		queue.add(new Point(x, y,0, dir));
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			if(now.x == ex && now.y == ey) {
				result = Math.min(result,  now.cnt);
				break;
			}
			
			if(now.dir) {//1, 세로
				//가로로 움직임
				for(int i = 2 ; i < 4; i++) {
					int nx = now.x + dirs[i][0];
					int ny = now.y + dirs[i][1];
					
					if(nx <0 || nx > 200 || ny <0 || ny > 200) {
						continue;
					}
					
					if(!visited[nx][ny][0]) {
						visited[nx][ny][0] = true;
						queue.add(new Point(nx, ny, now.cnt+1, false));
					}
					
				}
			}else {
				for(int i = 0 ; i < 2; i++) {
					int nx = now.x + dirs[i][0];
					int ny = now.y + dirs[i][1];
					
					if(nx <0 || nx > 200 || ny <0 || ny > 200) {
						continue;
					}
					
					if(!visited[nx][ny][1]) {
						visited[nx][ny][1] = true;
						queue.add(new Point(nx, ny, now.cnt+1, true));
					}
					
				}
			}
		}
		
	}

	public static class Point{
		int x;
		int y;
		int cnt;
		boolean dir;
		public Point(int x, int y, int cnt, boolean dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
		
	}
	public static String src = "3\r\n" + 
			"0 0 1 0\r\n" + 
			"-1 -1 0 0\r\n" + 
			"0 0 0 2";
}
