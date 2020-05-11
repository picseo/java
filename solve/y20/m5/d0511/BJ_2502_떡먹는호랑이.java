package d0511;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2502_떡먹는호랑이 {
	static int[] diff = new int[33];
	static int D, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		D = sc.nextInt();
		K = sc.nextInt();
		
		
		diff[0] = 1;
		diff[1] = 1;
		for(int i = 2; i < 33; i++) {
			diff[i] = diff[i-1] + diff[i-2];
		}
		
		for(int i = 1; i <= K/2; i++) {
			int a = i;
			int div = K - diff[D-3]*a;
			int b = div/diff[D-2];
			if(a*diff[D-3] + b*diff[D-2] == K) {
				System.out.println(a);
				System.out.println(b);
				break;
			}
		}
		
	}

}
