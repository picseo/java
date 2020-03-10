package JA;

import java.util.Scanner;
/**
 * 이건 종이가 안 겹친 채로 붙은 상태를 고려하지 않고 풀어서 틀렸다.
 * **/
public class JA_1438_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int n = sc.nextInt();
		int[][] minmax = new int[101][2];
		
		for(int i = 0; i <=100; i++) {
			minmax[i][0] = Integer.MAX_VALUE;
			minmax[i][1] = Integer.MIN_VALUE;
		}
		
		for(int i = 0; i < n ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j = 0; j < 10; j++) {
				int now = x+j;
				int min = y;
				int max = y+10;
				
				if(minmax[now][0] > min) {
					minmax[now][0] = min;
				}
				
				if(minmax[now][1] < max) {
					minmax[now][1] = max;
				}
				
			}			
		}
		
		int result = 0;
		for(int i = 0; i <=100; i++) {
			if(minmax[i][0] != Integer.MAX_VALUE) {
				result += (minmax[i][1] - minmax[i][0]);
			}
		}
		
		System.out.println(result);
	}
	
	private static String src = "";
}
