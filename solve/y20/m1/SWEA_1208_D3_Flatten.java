package swea.D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1208_D3_Flatten {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1208.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int dump = sc.nextInt();
			int[] height = new int[102];
			
			int Max = Integer.MIN_VALUE;
			int Min = Integer.MAX_VALUE;
			
			for(int i = 1; i <= 100; i++) {
				int tmp = sc.nextInt();
				height[tmp]++;
				
				if(Max < tmp) {
					Max = tmp;
				}
				if(Min > tmp) {
					Min = tmp;
				}
			}
			
			while(dump > 0) {
				int tmp = Integer.min(height[Max], height[Min]);
				if(dump < tmp) {
					tmp = dump;
				}
				
				height[Max] -= tmp;
				height[Min] -= tmp;
				height[Max-1] += tmp;
				height[Min+1] += tmp;
				
				if(height[Max] == 0) {
					Max--;
				}
				if(height[Min] == 0) {
					Min++;
				}
				
				dump -= tmp;
				
				if(Max <= Min) {
					break;
				}
			}		
			
			int result = Max - Min;
			System.out.println("#"+t+" "+result);
		}
	}
}
