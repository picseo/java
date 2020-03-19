package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * dfs�� �ϸ� �־��� ��쿡 �ð��ʰ��� ������ �ȴ�.
 * bfs�� �̿��ؾ� �ϴµ� �޸𸮸� �����ϰ� ������� �ʰ� �ذ��� �� �ִ� ����� ����ؾ� �Ѵ�.
 * 
 * **/
public class �����ǵ��̸����� {
	static int N, M;
	static char[][] map;
	static int[][] dirs = {{0, 1}, {1, 0}};
	static char[] result = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N+1][M+1];
			
			for(int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			result = null;
			char[] tmp = new char[N+M+5];
			dfs(0, 0, 0, tmp, false);
		
			System.out.println("result : " +Arrays.toString(result));
			
			sb.append("#").append(t).append(" ");
			for(int i = 0; i < N+M; i++) {
				sb.append(result[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int x, int y, int idx, char[] tmp, boolean front) {			
		if(!front && result != null) {
			if(result[idx] < map[x][y]) {
				return;
			}else if(result[idx] > map[x][y]) {
				front = true;
			}			
		}
		
		tmp[idx] = map[x][y];
		
		if(x == N-1 && y == M-1) {
			for(int i = 0; i < N+M; i++) {
				char ss = tmp[i];
				result[i] = ss;
			}
			return;
		}
		
		for(int i = 0; i < 2; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			
			if(isIn(nx,  ny)) {
				dfs(nx, ny, idx+1, tmp, front);
			}
		}
		
	}
	
	private static boolean isIn(int x, int y) {
		if(x >= 0 && x< N && y >= 0 && y <M) {
			return true;
		}else {
			return false;
		}
	}

	private static String src = "3\r\n" + 
			"2 5\r\n" + 
			"adbfc\r\n" + 
			"dcghi\r\n" + 
			"5 5\r\n" + 
			"bbbbb\r\n" + 
			"bbbbb\r\n" + 
			"bazbb\r\n" + 
			"bzbbb\r\n" + 
			"bbbbb\r\n" + 
			"4 5\r\n" + 
			"ponoc\r\n" + 
			"ohoho\r\n" + 
			"hlepo\r\n" + 
			"mirko";
}
