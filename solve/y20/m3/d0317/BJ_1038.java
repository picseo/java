package d0317;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 감소하는 수를 처음에는 0부터 9876543210까지 하나씩 확인을 해보려고 했었는데
 * 시간초과에 걸렸었다.
 * 
 * 나중에 다른사람의 코드를 보니 감소하는 수는 규칙이 확실해서
 * 모든 수를 모두 확인하는게 아니라 직접 감소하는 수를 만들어 가는 게 더 좋은 방법이었다.
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
