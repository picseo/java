package d0521;

import java.util.Arrays;
import java.util.Scanner;
//부분집합을 통해서 나누는 모든 경우를 구하고
//재귀를 통해서 계속 반복한다.
//그러다가 10다 작은 수가 되면은 return 0!
//다시 div를 10으로 돌려주는 부분을 잊지말자!
public class SW_7206_숫자게임 {
	static int[] memo = new int[100000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		
		Arrays.fill(memo, -1);
		
		for(int t = 1 ; t <= T; t++) {
			int num = sc.nextInt();
			
			//부분집합으로 나눌 부분을 체크한다.
			find(num);
			
			System.out.println("#"+t+" "+memo[num]);
		}
		//System.out.println(Arrays.toString(memo));

	}

	private static int find(int num) {
		if(memo[num] != -1) {
			return memo[num];
		}
		
		if(num < 10) {
			memo[num] = 0;
			return memo[num];
		}
		
		int max = -1;
		int length = (int)Math.log10(num);
		for(int i = 1; i < (1<<length); i++) {
			int tmp = 1;
			int tmp_num = num;
			int div = 10;
			for(int j = length-1; j >=0; j--) {
				if((i&(1<<j)) > 0) {
					tmp *= (tmp_num)%div;
					tmp_num /= div;
					div = 10;
				}else {
					div *= 10;
				}
			}
			
			tmp *= tmp_num;
			int tt = find(tmp);
			if(max < tt+1) {
				max = tt+1;
			}
		}
		
		memo[num] = max;
		return memo[num];
	}

}
