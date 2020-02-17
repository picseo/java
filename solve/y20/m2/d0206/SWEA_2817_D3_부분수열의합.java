package algo_basic.SWEA.d0206;

import java.util.Scanner;

public class SWEA_2817_D3_부분수열의합 {
//	public static boolean[] check = {true, false};
	public static int k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			int n = sc.nextInt();
			k = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int num = find_sum(n, 0, 0 ,arr);
			System.out.println("#"+t+" "+num);
		}
	}

	public static int find_sum(int n, int cur, int sum,int[] arr) {
		int res = 0;
		if(sum == k) {
			return 1;
		}else if(sum > k) {
			return 0;
		}
		
		if(n == cur) {
			return 0;
		}else {
			res += find_sum(n, cur+1, sum, arr);//포함안할때
			res += find_sum(n, cur+1, sum+arr[cur], arr);//포함할때
		}		
		return res;
	}
	
	
	private static String src = "1\r\n" + 
			"4 3\r\n" + 
			"1 2 1 2";
}
