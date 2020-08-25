package algo;

import java.util.Scanner;
/* 
	재귀는 컴퓨터한테 알려주기만 하면 된다.
 
 	하노이 문제는 N개를 1->3으로 옮기려면
 	
 	위의 N-1개를 1->2, 한개 남은 원판을 1->3, 2에 있던 N-1개를 2->3하면 옮길 수 있다.
 */
public class BJ_11729_하노이탑이동순서_recur {
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
