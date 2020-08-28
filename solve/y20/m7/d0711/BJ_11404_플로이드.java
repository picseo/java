package algo;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 플로이드 워샬은  길의 가중치가 달라도 되고, 심지어는 음수값을 가지고 있어도 최솟값을 구할 수 있다.
 * 
 * 모든 점에서 다른 모든 점으로의 최솟값을 구할 수 있고
 * 
 * 시간 복잡도는 N^3이라서 1000이상인 N값이 있다면 플로이드로 풀수가없다
 * */
public class BJ_11404_플로이드 {
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
