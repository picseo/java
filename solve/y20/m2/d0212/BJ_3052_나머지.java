package algo_basic.SWEA.d0212;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_3052_나머지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		boolean[] visited = new boolean[42];
		
		for(int i =0 ; i < 10; i++) {
			int tmp = sc.nextInt();
			int na = tmp%42;
			visited[na] = true;
		}
		
		int result = 0;
		for(int i = 0; i < 42; i++) {
			if(visited[i]) {
				result++;
			}
		}
		
		System.out.print(result);
	}
	
	private static String src = "39\r\n" + 
			"40\r\n" + 
			"41\r\n" + 
			"42\r\n" + 
			"43\r\n" + 
			"44\r\n" + 
			"82\r\n" + 
			"83\r\n" + 
			"84\r\n" + 
			"85";
}
