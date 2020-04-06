package d0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기 {
	static int N, MIN, MAX;
	static int[] A, op;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		A = new int[N];
		for(int i = 0; i < N ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		op = new int[4]; // 0 : +, -, *, /
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		MIN = Integer.MAX_VALUE;
		MAX = Integer.MIN_VALUE;
		
		dfs(N-1, 0, 1, new int[4], A[0]);
		
		System.out.println(MAX+"\n"+MIN);
	}
	
	private static void dfs(int n, int cur, int k, int[] tmp, int res) {
		if(cur == n) {
			if(res < MIN) {
				MIN = res;
			}
			if(res > MAX) {
				MAX = res;
			}
			return;
		}else {
			
			//+
			if(tmp[0] + 1 <= op[0]) {
				tmp[0]++;
				dfs(n, cur+1, k+1, tmp, res+A[k]);
				tmp[0]--;
			}
			//-
			if(tmp[1] + 1 <= op[1]) {
				tmp[1]++;
				dfs(n, cur+1, k+1, tmp, res-A[k]);
				tmp[1]--;
			}
			//*
			if(tmp[2] + 1 <= op[2]) {
				tmp[2]++;
				dfs(n, cur+1, k+1, tmp, res*A[k]);
				tmp[2]--;
			}
			///
			if(tmp[3] + 1 <= op[3]) {
				tmp[3]++;
				dfs(n, cur+1, k+1, tmp, res/A[k]);
				tmp[3]--;
			}
			
		}
		
	}
	
	

}
