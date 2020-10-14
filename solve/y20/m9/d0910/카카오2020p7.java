package d0910;

import java.util.*;

public class 카카오2020p7 {
	public static boolean[][][] visited;
	static int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};//0123
	static int[][] roll = {{-1, -1}, {-1, 1, 0, 0}, {0, 0, 1, -1}, {1, 1, 0, 0}};
	
	static class Point{
		int x, y, type;

		public Point(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
		
	}
	
	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		System.out.println(solution(board));
	}
	
	public static int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        visited = new boolean[len][len][4];//기준은 오른쪽으로 
        
        answer = bfs(new Point(0, 1, 0), board);        
        
        return answer;
    }

	private static int bfs(Point start, int[][] board) {
		Queue<Point> queue = new LinkedList();
		queue.add(start);
		visited[start.x][start.y][start.type] = true;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s = 0; s < size; s++) {
				Point now = queue.poll();
				
				if(check(now)) {
					return cnt;
				}				
				
				for(int d = 0; d < 4; d++) {
					int nx = now.x + dirs[d][0];
					int ny = now.y + dirs[d][1];
					
					if(isIn(nx, ny, now.type) && !visited[nx][ny][now.type] && wall(nx, ny, now.type, board)) {
						visited[nx][ny][now.type] = true;
						queue.add(new Point(nx, ny, now.type));
					}
				}
				
				if(now.type == 0) {
					if(isIn(now.x-1, now.y, 0) && wall(now.x-1, now.y, 0, board)) {//위쪽이 모두 빔
						//오른쪽 기준
						if(!visited[now.x][now.y][1]) {
							visited[now.x][now.y][1] = true;
							queue.add(new Point(now.x, now.y, 1));
						}
						//왼쪽 기준
						if(!visited[now.x-1][now.y-1][3]) {
							visited[now.x-1][now.y-1][3] = true;
							queue.add(new Point(now.x-1, now.y-1, 3));
						}
					}
					
					if(isIn(now.x+1, now.y, 0) && wall(now.x+1, now.y, 0, board)) {//아래쪽이 모두 빔
						//오른쪽 기준
						if(!visited[now.x][now.y][3]) {
							visited[now.x][now.y][3] = true;
							queue.add(new Point(now.x, now.y, 3));
						}
						//왼쪽 기준
						if(!visited[now.x+1][now.y-1][1]) {
							visited[now.x+1][now.y-1][1] = true;
							queue.add(new Point(now.x+1, now.y-1, 1));
						}
					}
				}else if(now.type == 2) {
					if(isIn(now.x-1, now.y, 2) && wall(now.x-1, now.y, 2, board)) {//위쪽이 모두 빔
						//오른쪽 기준
						if(!visited[now.x][now.y][1]) {
							visited[now.x][now.y][1] = true;
							queue.add(new Point(now.x, now.y, 1));
						}
						//왼쪽 기준
						if(!visited[now.x-1][now.y+1][3]) {
							visited[now.x-1][now.y+1][3] = true;
							queue.add(new Point(now.x-1, now.y+1, 3));
						}
					}
					
					if(isIn(now.x+1, now.y, 2) && wall(now.x+1, now.y, 2, board)) {//아래쪽이 모두 빔
						//오른쪽 기준
						if(!visited[now.x][now.y][3]) {
							visited[now.x][now.y][3] = true;
							queue.add(new Point(now.x, now.y, 3));
						}
						//왼쪽 기준
						if(!visited[now.x+1][now.y+1][1]) {
							visited[now.x+1][now.y+1][1] = true;
							queue.add(new Point(now.x+1, now.y+1, 1));
						}
					}
				}else if(now.type == 1) {
					if(isIn(now.x, now.y-1, 1) && wall(now.x, now.y-1, 1, board)) {//왼쪽이 모두 빔
						//중심 기준
						if(!visited[now.x][now.y][0]) {
							visited[now.x][now.y][0] = true;
							queue.add(new Point(now.x, now.y, 0));
						}
						
						if(!visited[now.x-1][now.y-1][2]) {
							visited[now.x-1][now.y-1][2] = true;
							queue.add(new Point(now.x-1, now.y-1, 2));
						}
					}
					
					if(isIn(now.x, now.y+1, 1) && wall(now.x, now.y+1, 1, board)) {//오른쪽이 모두 빔
						//중심 기준
						if(!visited[now.x][now.y][2]) {
							visited[now.x][now.y][2] = true;
							queue.add(new Point(now.x, now.y, 2));
						}
						
						if(!visited[now.x-1][now.y+1][0]) {
							visited[now.x-1][now.y+1][0] = true;
							queue.add(new Point(now.x-1, now.y+1, 0));
						}
					}
				}else {
					if(isIn(now.x, now.y-1, 3) && wall(now.x, now.y-1, 3, board)) {//왼쪽이 모두 빔
						//중심 기준
						if(!visited[now.x][now.y][0]) {
							visited[now.x][now.y][0] = true;
							queue.add(new Point(now.x, now.y, 0));
						}
						
						if(!visited[now.x+1][now.y-1][2]) {
							visited[now.x+1][now.y-1][2] = true;
							queue.add(new Point(now.x+1, now.y-1, 2));
						}
					}
					
					if(isIn(now.x, now.y+1, 3) && wall(now.x, now.y+1, 3, board)) {//오른쪽이 모두 빔
						//중심 기준
						if(!visited[now.x][now.y][2]) {
							visited[now.x][now.y][2] = true;
							queue.add(new Point(now.x, now.y, 2));
						}
						
						if(!visited[now.x+1][now.y+1][0]) {
							visited[now.x+1][now.y+1][0] = true;
							queue.add(new Point(now.x+1, now.y+1, 0));
						}
					}
				}
				
				
			}
			cnt++;
		}
		
		return -1;
	}

	private static boolean wall(int x, int y, int type, int[][] board) {
		if(board[x][y] == 1) {
			return false;
		}
		int nx = x + dirs[type][0];
		int ny = y + dirs[type][1];
		
		if(board[nx][ny] == 1) {
			return false;
		}
		return true;
	}

	private static boolean check(Point now) {
		if(now.x == visited.length-1 && now.y == visited.length-1) {
			return true;
		}
		int nx = now.x + dirs[now.type][0];
		int ny = now.y + dirs[now.type][1];
		
		if(nx == visited.length-1 && ny == visited.length-1) {
			return true;
		}
		return false;
	}

	private static boolean isIn(int x, int y, int t) {
		if(x >=0 && x < visited.length && y >=0 && y < visited.length) {
			int nx = x + dirs[t][0];
			int ny = y + dirs[t][1];
			if(nx >=0 && nx < visited.length && ny >=0 && ny < visited.length) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
