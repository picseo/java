package algo_basic.day1;

import java.util.Scanner;

public class SWEA_1936_D1_1대1가위바위보 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		
		if((a-b)==1||(a-b)==-2)
			System.out.println("A");
		else
			System.out.println("B");
			
	
		

	}

}
