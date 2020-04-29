package d0416;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1463_1로만들기 {
	static int N;
	static int[] memo = new int[1000001];
	
	public static int min(int a, int b, int c) {
		int result = Math.min(a,  b);
		result = Math.min(result, c);
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			if(i == 1) {
				memo[i] = 0;
			}else if(i == 2 || i == 3) {
				memo[i] = 1;
			}else {
				if(i%2 == 0 && i%3 == 0) {
					memo[i] = min(memo[i/2],memo[i/3],memo[i-1])+1;
				}else {
					if(i%2 == 0) {
						memo[i] = Math.min(memo[i/2],memo[i-1])+1;
					}else if( i%3 == 0) {
						memo[i] = Math.min(memo[i/3],memo[i-1])+1;
					}else {
						memo[i] = memo[i-1]+1;
					}
				}
			}
		}
		
		System.out.println(memo[N]);
	}

}
