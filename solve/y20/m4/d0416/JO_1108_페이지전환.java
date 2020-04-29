package d0416;

import java.util.Arrays;
import java.util.Scanner;

public class JO_1108_페이지전환 {
	static int max = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int input[][] = new int[n][2];
		int num = 0;
		
		for(int i = 0; i < n; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			input[i][0] = from-1;
			input[i][1] = to-1;
			
			num = Math.max(num, Math.max(from, to));
		}
		
		int[][] map = new int[num][num];
		for(int i = 0; i < num; i++) {
			Arrays.fill(map[i], max);
			map[i][i] = 0;
		}
		
		for(int i = 0; i < n; i++) {
			map[input[i][0]][input[i][1]] = 1;
		}
		
		
		for(int k = 0; k < num; k++) {
			for(int i = 0; i < num; i++) {
				for(int j = 0; j < num; j++) {
					if(map[i][j] > map[i][k]+map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		double result = 0;
		for(int i =0 ; i < num; i++) {
			for(int j = 0; j < num; j++) {
				result += map[i][j];
			}
		}
		
		result /= num*(num-1);
		System.out.printf("%.3f", result);
	}

}
/*
 * 5
1 2
2 4
1 3
3 1
4 3
 * */
