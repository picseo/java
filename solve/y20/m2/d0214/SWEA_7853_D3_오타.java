package swea.d0214;

import java.util.Scanner;
//3개를 비교하는 조건을 이상하게 해서 계속 틀렸다.
//그러고는 int, long탓을 하고 있었다. 
//반성해야지
public class SWEA_7853_D3_오타 {
	public static long div = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			String input = sc.next();
			
			long result = 1;
			for(int i =0; i <input.length(); i++) {
				if(i == 0) {
					if(input.charAt(i) != input.charAt(i+1)) {
						result = (result*2)%div;
					}
				}else if(i == input.length()-1) {
					if(input.charAt(i) != input.charAt(i-1)) {
						result = (result*2)%div;
					}
				}else {
					int p = 1;
					char pre  = input.charAt(i-1);
					char now = input.charAt(i);
					char post = input.charAt(i+1);
					
					if(pre == now && now == post && pre == post) {
						result = (result%div);
					}else if(pre != now && now != post && pre != post) {
						result = (result*3)%div;
					}else {
						result = (result*2)%div;
					}
					
					result = (result*p)%div;
				}
			}
			
			System.out.println("#"+t+" "+result);
		}

	}

	private static String src = "3\r\n" + 
			"apa\r\n" + 
			"abcde\r\n" + 
			"aaaaa";
}
