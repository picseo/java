package repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_6782_현주가좋아하는제곱근놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			long N = sc.nextLong();
			int cnt = 0;
			long a = 0;
			
			while(true) {
				if(N == 2)
					break;
				
				a = (long)Math.sqrt(N);
				
				if(a*a == N) {
					cnt++;
					N = a;
				}else {
					cnt +=((a+1)*(a+1) - N);// 현재 수에서 제곱근이 정수가 될수 있는 가장 가까운 수를 만드는 횟수계산
					N = (a+1)*(a+1);
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
