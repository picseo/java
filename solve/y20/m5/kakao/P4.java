package kakao;

import java.util.Arrays;

/*
[[0,0,0],[0,0,0],[0,0,0]]	900
[[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]]	3800
[[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]	2100
[[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]]	3200
 */
public class P4 {
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static boolean[][] visited;
	static int result, N;
	static int[][] map;
	static int[][] min;
	
	public static void main(String[] args) {
		
		int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		System.out.println(solution(board));

	}

	public static int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        visited = new boolean[N][N];
        result = Integer.MAX_VALUE;
        map = board;
        min = new int[N][N];
        for(int[] row : min) {
        	Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        visited[0][0] = true;
        dfs(0, 0, 0, -1);
        
        answer = result;
        return answer;
    }

	static boolean isIn(int x, int y) {
		return x >=0 && x < N && y >= 0 && y < N;
	}
	
	private static void dfs(int x, int y, int cost, int pre_d) {
		if(cost >= result || min[x][y] < cost) {
			//더이상 볼필요 없음
			return;
		}
		
		if(x == N-1 && y == N-1) {
			//목적지에 도착
			if(cost < result) {
				result = cost;
				return;
			}
		}
		
		if(min[x][y] > cost) {
			min[x][y] = cost;
		}
		
		for(int d = 0 ; d < 4; d++) {
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];
			
			int plus = 100;
			if((pre_d == 0 || pre_d == 1) && (d == 2 || d ==3)) {
				plus += 500;
			}else if((pre_d == 2 || pre_d == 3) && (d == 1 || d ==0)) {
				plus += 500;
			}
			
			if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0 && min[nx][ny] >= cost+plus) {
				visited[nx][ny] = true;
				if(cost+plus < result )
					dfs(nx, ny, cost+plus, d);
				visited[nx][ny] = false;
			}
		}		
	}
}
