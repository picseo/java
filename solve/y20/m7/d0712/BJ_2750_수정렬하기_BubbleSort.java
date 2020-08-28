package algo;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2750_수정렬하기_BubbleSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] input = new int[N];
		for(int i =0 ; i < N ; i++) {
			input[i] = sc.nextInt();
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < N -i; j++) {
				if(input[j] > input[j+1]) {
					int tmp = input[j];
					input[j] = input[j+1];
					input[j+1] = tmp;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(input[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
