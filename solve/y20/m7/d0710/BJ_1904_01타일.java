package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
   n개의 타일을 구하려면 n-1개의 타일 뒤에 1을 추가하거나, n-2개의 타일 뒤에 00을 추가하면 구할 수 있다.
  
 */
public class BJ_1904_01타일 {
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
