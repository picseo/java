package d0820;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 	입력된 각을 queue에 넣은 후에
 	하나씩 빼서 이미 읽은 각과 합, 차를 구해 queue에 추가한다.
 	그 후에 해당 값은 이미 읽은 각으로 넣어준다.
 	
 	이때 중요한게 자기자신을 더해서 만든 각도 고려해야한다는 점이다
 	두각이래서 같은 각은 안된다고 생각햇는데
 	안된다는 조건이 없었다.
 	
 	(수학)
 
  */
public class BJ_2916_자와각도기2 {
	private static int N, K;
	private static ArrayList<Integer> angles;
	private static Queue<Integer> q;
	private static int[] yells;
	private static boolean[] memo = new boolean[360];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
	
		angles = new ArrayList();
		q = new LinkedList();
		yells = new int[K];
		memo[0] = true;
		
		for(int i = 0; i < N; i++) {
			int input = sc.nextInt();
			memo[input] = true;
			q.add(input);
		}
		
		for(int i = 0; i < K; i++) {
			yells[i] = sc.nextInt();
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 0; i < angles.size(); i++) {
				//합한 값을 추가한다.
				int sum = (angles.get(i) + now) % 360;
				if(!memo[sum]) {
					memo[sum] = true;
					q.add(sum);
				}
				
				//minus값을 추가한다.
				int minus = (angles.get(i) - now + 360)%360;
				if(!memo[minus]) {
					memo[minus] = true;
					q.add(minus);
				}
			}
			
			//자기자신을 이용
			int sum = (now + now) % 360;
			if(!memo[sum]) {
				memo[sum] = true;
				q.add(sum);
			}
			
			angles.add(now);
		}
		
		for(int i = 0; i < K; i++) {
			if(memo[yells[i]]) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
	}

}