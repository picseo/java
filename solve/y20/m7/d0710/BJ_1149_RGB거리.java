package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 	���� �˰� ������ Ǯ��߰ڴٰ� �����ߴ�. �� ��Ǯ�ԵǴٴ�
 	
 	�� ó�� ���ٹ����
 		D[i] = D[i-1] + a[i];
 	�� i��° ������ ������ �� �ּڰ��� ���������� D[i-1]�� ���� a[i]�� �ּڰ��� ���ϴ� ����̴�.
 	
 	�׷��� ���⼭ ���� ��ĥ�� �� �ִ� �������� 3���̹Ƿ� 
 		D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + a[i][0];
 	�̷� ���� �ٲپ�� �Ѵ�.
 	
 	���� �İ� �ٸ� ���� ���� ���� ������ ������� ������ ���� ����  ������ ����Ѵٴ� ���� �ٸ���.
 	�Ʒ��� ���� i��° ������ ��ĥ�ߴµ� ������ ���� 0���� ĥ�Ѱ��� �ǹ��Ѵ�.
 	���� ������ ��ġ�� �ȵǹǷ� i-1������� ��ĥ �Ȱ� �� ������ ���� 1, 2�� ��� �� �ּҰ��� �͸� ����ϴ� ������ ������ Ǯ����.
 */
public class BJ_1149_RGB�Ÿ� {
	static int[][] prices = new int[1001][3];
	static int[][] memo = new int[1001][3];
	
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N ; i++) {
			StringTokenizer cut = new StringTokenizer(br.readLine());
			prices[i][0] = Integer.parseInt(cut.nextToken());
			prices[i][1] = Integer.parseInt(cut.nextToken());
			prices[i][2] = Integer.parseInt(cut.nextToken());
			
			memo[i][0] = ((memo[i-1][1] < memo[i-1][2]) ? memo[i-1][1] : memo[i-1][2]) + prices[i][0];
			memo[i][1] = ((memo[i-1][0] < memo[i-1][2]) ? memo[i-1][0] : memo[i-1][2]) + prices[i][1];
			memo[i][2] = ((memo[i-1][1] < memo[i-1][0]) ? memo[i-1][1] : memo[i-1][0]) + prices[i][2];
		}
		
		for(int i = 0; i < 3; i++) {
			result = result > memo[N][i] ? memo[N][i] : result;
		}
		
		System.out.println(result);
	}
}
