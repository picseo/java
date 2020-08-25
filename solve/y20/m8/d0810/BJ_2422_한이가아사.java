package d0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
//���� �¾Ҵµ�, for�� 3������ ��͸� ����ϴ°� �� ������ ���ȴ�.
public class BJ_2422_���̰��ƻ� {
	static int N, M;
	static boolean[][] never = new boolean[201][201];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
		
			never[from][to] = true;
			never[to][from] = true;
		}
		
		int result = 0;
		for(int i = 1; i <= N-2; i++) {
			for(int j = i+1; j <= N-1; j++) {
				if(never[i][j]) {
					continue;
				}
				for(int k = j+1; k <= N; k++) {
					if(never[i][k] || never[j][k]) {
						continue;
					}else {
						result++;
					}
				}
			}
		}
		
		System.out.println(result);		
	}
}

/*
 * �����Լ�����
 	for(int i= 0;i<=N-LIMIT;i++) {//0(+1)���� N-3(+1)����
			find(i+1, i+1, 1);
		}
		System.out.println(answer);
	
	ȣ���ϴ� ����Լ�
	void find(int num1, int curNum, int count) {
		if(count == LIMIT) {
			answer++;
			return;
		}else {
			for(int i = curNum+1;i<=N;i++) {//���簪+1 ���� N����
				if(!forbid[num1][i] && !forbid[curNum][i]) {//������ ������ �ƴ϶��
					find(num1, i, count+1);//ù��°���� ����, ������ �ְ�, ���ڰ��� �ϳ� ��������
				}
			}
		}
	}
 * */
