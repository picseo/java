package SWEA;

import java.util.Scanner;

public class SWEA_1288_D2_새로운불면증치료법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();
		Boolean[] save = new Boolean[11];
		Boolean check = false;
		
		for(int t = 1; t<=T; t++) {
			int n = sc.nextInt();
			int gob = 1;
			for(int i = 0; i<10; i++) {
				save[i] = false;
			}
			
			check = false;
			while(!check) {
				int tmp_n = n*gob;
				for(int i = 100000000; i >=1 ; i /= 10) {
					int tmp = tmp_n / i;
					
					if(tmp != 0) {
						check = true;
						save[tmp] = true;
					}else {
						if(check) {
							save[tmp] = true;
						}
					}
					tmp_n %= i;				
				}			
				
				//check
				check = true;
				for(int i = 0; i<10; i++) {
					if(!save[i]) {
						check = false;
						break;
					}
				}
				if(check) {
					break;
				}
				gob++;
			}
			
			System.out.println("#"+t+" "+(gob*n));
		}
	}
	
	private static String src = "5\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"11\r\n" + 
			"1295\r\n" + 
			"1692";

}
