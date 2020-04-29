package d0417;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 별자리 {
	static boolean[][] map = new boolean[10][10];
	static boolean[][] visited = new boolean[10][10];
	static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1;t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					int n = sc.nextInt();
					if(n == 1) {
						map[i][j] = true;
					}else {
						map[i][j] = false;
					}
					visited[i][j] = false;//visited 초기화
				}
			}
			
			
			int result = 0;
			for(int i = 0; i < 10; i++) {
				for(int j= 0; j < 10; j++) {
					if(!visited[i][j] && map[i][j]) {
						bfs(i, j);
						result++;
					}
				}
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	
	
	private static void bfs(int x, int y) {
		Queue<Integer> queue = new LinkedList();
		visited[x][y] = true;
		queue.add(x);
		queue.add(y);
		while(!queue.isEmpty()) {
			int nowx = queue.poll();
			int nowy = queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = nowx + dirs[i][0];
				int ny = nowy + dirs[i][1];
				
				if(isIn(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(map[nx][ny]) {
						queue.add(nx);
						queue.add(ny);
					}
				}
			}
		}
	}


	static boolean isIn(int x, int y) {
		if(x >= 0 && x < 10 && y >=0 && y < 10) {
			return true;
		}
		return false;
	}
	
	static String src = "10	\r\n" + 
			"1 1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 0 0 0 0 0 0\r\n" + 
			"0 1 0 1 0 1 0 0 0 1\r\n" + 
			"0 1 1 1 0 0 1 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 0 1 0 1 0 0 0\r\n" + 
			"0 0 0 1 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 1 0 1 1 0 1 1 1 0\r\n" + 
			"1 0 0 1 0 0 1 0 1 0\r\n" + 
			"0 1 0 0 1 0 1 1 1 0\r\n" + 
			"1 1 0 1 1 0 1 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 1 1 0 1 0 1 0 0\r\n" + 
			"0 1 0 0 0 1 1 1 0 0\r\n" + 
			"0 1 1 1 0 0 1 0 0 0\r\n" + 
			"0 1 0 0 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 1 1 0 0 0 1 0\r\n" + 
			"0 1 0 0 0 1 0 0 1 0\r\n" + 
			"0 0 0 0 0 1 0 0 1 0\r\n" + 
			"0 0 0 1 1 0 0 0 1 0\r\n" + 
			"0 0 0 1 0 0 0 0 1 0\r\n" + 
			"0 0 0 1 0 0 0 0 1 0\r\n" + 
			"0 0 0 1 0 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 0 0 0 0 1 0\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"0 1 0 1 0 1 0 1 0 1\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"0 1 0 1 0 1 0 1 0 1\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"0 1 0 1 0 1 0 1 0 1\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"0 1 0 1 0 1 0 1 0 1\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"0 1 0 1 0 1 0 1 0 1\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 1 1 1 1 1 1 1 1 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"1 0 1 1 1 1 1 1 0 1\r\n" + 
			"1 0 1 0 0 0 0 1 0 1\r\n" + 
			"1 0 1 0 1 0 0 1 0 1\r\n" + 
			"1 0 1 0 0 1 0 1 0 1\r\n" + 
			"1 0 1 0 0 0 0 1 0 1\r\n" + 
			"1 0 1 1 1 1 1 1 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"1 1 1 1 1 1 1 1 1 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"0 1 0 0 0 0 0 0 1 0\r\n" + 
			"0 0 1 0 0 0 0 1 0 0\r\n" + 
			"0 0 0 1 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 1 1 0 0 0 0\r\n" + 
			"0 0 0 0 1 1 0 0 0 0\r\n" + 
			"0 0 0 1 0 0 1 0 0 0\r\n" + 
			"0 0 1 0 0 0 0 1 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 1 0\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"0 1 1 1 1 1 1 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 1 0 1 1 0 1 1\r\n" + 
			"0 0 0 0 0 0 0 0 1 1\r\n" + 
			"0 0 0 0 1 0 0 0 1 1\r\n" + 
			"0 0 1 0 0 0 1 0 1 1\r\n" + 
			"0 0 0 1 1 1 0 0 1 1\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 1 1 1 1 1 1 1 0\r\n" + 
			"1 1 0 0 0 0 0 0 1 1\r\n" + 
			"1 0 0 1 0 0 0 0 0 1\r\n" + 
			"1 0 1 0 1 0 1 1 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0 1\r\n" + 
			"1 0 1 0 0 0 0 1 0 1\r\n" + 
			"1 0 0 1 1 1 1 0 0 1\r\n" + 
			"1 1 0 0 0 0 0 0 1 1\r\n" + 
			"0 1 1 1 1 1 1 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 1 1\r\n" + 
			"0 0 1 0 0 0 1 0 0 1\r\n" + 
			"0 1 0 1 0 1 0 1 0 0\r\n" + 
			"1 0 0 0 1 0 0 0 1 0\r\n" + 
			"1 0 0 0 0 0 0 0 1 0\r\n" + 
			"1 0 0 0 0 0 0 0 1 0\r\n" + 
			"1 0 0 0 0 0 0 0 1 0\r\n" + 
			"0 1 0 0 0 0 0 1 0 0\r\n" + 
			"0 0 1 0 0 0 1 0 0 1\r\n" + 
			"0 0 0 1 1 1 0 0 1 1\r\n" + 
			"";
}
