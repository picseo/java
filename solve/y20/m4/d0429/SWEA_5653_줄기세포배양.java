package d0429;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
// 세포의 now를 0이 된 후에 다시 reset해주는거랑 번식해야하는 시기를
// 바로 하지 않고, 다음 단계에서 하는게 중요한것같다.
public class SWEA_5653_줄기세포배양 {
	static class Sepo{
		int x, y;//위치
		int val;//원래 가진 값
		int now;//현재 가진 값
		int time;//시간
		boolean die;//죽었는지 살았는지
		Sepo(int x, int y, int val, int now, int time, boolean die) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
			this.now = now;
			this.time = time;
			this.die = die;
		}
	}
	
	static int N, M, K;
	static int[][] map;
	static List<Sepo> list;
	static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N+K][M+K];
			list = new ArrayList<Sepo>();
			
			for(int i = (K/2); i < (K/2)+N; i++) {
				for(int j = (K/2); j < (K/2)+M; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] != 0) {
						list.add(new Sepo(i, j, map[i][j], map[i][j], K, false));
					}
				}
			}
			
			list.sort(new Comparator<Sepo>() {

				@Override
				public int compare(Sepo o1, Sepo o2) {
					return -Integer.compare(o1.val, o2.val);
				}
				
			});
			
			bfs();
			
			int cnt = 0;
			for(int i =0; i < N+K; i++) {
				for(int j = 0; j < M+K; j++) {
					if(map[i][j] != 0 && map[i][j]!= -1) {
						cnt++;
					}
				}
			}
			sb.append("# "+t+" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Sepo> queue = new LinkedList();
		for(int i =0; i < list.size(); i++) {
			queue.add(list.get(i));
		}
		
		while(!queue.isEmpty()) {
			Sepo now = queue.poll();
			
			if(now.now == 0 && now.die) {//죽었다면
				map[now.x][now.y]= -1; 
				continue;
			}
			
			if(now.time == 0) {//주어진 시간이 끝남
				//return ;
				continue;
			}
			
			if(now.now != 0) {//아직 번식시기 아님
				queue.add(new Sepo(now.x, now.y, now.val, now.now-1, now.time-1, now.die));
				continue;
			}
			
			//이제 번식후 남은 시간을 지남
			queue.add(new Sepo(now.x, now.y, now.val, now.val, now.time, true));
			
			for(int d = 0; d < 4; d++) {
				int nx = now.x + dirs[d][0];
				int ny = now.y + dirs[d][1];
				if(0 <= nx && nx < N+K && 0<=ny && ny < M+K &&map[nx][ny] == 0) {
					map[nx][ny] = now.val;
					queue.add(new Sepo(nx, ny, now.val, now.val, now.time-1, false));
				}
			}
			
		}
		
	}
}
