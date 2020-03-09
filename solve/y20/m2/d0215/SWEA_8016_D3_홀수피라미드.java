package solve.s0215;

import java.util.Scanner;
/*
 * left�� ���ϰ� right�ϰ��� ���̸�ŭ �� left�� ���ؼ�
 * right�� ���ߴ�.
 * **/
public class SWEA_8016_D3_Ȧ���Ƕ�̵� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			long n = sc.nextInt();
			
			long gab = (n-1)*2;
			
			long left = 0, right = 0;
			
			long gabl = 2*(n-1)*(n-1);
			
			left = 1 + gabl;
			right = left + gab*2;
			System.out.println("#"+t+" "+left+" "+right);
		}
	}

	private static String src = "3\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"3";
}
