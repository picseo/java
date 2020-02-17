package swea.d0207;

import java.util.Scanner;
/**
 * 입력을 int n으로 받고 있으니까 long으로 답을 받아도 계산이 안됐다.
 * 앞으로 수가 큰거 같으면 그냥 long을 써야 겠다.
 * 
 * */
public class SWEA_3408_D3_세가지합구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t=1; t<= T; t++) {
			long n = sc.nextInt();
			long res1 = 0, res2 = 0, res3 = 0;
			
			if(n%2 == 0) {
				long tmp = n/2;
				res1 = tmp *(n+1);
				
				res2 = (2+(n-1)*2) * tmp;
				
				res3 = (4+(n-1)*2) *tmp;
			}else {
				res1 = (n+1)/2;
				res1 *= n;
				
				res2 = n*n;
				res3 = n*(n+1);
				
			}		
			System.out.println("#"+t+" "+res1+" "+res2+" "+res3);
		}

	}

	
	private static String src = "4\r\n" + 
			"1\r\n" + 
			"1000000000\r\n" + 
			"999999999\r\n" + 
			"1001	";
}
