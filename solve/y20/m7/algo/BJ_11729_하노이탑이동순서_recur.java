package algo;

import java.util.Scanner;
/* 
	��ʹ� ��ǻ������ �˷��ֱ⸸ �ϸ� �ȴ�.
 
 	�ϳ��� ������ N���� 1->3���� �ű����
 	
 	���� N-1���� 1->2, �Ѱ� ���� ������ 1->3, 2�� �ִ� N-1���� 2->3�ϸ� �ű� �� �ִ�.
 */
public class BJ_11729_�ϳ���ž�̵�����_recur {
	static int N;
	static int result = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		hanoi(N, 1, 2, 3);
		
		System.out.println(result);
		System.out.println(sb.toString());
	}

	
	private static void hanoi(int cnt, int st, int mid, int ed) {
		if(cnt == 1) {
			move(st, ed);
			return;
		}
		
		hanoi(cnt-1, st, ed, mid);
		move(st, ed);
		hanoi(cnt-1, mid, st, ed);
	}


	private static void move(int st, int ed) {
		result++;
		sb.append(st+" "+ed+"\n");
	}

}
