package page.SWEA;

import java.util.Scanner;

public class SWEA_1948_D2_날짜계산기 {
	private static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			System.out.print("#"+t+" ");
			
			int f_m = sc.nextInt();
			int f_d = sc.nextInt();
			int s_m = sc.nextInt();
			int s_d = sc.nextInt();
			int result = 0;
			
			if(f_m == s_m) {
				result = (s_d-f_d+1);
			}else {
				for(int i = f_m+1; i < s_m; i++) {
					result += days[i];
				}
				
				result += (days[f_m]-f_d+1);
				result += (s_d-1+1);
			}
			
			System.out.println(result);
		}
	}
	
	private static String src = "3 \r\n" + 
			"3 1 3 31\r\n" + 
			"5 5 8 15\r\n" + 
			"7 17 12 24";
}
