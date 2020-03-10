package SWEA;

import java.util.Scanner;
/**
 * 1000*1000은 2초내로 가능한가보다.
 * **/
public class SWEA_9229_D3_한빈이의SpotMart {
	
	private static String src = "4\r\n" + 
			"3 45\r\n" + 
			"20 20 20\r\n" + 
			"6 10\r\n" + 
			"1 2 5 8 9 11\r\n" + 
			"4 100\r\n" + 
			"80 80 60 60\r\n" + 
			"4 20\r\n" + 
			"10 5 10 16";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] input = new int[n+1];
			for(int i = 0; i < n; i++) {
				input[i] = sc.nextInt();
			}
			
			int Max = -1;
			for(int i = 0; i <n-1; i++) {
				for(int j = i+1; j < n; j++) {
					if(i == j) {
						continue;
					}
					
					int tmp = input[i] + input[j];
					
					if(tmp <= m && tmp > Max) {
						Max = tmp;
					}
				}
			}
			
			sb.append(Max).append("\n");
		}
		
		System.out.print(sb);
	}
}
