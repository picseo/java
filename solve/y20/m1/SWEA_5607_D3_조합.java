package swea.D3;

import java.util.Scanner;
/**
 * long으로도 범위를 커버할 수 없는 문제였다.
 * 방법 을 찾아보니 : 확장 유클리드 알고리즘 , 페르마의 소정리 
 * 둘 중에 하나를 사용하면 풀린다고 한다.
 * https://sexycoder.tistory.com/67
 * https://5stralia.tistory.com/4
 * https://www.acmicpc.net/problem/11401
 * **/
public class SWEA_5607_D3_조합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			long result = 1;
			int n = sc.nextInt();
			int r = sc.nextInt();
			
			for(int i = n; i > n-r; i--) {
				result = (result%1234567891)*(i%1234567891);
				result %= 1234567891;
			}
			
			int dv = 1;
			for(int i = 1; i <= r ; i++) {
				dv = (dv%1234567891)*(i%1234567891);
				dv %= 1234567891;
			}
			
			result = (result%1234567891)/(dv%1234567891);
			System.out.println("#"+t+" "+result);
		}
	}

	private static String src = "2\r\n" + 
			"1000000 2\r\n" +
			"10 2";
}
