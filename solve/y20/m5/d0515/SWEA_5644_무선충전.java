package d0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 배터리 충전이 겹치는 부분, -> bitmask로 표시
 같은 시간에 같은 배터리에 곁치는 경우 -> queue에 둘을 넣고 둘다 이동시킨다음에 같은 배터리인지확인하고 같은 배터리가 아닌 경우에만 값을 더해주었다

 */

public class SWEA_5644_무선충전 {
	static int[][] dirs = {{0, 0}, {-1, 0}, {0,1}, {1, 0}, {0,-1}};
	static int M, A, result;
	static int[] p1, p2, bc;
	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			//input 받음
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			result = 0;
			p1 = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				p1[i] = Integer.parseInt(st.nextToken());
			}

			p2 = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				p2[i] = Integer.parseInt(st.nextToken());
			}

			map = new int[10][10];
			bc = new int[A];
			for(int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				int len = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());

				bfs(x, y, i, len);
				bc[i] = val;
			}

			for(int i = 0; i < 10; i++) {
				System.out.println(Arrays.toString(map[i]));
			}

			Queue<int[]> q = new LinkedList();
			q.add(new int[] {0, 0});//A
			q.add(new int[] {9, 9});

			for(int i = 0; i < M+1; i++) {
				int[] pA = q.poll();
				int[] pB = q.poll();

				//배터리 충전
				charge(pA, pB);

				if(i == M) {
					break;
				}

				//이동
				int nxA = pA[0] + dirs[p1[i]][0];
				int nyA = pA[1] + dirs[p1[i]][1];
				int nxB = pB[0] + dirs[p2[i]][0];
				int nyB = pB[1] + dirs[p2[i]][1];

				q.add(new int[] {nxA, nyA});
				q.add(new int[] {nxB, nyB});
			}

			for(int i = 0; i < 10; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);		
	}

	private static void bfs(int x, int y, int i, int len) {
		Queue<Integer> q = new LinkedList();
		q.add(x); q.add(y);
		map[x][y] |= (1<<i);
		int count = 0;
		while(!q.isEmpty()) {
			int size = q.size()/2;
			for(int j = 0; j < size; j++){
				int qx = q.poll();
				int qy = q.poll();

				for(int d= 1 ; d < 5; d++) {
					int nx = qx + dirs[d][0];
					int ny = qy + dirs[d][1];

					if(isIn(nx, ny) && (map[nx][ny]&(1<<i)) == 0) {
						map[nx][ny] |= (1<<i);
						q.add(nx); q.add(ny);
					}
				}
			}

			count++;
			if(count == len) {
				break;
			}
		}
	}

	private static void charge(int[] pA, int[] pB) {
		int Ax = pA[0];
		int Ay = pA[1];
		int Bx = pB[0];
		int By = pB[1];

		int max = 0;
		for(int i = 0; i < 9; i++) {
			int tmp = 0;
			if((map[Ax][Ay]&(1<<i)) == 0) {
				tmp = 0;
			}else {
				tmp += bc[i];
			}			

			for(int j = 0; j < 9; j++) {
				if((map[Bx][By]&(1<<j)) > 0) {
					if(i != j) {
						tmp += bc[j];
					}
				}
				
				if(max < tmp) {
					max = tmp;
				}
				if((map[Bx][By]&(1<<j)) > 0 && i!=j) {
					tmp -= bc[j];
				}		
			}
		}

		result += max;
	}

	static boolean isIn(int x, int y) {
		return x >=0 && x < 10 && y >=0 && y < 10;
	}
}
