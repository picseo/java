package d0909;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 보는 오른쪽을 항상 보고, 기둥은 위쪽을 항상본다.

 기둥은 바닥위나, 보의 한쪽 끝, 다른 기둥위에 있어야함
 보는 한쪽 끝 부분이 기둥위, 양쪽 끝부분이 다른 보와 동시에 연결

 한 좌표에서 위아래에 기둥여부, 왼오 보 여부가 필요하다고 생각 (x, y, (위, 아래, 보), (왼, 오, 기둥)) (90도 회전한상태라고 생각하기)

삭제의 조건을 내가 모두 확인하기는 힘든것같다 -> 그럴때는 거꾸로 생각하기, 지우고 확인한후 안되면 다시 추가************************************************
경우의 수가 너무 많을 때는 다른 방법을 사용한다.(여기서는 일단 삭제를 한 후 해당 위치에 기둥이나 보를 넣을 수 있는지 확인하고, 안된다면 false를 리턴하는 식으로 확인할 수 잇다.)


 * */
public class 카카오2020p5 {
	static Point[][] map = new Point[101][101];
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	static class Point{
		int x, y;
		boolean up, down, left, right;
		public Point(int x, int y, boolean up, boolean down, boolean left, boolean right) {
			this.x = x;
			this.y = y;
			this.up = up;
			this.down = down;
			this.left = left;
			this.right = right;
		}
	}

	static class Write{
		int x, y, a;

		public Write(int x, int y, int a) {
			this.x = x;
			this.y = y;
			this.a = a;
		}
	}
	
	public static void main(String[] args) {
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int[][] build_frame2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] result = solution(5, build_frame2);
		for(int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}

	public static int[][] solution(int n, int[][] build_frame) {
		int[][] answer = {};

		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				map[i][j] = new Point(i, j, false, false, false, false);
			}
		}

		for(int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];//0 : 기둥, 1: 보
			int b = build_frame[i][3];//0 삭제, 1:설치

			if(b == 1) {
				if(checkinsert(x, y, a)) {
					if(a == 0) {//기둥(0, 1)
						map[x][y].right = true;
						map[x][y+1].left = true;
					}else {
						map[x][y].down = true;
						map[x+1][y].up = true;
					}
				}
			}else {
				/*if(checkremove(x, y, a)) {
					if(a == 0) {//기둥(0, 1)
						map[x][y].right = false;
						map[x][y+1].left = false;
					}else {
						map[x][y].down = false;
						map[x+1][y].up = false;
					}
				}*/
				
				if(a == 0) {//기둥(0, 1)
					map[x][y].right = false;
					map[x][y+1].left = false;
					
					if(!check(x, y)) {
						map[x][y].right = true;
						map[x][y+1].left = true;
					}
				}else {
					map[x][y].down = false;
					map[x+1][y].up = false;
					
					if(!check(x, y)) {
						map[x][y].down = true;
						map[x+1][y].up = true;
					}
				}
			}
		}
		
		ArrayList<int[]> result = new ArrayList<int[]>();
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(map[i][j].right) {
					result.add(new int[] {i, j, 0});
				}
				if(map[i][j].down) {
					result.add(new int[] {i, j, 1});
				}
			}
		}
		
		answer = new int[result.size()][3];
		for(int i =0; i < result.size(); i++) {
			answer[i] = result.get(i).clone();
		}
		return answer;
	}

	private static boolean check(int x, int y) {
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(map[i][j].right) {
					if(!checkinsert(i, j, 0)) {
						return false;
					}
				}
				if(map[i][j].down) {
					if(!checkinsert(i, j, 1)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean checkremove(int x, int y, int a) {
		if(a == 0) {//기둥
			if(isIn(x, y+1)) {
				//위칸의 왼쪽보를 확인한다.
				boolean right = false;
				boolean down = false;
				boolean up = false;
				
				if(map[x][y+1].up) {
					if(isIn(x-1, y+1)) {
						if(map[x-1][y+1].left) {
							up = true;
						}
					}
				}
				
				if(map[x][y+1].down) {
					if(isIn(x+1, y+1)) {
						if(map[x+1][y+1].left) {
							down = true;
						}
					}
				}
				
				if(!(up||down) && map[x][y+1].up && map[x][y+1].down) {//확신이 안됨 -> 
					if(isIn(x-2, y+1) && map[x-2][y+1].down &&
							isIn(x+2, y+1) && map[x+2][y+1].up) {
						up = true;
						down = true;
					}
				}
				
				if(map[x][y+1].right && (up || down)) {
					right = true;
				}
				
				boolean result = true;
				if(map[x][y+1].up) {
					if(!up) {
						result = false;
					}
				}
				
				if(map[x][y+1].down) {
					if(!down) {
						result = false;
					}
				}
				
				if(map[x][y+1].right) {
					if(!right) {
						result = false;
					}
				}
				return result;
				
			}else {
				return false;
			}
		}else {
			if(isIn(x+1, y)) {
				boolean up = false;
				boolean right1 = false;
				boolean right2 = false;
				boolean down = false;
				
				if(map[x+1][y].left) {
					right2 = true;
					down = true;
				}else {
					if(isIn(x+2, y) && map[x+2][y].left) {
						right2 = true;
						down = true;
					}
				}
				
				if(map[x][y].left) {
					right1 = true;
					up = true;
				}else {
					if(isIn(x-1, y) && map[x-1][y].left) {
						right1 = true;
						up = true;
					}
				}
				
				boolean result = true;
				if(map[x][y].up) {
					if(!up) {
						result = false;
					}
				}
				
				if(map[x][y].right) {
					if(!right1) {
						result = false;
					}
				}
				
				if(map[x+1][y].down) {
					if(!down) {
						result = false;
					}
				}
				
				if(map[x][y+1].right) {
					if(!right2) {
						result = false;
					}
				}
				return result;
				
			}else {
				return false;
			}
		}
	}

	private static boolean checkinsert(int x, int y, int a) {
		if(a == 0) {
			if(isIn(x, y+1)) {
				if(y == 0 || map[x][y].up || map[x][y].down || map[x][y].left) {
					return true;
				}
			}
		}else {
			if(isIn(x+1, y)) {
				if(map[x][y].left || map[x+1][y].left || (map[x][y].up && map[x+1][y].down)) {
					return true;
				}
			}
		}		

		return false;
	}

	static boolean isIn(int x, int y) {
		if(x >=0 && x < 101 && y >= 0 && y < 101) {
			return true;
		}
		return false;
	}

}
