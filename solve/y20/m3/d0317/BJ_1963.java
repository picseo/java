package d0317;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 4�ڸ� �Ҽ����� 1���� ���� �ٲپ ��ǥ�� ��� 4�ڸ� �Ҽ��� �����ϱ������ �ּڰ��� ���ϴ� ��������.
 * 
 * �ּڰ����� bfs�� �����ߴ�.
 * 
 * �Ź� ���ڸ��� ���� �ٲپ� ���� �̰� �Ҽ���� queue�� �־��ִ� ������ �����Ͽ���.
 * �Ҽ��� �ƴϿ��� visited�̶�� �迭�� ǥ�ø� �Ͽ� �ٽ� �Ҽ����� �ƴ��� Ȯ���ϴ� ������ ���� �ʰ� �Ͽ���.
 * 
 * �׸��� ���� bfs���� �信 �����ϸ� �׶��� ���� ª�� ����̹Ƿ� return�� �Ͽ� bfs�� ���´�.
 * 
 * */
public class BJ_1963 {
	static boolean[] visited = new boolean[10000];
	static int from, to, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			result = -1;
			Arrays.fill(visited,  false);
			from = sc.nextInt();
			int[] farr = new int[4];
			int tmp = from;
			for(int i = 3; i >=0; i--) {
				farr[i] = tmp%10;
				tmp /= 10;
			}
			
			to = sc.nextInt();	
			if(from != to)
				bfs(farr);
			
			if(result == -1) {
				result = 0;
			}
			
			System.out.println(result);
		}

	}

	public static void bfs(int[] farr) {
		int cnt = 0;
		Queue<int[]> queue = new LinkedList();
		queue.add(farr);
		visited[from] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s = 0; s < size; s++) {
				int[] now = queue.poll();
				
				for(int i = 0; i < now.length; i++) {
					for(int j = 0; j < 10; j++) {
						if(i == 0 && j == 0) {
							continue;
						}
						int[] next = now.clone();
						next[i] = j;
						
						int next_num = strtonum(next);
						if(!visited[next_num]) {
							visited[next_num] = true;
							if(checkPrime(next_num)) {
								queue.add(next);
								if(next_num == to) {
									result = cnt +1;
									return;
								}
							}							
						}
						
					}
				}
			}
			cnt++;
		}
		
		result = -1;
	}
	
	private static int strtonum(int[] str) {
		int tmp = 0;
		for(int i = 0; i <4; i++) {
			tmp = (tmp*10) + str[i];
		}
		return tmp;
	}
	
	private static boolean checkPrime(int num) {
		for(int i = 2; i*i <= num; i++) {
			if(num%i == 0) {
				return false;
			}
		}		
		return true;
	}

	private static String src = "3\r\n" + 
			"1033 8179\r\n" + 
			"1373 8017\r\n" + 
			"1033 1033";
}
