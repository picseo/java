package swea.D3;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1225_D3_암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		for(int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			int len = 8;
			int[] pass = new int[len];
			int minus = 1;
			int st = 0;
			
			for(int i = 0; i < len ; i++) {
				pass[i] = sc.nextInt();
			}
			
			while(true) {
				st = st%len;
				minus = minus%6;
				if(minus == 0) minus++;
				
				int tmp = pass[st]-(minus++);
				
				if(tmp <= 0) {
					tmp = 0;
					pass[st++] = tmp;
					break;
				}
				pass[st++] = tmp;
			}
			
			System.out.println(Arrays.toString(pass));
			System.out.print("#"+n+" ");
			int idx = 0;
			while(idx != len) {
				int tmp_idx = st%len;
				System.out.print(pass[tmp_idx]+" ");
				idx++;
				st++;
			}
			System.out.println();
			
		}//test_case
	}

	private static String src = "2\r\n" + 
			"2419 2418 2423 2415 2422 2419 2420 2415 \r\n" + 
			"1\r\n" + 
			"9550 9556 9550 9553 9558 9551 9551 9551 \r\n" + 			
			"3\r\n" + 
			"7834 7840 7840 7835 7841 7835 7835 7838 \r\n" + 
			"4\r\n" + 
			"4088 4087 4090 4089 4093 4085 4090 4084 \r\n" + 
			"5\r\n" + 
			"2945 2946 2950 2948 2942 2943 2948 2947 \r\n" + 
			"6\r\n" + 
			"670 667 669 671 670 670 668 671 \r\n" + 
			"7\r\n" + 
			"8869 8869 8873 8875 8870 8872 8871 8873 \r\n" + 
			"8\r\n" + 
			"1709 1707 1712 1712 1714 1710 1706 1712 \r\n" + 
			"9\r\n" + 
			"10239 10248 10242 10240 10242 10242 10245 10235 \r\n" + 
			"10\r\n" + 
			"6580 6579 6574 6580 6583 6580 6577 6581 \r\n" + 			 
			"";
}
