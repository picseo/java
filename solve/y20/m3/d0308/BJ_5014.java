package d0308;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_5014 {
	static int F, S, G, U, D;
	static int MAX = 1000000;
	static int[] nums = null;//new int[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		nums = new int[F+1];
		Arrays.fill(nums,  -1);
		
		nums[S] = 0;
		bfs(S);
		
		if(nums[G] == -1) {
			System.out.println("use the stairs\n");
		}else {
			System.out.println(nums[G]);
		}
	}

	private static void bfs(int s) {
		Queue<Integer> queue = new LinkedList();
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int now = queue.poll();
				
				int next_up = now + U;
				if(isIn(next_up) && nums[next_up] == -1) {// && now < G) {
					queue.add(next_up);
					nums[next_up] = nums[now] + 1;
				}
				
				int next_down = now - D;
				if(isIn(next_down) && nums[next_down] == -1 ) {//&& now > G) {
					queue.add(next_down);
					nums[next_down] = nums[now] + 1;
				}
			}
		}
		
	}
	
	private static boolean isIn(int s) {
		if(s >= 1 && s <= F) {
			return true;
		}else {
			return false;
		}
	}
}
