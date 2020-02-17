package swea.d0210;

import java.util.Scanner;
/*왜이렇게 안풀리지.........
 * (1<= A <= 30000)이라는 조건을 보고  dv를 10000부터 놓았는데
 * 구해야 하는 단조증가하는 수는 Ai * Aj였으므로 
 * dv를 10000*10000이상인 값으로 설정하고 시작해야했다.......
 * 역시 문제를 잘 읽어야 한다....... 
 * **/
public class SWEA_6190_D3_정곤이의단조증가하는수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			
			int max = -1;
			for(int i = 0; i < n-1; i++) {
				for(int j = i+1; j < n; j++) {
					int tmp = a[i]*a[j];
					
					boolean tmp_res = find(tmp);
					if(tmp_res && max < tmp)
						max = tmp;
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
	
	private static boolean find(int num) {
		int tmp = num;
		int pre = 0;
		int dv = 1000000000;
		
		while(dv > 0) {
			int value = tmp/dv;
			if(pre <= value) {
				pre = value;
			}else {
				return false;
			}
			tmp %= dv;
			dv /= 10;
		}
		
		return true;
	}
	
	private static String src = "2\r\n" + 
			"5\r\n" + 
			"2 4 7 10 11 \r\n"+ 
			"3\r\n" + 
			"1 1 1";
}
