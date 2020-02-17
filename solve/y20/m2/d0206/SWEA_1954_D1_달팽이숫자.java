package algo_basic.day2;

import java.util.Scanner;

public class SWEA_1954_D1_달팽이숫자 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			int ans = 1;
			int x = 0, y = -1;
			while (ans <= n * n) {
//			System.out.println(ans);
				for (int j = y+1; j < n; j++) {
					if (arr[x][j] != 0) {
						break;
					}

					arr[x][j] = ans;
					ans++;
					y = j;

				}
				for (int j = x+1; j < n; j++) {

					if (arr[j][y] != 0) {
						break;
					}
					arr[j][y] = ans;
					ans++;
					x = j;

				}

				for (int j = y-1; j > -1; j--) {
					if (arr[x][j] != 0) {
						break;
					}
					arr[x][j] = ans;
					ans++;
					y = j;
				}
				for (int j = x-1; j > -1; j--) {
					if (arr[j][y] != 0) {
						break;
					}
					arr[j][y] = ans;
					ans++;
					x = j;
				}

			}

			System.out.printf("#%d\n", i);
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}

		}

	}

}
