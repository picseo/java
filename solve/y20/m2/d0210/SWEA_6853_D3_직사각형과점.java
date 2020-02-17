package swea.d0210;

import java.util.Scanner;
/**
 * 왜 내부에 있는 것 부터 구하고 네 변위에 있는 걸 구하면 틀리지??(x< x2 && x > x1 && y > y1 && y < y2)
 * 는 내부에 있는 점들을 모두 구하지 못하는 걸까??
 * --->  변위에 있는 값인지를 구분하지 못하게 된다.
 * (x2, y1보다 작은 y) 이면 사각형 변위에 존재하지 않는다.
 * 그래서 꼭 사각형 내부에 존재하는 점들 중에서 x1 or x2 or y1 or y2 위에 있는
 * xy를 구분해내야한다. * 
 * */
public class SWEA_6853_D3_직사각형과점 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T= sc.nextInt();
		for(int t= 1; t<= T; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int res1 = 0;
			int res2 = 0;
			int res3 = 0;
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(x <= x2 && x >= x1 && y >= y1 && y <= y2) {
					if(x == x1 || x == x2 || y == y1 || y == y2) {
						res2++;
					}else {
						res1++;
					}					
				}else {
					res3++;
				}
			}
			
			System.out.println("#"+t+" "+res1 +" "+res2 + " "+res3);
		}

	}
	
	private static String src = "\r\n" + 
			"1\r\n" + 
			"0 0 2 2\r\n" + 
			"4\r\n" + 
			"-1 -1\r\n" + 
			"0 0\r\n" + 
			"1 1\r\n" + 
			"2 2";
}
