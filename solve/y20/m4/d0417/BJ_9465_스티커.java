package d0417;

import java.util.Scanner;
/*
 * 각 열에서 첫번째 스티커를 붙이고 싶으면 바로 이전 줄에서 두번째 스티커를 썼거나 아예안 썼어야 한다.
 * 이러한 정보를 가지고 있는 memo배열을 만들어서 풀었다.ㄴ
 * */
public class BJ_9465_스티커 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			
			int[][] stickers = new int[n][2];
			int[][] memo = new int[n][3];
			
			for(int i = 0; i < n; i++) {
				stickers[i][0] = sc.nextInt();
			}
			
			for(int i = 0; i < n; i++) {
				stickers[i][1] = sc.nextInt();
			}
			
			memo[0][0] = 0;
			memo[0][1] = stickers[0][0];
			memo[0][2] = stickers[0][1];
			
			for(int i = 1; i < n; i++) {
				memo[i][1] = Math.max(memo[i-1][0], memo[i-1][2])+stickers[i][0];
				memo[i][2] = Math.max(memo[i-1][0], memo[i-1][1])+stickers[i][1];
				memo[i][0] = Math.max(memo[i-1][0],  Math.max(memo[i-1][1], memo[i-1][2]));
			}
			
			int result = Math.max(memo[n-1][0],  Math.max(memo[n-1][1], memo[n-1][2]));
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
