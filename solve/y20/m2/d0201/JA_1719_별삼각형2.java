package JA;

import java.util.Scanner;

public class JA_1719_º°»ï°¢Çü2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if( n <= 0 || n > 100 || n%2 == 0 || m < 1 || m > 4) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		if(m == 1) {
			
			int tmp = (n+1)/2;
			int how = 1;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < how; j++ ) {
					System.out.print("*");
				}
				System.out.println();
				
				if(i+1 < tmp) {
					how++;
				}else {
					how--;
				}
			}
			
		}else if(m == 2) {
			
			int tmp = (n+1)/2;
			int how = 1;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < tmp - how; j++) {
					System.out.print(" ");
				}				
				
				for(int j = 0; j < how; j++ ) {
					System.out.print("*");
				}
				System.out.println();
				
				if(i+1 < tmp) {
					how++;
				}else {
					how--;
				}
			}
			
		}else if(m == 3) {
			
			int tmp = (n+1)/2;
			int how = n;
			int how_null = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < how_null; j++) {
					System.out.print(" ");
				}				
				
				for(int j = 0; j < how; j++ ) {
					System.out.print("*");
				}
				System.out.println();
				
				if(i+1 < tmp) {
					how -= 2;
					how_null++;
				}else {
					how += 2;
					how_null--;
				}
			}
			
		}else if(m == 4) {
			
			int tmp = (n+1)/2;
			int how = tmp;
			int how_null = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < how_null; j++) {
					System.out.print(" ");
				}				
				
				for(int j = 0; j < how; j++ ) {
					System.out.print("*");
				}
				System.out.println();
				
				if(i+1 < tmp) {
					how--;
					how_null++;
				}else {
					how++;
				}
			}
			
		}
		
	}


}
