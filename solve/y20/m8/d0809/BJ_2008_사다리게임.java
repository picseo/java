package d0809;

import java.util.Arrays;
import java.util.Scanner;

//위에서 지금으로 오는 경우를 한칸전, 바로위, 한칸 뒤로만 생각했는데
//너무 작은 범위만 생각해서 틀린거같다.
public class BJ_2008_사다리게임 {
	static int N, M, a, b, X, Y;
	static int[] rad;
	static int[][] value;
	static int MAX = 1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		a = sc.nextInt();
		b = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();

		rad = new int[N+1];
		for(int i = 0; i < N; i++) {
			rad[i+1] = sc.nextInt();
		}

		value = new int[N+2][M+2];

		for(int i = 0; i <= N+1; i++) {
			for(int j = 0; j <= M+1; j++) {
				value[i][j] = MAX;
			}
		}
		
		for(int i = 0; i < M+1; i++) {
			if(i == a) {
				value[0][i] = 0;
			}else {
				value[0][i] = Math.abs(a-i) * X;
			}
		}

		//시작 할때는 비용이 필요없으므로 0으로 시작
		for(int i = 1; i <= N; i++) {//내려가면서 탐색한다.
			for(int j = 1; j <= M; j++) {
				//연결된 선이 없어서 그대로 내려오는 경우
				if(rad[i] != j-1 && rad[i] != j) {
					value[i][j] = value[i-1][j];
				}else {//연결된 선이 있어서 그중에 하나를 지우는 경우
					value[i][j] = value[i-1][j] + X;
				}

				//왼쪽에서 오는 경우
				if(j-1 != 0) {//0은 왼쪽이 존재
					if(rad[i] == j-1) {//이미 선이 존재하는 경우
						value[i][j] = Math.min(value[i][j], value[i-1][j-1]);
					}else {//왼쪽에는 선이 없는 경우
						//만약에 어딘가에 선이 있다면
						if(((j-2 != 0) && rad[i] == j-2) || rad[i] == j) {//오른쪽에 있다면 삭제하고 추가
							value[i][j] = Math.min(value[i][j], value[i-1][j-1] + X + Y);
						}else {
							value[i][j] = Math.min(value[i][j], value[i-1][j-1] + Y);
						}
					}
				}

				//왼쪽에서 오는 경우
				if(j+1 != M+1) {//오른쪽이 존재
					if(rad[i] == j) {//이미 선이 존재하는 경우
						value[i][j] = Math.min(value[i][j], value[i-1][j+1]);
					}else {//오룬쪽에는 선이 없는 경우
						//만약에 어딘가에 선이 있다면
						if(rad[i] == j-1 || (rad[i] == j+1 && j+1 != M+1)) {
							value[i][j] = Math.min(value[i][j], value[i-1][j+1] + X + Y);
						}else {
							value[i][j] = Math.min(value[i][j], value[i-1][j+1] + Y);
						}
					}
				}
			}
		}
		
		System.out.println(value[N][b]);
	}

}
