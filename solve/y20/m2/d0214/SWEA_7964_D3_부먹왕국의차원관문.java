package swea.d0214;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 먼저 오른쪽으로 읽으면서 1인 경우에 오른쪽의 범위 내에 1이 존재하는 지 확인하고 없으면
 * 1을 추가해주면서 result를 증가 시켰다.
 * 오른쪽을 모두 진행한 다음에 왼쪽으로 읽으면서 왼쪽 범위를 확인해 주었다
 * */
public class SWEA_7964_D3_부먹왕국의차원관문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T; t++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			
			int[] doors = new int[n];
			for(int i = 0 ; i < n ; i++) {
				doors[i] = sc.nextInt();
			}
			
			int result  = 0;
			//한번은 오른쪽으로 진행하면서 1이 필요하면 채워준다.
			for(int i = 0; i < n ; i++) {
				int now = doors[i];
				int big = i+d;
				if(big >= n)
					big = n-1;
				
				int j = 0;
				for(j = i+1; j < big; j++) {
					if(doors[j] == 1) {
						i = j-1;
						break;
					}
				}
				
				if(j == big && doors[big] != 1) {
					result++;
					doors[big] = 1;
				}
			}
			//System.out.println(Arrays.toString(doors));
			
			//오른쪽에서 부터 왼쪽으로 1이 필요하면 채워준다.
			for(int i = n-1; i >= 0; i--) {
				int now = doors[i];
				int small = i-d;
				if(small < 0)
					small = 0;
				
				int j = 0;
				for(j = i-1; j > small ; j--) {
					if(doors[j] == 1) {
						i = j+1;
						break;
					}
				}
				
				if(j == small&& doors[small] != 1) {
					result++;
					doors[small] = 1;
				}
			}
			//System.out.println(Arrays.toString(doors));
			System.out.println("#"+t+" "+result);			
		}
	}
	
	private static String src = "3\r\n" + 
			"6 2\r\n" + 
			"1 0 0 0 0 1\r\n" + 
			"10 2\r\n" + 
			"0 0 1 0 1 0 0 0 0 1\r\n" + 
			"10 1\r\n" + 
			"0 0 0 0 0 0 0 0 0 0";
}
