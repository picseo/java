package algo;

import java.util.Scanner;
/* ��Ģ�� ã�Ƽ� Ǫ�� ��������*/
public class BJ_2292_����_���� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int start = 1;
		int cnt = 0;
		
		while(true) {

			cnt++;
			if(N <= start) {
				break;
			}
			start += cnt*6;
		}
		
		System.out.println(cnt);
	}

}
