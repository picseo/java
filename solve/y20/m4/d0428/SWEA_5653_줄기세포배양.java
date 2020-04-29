package d0428;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_5653_줄기세포배양 {
	static int N, M, K;
	static int map[][];
	static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			map =  new int[N+2*K][M+2*K];
			for(int i = 0; i < N+2*K; i++) {
				Arrays.fill(map[i], -11);
			}
			
			PriorityQueue<Sepo> queue = new PriorityQueue();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					int tmp = sc.nextInt();
					if(tmp != 0) {
						map[K+i][K+j] = tmp;
						queue.add(new Sepo(K+i, K+j, tmp, tmp));
					}
				}
			}
			
			int time = K;
			while(time != 0) {
				
				int size = queue.size();
				PriorityQueue<Sepo> tmp = new PriorityQueue<>();
				for(int i = 0; i < size; i++) {
					Sepo now = queue.poll();
					now.now -= 1;
					
					
					if(now.now+now.val == 0) {//죽음
						
					}else {//죽지 않았을때 
						if(now.now == 0) {//번식
							
							for(int d = 0; d < 4; d++) {
								int nx = now.x + dirs[d][0];
								int ny = now.y + dirs[d][1];
								
								if(isIn(nx, ny) && map[nx][ny] == -11) {
									map[nx][ny] = now.val;
									tmp.add(new Sepo(now.x, now.y, now.val, now.val));
								}
							}
							
						}else{
							//값을 줄임
							tmp.add(new Sepo(now.x, now.y, now.val, now.now-1));
						}
						
					}
				}
				
				//queue로 값을 옮기기
				queue.clear();
				while(!tmp.isEmpty()) {
					queue.add(tmp.poll());
				}
				
				time--;
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		if(x >= 0 && x < N+2*K && y >= 0 && y < M+2*K) {
			return true;
		}
		return false;
	}
	
	static class Sepo implements Comparable<Sepo>{
		int x, y, val, now;

		public Sepo(int x, int y, int val, int now) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;//원래 가진 값
			this.now = now;//지금 가진 값
		}

		@Override
		public int compareTo(Sepo o) {
			if(this.now == o.now) {
				return o.val - this.val;
			}
			return this.now - o.now;
		}
	}

}
