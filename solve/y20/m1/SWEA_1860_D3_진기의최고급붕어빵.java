package swea.D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1860_D3_진기의최고급붕어빵 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1860.txt"));
		Scanner sc = new Scanner(System.in);
		//sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			System.out.print("#"+t+" ");
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			int[] time = new int[11112];
			int Max = 0;
			for(int i = 0; i < n ; i++) {
				int now = sc.nextInt();
				if(Max < now)
					Max = now;
				time[now]++;
			}
			
			int num = 0;
			boolean check = false;
			for(int i = 0; i <= Max; i++) {
				if(i != 0 && i%m == 0) {
					num += k;
				}
				
				if(num - time[i] < 0) {
					check = true;
					break;
				}
				num -= time[i];
			}
			
			if(check) {
				System.out.println("Impossible");
			}else {
				System.out.println("Possible");
			}
		}
	}
	
	private static String src = "4\r\n" + 
			"2 2 2\r\n" + 
			"3 4\r\n" + 
			"2 2 2\r\n" + 
			"1 2\r\n" + 
			"2 2 1\r\n" + 
			"4 2\r\n" + 
			"2 2 1\r\n" + 
			"3 2";
}
