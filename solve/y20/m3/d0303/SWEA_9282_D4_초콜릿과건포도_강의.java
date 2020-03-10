package d0303;

import java.util.Arrays;
import java.util.Scanner;


/*
 * 순열을 쓰면 절대 못 풀거라 생각해서 고민을 했는데
 * 재귀를 쓰면 되는 문제였다.
 * 재귀를 생각하게된 이유는 자른 결과를 또자르는 경우 행동이 반복된다는 것을 알았기 때문이다.
 * 그리고 이런 재귀문제에서는 작은 조각들의 값을 구하는 행동이 반복되는 경우가 생기므로
 * memoization을 사용해서 반복을 줄이면 된다.
 * 
 * 왼쪽 위 점과 너비, 높이를 이용하면 사각형 정보를 보낼 수 잇다.
 * 
 * 이런 식으로 접근하는 건 처음 봤으니 다시 복습해야겠다.
 * 
 * */
public class SWEA_9282_D4_초콜릿과건포도_강의 {
	static int result;
	static int n, m;
	static int[][] map;
	static int[][][][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			map = new int[n][m];
			visited = new int[n+1][m+1][n+1][m+1];
			
			for(int[][][] d1 : visited) {
				for(int[][] d2 : d1) {
					for(int[] d3 : d2) {
						Arrays.fill(d3,  Integer.MAX_VALUE);
					}
				}
			}
			
			for(int i = 0; i < n ; i++) {
				for(int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//사이즈 정해져 있으면 처리
			result = dfs(0, 0, n, m);//, Integer.MAX_VALUE);
			//출력
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	static int dfs(int y, int x, int h, int w) {//, int min) {
		//if(visited[y][x][h][w] != 0)
		if(visited[y][x][h][w] != Integer.MAX_VALUE)
			return visited[y][x][h][w];
		
		//종료
		if(w == 1 && h == 1) {
			return 0;
		}
		//실행
		//기존에 있는 덩어리의 건포도의 갯수
		//매번 합을 구하는 부분도 줄일수 있다.
		int sum = 0;
		for(int i = y; i < y + h; i++) {
			for(int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}
		//가로로 나누어서 배용을 최소비용을 구한다.
		for(int i = 1; i < h; i++) {
			//위쪽에 비용
			//int sum1 = dfs(y, x, i, w);//, min);
			if(visited[y][x][i][w] == Integer.MAX_VALUE)
				visited[y][x][i][w] = dfs(y, x, i, w);
			//아래쪽에 대한 비용
			//int sum2 = dfs(y+i, x, h-i, w);//, min);
			if(visited[y+i][x][h-i][i] == Integer.MAX_VALUE)
				visited[y+i][x][h-i][w] = dfs(y+i, x, h-i, w);
			//int sum3 = sum + sum1 + sum2;
			int sum3 = sum + visited[y][x][i][w] + visited[y+1][x][h-i][w];
			//min = Math.min(min,  sum3);
			visited[y][x][h][w] = Math.min(visited[y][x][h][w], sum3);
		}
		//세로로 나누어서 비용을 구한다.
		for(int i = 1; i < w; i++) {
			//왼쪽에 비용
			//int sum1 = dfs(y, x, h, i);//, min);
			if(visited[y][x][h][i] == Integer.MAX_VALUE)
				visited[y][x][h][i] = dfs(y, x, h, i);
			//오른쪽에 대한 비용
			//int sum2 = dfs(y, x+i, h, w-i);//, min);
			if(visited[y][x+i][h][w-i] == Integer.MAX_VALUE)
				visited[y][x+i][h][w-i] = dfs(y, x+i, h, w-i);
			//int sum3 = sum + sum1 + sum2;
			int sum3 = sum + visited[y][x][h][i] + visited[y][x+i][h][w-i];
			//min = Math.min(min,  sum3);
			visited[y][x][h][w] = Math.min(visited[y][x][h][w], sum3);
		}
		
		//visited[y][x][h][w] = min;
		//return min;	
		return visited[y][x][h][w];
	}
	private static String src = "2\r\n" + 
			"\r\n" + 
			"2 2\r\n" + 
			"\r\n" + 
			"1 1\r\n" + 
			"\r\n" + 
			"1 1\r\n" + 
			"\r\n" + 
			"2 3\r\n" + 
			"\r\n" + 
			"2 7 5\r\n" + 
			"\r\n" + 
			"1 9 5";
}
