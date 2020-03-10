package d0303;

import java.util.Arrays;
import java.util.Scanner;


/*
 * ������ ���� ���� �� Ǯ�Ŷ� �����ؼ� ����� �ߴµ�
 * ��͸� ���� �Ǵ� ��������.
 * ��͸� �����ϰԵ� ������ �ڸ� ����� ���ڸ��� ��� �ൿ�� �ݺ��ȴٴ� ���� �˾ұ� �����̴�.
 * �׸��� �̷� ��͹��������� ���� �������� ���� ���ϴ� �ൿ�� �ݺ��Ǵ� ��찡 ����Ƿ�
 * memoization�� ����ؼ� �ݺ��� ���̸� �ȴ�.
 * 
 * ���� �� ���� �ʺ�, ���̸� �̿��ϸ� �簢�� ������ ���� �� �մ�.
 * 
 * �̷� ������ �����ϴ� �� ó�� ������ �ٽ� �����ؾ߰ڴ�.
 * 
 * */
public class SWEA_9282_D4_���ݸ���������_���� {
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
			//������ ������ ������ ó��
			result = dfs(0, 0, n, m);//, Integer.MAX_VALUE);
			//���
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	static int dfs(int y, int x, int h, int w) {//, int min) {
		//if(visited[y][x][h][w] != 0)
		if(visited[y][x][h][w] != Integer.MAX_VALUE)
			return visited[y][x][h][w];
		
		//����
		if(w == 1 && h == 1) {
			return 0;
		}
		//����
		//������ �ִ� ����� �������� ����
		//�Ź� ���� ���ϴ� �κе� ���ϼ� �ִ�.
		int sum = 0;
		for(int i = y; i < y + h; i++) {
			for(int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}
		//���η� ����� ����� �ּҺ���� ���Ѵ�.
		for(int i = 1; i < h; i++) {
			//���ʿ� ���
			//int sum1 = dfs(y, x, i, w);//, min);
			if(visited[y][x][i][w] == Integer.MAX_VALUE)
				visited[y][x][i][w] = dfs(y, x, i, w);
			//�Ʒ��ʿ� ���� ���
			//int sum2 = dfs(y+i, x, h-i, w);//, min);
			if(visited[y+i][x][h-i][i] == Integer.MAX_VALUE)
				visited[y+i][x][h-i][w] = dfs(y+i, x, h-i, w);
			//int sum3 = sum + sum1 + sum2;
			int sum3 = sum + visited[y][x][i][w] + visited[y+1][x][h-i][w];
			//min = Math.min(min,  sum3);
			visited[y][x][h][w] = Math.min(visited[y][x][h][w], sum3);
		}
		//���η� ����� ����� ���Ѵ�.
		for(int i = 1; i < w; i++) {
			//���ʿ� ���
			//int sum1 = dfs(y, x, h, i);//, min);
			if(visited[y][x][h][i] == Integer.MAX_VALUE)
				visited[y][x][h][i] = dfs(y, x, h, i);
			//�����ʿ� ���� ���
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
