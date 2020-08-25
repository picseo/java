package d0810;

import java.util.Scanner;

public class BJ_1019_책페이지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] cnt = new int[10];
		
		int i = 0;
		int j = 9;
		for(i = 1000000000; i >= 1; i/= 10, j -=1) {
			if(N/i != 0) {
				break;
			}
		}
		
		System.out.println(i + " " + j);
		
	}
}
