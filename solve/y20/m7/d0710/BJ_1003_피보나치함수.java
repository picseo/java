package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 	Ȧ�� ¦���� ����� �����ߴ�.
 	0�� 0->2->4->6->8...
 	1�� 1->3->5->7->9...
 	�� ���� �����ϴ� ���̴�.
 	
 	i�� 2�϶��� 0��°, 1��°�� 0, 1�� ������ ���ؾ� �ϹǷ�
 	memo[i][0] = memo[i-1][0] + memo[i-2][0]���� ����Ͽ���.
 	
 	�� N���� ũ�� �ʾƼ� 40���� �� ���� ������ �ԷµǴ� ���� �´� ���� ������־���.
  
   */
public class BJ_1003_�Ǻ���ġ�Լ� {
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
