package algo_basic.SWEA.d0212;

import java.util.Scanner;
//결국 짝수, 홀수로 나누면 되는 문제였다.
public class BJ_9655_돌게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n%2 == 0) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}

		
	}

}
