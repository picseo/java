package algo_basic.SWEA.mon1;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1966_D2_숫자를정렬하자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			System.out.print("#"+t+" ");
			
			int n = sc.nextInt();
			int[] input = new int[n];
			
			for(int i =0; i < n ;i++) {
				input[i] = sc.nextInt();
			}
			
			Arrays.sort(input);
			for(int i = 0; i < n ;i++) {
				System.out.print(input[i]+" ");
			}
			System.out.println();
		}
	}
	
	private static String src = "10\r\n" + 
			"5\r\n" + 
			"1 4 7 8 0\r\n" + 
			"10\r\n" + 
			"15 20 8 28 16 27 17 27 10 12\r\n" + 
			"15\r\n" + 
			"17 22 20 21 29 6 10 25 20 4 9 21 14 26 23\r\n" + 
			"20\r\n" + 
			"26 25 20 1 2 16 9 24 19 11 12 28 7 20 20 12 9 2 16 13\r\n" + 
			"25\r\n" + 
			"7 4 9 18 7 4 13 5 7 14 3 14 15 19 4 15 11 25 12 7 14 12 4 10 23\r\n" + 
			"30\r\n" + 
			"4 11 16 17 24 16 10 16 29 27 21 18 8 6 5 16 20 26 24 21 15 21 12 26 26 6 8 8 22 2\r\n" + 
			"35\r\n" + 
			"3 29 2 19 7 0 5 11 10 20 13 17 1 12 29 26 28 6 24 18 11 26 16 10 22 25 19 3 0 29 7 27 16 17 6\r\n" + 
			"40\r\n" + 
			"9 13 16 9 13 24 7 0 29 12 12 12 3 29 27 20 14 20 16 8 2 9 15 24 7 11 16 23 9 5 6 28 9 27 11 10 3 18 5 20\r\n" + 
			"45\r\n" + 
			"12 21 1 20 2 25 11 20 14 23 8 3 28 10 22 28 19 5 20 1 5 1 19 1 20 22 1 0 24 10 1 6 25 27 27 19 13 14 21 21 28 0 3 5 29\r\n" + 
			"50\r\n" + 
			"10 27 17 5 19 27 9 14 25 0 9 19 12 5 15 5 19 17 14 18 2 10 13 13 12 21 4 21 21 27 28 21 20 10 25 10 28 9 23 20 17 6 24 15 13 27 18 19 0 14";
}
