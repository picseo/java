package page.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_9088_D4_다이아몬드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<=T ; t++) {
			System.out.println("#"+t+" ");
			int result = 0;
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
		
			Arrays.sort(arr);
			
			for(int i = 0; i < n; i++) {
				int tmp_result = 0;
				for(int j = i; j < n; j++) {
					int tmp = arr[j] - arr[i];
					if(tmp > k) {
						break;
					}else {
						tmp_result++;
					}
				}
				
				if(result < tmp_result)
					result = tmp_result;
			}
			
			System.out.println(result);
		}
		
	}
	
	private static String src = "2\r\n" + 
			"2 0\r\n" + 
			"1\r\n" + 
			"1\r\n" + 
			"3 3\r\n" + 
			"1\r\n" + 
			"6\r\n" + 
			"4";
}
