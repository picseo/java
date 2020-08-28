package algo;

import java.util.Scanner;
/* �׳� �Ǻ���ġ �������µ�, ������� long�Ǵ°� �����ؾ��ߴ�*/
public class BJ_2748_�Ǻ���ġ��2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		long[] memo = new long[2];
		
		memo[0] = 0; memo[1] = 1;
		for(int i = 2; i <= input; i++) {
			long tmp = memo[0] + memo[1];
			memo[i%2] = tmp;
		}

		System.out.println(memo[input%2]);
	}

}
