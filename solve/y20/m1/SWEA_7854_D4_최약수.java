package swea.D3;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_7854_D4_최약수 {
	private static int[] num = {2, 4, 5};
	private static int[] tmp = new int[50];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();
		int dv = 1000000000;
		
		tmp[0] = dv;
		int end = find(dv, dv/10, 0, 1);
		
		System.out.println(Arrays.toString(tmp));
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();	
			int result = 0;
			
			for(int i = 0; i < end; i++) {
				if(tmp[i] <= n)
					result++;
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	public static int find(int dv, int dv_next, int st, int end) {
		int result = 0;
		if(dv == 1) {
			return end;
		}else {
			int i =0;
			for(i = st; i < end; i++) {
				for(int j = 0; j < 3; j++) {
					int now = tmp[i]/num[j];
					if(now != 0 && dv%now == 0 && now > dv_next) {
						boolean check = false;
						for(int k = st; k < end; k++) {
							if(k != i && now  == tmp[k]) {
								check = true;
								break;
							}
						}
						if(!check) {
							tmp[end] = now;
							end++;
						}
					}
				}
			}
			
			tmp[end++] = dv_next;
			result = find(dv/10, dv_next/10, i, end);
		}
		
		return result;
	}

	private static String src = "3\r\n" + 
			"2\r\n" + 
			"100\r\n" + 
			"1000000000";
}
