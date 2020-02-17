package algo_basic.SWEA.mon1;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1209_D3_Sum {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1209.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int now = sc.nextInt();
			System.out.print("#"+now+" ");
			
			int[][] num = new int[100][100];
			int Max = Integer.MIN_VALUE;
			
			for(int i = 0; i < 100; i ++) {
				int tmp  = 0;
				for(int j = 0; j < 100; j++) {
					num[i][j] = sc.nextInt();
					
					tmp += num[i][j];
				}
				
				if(Max < tmp) {
					Max = tmp;
				}
			}
			
			int tmp_r = 0;
			int tmp_l = 0;
			for(int j = 0; j < 100; j++) {
				int tmp = 0;
				for(int i = 0; i < 100; i++) {
					tmp += num[i][j];
				}
				if(Max < tmp) {
					Max = tmp;
				}
				
				tmp_r += num[j][j];
				tmp_l += num[j][99-j];
			}
			
			Max = Integer.max(Max,  Integer.max(tmp_r,  tmp_l));
			System.out.println(Max);
		}		
	}
}
