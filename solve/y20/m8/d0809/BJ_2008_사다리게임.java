package d0809;

import java.util.Arrays;
import java.util.Scanner;

//������ �������� ���� ��츦 ��ĭ��, �ٷ���, ��ĭ �ڷθ� �����ߴµ�
//�ʹ� ���� ������ �����ؼ� Ʋ���Ű���.
public class BJ_2008_��ٸ����� {
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

		//���� �Ҷ��� ����� �ʿ�����Ƿ� 0���� ����
		for(int i = 1; i <= N; i++) {//�������鼭 Ž���Ѵ�.
			for(int j = 1; j <= M; j++) {
				//����� ���� ��� �״�� �������� ���
				if(rad[i] != j-1 && rad[i] != j) {
					value[i][j] = value[i-1][j];
				}else {//����� ���� �־ ���߿� �ϳ��� ����� ���
					value[i][j] = value[i-1][j] + X;
				}

				//���ʿ��� ���� ���
				if(j-1 != 0) {//0�� ������ ����
					if(rad[i] == j-1) {//�̹� ���� �����ϴ� ���
						value[i][j] = Math.min(value[i][j], value[i-1][j-1]);
					}else {//���ʿ��� ���� ���� ���
						//���࿡ ��򰡿� ���� �ִٸ�
						if(((j-2 != 0) && rad[i] == j-2) || rad[i] == j) {//�����ʿ� �ִٸ� �����ϰ� �߰�
							value[i][j] = Math.min(value[i][j], value[i-1][j-1] + X + Y);
						}else {
							value[i][j] = Math.min(value[i][j], value[i-1][j-1] + Y);
						}
					}
				}

				//���ʿ��� ���� ���
				if(j+1 != M+1) {//�������� ����
					if(rad[i] == j) {//�̹� ���� �����ϴ� ���
						value[i][j] = Math.min(value[i][j], value[i-1][j+1]);
					}else {//�����ʿ��� ���� ���� ���
						//���࿡ ��򰡿� ���� �ִٸ�
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
