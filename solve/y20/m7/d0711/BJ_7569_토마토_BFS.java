package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/* 
 	BFS문제
 	
 	최소라는 개념을 물을 때 주로 사용한다.
 	
 	queue와 함께 사용된다.
 	
 	보통은 2차원 배열을 이용하는데 조건을 추가해서 3차원으로 풀어야 하는 문제가 있다.
 	
 	ㅣ날짜를 구하는 문제에서는 queue의 사이즈를 미리 구한 다음에 size만큼 for문을 돌린 후 나왔을 때 1을 증가시키는 방법으로 구한다.
 	
 	탐색해야 하는 방향을 미리 dirs라는 배열로 저장해두면, for문으로 금방 탐색할 수 있다. 
 */
class Point{
	int x, y, z;

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}	
}

public class BJ_7569_토마토_BFS {
	static int M, N, H;
	static int[][][] tomatos =  new int[101][101][101];
	static boolean[][][] visited = new boolean[101][101][101];
	static int[][] dirs = {{0, 0, 1}, {0, 0 ,-1}, {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}};
	static Queue<Point> queue = new LinkedList();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int zero_num = 0;
		
		for(int h = 0; h < H; h++) {
			for(int i = 0 ; i < N; i++) {
				int j = 0;
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					int tmp = Integer.parseInt(st.nextToken());
					tomatos[i][j++][h] = tmp;

					if(tmp == 1) {
						queue.add(new Point(i, j-1, h));
						visited[i][j-1][h] = true;
					}
					if(tmp == 0) {
						zero_num++;
					}
				}
			}
		}

		int result = -1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s = 0 ;s < size; s++) {
				Point next = queue.poll();


				for(int i = 0; i < 6; i++) {
					int nx = next.x + dirs[i][0];
					int ny = next.y + dirs[i][1];
					int nz = next.z + dirs[i][2];

					if(isIn(nx, ny, nz) && !visited[nx][ny][nz]) {
						if(tomatos[nx][ny][nz] == 0) {
							tomatos[nx][ny][nz] = 1;
							visited[nx][ny][nz] = true;
							queue.add(new Point(nx, ny, nz));
							zero_num--;
						}
					}
				}
			}
			result++;
		}
		
		if(zero_num == 0) {
			System.out.println(result);
		}else {
			System.out.println("-1");
		}
	}

	private static boolean isIn(int x, int y, int z) {
		if(x >=0 && x < N && y >=0 && y < M && z >=0 && z <H) {
			return true;
		}
		return false;
	}



}
