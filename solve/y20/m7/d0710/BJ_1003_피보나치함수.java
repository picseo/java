package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 	홀수 짝수로 나누어서 저장했다.
 	0은 0->2->4->6->8...
 	1은 1->3->5->7->9...
 	의 값을 저장하는 식이다.
 	
 	i가 2일때는 0번째, 1번째의 0, 1의 갯수를 더해야 하므로
 	memo[i][0] = memo[i-1][0] + memo[i-2][0]으로 계산하였다.
 	
 	또 N값이 크지 않아서 40까지 쭉 구한 다음에 입력되는 수에 맞는 수를 출력해주었다.
  
   */
public class BJ_1003_피보나치함수 {
	static int[][] memo = new int[41][2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		//fill_memo
		memo[0][0] = 1;
		memo[0][1] = 0;
		memo[1][0] = 0;
		memo[1][1] = 1;
		
		for(int i = 2; i < 41; i++) {
			memo[i][0] = memo[i-1][0] + memo[i-2][0];
			memo[i][1] = memo[i-1][1] + memo[i-2][1];
		}
		
		for(int i = 0; i < T; i++) {
			int input = Integer.parseInt(br.readLine());
			
			System.out.println(memo[input][0]+" "+memo[input][1]);
		}
	}

}
