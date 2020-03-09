package solve.s0213;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SWEA_1979_D2_어디에단어가들어갈수있을까 {

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res\\1979.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t= 1; t <= T; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			boolean[][] map = new boolean[n][n];
			int[] nums = new int[16];
			
			
			for(int i = 0; i < n ; i++) {
				int cnt = 0;
				boolean now = false;//앞에가 0이면 f, 1이면 t
				for(int j = 0; j < n ; j++) {
					int tmp = sc.nextInt();
					if(tmp == 1) {
						map[i][j] = true;
						if(!now) {
							now = true;
						}
						cnt++;
					}else {
						if(now) {
							nums[cnt]++;
							now = !now;
						}
						cnt = 0;
					}
				}
				if(now) {
					nums[cnt]++;
				}
			}
			
			for(int i = 0; i < n ; i++) {
				int cnt = 0;
				boolean now = false;//앞에가 0이면 f, 1이면 t
				for(int j = 0; j < n ; j++) {
					if(map[j][i]) {
						if(!now) {
							now = true;
						}
						cnt++;
					}else {
						if(now) {
							nums[cnt]++;
							now = !now;
						}
						cnt = 0;
					}
				}
				if(now) {
					nums[cnt]++;
				}
			}
			
			System.out.println("#"+t+" "+nums[k]);
		}
		
	}

}
