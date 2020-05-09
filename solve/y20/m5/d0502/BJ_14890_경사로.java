package d0502;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_14890_경사로 {
	static int N, L;
	static int[][] map;
	static int[][] dirs = {{0, 1}, {1, 0}};
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		
		map = new int[N][N];
		for(int i = 0; i < N ;i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		result = 0;
		//오른쪽으로 진행
		count();
		
		count2();
		System.out.println(result);
	}

	static void count() {
		for(int i = 0; i < N; i++) {
			int prelen = 1;
			boolean check = false;
			boolean ok = true;
			for(int j = 1; j < N; j++) {				
				if(map[i][j-1] == map[i][j]) {
					prelen++;
				}else if(map[i][j] == map[i][j-1] +1) {
					if(check) {
						ok = false;
					}
					if(prelen >= L) {
						prelen = 1;
					}else {
						ok = false;
					}
				}else if(map[i][j] + 1 == map[i][j-1]) {
					if(check) {
						ok = false;
					}else {
						check = true;
						prelen = 1;
					}					
				}else {
					ok = false;
				}
				
				if(!ok) {
					break;
				}
				
				if(check) {
					if(prelen == L) {
						prelen = 0;
						check = false;
					}
				}
			}
			if(ok) {
				if(check && prelen < L) {
					
				}else {
					result++;
				}
			}
		}		
	}
	
	static void count2() {
		for(int i = 0; i < N; i++) {
			int prelen = 1;
			boolean check = false;
			boolean ok = true;
			for(int j = 1; j < N; j++) {				
				if(map[j-1][i] == map[j][i]) {
					prelen++;
				}else if(map[j][i] == map[j-1][i] +1) {
					if(check) {
						ok = false;
					}
					if(prelen >= L) {
						prelen = 1;
					}else {
						ok = false;
					}
				}else if(map[j][i] + 1 == map[j-1][i]) {
					if(check) {
						ok = false;
					}else {
						check = true;
						prelen = 1;
					}					
				}else {
					ok = false;
				}
				
				if(!ok) {
					break;
				}
				
				if(check) {
					if(prelen == L) {
						prelen = 0;
						check = false;
					}
				}
			}
			if(ok) {
				if(check && prelen < L) {
					
				}else {
					result++;
				}
			}
		}		
	}
}
