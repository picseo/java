package page.SWEA;

import java.io.FileInputStream;
import java.util.Scanner;
/**
 * r의 범위를 r=1에서 r*r <= n까지 라는 것은 알아냈지만
 * c값도 1부터 값을 찾아야 되는 것을 생각하지 못했다.
 * 최대한 많은 타일을 이용한다는 글에 정신이 팔려서 c의 값을 1부터 보는 것을 생각하지 못했다.
 * 최대한 많은 타일이 기준이 아니라 주어진 식의 값이 가장 작은 걸 묻고 있었는데 말이다.........
 * 또한 int범위를 넘지 않을 것이라 생각했는데, 넘는 값이었다.
 * 잘 모르겠는 것은 long r, int c 나 int r, long c를 하면 값이 잘 나오지만
 * int r, int c인 경우에는 값 overflow되어 나왔다.
 * 왜그럴까
 * **/
public class SWEA_1491_D3_원재의벽꾸미기 {

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
