package JA;

import java.util.Scanner;

public class JA_1071_약수와배수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int n = sc.nextInt();
		int[] input = new int[n];
		
		for(int i = 0;i < n ; i++) {
			input[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		
		int min_sum = 0;
		int max_sum = 0;
		for(int i = 0; i < n ; i++) {
			if(m%input[i] == 0) {
				min_sum += input[i];
			}
			if(input[i]%m == 0) {
				max_sum += input[i];
			}
		}
		
		System.out.println(min_sum);
		System.out.println(max_sum);
	}

	private static String src = "6\r\n" + 
			"2 3 5 12 18 24\r\n" + 
			"12";
}
