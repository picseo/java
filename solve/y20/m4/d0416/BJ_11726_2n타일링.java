package d0416;

import java.util.Scanner;

public class BJ_11726_2n타일링 {
	static int N;
	static int[] memo;
	static int mod = 10007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		memo = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			if(i == 0 || i == 1) {
				memo[i] = 1;
			}else {
				memo[i] = (memo[i-1] + memo[i-2])%mod;
			}
		}
		
		System.out.println(memo[N]);
	}

}
