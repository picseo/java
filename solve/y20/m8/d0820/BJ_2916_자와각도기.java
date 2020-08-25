package d0820;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//만들 수 있는 각을 모두 찾은 후에
//외치는 각에 대해 결과를 출력하고 싶은데
//만들 수 있는 각을 어떻게 찾지
public class BJ_2916_자와각도기 {
	private static int N, K;
	private static int[] angles;
	private static boolean[] memo = new boolean[360];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
	
		angles = new int[N];
		
		for(int i = 0; i < N; i++) {
			angles[i] = sc.nextInt();
		}
		
		memo[0] = true;
		for(int i = 0; i < N; i++) {
			for(int k = 0; k < 360; k++) {
				for(int j = 0; j < 360; j++) {
					if(memo[j] == false) continue;
					memo[(j-angles[i]+360)%360] = true;
					memo[(j+angles[i])%360] = true;
				}
			}
		}

		for(int i = 0; i < K; i++) {
			int now = sc.nextInt();

			if(memo[now]) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
		
	}

}
