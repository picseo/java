package d0317;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * �����ϴ� ���� ó������ 0���� 9876543210���� �ϳ��� Ȯ���� �غ����� �߾��µ�
 * �ð��ʰ��� �ɷȾ���.
 * 
 * ���߿� �ٸ������ �ڵ带 ���� �����ϴ� ���� ��Ģ�� Ȯ���ؼ�
 * ��� ���� ��� Ȯ���ϴ°� �ƴ϶� ���� �����ϴ� ���� ����� ���� �� �� ���� ����̾���.
 * 
 * */
public class BJ_1038 {
	static long result = 0;
	static int idx = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		bfs(N);
		
		if(idx < N) {
			result = -1;
		}
		System.out.println(result);
	}
	
	private static void bfs(int N) {
		idx = -1;
		Queue<Long> queue = new LinkedList();
		for(int i = 0; i < 10; i++) {
			queue.add((long)i);
			idx++;
			if(N == idx) {
				result = i;
				return;
			}
		}
		
		while(!queue.isEmpty()) {
			long now = queue.poll();
			
			for(int i = 0; i < now%10; i++) {
				long next = now*10 + i;
				queue.add(next);
				idx++;
				if(N == idx) {
					result = next;
					return;
				}
			}	
			
		}
	}
}
