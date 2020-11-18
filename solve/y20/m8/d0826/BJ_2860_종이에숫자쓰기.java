package d0826;

import java.util.Scanner;
/*
 재귀를 이용한 완탐으로 풀려고 했는데, 시간초과가 나온다.
 
 그러면 보통 memo를 사용하는데, 이건 어떻게 할지 모르겠다.
 
 
 * */
public class BJ_2860_종이에숫자쓰기 {
	static int[] cnt = new int[6];
	static int total = 0;
	static double input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextDouble();
		
		total = 1;
		while(true) {
			if(find(total, 0, new int[6], 1)) {
				break;
			}
			total += 1;
		}

		for(int i = 1; i < 6; i++) {
			System.out.print(cnt[i]+" ");
		}
		System.out.println();
		
		return;
	}

	private static boolean find(int last, double sum, int[] tmp, int idx) {
		if(last == 0) {
			double avg = sum/(double)(total);
			if(avg == input) {
				for(int i = 1; i < 6; i++) {
					cnt[i] = tmp[i];
				}
				return true;
			}
		}
		
		for(int i = idx; i < 6; i++) {
			if(last >= 1) {
				tmp[i] += 1;
				if(find(last-1, sum+(double)i, tmp, i)) {
					return true;
				}
				tmp[i] -= 1;
			}
			
			if(find(last, sum, tmp, i+1)) {
				return true;
			}
		}
		return false;
	}	
}
