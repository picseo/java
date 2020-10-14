package d1002;

import java.util.Scanner;

public class 화섭이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 1; i <= n; i++) {
				int result = find(i, arr);
				if(result != -1) {
					sb.append("#"+i+" "+result+"\n");
					break;
				}
			}
		}

	}

	private static int find(int len, int[] arr) {
		int tmp = 0;
		for(int i = 0; i < arr.length - len + 1; i++) {
			
			//값만들기
			tmp = 0;
			int cnt = 0;
			while(cnt < len) {
				tmp = tmp*10 + arr[i+(cnt++)];
			}
			
			System.out.println(tmp);
		}
		
		return -1;
	}

}
