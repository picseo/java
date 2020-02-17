package swea.d0214;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * Max값이 같을때는  num값을 비교해서 작은 경우만 바꾸어주고, Max보다 큰 값이 나온 경우에는 num은 무조건 업데이트 해야한다.
 * 혼자서 입력되는 값이 오름차순일 거라고 생각해서 num을 비교해 바꾸어주는걸 안했다가 이상한 값이 나왔다.
 * 
 * 그리고 제일 긴 걸 찾는 거라서 dfs라고 생각했다.
 * 방향을 확인해야 되서 x, y를 파라메터로 주었고, 현재까지의 길이도 알아야 해서 len이라는 변수도 파라메터로 넘겨주었다.
 * 
 * 처음에는 무조건 막히는 곳의 len값을 Max변수에 저장해 주었는데 이렇게 하면 해당 위치의 값을 모르게 되어서 
 * for문 마다 값을 받아서 그중에 큰 값만을 넘겨주었다.
 * */
public class SWEA_1861_D4_정사각형방 {
	private static int[][] rooms = null;
	private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//상우하좌
	private static int N = 0;
	private static int Max = Integer.MIN_VALUE;
	private static int num = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res\\sinput.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			rooms = new int[N][N];
			Max = Integer.MIN_VALUE;
			num = Integer.MAX_VALUE;
			
			for(int i = 0; i <N ; i++) {
				for(int j =0; j < N; j ++) {
					rooms[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i <N ; i++) {
				for(int j =0; j < N; j ++) {
					int now_max = dfs(i, j, 1);
					if(now_max > Max) {
						Max = now_max;
						num = rooms[i][j];
					}else if(Max == now_max){
						if(num > rooms[i][j])
							num = rooms[i][j];
					}
				}
			}
			System.out.println("#"+t+" "+num+" "+Max);
		}
	}

	private static int dfs(int x, int y, int len) {
		boolean stop = true;
		int tmp = 0;
		int max = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dirs[i][0];
			int ny = y + dirs[i][1];
			if(isIn(nx, ny) && (rooms[nx][ny] == (rooms[x][y] + 1))) {
				stop = false;
				tmp = dfs(nx, ny, len+1);	
				if(tmp > max) {
					max = tmp;
				}
			}
		}
		
		if(stop) {//아무곳도 안들거간곳 == 마지막위치
			return len;
		}else {
			return max;
		}		
	}
	private static boolean isIn(int x, int y) {
		if(x >= 0 && x <N && y >=0 && y< N) {
			return true;
		}else {
			return false;
		}
	}
}
