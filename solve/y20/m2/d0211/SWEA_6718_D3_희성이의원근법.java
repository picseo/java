package swea.d0211;

import java.util.Scanner;

public class SWEA_6718_D3_희성이의원근법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T= sc.nextInt();
		for(int t= 1; t<= T; t++) {
			int result = 5;
			int n = sc.nextInt();
			
			/*if(n < 100) {
				result = 0;
			}else if(n >= 100 && n < 1000) {
				result = 1;
			}else if(n >= 1000 && n < 10000) {
				result = 2;
			}else if(n >= 10000 && n < 100000) {
				result = 3;
			}else if(n >= 100000 && n < 1000000) {
				result = 4;
			}else {
				result = 5;
			}*/
			int dv = 1000000;
			while(dv > 0) {
				if(n/dv != 0) {
					break;
				}
				n %= dv;
				dv /= 10;
				result--;
			}
			if(result < 0)//0, 1같은 경우는 0보다 result가 작아지므로 예외처리해주기
				result = 0;
			System.out.println("#"+t+" "+result);
		}

	}
	
	private static String src = "7\r\n" + 
			"1\r\n" + 
			"100\r\n" + 
			"1003\r\n" + 
			"10067\r\n" + 
			"100567\r\n" + 
			"1000000\r\n" + 
			"10000000";
}
