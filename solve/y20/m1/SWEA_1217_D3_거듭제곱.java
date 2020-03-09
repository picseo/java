package page.SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1217_D3_°ÅµìÁ¦°ö {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		for(int t = 1; t<= 10; t++) {
			int n = sc.nextInt();
			int num = sc.nextInt();
			int how = sc.nextInt();
			
			System.out.println("#"+t+" "+power(num, how, 1));
		}
		
	}
	
	private static int power(int num, int how, int cur) {
		if(how == cur) {
			return num;
		}else {
			return num*power(num, how, cur+1);
		}
	}

	private static String src = "1\r\n" + 
			"9 8\r\n" + 
			"2\r\n" + 
			"2 8\r\n" + 
			"3\r\n" + 
			"6 5\r\n" + 
			"4\r\n" + 
			"10 7\r\n" + 
			"5\r\n" + 
			"6 7\r\n" + 
			"6\r\n" + 
			"7 2\r\n" + 
			"7\r\n" + 
			"9 8\r\n" + 
			"8\r\n" + 
			"3 2\r\n" + 
			"9\r\n" + 
			"4 8\r\n" + 
			"10\r\n" + 
			"8 6";
}
