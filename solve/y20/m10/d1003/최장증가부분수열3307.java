package d1003;

import java.util.Scanner;

public class 최장증가부분수열3307 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int result = -1;
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int[] cnt = new int[n];
			cnt[0] = 1;
			result = 1;
			
			for(int i = 1; i < n; i++) {
				cnt[i] = 0;
				for(int j = i-1; j >=0 ; j--) {
					if(arr[i] >= arr[j]) {
						if(cnt[i] < cnt[j]) {
							int tmp = cnt[j];
							cnt[i] = tmp;
						}
					}
				}
				
				cnt[i] += 1;
				if(result < cnt[i]) {
					result = cnt[i];
				}
			}
			
			sb.append("#"+t+" "+result+"\n");
		}

		System.out.println(sb.toString());
	}

}
