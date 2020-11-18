package d0828;

import java.util.Scanner;

public class BJ_2003_수들의합2 {
	static int N, M;
	static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		for(int i =0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		int tmp = 0;
		int result = 0;
		int st = 0, ed =0;
		
		while(true) {
			if(tmp >= M || ed == N) {
				tmp -= input[st++];
			}else {
				tmp += input[ed++];
			}
			
			if(tmp == M) {
				result++;
			}
			
			if(st == N) break;
		}
		
		
		System.out.println(result);
	}

}
