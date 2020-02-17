package swea.D3;

import java.util.Scanner;

public class SWEA_5642_D3_합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n ; i++) {
				arr[i] = sc.nextInt();
			}
			
			int[] front = new int[n];
			int[] back = new int[n];
			
			front[0] = arr[0];
			back[n-1] = arr[n-1];
			for(int i = 1; i < n ; i++) {
				front[i] = Math.max(front[i-1] + arr[i], arr[i]);
				back[n-1-i] = Math.max(back[n-1-i+1] + arr[i],  arr[i]);
			}
			
			int result = Integer.MIN_VALUE;
			for(int i = 0; i < n;i++) {
				//int tmp = front[i] + back[i] - arr[i] -1;
				int tmp = front[i];
				if(result < tmp)
					result = tmp;
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	private static String src = "\r\n" + 
			"1\r\n" + 
			"5\r\n" + 
			"1 3 -8 18 -8";
}
