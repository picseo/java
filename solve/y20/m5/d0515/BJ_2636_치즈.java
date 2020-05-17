package d0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//외부인 0을 기준으로 진행하였다. 0에 대해 bfs를 진행하면서 만나는 1이 다음에 녹는 치즈이므로
//그 치즈의 값을 다른 값으로 바꾸고, 새로운 녹는 부분을 저장하는 new_zero에 추가하였다.
//그런데 현재 녹아지는 부분이랑 이미 녹아버린 부분을 구분하기 위해서 bfs에 type변수를 추가하여 구분하였다.

//다른 사람 코드를 보니 Queue말고 LinkedList를 사용해서 현재 지워진 부분은 앞부분에 채우고, 녹을 부분은 뒷부분에 넣으므로써 시간을 줄일수 있을 것같다.
public class BJ_2636_치즈 {
	static int N, M, cnt;
	static boolean[][] out_zero;
	static int[][] map;
	static Queue<Integer> new_zeros = new LinkedList();
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		out_zero = new boolean[N][M];
		cnt = 0;

		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) {
					map[i][j] = 1;
					cnt++;
				}
			}
		}

		int result = 0;
		int pre_cnt = cnt;
		new_zeros.add(0); new_zeros.add(0);
		int t = 1;
		while(cnt > 0) {		
			result++;
			//System.out.println("pre : " +pre_cnt + " , " + cnt);
			pre_cnt = cnt;
			int type = (result == 0)?0:t;
			int size = new_zeros.size()/2;
			for(int i  =0; i < size; i++){
				int x = new_zeros.poll();
				int y = new_zeros.poll();
				if(!out_zero[x][y]) {
					find_out(x, y, type);
				}
			}
			t++;
		}
		
		System.out.println(result+"\n"+pre_cnt);
	}


	private static void find_out(int x, int y, int type) {
		Queue<Integer> queue = new LinkedList();
		out_zero[x][y] = true;
		queue.add(x);queue.add(y);
		while(!queue.isEmpty()) {
			int qx = queue.poll();
			int qy = queue.poll();

			for(int d =0; d < 4; d++) {
				int nx = qx + dirs[d][0];
				int ny = qy + dirs[d][1];

				if(isIn(nx, ny)) {
					if(map[nx][ny] == 1) {//1
						map[nx][ny] = type+1;
						new_zeros.add(nx);
						new_zeros.add(ny);
						cnt--;
					}else if(map[nx][ny] <= type){//0
						if(!out_zero[nx][ny]) {
							out_zero[nx][ny] = true;
							queue.add(nx); queue.add(ny);
						}
					}
				}
			}
		}
	}



	static boolean isIn(int x, int y) {
		return x >=0 && x < N && y >=0 && y < M;
	}

}
