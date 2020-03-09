package page.SWEA;

import java.util.Scanner;

public class SWEA_1284_D2_수도요금경쟁 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T ; t++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int A = P*W;
			int B = Q;
			
			if(W > R)
				B += (W-R)*S;
			
			System.out.println("#"+t+" "+Math.min(A,  B));			
		}
	}
	
	private static String src = "2\r\n" + 
			"9 100 20 3 10\r\n" + 
			"8 300 100 10 250";
}
