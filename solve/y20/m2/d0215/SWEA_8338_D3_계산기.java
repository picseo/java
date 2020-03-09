package solve.s0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * �κ����� ���ϴ°� �ݺ��ݺ� �� �ݺ�
 * �׸��� �ð��� ���̷��� buffered reader!!!!!!
 * */
public class SWEA_8338_D3_���� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T ;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			//System.out.println(Arrays.toString(a));
			int max = a[0];
			for(int i = 0; i < (1<<(n-1)); i++) {
				int tmp = a[0];
				for(int j = 0; j < n-1; j++) {
					if((i&(1<<j)) >0) {
						//System.out.print(1);
						tmp *= a[j+1];
					}else {
						//System.out.print(0);
						tmp += a[j+1];
					}
				}
//				System.out.println();
//				System.out.println("result : " + tmp);
				if(max < tmp)
					max = tmp;
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
	private static String src = "2\r\n" + 
			"3\r\n" + 
			"1 2 3\r\n" + 
			"4\r\n" + 
			"4 0 0 4";
}
