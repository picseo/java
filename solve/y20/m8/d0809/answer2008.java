package d0809;

import java.util.*;

public class answer2008 {
	static int[] a = new int[501];
	static int[][] d = new int[501][501];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		int del = sc.nextInt();
		int add = sc.nextInt();
		
		start -= 1;
		end -= 1;
		
		for(int i =1; i <= n; i++){
			a[i] = sc.nextInt()-1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < m; j++) {
				d[i][j] = 1000000000;
			}
		}
		
		for(int i = 0; i < m; i++) {
			if(i == start) {
				d[0][i] = 0;
			}else {
				d[0][i] = Math.abs(start-i) * add;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k <m; k++) {
					if(k == j &&(a[i] == k || a[i]+1 ==k )) {
						if(d[i][j] > d[i-1][k] + del) {
							d[i][j] = d[i-1][k] + del;
						}
					}else if((k <= a[i] && a[i] <= j-1) || (j <= a[i] && a[i] <= k-1)) {
						if(d[i][j] > d[i-1][k] + (Math.abs(k-j)-1)*add) {
							d[i][j] = d[i-1][k] + (Math.abs(k-j)-1)*add;
						}
					}else {
						if(d[i][j] > d[i-1][k] + (Math.abs(k-j))*add) {
							d[i][j] = d[i-1][k] + (Math.abs(k-j))*add;
						}
					}
					
				}
			}
		}
	}
}
