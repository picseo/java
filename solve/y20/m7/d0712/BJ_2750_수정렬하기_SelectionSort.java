package algo;

import java.util.*;

public class BJ_2750_수정렬하기_SelectionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] input = new int[N];
		for(int i =0 ; i < N ; i++) {
			input[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N-1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			
			for(int j = i; j < N; j++) {
				if(min > input[j]) {
					min = input[j];
					idx =  j;
				}
			}
			
			int tmp = input[idx];
			input[idx] = input[i];
			input[i] = tmp;
			
			System.out.println(Arrays.toString(input));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(input[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
