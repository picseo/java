package algo;

import java.util.Arrays;
import java.util.Scanner;
/*
 * �÷��̵� ������  ���� ����ġ�� �޶� �ǰ�, ������� �������� ������ �־ �ּڰ��� ���� �� �ִ�.
 * 
 * ��� ������ �ٸ� ��� �������� �ּڰ��� ���� �� �ְ�
 * 
 * �ð� ���⵵�� N^3�̶� 1000�̻��� N���� �ִٸ� �÷��̵�� Ǯ��������
 * */
public class BJ_11404_�÷��̵� {
	static long[][] graph = new long[101][101];
	static long MAX = 100000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		for(int i = 0; i <= N; i++) {
			Arrays.fill(graph[i], MAX);
		}

		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int price = sc.nextInt();

			if(graph[from][to] > price)
				graph[from][to] = price;
		}

		for(int m = 1; m <= N; m++) {
			for(int s = 1; s <= N; s++) {
				for(int e = 1; e <= N; e++) {
					if(s == e)
						continue;
					graph[s][e] = Math.min(graph[s][e], graph[s][m] + graph[m][e]);
				}
			}
		}

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(graph[i][j] == MAX) {
					System.out.print("0 ");
				}else {
					System.out.print(graph[i][j] + " ");
				}
			}
			System.out.println();
		}

	}

}
