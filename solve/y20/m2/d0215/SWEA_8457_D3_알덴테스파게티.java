package solve.s0215;

import java.util.Scanner;
/*
 * 0�ʺ��� while���� ������ b-e <= <=b+e�� ������ Ȯ���ϰ�
 * ���� cnt�� �ø��� ������� ������ ã�Ҵ�.
 * */
public class SWEA_8457_D3_�˵��׽��İ�Ƽ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int b = sc.nextInt();
			int e = sc.nextInt();
			
			int[] x = new int[n];
			for(int i = 0; i < n ; i++) {
				x[i] = sc.nextInt();
			}
			
			int min = b-e;
			if(min < 0 ) {
				min = 0;
			}
			
			int max = b+e;
			
			int cnt = 0;
			for(int i = 0; i < n ; i++) {
				int time = 0;
				while(time <= max) {
					time += x[i];
					if(min <= time && time <= max) {
						cnt++;
						break;
					}
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}

	private static String src = "2\r\n" + 
			"2 10 2\r\n" + 
			"3 4\r\n" + 
			"3 10 5\r\n" + 
			"16 100 10000";
}
