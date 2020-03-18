package d0317;

import java.util.Scanner;
/*
 * ��Ž�ؼ� ���ߴ�.
 * 
 * ģ���� �ڵ带 ���� 0~10���� �ϴ� �ͺ��� ������ ���� 2, 3, 5, 7�� �����ϴ� �� �� 
 * ������.
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
