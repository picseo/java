package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/* 
 	BFS����
 	
 	�ּҶ�� ������ ���� �� �ַ� ����Ѵ�.
 	
 	queue�� �Բ� ���ȴ�.
 	
 	������ 2���� �迭�� �̿��ϴµ� ������ �߰��ؼ� 3�������� Ǯ��� �ϴ� ������ �ִ�.
 	
 	�ӳ�¥�� ���ϴ� ���������� queue�� ����� �̸� ���� ������ size��ŭ for���� ���� �� ������ �� 1�� ������Ű�� ������� ���Ѵ�.
 	
 	Ž���ؾ� �ϴ� ������ �̸� dirs��� �迭�� �����صθ�, for������ �ݹ� Ž���� �� �ִ�. 
 */
class Point{
	int x, y, z;

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}	
}

public class BJ_7569_�丶��_BFS {
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
