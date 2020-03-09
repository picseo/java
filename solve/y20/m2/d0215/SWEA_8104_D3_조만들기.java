package solve.s0215;

import java.util.Scanner;
/*
 * 처음에는 모든 값을 더한 다음에 k로 나눈 값을 넣었는데
 * 이런 경우엔 n이 홀수일때 답이 나오지 않았다.
 * 그래서 홀수일때와 짝수일때는 나누어 계산해주었다.
 * */
public class SWEA_8104_D3_조만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			long n = sc.nextLong();
			long k = sc.nextLong();
			long total = 0;
			
			if(n%2 == 0) {
				total = n*k;
			}else {
				total = (n-1)*k;
			}
			
			long len = total*(total+1)/2;
			long answer  = len / k;
			
			if(n%2 == 0) {
				System.out.print("#"+t+" ");
				for(int i = 0; i < k; i++) {
					System.out.print(answer+" ");
				}
				System.out.println();
			}else {
				System.out.print("#"+t+" ");
				for(int i = 0; i < k; i++) {
					long tmp_answer = answer + (total+i+1);
					System.out.print(tmp_answer+" ");
				}
				System.out.println();
			}
		}
	}

	private static String src = "1\r\n" + 
			"3 6";
}
