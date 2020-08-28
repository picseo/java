package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
   n���� Ÿ���� ���Ϸ��� n-1���� Ÿ�� �ڿ� 1�� �߰��ϰų�, n-2���� Ÿ�� �ڿ� 00�� �߰��ϸ� ���� �� �ִ�.
  
 */
public class BJ_1904_01Ÿ�� {
	public static int[] memo = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = Integer.parseInt(br.readLine());
		
		memo[0] = 1;
		memo[1] = 0;
				
		for(int i = 1; i <= input; i++) {
			int tmp = (memo[0] + memo[1])%15746;
			memo[i%2] = tmp;
		}
		
		int result = memo[input%2];
		System.out.println(result);
	}
}
