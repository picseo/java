package swea.d0214;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 궁수의 위치를  nextpermutation을 이용해서 구해주었다.
 * 모든 궁수의 배치를 한 후에 
 * 각 궁수들이 죽일 사람을 구하고
 * 다 끝난 후에 총 몇명이 죽었는지를 확인했다.
 * */
public class Main17135_CastleDefense_서승희 {
	public static int[] soo = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();
		
		soo = new int[m];
		soo[0] = 1;
		soo[1] = 1;
		soo[2] = 1;
		Arrays.sort(soo);
		
		int[][] sol = new int[n][m];
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < m; j++) {
				sol[i][j] = sc.nextInt();
			}
		}
		
		int max = Integer.MIN_VALUE;
		do {
			int[][] check = new int[n][m];
			
			for(int i = n-1; i >= 0; i--) {
				int num_what = n - i;//몇번째 시도 중인지
				
				for(int k3 = 0;k3 < m; k3++) {//궁수세먕
					if(soo[k3] == 0) {
						continue;
					}
					
					//궁수의 위치
					int x = i+1;
					int y = k3;
					
					boolean find = false;
					for(int j = 1; j <=d ;j ++) {//d의크기 1부터 d까지
						if(find) {
							break;
						}
						
						for(int x_idx = 1; x_idx <= j; x_idx++) {//왼쪽 부터 가운데 까지
							int sx = x - x_idx;
							int sy = y - (j-x_idx);
							if(isIn(sx, sy, n, m)&& sol[sx][sy] != 0) {
								if(check[sx][sy] == -num_what || check[sx][sy] == 0) {
									check[sx][sy] = -num_what;
									find = true;
									break;
								}
							}
						}
						
						if(!find) {
							for(int x_idx = j-1; x_idx >=1 ; x_idx--) {//가운데 오른쪽부터 오른쪽 까지
								int sx = x - x_idx;
								int sy = y + (j-x_idx);
								if(isIn(sx, sy, n, m) && sol[sx][sy] != 0) {
									if(check[sx][sy] == -num_what || check[sx][sy] == 0) {//아직 안죽었거나 현재 단계에 죽을 사람만 가능... 이전 단계에서 죽었으면 안된다.
										check[sx][sy] = -num_what;
										find = true;
										break;
									}
								}
							}
						}
					}
				}
			}
			
			int num = 0;
			for(int i = 0; i < n; i++) {
				for(int j =0 ; j < m ; j++) {
					if(check[i][j] != 0) {
						num++;
					}
				}
			}
			
			if(max < num) {
				max = num;
			}
		}while(nextPermutation());//궁수세명 배치
		
		System.out.println(max);
	}
	private static boolean isIn(int x, int y, int n, int m) {
		if(x >= 0 && x < n && y >= 0 && y < m) {
			return true;
		}else {
			return false;
		}		
	}
	
	private static boolean nextPermutation() {
		int i;
		for(i = soo.length-2; i >= 0; i--) {
			if(soo[i] < soo[i+1]) {
				break;
			}
		}
		
		if(i < 0) {
			return false;
		}
		
		int j;
		for(j = soo.length-1; j >= 0; j--) {
			if(soo[i] < soo[j]) {
				break;
			}
		}
		
		int tmp = soo[i];
		soo[i] = soo[j];
		soo[j] = tmp;
		
		for(int st = i+1, ed = soo.length-1; st < ed; st++, ed--) {
			tmp = soo[st];
			soo[st] = soo[ed];
			soo[ed] = tmp;
		}
		
		return true;
	}
	
	private static String src = "6 5 2\r\n" + 
			"1 0 1 0 1\r\n" + 
			"0 1 0 1 0\r\n" + 
			"1 1 0 0 0\r\n" + 
			"0 0 0 1 1\r\n" + 
			"1 1 0 1 1\r\n" + 
			"0 0 1 0 0";
}
