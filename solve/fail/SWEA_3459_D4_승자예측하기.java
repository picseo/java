package fail;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_3459_D4_승자예측하기 {
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			result = 0;
			long n = sc.nextLong();
			long tmp = 1;

			if(n == 1) {
				result = 1;
			}else if(n == 2 || n ==3 ) {
				result = 2;
			}{
				while(true) {
					result++;
					tmp *= 2;

					if(tmp > n) {
						if((n)%4 < 2) {
							result--;
						}
						break;
					}	
				}
			}

			if(result % 2 == 1) {
				sb.append("Bob").append("\n");
			}else {
				sb.append("Alice").append("\n");
			}
		}
		System.out.println(sb);
	}

	/**/

	private static String src = "\r\n" + 
			"5\r\n" + 
			"1\r\n" + 
			"5\r\n" + 
			"7\r\n" + 
			"10\r\n" + 
			"123456789123456789";
	//+ 
	//	"123456789123456789";
}
