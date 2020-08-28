package algo;

import java.util.Scanner;
/* 규칙을 찾아서 푸는 문제였다*/
public class BJ_2292_벌집_수학 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int start = 1;
		int cnt = 0;
		
		while(true) {

			cnt++;
			if(N <= start) {
				break;
			}
			start += cnt*6;
		}
		
		System.out.println(cnt);
	}

}
