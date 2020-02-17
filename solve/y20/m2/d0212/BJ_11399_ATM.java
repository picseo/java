package algo_basic.SWEA.d0212;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] p = new int[n];
		for(int i = 0; i < n ; i++) {
			p[i] = sc.nextInt();
		}
		
		Arrays.sort(p);
		int result = 0;
		for(int i =0; i < n ; i++) {
			result += (n-i)*p[i];
		}

		System.out.println(result);
	}

}
