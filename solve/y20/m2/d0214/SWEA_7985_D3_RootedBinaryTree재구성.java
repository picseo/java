package swea.d0214;

import java.util.Scanner;

public class SWEA_7985_D3_RootedBinaryTree재구성 {
	public static int[] result = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			System.out.print("#"+t+" ");
			int n = sc.nextInt();
			int[] input = new int[n];
			result = new int[n];
			for(int i =0; i < n ; i++) {
				input[i] = sc.nextInt();
			}
			
			
		}
	}
	
	private static void print_middle(int[] tmp, int len, int n, int cur) {
		int mid = len / 2;
		
		
		for(int i = 0; i < cur; i++) {
			
			
		}
		System.out.println();
	}
	private static String src = "2\r\n" + 
			"3\r\n" + 
			"3 2 7 5 6 1 4\r\n" + 
			"2\r\n" + 
			"2 1 3";
}
