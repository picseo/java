package algo_basic.day6.permutation;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//문제의 외곽이 1로 채워져 있으므로 항상 영역내에 존재한다. -> isIn함수를 만들 필요가 없다.

public class SWEA_1226_D4_미로_bfs {
	private static char[][] map;
	private static int [][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1226.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 0; t < 10; t++) {
			int num = sc.nextInt();
			
			int sx = 0, sy = 0;
			map = new char[16][16];
			
			for(int i = 0; i < 16; i ++) {
				String map_row = sc.next();
				for(int j = 0; j < 16; j++) {
					map[i][j] = map_row.charAt(j);
					if(map[i][j] == '2') {
						sx = i;
						sy = j;
						map[i][j] = '1';
					}
				}
			}
			
			System.out.print("#"+num+" ");
			byBfs(new Point(sx, sy));		
		}
	}
	
	public static void byBfs(Point start) {
		Queue<Point> queue = new LinkedList();
		
		queue.add(start);
		map[start.x][start.y] = '1';
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dirs[i][0];
				int ny = now.y + dirs[i][1];
				
				if(map[nx][ny] == '3') {
					System.out.println(1);
					return;
				}else if(map[nx][ny] == '0') {
					map[nx][ny] = '1';
					queue.add(new Point(nx, ny));
				}				
			}
		}
		
		System.out.println(0);
	}
	
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}
	
}
