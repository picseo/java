package swea.D3;

import java.util.Scanner;

public class SWEA_1926_D2_간단한369게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		for(int i = 1; i <= n ; i++) {
			int tmp = 1000;
			int now_i = i;
			int cnt = 0;
			while(tmp > 0) {
				int now = now_i/tmp;
				if(now != 0 && now%3 == 0) {
					cnt++;
				}							
				now_i %= tmp;
				tmp /= 10;				
			}
			if(cnt == 0) {
				System.out.print(i);
			}else {
				while(cnt != 0) {
					System.out.print("-");
					cnt--;
				}
			}
			System.out.print(" ");
		}
	}

}
