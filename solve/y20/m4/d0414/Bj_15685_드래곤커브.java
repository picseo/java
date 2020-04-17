package d0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//이전의 방향만 기억한 후 90도 회전된 값을 구해서 visited에 표시를 한뒤에
//마지막에 사각형이 된 부분들을 확인하면 된다.

/* 배열을 미리 구한 후 푸는 방법이 조금 더 빨라서 가지고 왔다.
 * int len = (int) Math.pow(2, g);
			
			int[] arr = new int[len];
			arr[0] = d;
			
			
			//방향 배열 구하기
			for (int j = 0; j < g; j++) {
				int loop = (int) Math.pow(2, j);
				
				for (int k = 0; k < loop; k++) {
					arr[loop+k] = (arr[loop-k-1]+1)%4;
				}
			}
 * 
 * */
public class Bj_15685_드래곤커브 {
	static boolean [][] visited = new boolean[101][101];
	static int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new ArrayList();
			
			//0세대 진행
			visited[x][y] = true;
			int nx = x + dirs[d][0];
			int ny = y + dirs[d][1];
			x = nx;
			y = ny;
			visited[nx][ny] = true;
			list.add(d);
			
			for(int i = 0; i < g; i++) {
				int size = list.size();
				for(int j = size-1; j >=0 ;j--) {
					int nd = (list.get(j)+1)%4;
					nx = x + dirs[nd][0];
					ny = y + dirs[nd][1];
					
					visited[nx][ny] = true;
					list.add(nd);
					x = nx;
					y = ny;
				}
			}
		}

		int result = 0;
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(isIn(i+1, j+1)) {
					if(visited[i][j] && visited[i+1][j+1] && visited[i+1][j] && visited[i][j+1]) {
						result++;
					}
				}
			}
		}
		
		System.out.println(result);
	}
	public static boolean isIn(int x, int y) {
		if(x < 0 || x > 100 || y <0 ||y >100) {
			return false;
		}
		return true;
	}

}
