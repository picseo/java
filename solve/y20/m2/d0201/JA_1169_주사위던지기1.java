package JA;

import java.util.Scanner;
/**
 *  �ι�° �� ã�� �κп��� ���� �ԷµǴ� ���� �������� �ٷ� ������ tmp�� ����� ����
 *  �̿��߾��µ� �� ��쿡�� �ε����� 0�� �� ������ ���� �� �־���.
 *  �׷��� ����Ҷ� ������ ���� �ֻ��� ��ȣ�� �ε����� �ѱ��
 *  �� ���� for���� �ٷ� �̿��ؼ� �����ϰ� �������.
 * */
public class JA_1169_�ֻ���������1 {
	private static int[] dice = {1, 2, 3, 4, 5, 6};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(m == 1)
			find_recur(0, n, new int[n]);
		else if(m == 2) {
			find_recur(0, n, new int[n], 0);
		}else if(m ==3) {
			find_recur3(0, n, new int[n], new boolean[6]);
		}
	}

	private static void find_recur(int cur, int n, int[] tmp) {
		if(cur == n) {
			for(int i = 0; i < tmp.length; i++) {
				System.out.print(tmp[i]+" ");
			}
			System.out.println();
		}else {
			for(int i = 0; i < 6; i++) {
					tmp[cur] = dice[i];
					find_recur(cur+1, n, tmp);
			}
		}
	}
	
	private static void find_recur(int cur, int n, int[] tmp, int before) {
		if(cur == n) {
			for(int i = 0; i < tmp.length; i++) {
				System.out.print(tmp[i]+" ");
			}
			System.out.println();
		}else {
			for(int i = before; i < 6; i++) {
					tmp[cur] = dice[i];
					find_recur(cur+1, n, tmp, i);
			}
		}
	}
	
	private static void find_recur3(int cur, int n, int[] tmp, boolean[] visited) {
		if(cur == n) {
			for(int i = 0; i < tmp.length; i++) {
				System.out.print(tmp[i]+" ");
			}
			System.out.println();
		}else {
			for(int i = 0; i < 6; i++) {
				if(!visited[i]) {
					visited[i] = true;
					tmp[cur] = dice[i];
					find_recur3(cur+1, n, tmp, visited);
					visited[i] = false;
				}
			}
		}
	}
	private static String src = "3 2";			
}
