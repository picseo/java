package swea.d0210;

import java.util.Scanner;

public class SWEA_6958_D3_동철이의프로그래밍대회 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T= sc.nextInt();
		for(int t= 1; t<= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] how = new int[m+1];//맞힌문제 수에 따른 사람수
			int res_how = 0;//최대몇문제
			for(int i = 0; i < n ; i++) {
				int tmp = 0;
				for(int j = 0; j < m; j++) {
					int input = sc.nextInt();
					if(input == 1) {
						tmp++;
					}
				}
				
				how[tmp]++;
				if(res_how < tmp)
					res_how = tmp;
				
			}
		
			System.out.println("#"+t+" "+how[res_how]+" "+res_how);
		}

	}
	
	private static String src = "\r\n" + 
			"4\r\n" + 
			"3 5\r\n" + 
			"1 0 0 1 0\r\n" + 
			"1 1 1 0 0\r\n" + 
			"0 0 0 1 0\r\n" + 
			"4 4\r\n" + 
			"1 1 1 1\r\n" + 
			"1 1 1 1\r\n" + 
			"1 1 1 1\r\n" + 
			"1 1 1 1\r\n" + 
			"4 4\r\n" + 
			"0 1 1 1\r\n" + 
			"1 0 1 1\r\n" + 
			"1 1 0 1\r\n" + 
			"1 1 1 0\r\n" + 
			"1 1\r\n" + 
			"0";
}
