package d0317;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 4자리 소수에서 1글자 씩만 바꾸어서 목표로 삼는 4자리 소수에 도달하기까지의 최솟값을 구하는 문제였다.
 * 
 * 최솟값에서 bfs를 생각했다.
 * 
 * 매번 한자리씩 수를 바꾸어 보고 이게 소수라면 queue에 넣어주는 식으로 진행하였다.
 * 소수가 아니여도 visited이라는 배열에 표시를 하여 다시 소수인지 아닌지 확인하는 과정을 하지 않게 하였다.
 * 
 * 그리고 만약 bfs에서 답에 도달하면 그때가 가장 짧은 경우이므로 return을 하여 bfs을 끝냈다.
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
