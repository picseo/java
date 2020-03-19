package d0319;

import java.util.Scanner;

/*
 * ��Ž�� ����ϱ� �ѵ� ��͸� ����ؼ� ����ġ�⸦ � �߰��ؾ� Ǯ���� ������ �����.
 * 
 * 1. �־��� ������ �����ϴ��� Ȯ��
 * 2. ������ ���� ���� �̿��Ѵٸ� �޸������̼��� �̿�
 * */
public class SWEA_5987_�޸��� {
	static int N, M;
	static long[] needs;
	static long[] memo;
	static long result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			needs = new long[N];//�ڿ� �;��ϴ� ������� ǥ���Ѵ�.
			memo = new long[(1<<N)];
			
			for(int i = 0; i < M; i++) {
				int x = sc.nextInt() -1;
				int y = sc.nextInt() -1;
				
				needs[x] |= (1<<y); //x�� y�� �ڿ� �־�� �Ѵ�.
			}
			
			result = dfs(0);
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static long dfs(int visit) {
		if(memo[visit] != 0) {
			return memo[visit];
		}
		
		if(visit == (1<<N)-1) {//������� ��� ������
			return 1;
		}else {//���� ������� �����ؾ� �Ѵ�.
			
			for(int i = 0; i < N; i++) {
				if((visit & (1<<i)) == 0) { //���� i��° ����� �������� �ʾҴٸ�
					if((visit & needs[i]) == needs[i]) { //i��° ������� �ڿ� �־�� �ϴ� ����� ��� �ڿ� ��������
						memo[visit] += dfs(visit|(1<<i));//���ο� ����� �߰��Ѵ�.
					}
				}
			}
		}
		
		return memo[visit];
	}
	
	
	private static String src = "3\r\n" + 
			"3 2\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"5 5\r\n" + 
			"1 2\r\n" + 
			"2 5\r\n" + 
			"1 3\r\n" + 
			"3 4\r\n" + 
			"4 5\r\n" + 
			"16 1\r\n" + 
			"5 9";
}
