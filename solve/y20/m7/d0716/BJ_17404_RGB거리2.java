package d0716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//RGB�Ÿ��� ���� �����ε� 1�� �����Ÿ��� ������ �þ��ִٸ� 2�� ���� �Ÿ��� ������ �þ����Ű� �ٸ����̴�
//�ᱹ ù��°�� ������ ���� �Ѱ��� �����ϰ� �����ؾ� �Ѵ�.
public class BJ_17404_RGB�Ÿ�2 {
	static int N;
	static int[][] prices;
	static int[][] memo;
	static int MAX = 2000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		prices = new int[N+2][3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				prices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = MAX;
		memo = new int[N+2][3];
		for(int i = 0; i < 3; i++) {
			memo[0][i] = prices[0][i];
			memo[0][(i+1)%3] = MAX;
			memo[0][(i+2)%3] = MAX;
			
			for(int j = 1; j < N; j++) {
				memo[j][0] = Math.min(memo[j-1][1],  memo[j-1][2]) + prices[j][0];
				memo[j][1] = Math.min(memo[j-1][0],  memo[j-1][2]) + prices[j][1];
				memo[j][2] = Math.min(memo[j-1][1],  memo[j-1][0]) + prices[j][2];
			}
			
			result = Math.min(Math.min(result, memo[N-1][(i+1)%3]), memo[N-1][(i+2)%3]);
		}
		
		System.out.println(result);
	}

}
