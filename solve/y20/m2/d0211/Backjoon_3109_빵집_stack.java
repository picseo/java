package swea.d0211;

import java.util.Scanner;
import java.util.Stack;

 

public class Backjoon_3109_빵집_stack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
		int r = sc.nextInt();
		int c = sc.nextInt();
		char[][] map = new char[r][c];
		String tmp;
		Stack<info> st = new Stack<>();
		for (int i = 0; i < r; i++) {
			tmp = sc.next();
			for (int j = 0; j < c; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		int cnt = 0;
		for (int m = 0; m < r; m++) {
			st.add(new info(m, 0, 0));
			
			
			while (!st.isEmpty()) {
				boolean notout = false;
				int now = st.peek().dir;
				for (int k = now; k < 3; k++) {
					int nx = st.peek().x + dir[k][0];
					int ny = st.peek().y + dir[k][1];
					if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == '.') {
						map[st.peek().x][st.peek().y] = 'x';
						st.peek().dir = 0;//k;
						st.add(new info(nx, ny, 0));
						notout = true;
						break;
					}
				}

				map[st.peek().x][st.peek().y] = 'x';
				if (st.peek().y == c - 1) {
					st.clear();
					cnt++;
					break;
				}
				if(!notout)
					st.pop();
			}
		}

		System.out.println(cnt);
	}
 

	static class info {
		int x;
		int y;
		int dir;
		
		public info(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	
	private static String src = "5 5\r\n" + 
			".xx..\r\n" + 
			"..x..\r\n" + 
			".....\r\n" + 
			"...x.\r\n" + 
			"...x.";
}
