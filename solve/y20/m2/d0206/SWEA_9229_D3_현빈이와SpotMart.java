package algo_basic.day2;

import java.util.Scanner;

public class SWEA_9229_D3_현빈이와SpotMart {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[] = new int[n];

			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			int index = 0;
			int max = -1;
			for(int k=0;k< arr.length-1;k++) {
				for (int j = k+1; j < arr.length; j++) {
					if ((arr[j] + arr[k] <= m)) {
						if (arr[j] + arr[k] >= max) {
							max = arr[j] + arr[k];
						}
					}
					
				}
			}
			System.out.printf("#%d %d\n", i, max);
		}
	}

}
