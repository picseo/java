package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 LIS(Longest increasing substring?)
 �����ϴ� ���� �� ������ ã�� ��������.
 
 �ԷµǴ°� A�������� �������� ���ĵǼ� ������ �ʾƼ� 
 �������� ���� �� �ִ� ��(1~500)�� ��� ���� �� �ִ� �迭�� ���� �����Ͽ���.
 
 �׸��� A�� ������ �Ǿ������Ƿ�, ���� ����Ǿ��ִ� ��쿡 ���� �ٺ��� �ִ밪�� ���� memo�� ���߿���
 ���� ���� ū�� ��� ���� �����Ͽ���.
 ���� �ٲپ��ָ鼭  Max���� �ʿ��Ҷ����� ������Ʈ ���־���.
 
 �׷� �Ŀ� �� ������ �������� - Max�� �ؼ� ���־� �ϴ� �ּڰ��� ���ϴ� ����� ����Ͽ���. 
 */
public class BJ_2565_������ {
	static int[][] lines = new int[501][2];
	static int[][] memo = new int[501][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int Max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			lines[from][0] = from; 
			lines[from][1] = to;
		}
		
		for(int i = 1; i <501; i++) {
			if(lines[i][0] == 0) {
				continue;
			}
			
			memo[i][1] = lines[i][1];
			memo[i][0] = 1;
			
			for(int j = i-1; j >=0 ; j--) {
				if(lines[j][0] == 0 || memo[j][1] > lines[i][1]) {
					continue;
				}
				
				memo[i][0] = Math.max(memo[j][0]+1, memo[i][0]);
			}
			
			Max = Math.max(memo[i][0], Max);
		}
		
		int result = N - Max;
		System.out.println(result);
	}

}
