package d0820;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 	�Էµ� ���� queue�� ���� �Ŀ�
 	�ϳ��� ���� �̹� ���� ���� ��, ���� ���� queue�� �߰��Ѵ�.
 	�� �Ŀ� �ش� ���� �̹� ���� ������ �־��ش�.
 	
 	�̶� �߿��Ѱ� �ڱ��ڽ��� ���ؼ� ���� ���� ����ؾ��Ѵٴ� ���̴�
 	�ΰ��̷��� ���� ���� �ȵȴٰ� �����޴µ�
 	�ȵȴٴ� ������ ������.
 	
 	(����)
 
  */
public class BJ_2916_�ڿͰ�����2 {
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
				//���� ���� �߰��Ѵ�.
				int sum = (angles.get(i) + now) % 360;
				if(!memo[sum]) {
					memo[sum] = true;
					q.add(sum);
				}
				
				//minus���� �߰��Ѵ�.
				int minus = (angles.get(i) - now + 360)%360;
				if(!memo[minus]) {
					memo[minus] = true;
					q.add(minus);
				}
			}
			
			//�ڱ��ڽ��� �̿�
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