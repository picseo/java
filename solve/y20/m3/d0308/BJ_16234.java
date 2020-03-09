package d0308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * �Ź� bfs�� �����ؼ� ���� �ٲپ� �ְ�
 * bfs�� ���� �ٲٴ� ��찡 ����� ��� true, ���� �ٲ��� �ʴ� ��� false�� 
 * return ���ش�.
 * 
 * bfs�� ã�� ����� ������ �α����� update�ϱ� ���ؼ� ������ ������ �����صδ� list�� ����� �ξ���.
 * 
 * inin�� bfs�� ����� �����ϴ� ������ �ϳ��� ���� �ٲ�� true, ��� �ٲ��� �ʾҴٸ� false�� ������.
 * */
public class BJ_16234 {
	static int[][] pnums = null;
	static boolean[][]visited = null;
	static int result = 0;
	static int N, L, R;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		pnums = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N ;j++) {
				pnums[i][j] = sc.nextInt();
			}
		}
		
		boolean inin = false;
		int cnt = 0;
		while(true) {
			inin = false;
			//�α����� ������ ���� ���, graph�� ���� �����Ǵ��� ������ ����� �ȴ�.
			for(int i = 0; i < N ; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						inin = inin | bfs(i, j);//�ٲپ����� true, �ƴϸ� false
					}
				}
			}
			
			if(!inin) {
				break;
			}
			
			
			cnt++;		
			for(int i = 0; i < N; i++) {
				Arrays.fill(visited[i],  false);
			}			
		}
		
		sb.append(cnt).append("\n");
		System.out.print(sb);
	}
	
	private static boolean isIn(int x, int y) {
		if(x >=0 && x <N && y >=0 && y <N) {
			return true;
		}else {
			return false;
		}
	}
	
	private static boolean bfs(int x, int y) {
		Queue<Point> queue = new LinkedList();
		List<Point> list = new ArrayList();
		visited[x][y] = true;
		queue.add(new Point(x, y));
		int sum = 0;
		int cnt = 0;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			sum += pnums[now.x][now.y];
			cnt++;
			list.add(now);
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dirs[i][0];
				int ny = now.y + dirs[i][1];
				
				if(isIn(nx, ny) && !visited[nx][ny]) {
					int diff = Math.abs(pnums[nx][ny] - pnums[now.x][now.y]);
					if(diff >= L && diff <= R) {
						visited[nx][ny] = true;
						queue.add(new Point(nx, ny));
					}
				}
			}
		}
		
		if(cnt > 1) {
			int next_num = sum/cnt;
			for(int i = 0; i < list.size(); i++) {
				Point now = list.get(i);
				pnums[now.x][now.y] = next_num;
			}
			return true;
		}else {
			return false;
		}		
	}
	
	private static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
			
		}
	}
	
	private static String src = "4 10 50\r\n" + 
			"10 100 20 90\r\n" + 
			"80 100 60 70\r\n" + 
			"70 20 30 40\r\n" + 
			"50 20 100 10";
}
