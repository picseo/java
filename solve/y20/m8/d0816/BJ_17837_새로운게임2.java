package d0816;

import java.util.Scanner;

public class BJ_17837_새로운게임2 {
	static public int N, K;
	static public int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};	
	static public int[][] map;
	static public int[][] check;
	
	static public class horse{
		int x;
		int y;
		int dir;
		int up;
		int down;
		
		horse(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.up = -1;
			this.down = -1;
		}
	}
	
	static public horse[] hs;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N+1][N+1];
		check = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		hs = new horse[K+1];
		for(int i = 1; i <= K; i++) {
			hs[i] = new horse(sc.nextInt(), sc.nextInt(), sc.nextInt()-1);
			check[hs[i].x][hs[i].y] = i; 
		}
		
		boolean stop = true; // 말의 위치가 바뀌었는가?
		int cnt = 0;
		while(++cnt < 1000) {
			if(cnt > 1000) {
				break;
			}
			
			for(int i = 1; i <= K; i++) {
				int x = hs[i].x;
				int y = hs[i].y;
				int nx = x + dirs[hs[i].dir][0];
				int ny = y + dirs[hs[i].dir][1];
				
				if(!isIn(nx, ny) || map[nx][ny] == 2) {
					if(hs[i].dir == 0 || hs[i].dir == 2) {
						hs[i].dir += 1;
					}else if(hs[i].dir == 1 || hs[i].dir == 3){
						hs[i].dir -= 1;
					}
					i--;
					continue;					
				}else if(map[nx][ny] == 0) {//흰색
					
					if(hs[i].down != -1) {
						int down = hs[i].down;
						check[x][y] = down;
						hs[i].down = -1;
						hs[down].up = -1;
					}else {
						check[x][y] = 0;
					}					
					//위로 올라감
					if(check[nx][ny] != 0) {
						int now = check[nx][ny];
						hs[i].down = now;
						hs[now].up = i;
					}
					
					//check[nx][ny] = find_top(i);
					//set_top(i, nx, ny);
					
				}else if(map[nx][ny] == 1) {//빨간색
					
					if(hs[i].down != -1) {
						int down = hs[i].down;
						check[x][y] = down;
						hs[i].down = -1;
						hs[down].up = -1;
					}else {
						check[x][y] = 0;
					}					
					
					//뒤집어서 위로 올라감
					//int pre_top = find_top(i);
					if(check[nx][ny] != 0) {
						int now = check[nx][ny];
						//int top = pre_top;
						//reverse(top, now);
					}
					
					//System.out.println("restul : " + find_top(check[nx][ny]));
					check[nx][ny] = i;
					//set_top(pre_top, nx, ny);
					//System.out.println("i : "+ i);
				}
				
			}
			
			for(int i = 1; i <= K; i++) {
				System.out.println(" i : "+ i + " , (" + hs[i].x + " , " + hs[i].y + " )");
			}
			if(stop) {
				break;
			}
		}
		
		if(cnt > 1000 || stop) {
			System.out.println(-1);
		}else {
			System.out.println(cnt);
		}
	
	}

	private static void set_top(int i, int nx, int ny) {
		if(hs[i].up == -1) {
			return ;
		}else {
			hs[i].x = nx;
			hs[i].y = ny;
			set_top(hs[i].up, nx, ny);
		}		
	}

	private static void reverse(int top, int now) {
		int pre_down = hs[top].down;
		int pre_up = hs[top].up;
		
		if(pre_down != -1) {
			hs[now].up = top;
			hs[top].down = now;
		
			reverse(pre_down, top);
		}else {
			hs[top].up = -1;
		}
	}

	private static int find_top(int i) {
		if(hs[i].up == -1) {
			return i;
		}else {
			return find_top(hs[i].up);
		}
	}

	private static boolean isIn(int nx, int ny) {
		if(nx >= 0 && nx < N && ny >= 0 && ny <N) {
			return true;
		}
		return false;
	}

}
