package d0819;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
/*
 	한 말의 위, 아래 정보를 가지게해서 구현하고 싶었는데
 	못하겠어서
 	
 	일단은 각 칸에 말의 배열을 저장할 수 있게 만들어서 구현하였다.
 	
 	LinkedList()는 queue처럼 쓰는걸 다시 기억해야겠다.
 	(시뮬레이션)
 * */
public class BJ_17837_새로운게임2 {
	
	static public class horse{
		int x, y, dir;

		public horse(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static int N, K;
	static int[][] map;
	static Stack<Integer> [][] line;
	static horse[] horses;
	static int[][] dirs = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N+1][N+1];
		line = new Stack[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				line[i][j] = new Stack();
			}
		}
		
		horses = new horse[K+1];
		for(int i = 1; i < K+1; i++) {
			horses[i] = new horse(sc.nextInt(), sc.nextInt(), sc.nextInt());
			line[horses[i].x][horses[i].y].add(i);
		}
		
		int c;
		boolean out = false;
		for(c = 1; c <= 1000; c++) {
			for(int h = 1; h < K+1; h++) {
				int x = horses[h].x;
				int y = horses[h].y;
				
				int nx = x + dirs[horses[h].dir][0];
				int ny = y + dirs[horses[h].dir][1];
				
				if(!isIn(nx, ny) || map[nx][ny] == 2) {
					//방향을 반대로 바꿈
					int dir = horses[h].dir;
					
					if(dir == 1 || dir == 3) {
						dir += 1;
					}else {
						dir -= 1;
					}
					
					horses[h].dir = dir;
					
					nx = x + dirs[horses[h].dir][0];
					ny = y + dirs[horses[h].dir][1];
					if(isIn(nx, ny) && map[nx][ny] != 2) {
						h--;
						continue;
					}					
				}else if(map[nx][ny] == 1) {
					LinkedList<Integer> move = new LinkedList<Integer>();
					
					for(int i = line[x][y].size()-1; i >= 0; i--) {
						int now = line[x][y].pop();
						move.add(now);
						if(now == h) {
							break;
						}							
					}
					
					while(!move.isEmpty()) {
						int now = move.pop();
						horses[now].x = nx;
						horses[now].y = ny;
						line[nx][ny].add(now);
					}
					
					move.clear();
				}else {//0 흰색
					Stack<Integer> move = new Stack<Integer>();
					for(int i = line[x][y].size()-1; i >= 0; i--) {
						int now = line[x][y].pop();
						move.add(now);
						if(now == h) {
							break;
						}						
					}
					
					while(!move.isEmpty()) {
						int now = move.pop();
						horses[now].x = nx;
						horses[now].y = ny;
						line[nx][ny].add(now);
					}
					move.clear();
				}
				
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						if(line[i][j].size() >= 4) {
							out = true;
						}
					}
				}
				if(out) {
					break;
				}
			}//h loop
			if(out) {
				break;
			}
		}//c loop 
		
		if(c <= 1000) {
			System.out.println(c);
		}else {
			System.out.println(-1);
		}
				
	}

	private static boolean isIn(int nx, int ny) {
		if(nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
			return true;
		}
		return false;
	}

}
