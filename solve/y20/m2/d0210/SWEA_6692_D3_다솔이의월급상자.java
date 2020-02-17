package swea.d0210;

import java.util.Scanner;

public class SWEA_6692_D3_다솔이의월급상자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T= sc.nextInt();
		for(int t= 1; t<= T; t++) {
			double result = 0;
			int n = sc.nextInt();
			
			for(int i = 0; i < n; i++) {
				double p = sc.nextDouble();
				double x = sc.nextDouble();
				
				result += (p*x);
			}
			
			System.out.printf("#%d %6.6f\n", t, result);
		}

	}
	
	private static String src = "\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"0.3 100\r\n" + 
			"0.7 1";
}
