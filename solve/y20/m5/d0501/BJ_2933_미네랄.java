package d0501;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//클러스터를 list로 만드는게 가장 중요한거 같다
public class BJ_2933_미네랄 {
	static int R, C, N;
	static char[][] map;
	static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//오, 아, 왼, 위
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		for(int i = 0; i <R ; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		N = sc.nextInt();
		for(int n = 0; n < N; n++) {
			int row = sc.nextInt();
			
			if(n%2 == 0) {//왼
				for(int i = 0; i < C; i++) {
					if(map[R-row][i] == 'x') {
						map[R-row][i] = '.';
						break;
					}
				}				
			}else {//오
				for(int i = C-1; i >= 0; i--) {
					if(map[R-row][i] == 'x') {
						map[R-row][i] = '.';
						break;
					}
				}			
			}
			
			//클러스터가 생겼는지 확인하고, 생겼다면 내린다.
			visited = new boolean[R][C];
			for(int i = 0; i < C; i++) {//바닥에 연결된 부분을 찾음
				if(!visited[R-1][i] && map[R-1][i]== 'x') {
					bfs(R-1, i);
				}
			}
			
			//visited되지 않은 부분은 cluster
			List<Point> cluster = new ArrayList();
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(!visited[i][j] && map[i][j] == 'x') {
						map[i][j] = '.';
						cluster.add(new Point(i,j));
					}
				}
			}
			
			//떨어뜨리기
			if(cluster.size() != 0)
				down(cluster);
			
		}//for n
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}//main
	
	static boolean isIn(int x, int y) {
		if(x >= 0 && x < R && y >=0 && y < C) {
			return true;
		}
		return false;
	}
	
	static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<Point> queue = new LinkedList();
		queue.add(new Point(x, y));
		
		while(!queue.isEmpty()) {
			Point c = queue.poll();
						
			for(int i = 0; i < 4; i++) {
				int nx = c.x + dirs[i][0];
				int ny = c.y + dirs[i][1];				
				
				if(isIn(nx, ny) && map[nx][ny] == 'x'&&!visited[nx][ny]) {
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;					
				}
			}
		}//while end
	}//bfs end
	
	static void down(List<Point> cluster) {
		boolean stop = false;
		int size = cluster.size();
		while(!stop) {
			for(int i = 0; i < size; i++) {
				Point now = cluster.get(i);
				int nx = now.x+1;
				int ny = now.y;
				
				if(nx >= R || map[nx][ny] == 'x') {
					stop =true;
					break;
				}
			}
			
			if(stop) {
				continue;
			}
			
			//내려갈 수 있으면 update
			for(int i = 0; i < size; i++) {
				cluster.get(i).x++;
			}
		}
		
		for(int i = 0; i < size; i++) {
			Point now = cluster.get(i);
			map[now.x][now.y]= 'x'; 
		}
	}
	
	static class Point{
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}
	
}
