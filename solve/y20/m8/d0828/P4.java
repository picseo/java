package d0828;


import java.util.LinkedList;
import java.util.Queue;

/*
{{0,0,0},{0,0,0},{0,0,0}}	900
{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}	3800
{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}	2100
{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}	3200
 */

public class P4 {
	static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[][][][] visited; // K개의 코너를 돌아 xy에 d방향을 보면서 들어옴
	static int result, N;
	static int[][] map;
	
	static class Car{
		int x, y, k, d;

		Car(int x, int y, int k, int d) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.d = d;
		}
		
	}
	
	public static void main(String[] args) {
		int[][] board ={{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
        N = board.length;
        visited = new int[N][N][N*N][4];
        map = board;
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		for(int k = 0; k < N*N; k++) {
        			for(int d = 0; d < 4; d++) {
        				visited[i][j][k][d] = -1;
        				if(i == 0 && j == 0) {
        					visited[i][j][k][d] = 0;
        				}
        			}
        		}
        	}
        }
        
        result = Integer.MAX_VALUE;
        bfs(0, 0, 0, -1);
        
        return result;
    }

	

	private static void bfs(int sx, int sy, int k, int dir) {
		Queue<Car> queue = new LinkedList<Car>();
		
		queue.add(new Car(sx, sy, k, dir));
		
		while(!queue.isEmpty()) {
			Car now = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				if(now.d != -1 && d == (now.d+2)%4) continue; //반대 방향은 하지 않음
				
				int nx = now.x + dirs[d][0];
				int ny = now.y + dirs[d][1];
				
				if(isIn(nx, ny) && map[nx][ny] != 1) {
					//방향에 따라 값이 나눠짐
					if(now.d == -1) {
						if(visited[nx][ny][now.k][d] == -1) {
							visited[nx][ny][now.k][d] = 1;
							queue.add(new Car(nx, ny, now.k, d));
						}
					}else if(d == now.d) {
						if(visited[nx][ny][now.k][d] == -1) {
							visited[nx][ny][now.k][d] = visited[now.x][now.y][now.k][now.d] + 1;
							queue.add(new Car(nx, ny, now.k, d));
						}
					}else {
						if(now.k < N*N -1 && visited[nx][ny][now.k+1][d] == -1) {
							visited[nx][ny][now.k+1][d] = visited[now.x][now.y][now.k][now.d]+ 1;
							queue.add(new Car(nx, ny, now.k+1, d));
						}
					}
				}
				
			}
		}
		
		for(int i = 0; i < N*N; i++) {
			for(int d = 0; d < 4; d++) {
				int now = visited[N-1][N-1][i][d];
				
				if(now == -1) continue;
				
				if(result > (now)*100 + i*500) {
					result = (now)*100 + i*500;
				}
			}
		}
		
	}

	static boolean isIn(int x, int y) {
		return x >=0 && x < N && y >= 0 && y < N;
	}
	
	
}
