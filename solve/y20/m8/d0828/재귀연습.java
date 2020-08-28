package d0828;

import java.util.Arrays;

public class 재귀연습 {
	static int[][] map = new int[3][3];
	public static void main(String[] args) {		
		map[2][1] = 1;
		map[1][2] = 1;
		
		//2를 2개를 배치!
		for(int i = 0; i <= 7; i++) {
			find(0, i);
		}
	}

	private static void find(int idx, int k) {
		if(k != 0 && idx == 9) {
			return;
		}
		
		if(k == 0) {
			for(int i =0 ; i < 3; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
			return;
		}
		
		int x = idx/3;
		int y = idx%3;
		if(map[x][y] == 0) {
			map[x][y] = 2;
			find(idx+1, k-1);
			map[x][y] = 0;
		}
		find(idx+1, k);
		
	}

	
}
