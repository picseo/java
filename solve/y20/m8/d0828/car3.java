package d0828;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class car3 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int K = sc.nextInt();
		
		long result = bfs(K);
		
		if(result == -1) {
			System.out.println("-1");
		}else {
			String ans = Long.toString(result);
			String answer = ans.substring(1);
			System.out.println(answer);
		}
	}

	private static long bfs(int k) {
		Queue<Long> q = new LinkedList();
		
		int idx = 0;
		for(int i = 10; i < 20; i++) {
			idx++;
			q.add((long)i);
			/*String ans = Long.toString((long)i);
			String answer = ans.substring(1);
			System.out.println("idx" + idx + " : " + answer);*/
			if(idx == k) {
				return i;
			}
		}
		
		while(!q.isEmpty()) {
			long now = q.poll();
			
			if(now >= 10*(100000000) + 123456789) {
				break;
			}
			
			for(int i = (int)(now%10)+1; i <10; i++) {
				long next = now*10 + (long)i;
				idx++;
				q.add(next);
				
				/*String ans = Long.toString(next);
				String answer = ans.substring(1);
				System.out.println("idx" + idx + " : " + answer);*/
				
				if(idx == k) {
					return next;
				}
			}
		}
		return -1;
	}

	
}
