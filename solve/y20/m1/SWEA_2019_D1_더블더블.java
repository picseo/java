package page.SWEA;

import java.util.Scanner;

public class SWEA_2019_D1_������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result = 1;
		System.out.print(result + " ");
		for(int i = 1; i <=n; i++){
			result *= 2;
			System.out.print(result + " ");
		}		
		System.out.println();
	}
}
