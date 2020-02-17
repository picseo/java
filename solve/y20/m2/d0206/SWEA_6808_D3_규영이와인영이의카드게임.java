package algo_basic.day6.permutation;

import java.util.Scanner;
/**
 * backtracking하기에는 끝까지 카드값이 나와야 승자를 할 수 있어서 
 * 별로 하지 못한다.
 * */
public class SWEA_6808_D3_규영이와인영이의카드게임 {
	private static int[] cards = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
	private static int[] gyu = new int[9];
	private static int[] in = new int[9];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();

		for(int t = 1; t <= T; t++) {
			int total = 1;
			boolean[] check = new boolean[19];
			for(int i = 0; i < 9; i++) {
				gyu[i] = sc.nextInt();
				check[gyu[i]] = true;
				total *= (i+1);
			}
			
			int in_idx = 0;
			for(int i = 1; i < 19; i++) {
				if(!check[i]) {
					in[in_idx++] = i;
				}
			}
			
			
			int[] res = new int[3];
			dfs(9, 0, new boolean[9], new int[9], res);
			
			System.out.println("#"+t+" "+res[2]+" "+res[0]);
		}
	}

	
	private static void dfs(int n, int cur, boolean[] visit, int[] tmp, int[] res) {
		if(n == cur) {
			int gg = 0;
			int ii = 0;
			
			for(int i = 0; i < 9; i++) {
				if(gyu[i] < tmp[i]) {
					ii += (gyu[i] + tmp[i]);
				}else {
					gg += (gyu[i] + tmp[i]);
				}
			}
			
			if(ii > gg) {
				res[0]++;
			}else if(ii == gg) {
				res[1]++;
			}else {
				res[2]++;
			}
		}else {
			for(int i = 0; i < 9; i++) {
				if(!visit[i]) {
					visit[i] = true;
					tmp[cur] = in[i];
					dfs(n, cur+1, visit, tmp, res);
					visit[i] = false;
				}
			}
		}	
	}
	
	private static String src = "\r\n" + 
			"4\r\n" + 
			"1 3 5 7 9 11 13 15 17\r\n" + 
			"18 16 14 12 10 8 6 4 2\r\n" + 
			"13 17 9 5 18 7 11 1 15\r\n" + 
			"1 6 7 9 12 13 15 17 18";
}
