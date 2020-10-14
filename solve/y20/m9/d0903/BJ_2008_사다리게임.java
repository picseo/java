package d0903;

import java.util.*;

public class BJ_2008_사다리게임 {
	static int N, M, a, b, X, Y;
	static int[] d = new int[502];
	static int[][] memo = new int[502][102];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		a = sc.nextInt();
		b = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();

		for(int i = 0; i < 502; i++) {
			Arrays.fill(memo[i], Integer.MAX_VALUE);
		}
		
		for(int i = 1; i <= N; i++) {
			int input = sc.nextInt();
			d[i] = input;
		}

		//초기화
		for(int i = 1; i <= M; i++) {
			if(i == a) {
				memo[0][i] = 0;
			}else {
				memo[0][i] = Math.abs(i-a)*Y;
			}
		}

		//나머지 진행
		for(int i = 1 ; i <= N; i++) {//깊이
			for(int from = 1; from <= M; from++) {
				for(int to = 1; to <= M; to++) {

					if(from == to && (d[i] == to || d[i]+1 == to)) {
						if(memo[i][to] > memo[i-1][from] + X) {
							memo[i][to] = memo[i-1][from] + X;
						}
					}else if((to <= d[i] && d[i] <= from-1) || (to-1 >= d[i] && d[i] >= from)) {
						if(memo[i][to] > memo[i-1][from] + (Math.abs(to-from)-1)*Y) {
							memo[i][to] = memo[i-1][from] + (Math.abs(to-from)-1)*Y;
						}
					}else {
						if(memo[i][to] > memo[i-1][from] + (Math.abs(to-from))*Y) {
							memo[i][to] = memo[i-1][from] + (Math.abs(to-from))*Y;
						}
					}
				}
			}
		}

		System.out.println(memo[N][b]);
	}

}
