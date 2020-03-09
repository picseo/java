package page.SWEA;

import java.io.FileInputStream;
import java.util.Scanner;
/**
 * r�� ������ r=1���� r*r <= n���� ��� ���� �˾Ƴ�����
 * c���� 1���� ���� ã�ƾ� �Ǵ� ���� �������� ���ߴ�.
 * �ִ��� ���� Ÿ���� �̿��Ѵٴ� �ۿ� ������ �ȷ��� c�� ���� 1���� ���� ���� �������� ���ߴ�.
 * �ִ��� ���� Ÿ���� ������ �ƴ϶� �־��� ���� ���� ���� ���� �� ���� �־��µ� ���̴�.........
 * ���� int������ ���� ���� ���̶� �����ߴµ�, �Ѵ� ���̾���.
 * �� �𸣰ڴ� ���� long r, int c �� int r, long c�� �ϸ� ���� �� ��������
 * int r, int c�� ��쿡�� �� overflow�Ǿ� ���Դ�.
 * �ֱ׷���
 * **/
public class SWEA_1491_D3_�����Ǻ��ٹ̱� {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1491.txt"));
		Scanner sc = new Scanner(System.in);
		//sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();//1~10^5
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			long r = 1;
			long c = 1;
			long Min = Long.MAX_VALUE;
			for(r = 1; r*r <= n; r++) {
				//System.out.println("Min : " + Min);
				long res = 0;
				for(c = 1; c <= n/r; c++) {
					res = Math.abs(r-c);
					res *= a;
					res += b*(n - (r*c));
					if(Min > res)
						Min = res;
				}
				//System.out.println("r : "+ r + " , c :" + c + " , res : "+res);	
			}
			System.out.println("#"+t+" "+Min);
		}//test

	}

	private static String src = "2\r\n" + 
			"37 1 1\r\n" + 
			"21 10 1";
}
