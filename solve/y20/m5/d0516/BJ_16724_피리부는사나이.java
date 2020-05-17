package d0516;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//연결이라고 하면 bfs가 생각나서 bfs를 사용 했는데, 
// 그것보다 이문제는 재귀를 쓰는게 빠르다고 나온다.
//checked를 0:미방문, -1:비상구있음, 1:현재돌고있음으로 설정하고

public class BJ_16724_피리부는사나이 {
	static int N, M;
	static char[][] map;
	static int[][] visited;
	//static int[][] checked;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		int cnt = 0;
		int result = 0;
		for(int i = 0; i < N ; i++) {
			for(int j =0; j < M ; j++) {
				if(visited[i][j]==Integer.MAX_VALUE) {
					//move[i][j]
					if(	bfs(i, j, cnt) ) {
						result++;
					}
					cnt++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		System.out.println(result);
	}

	private static boolean bfs(int x, int y, int cnt) {
		Queue<Integer> q = new LinkedList();
		q.add(x); q.add(y);
		visited[x][y] = cnt;
		boolean check = true;
		//{0, 1}, {0, -1}, {1, 0}, {-1, 0}
		while(!q.isEmpty()) {
			int qx = q.poll();
			int qy = q.poll();
			
			int nx = qx;
			int ny = qy;
			
			if(map[qx][qy] == 'D') {
				nx += 1;
			}else if(map[qx][qy] == 'U') {
				nx -= 1;
			}else if(map[qx][qy] == 'L') {
				ny -= 1;
			}else {//R
				ny += 1;
			}
			
			if(isIn(nx, ny)) {
				if(visited[nx][ny] > cnt) {
					visited[nx][ny] = cnt;
					q.add(nx); q.add(ny);
				}else if(visited[nx][ny] < cnt){
					check = false;
				}
			}
		}
		
		return check;
	}

	static boolean isIn(int x, int y) {
		return x >=0 && x < N && y >=0 && y < M;
	}
	
	/*
	static void move(int r, int c) {
		if(checked[r][c]==1) ans++;	// 내꺼 다시들어가는거라 만들어야댐
		else if(checked[r][c]==-1) return; // 안만들어도댐
		else {	
			if(checked[r][c]==0) {
				checked[r][c] = 1;
				switch (map[r][c]) {
				case 'R':
					move(r, c+1);
					break;
				case 'L':
					move(r, c-1);
					break;
				case 'D':
					move(r+1, c);
					break;
				case 'U':
					move(r-1, c);
					break;
				}
				checked[r][c] = -1;
			}
		}
	}
	*/
}
