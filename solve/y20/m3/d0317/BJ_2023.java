package d0317;

import java.util.Scanner;
/*
 * 완탐해서 구했다.
 * 
 * 친구들 코드를 보니 0~10까지 하는 것보다 시작할 때는 2, 3, 5, 7만 진행하는 게 더 
 * 빨랐다.
 * */
public class BJ_2023 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		findnum(0, n, 0);
	}

	private static void findnum(int cur, int num, int tmp) {
		if(cur != 0) {
			if(!checkPrime(tmp)) {
				return;
			}
		}
		if(num == cur) {
			if(checkPrime(tmp)) {
				System.out.println(tmp);
			}
			return;
		}else {
			for(int i = 0; i < 10; i++) {
				if(cur == 0 && (i == 0 || i ==1)) {
					continue;
				}
				findnum(cur+1, num, tmp*10+i);
			}
		}
	}
	private static boolean checkPrime(int num) {
		
		for(int i = 2; i*i <= num; i++) {
			if(num%i == 0) {
				return false;
			}
		}		
		return true;
	}
}
