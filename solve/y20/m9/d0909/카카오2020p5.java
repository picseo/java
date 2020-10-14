package d0909;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 ���� �������� �׻� ����, ����� ������ �׻󺻴�.

 ����� �ٴ�����, ���� ���� ��, �ٸ� ������� �־����
 ���� ���� �� �κ��� �����, ���� ���κ��� �ٸ� ���� ���ÿ� ����

 �� ��ǥ���� ���Ʒ��� ��տ���, �޿� �� ���ΰ� �ʿ��ϴٰ� ���� (x, y, (��, �Ʒ�, ��), (��, ��, ���)) (90�� ȸ���ѻ��¶�� �����ϱ�)

������ ������ ���� ��� Ȯ���ϱ�� ����Ͱ��� -> �׷����� �Ųٷ� �����ϱ�, ����� Ȯ������ �ȵǸ� �ٽ� �߰�************************************************
����� ���� �ʹ� ���� ���� �ٸ� ����� ����Ѵ�.(���⼭�� �ϴ� ������ �� �� �ش� ��ġ�� ����̳� ���� ���� �� �ִ��� Ȯ���ϰ�, �ȵȴٸ� false�� �����ϴ� ������ Ȯ���� �� �մ�.)


 * */
public class īī��2020p5 {
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
			int a = build_frame[i][2];//0 : ���, 1: ��
			int b = build_frame[i][3];//0 ����, 1:��ġ

			if(b == 1) {
				if(checkinsert(x, y, a)) {
					if(a == 0) {//���(0, 1)
						map[x][y].right = true;
						map[x][y+1].left = true;
					}else {
						map[x][y].down = true;
						map[x+1][y].up = true;
					}
				}
			}else {
				/*if(checkremove(x, y, a)) {
					if(a == 0) {//���(0, 1)
						map[x][y].right = false;
						map[x][y+1].left = false;
					}else {
						map[x][y].down = false;
						map[x+1][y].up = false;
					}
				}*/
				
				if(a == 0) {//���(0, 1)
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
		if(a == 0) {//���
			if(isIn(x, y+1)) {
				//��ĭ�� ���ʺ��� Ȯ���Ѵ�.
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
				
				if(!(up||down) && map[x][y+1].up && map[x][y+1].down) {//Ȯ���� �ȵ� -> 
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
