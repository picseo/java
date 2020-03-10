package JA;

import java.util.Scanner;

public class JA_1523_º°»ï°¢Çü1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if( n <= 0 || n > 100 || m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		if(m == 1)
			star1(n);
		else if(m ==2)
			star2(n);
		else if(m == 3)
			star3(n);
	}

	public static void star1(int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <=i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void star2(int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void star3(int n) {
		for(int i = 0 ; i<n; i++) {
			for(int j = 0; j < n-i-1; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}
