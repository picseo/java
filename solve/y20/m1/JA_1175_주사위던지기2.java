package alog_basic.jungol;

import java.util.Scanner;

public class JA_1175_주사위던지기2 {
	public static int[] dice = {1, 2, 3, 4, 5, 6};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		permu(m, n, 0, new int[n]);
		
	}
	
	public static void permu(int sum, int r, int cur, int[] tmp) {
		if(r == cur) {
			int sum_tmp = 0;
			for(int i  = 0; i < tmp.length; i++){
				sum_tmp+=tmp[i];
			}
			if(sum_tmp == sum) {
				for(int i  = 0; i < tmp.length; i++){
					System.out.print(tmp[i]+" ");
				}
				System.out.println();
			}
		}else {
			for(int i = 0; i < 6; i++) {
				tmp[cur] = i+1;
				permu(sum, r, cur+1, tmp);
			}
		}
	}
	
	private static String src = "3 10";
}