package swea.d0214;

import java.util.Arrays;
import java.util.Scanner;
//시간계산하기 너무 귀찮다.
public class SWEA_7732_D3_시간개념 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			String now = sc.next();
			String promise = sc.next();
			
			String[] n_str = now.split(":");
			String[] p_str = promise.split(":");
			
			int[] narr = new int[3];
			int[] parr = new int[3];
			
			for(int i = 0; i < n_str.length; i++) {
				narr[i] = Integer.parseInt(n_str[i]);
				parr[i] = Integer.parseInt(p_str[i]);
			}
			
			int[] result = new int[3];
			if(narr[2] <= parr[2]) {
				result[2] += parr[2] - narr[2];
			}else {
				result[2] += 60 + (parr[2] - narr[2]);
				parr[1] -= 1;
			}
			
			if(narr[1] <= parr[1]) {
				result[1] += parr[1] - narr[1];
			}else {
				result[1] += 60 + (parr[1] - narr[1]);
				parr[0] -= 1;
			}
			
			if(narr[0] <= parr[0]) {
				result[0] += parr[0] - narr[0];
			}else {
				result[0] += 24 + (parr[0] - narr[0]);
			}
			
			System.out.print("#"+t+" ");
			for(int i = 0 ; i < 3; i++) {
				if(result[i] < 10) {
					System.out.print(0);
					System.out.print(result[i]);
				}else {
					System.out.print(result[i]);
				}
				if(i <2 ) {
					System.out.print(":");
				}
			}
			
			System.out.println();
		}
	}
	
	private static String src = "3\r\n" + 
			"00:00:00\r\n" + 
			"23:59:59\r\n" + 
			"23:59:59\r\n" + 
			"00:00:00\r\n" + 
			"03:29:35\r\n" + 
			"15:01:52";
}
