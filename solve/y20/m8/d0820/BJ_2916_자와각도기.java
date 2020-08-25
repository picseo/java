package d0820;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//���� �� �ִ� ���� ��� ã�� �Ŀ�
//��ġ�� ���� ���� ����� ����ϰ� ������
//���� �� �ִ� ���� ��� ã��
public class BJ_2916_�ڿͰ����� {
	private static int N, K;
	private static int[] angles;
	private static boolean[] memo = new boolean[360];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
	
		angles = new int[N];
		
		for(int i = 0; i < N; i++) {
			angles[i] = sc.nextInt();
		}
		
		memo[0] = true;
		for(int i = 0; i < N; i++) {
			for(int k = 0; k < 360; k++) {
				for(int j = 0; j < 360; j++) {
					if(memo[j] == false) continue;
					memo[(j-angles[i]+360)%360] = true;
					memo[(j+angles[i])%360] = true;
				}
			}
		}

		for(int i = 0; i < K; i++) {
			int now = sc.nextInt();

			if(memo[now]) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
		
	}

}
