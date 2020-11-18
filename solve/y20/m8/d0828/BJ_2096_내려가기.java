package d0828;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2096_내려가기 {
	static int N;
	static int[][] input;
	static int[] min, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		input = new int[N][3];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		//최대값찾기
		max = new int[3];
		max = input[0].clone();

		//최솟값 찾기
		min = new int[3];
		min = input[0].clone();

		int res1 = 0;
		int res2 = Integer.MAX_VALUE;
		
		for(int i = 1; i < N; i++) {
			int[] tmp_arr = max.clone();
			int[] tmp_arr1 = min.clone();
			
			for(int j = 0; j < 3; j++) {
				
				int tmp = 0;
				int left = j-1;
				int right = j+1;
				
				//max
				tmp = tmp_arr[j];
				if(left >= 0) {
					tmp = (tmp > tmp_arr[left])?tmp:tmp_arr[left];
				}
				if(right < 3) {
					tmp = (tmp > tmp_arr[right])?tmp:tmp_arr[right];
				}

				max[j] = input[i][j] + tmp;
				
				//min
				tmp = tmp_arr1[j];
				if(left >= 0) {
					if(tmp > tmp_arr1[left] ) {
						tmp = tmp_arr1[left];
					}
				}

				if(right < 3) {
					if(tmp > tmp_arr1[right] ) {
						tmp = tmp_arr1[right];
					}
				}

				min[j] = input[i][j] + tmp;				
			}
			
			
		}

		for(int i = 0;i < 3; i++) {
			res1 = (res1 < max[i])?max[i]:res1;
			res2 = (res2 > min[i])?min[i]:res2;
		}
		System.out.println(res1 + " " + res2);

	}

}
