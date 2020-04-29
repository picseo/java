package d0423;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2631_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] lis = new int[N];
		
		for(int i = 0; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = -1;
		for(int i = 0; i < N; i++) {
			lis[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && lis[j]+1 > lis[i]) {
					lis[i] = lis[j]+1;
				}
			}
			if(max < lis[i]) {
				max = lis[i];
			}
		}
		
		System.out.println(N-max);
	}

}
