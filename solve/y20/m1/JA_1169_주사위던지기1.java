package alog_basic.jungol;

import java.util.Arrays;
import java.util.Scanner;

public class JA_1169_주사위던지기1 {
	public static int[] dice = {1, 2, 3, 4, 5, 6};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(m == 1)
			permu(n, 0, new int[n]);
		else if(m == 2) {
			permu2(n, 0, new int[n]);
		}else if(m == 3) {
			permu3(3, 0, new int[3], new boolean[6]);
		}
	}

	/*public static void permu(int r, int cur, int[] tmp, boolean[][] visited) {
		if(r == cur) {
			System.out.println(Arrays.toString(tmp));
		}else {
			for(int i = 0; i < 6; i++) {
				if(!visited[cur][i]) {
					visited[cur][i] = true;
					tmp[cur] = i+1;
					permu(r, cur+1, tmp, visited);
					visited[cur][i] = false;
				}
			}
		}
	}*/
	
	public static void permu(int r, int cur, int[] tmp) {
		if(r == cur) {
			for(int i  = 0; i < tmp.length; i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println();
		}else {
			for(int i = 0; i < 6; i++) {
				tmp[cur] = i+1;
				permu(r, cur+1, tmp);
			}
		}
	}
	
	public static void permu2(int r, int cur, int[] tmp) {
		if(r == cur) {
			for(int i  = 0; i < tmp.length; i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println();
		}else {
			for(int i = 0; i < 6; i++) {
				if(cur!= 0 && tmp[cur-1] <= i+1) {
					tmp[cur] = i+1;
					permu2(r, cur+1, tmp);
				}else if(cur == 0) {
					tmp[cur] = i+1;
					permu2(r, cur+1, tmp);
				}
			}
			
			/*for(int i = 0일때는 0이고, 이전 수가 있을 때는 이전 수 이상부터; i < 6; i++) {
				tmp[cur] = i+1;
				permu2(r, cur+1, tmp);
			}*/
		}
	}
	
	public static void permu3(int r, int cur, int[] tmp, boolean[] visited) {
		if(r == cur) {
			for(int i  = 0; i < tmp.length; i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println();
		}else {
			for(int i = 0; i < 6; i++) {
				if(!visited[i]) {
					visited[i] = true;
					tmp[cur] = i+1;
					permu3(r, cur+1, tmp, visited);
					visited[i] = false;
				}
			}
		}
	}
	
	private static String src = "3 2";
}
