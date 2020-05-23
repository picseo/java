package d0522;

import java.util.*;
/*
 * 한줄 씩 검사할때 0번째 인덱스에 대해 정보를 확인해 주지 않아서 틀렸었다. 
 * 한줄 쭉 탐색할때는 꼭 한칸도 빼먹지 말고 확인하자
 * 
 * 순열로 A, B, 아무것도 아닌 경우로 나누어서 injection배열을 만들었고
 * N개를 모두 결정했을 때마다 check를 해서 맞은 경우 result값을 업데이터했다.
 * 
 * 가지치기는 result보다 cnt가 큰경우 해주었다.
 * */
public class SWEA_2112_보호필름 {
	static int N, M, K, result;
	static boolean[][] map;
	static int[] injection;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			result = Integer.MAX_VALUE;
			
			map = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j =0; j < M; j++) {
					int input = sc.nextInt();
					if(input == 1) {
						map[i][j] = true;
					}
				}
			}
			
			injection = new int[N];			
			find(0, 0);		
			
			if(result > K) {
				result = K;
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void find(int idx, int cnt) {
		if(result < cnt) {
			return;
		}
		
		if(idx == N) {
			if(check()) {
				result = Math.min(result, cnt);
			}
			return;
		}	
		
		for(int i = 0; i < 3; i++) {//0 : 주입X, 1:A, 2:B
			injection[idx] = i;
			if(i != 0) {
				find(idx+1, cnt+1);
			}else {
				find(idx+1, cnt);
			}
		}
	}

	private static boolean check() {		
		for(int i = 0; i < M; i++) {//열마다 진행
			boolean tmp = false;
			
			int cnt = 1;
			if(cnt >=K) {
				tmp = true;
				continue;
			}			
			
			for(int j = 1; j < N; j++) {//행마다 진행
				boolean pre = map[j-1][i];
				boolean now = map[j][i];
				if(injection[j] == 1) {
					now = false;
				}else if(injection[j] == 2) {
					now = true;
				}
				if(injection[j-1] == 1) {
					pre = false;
				}else if(injection[j-1] == 2) {
					pre = true;
				}
				if(pre == now) {
					cnt++;
					if(cnt >=K) {
						tmp = true;
						break;
					}
				}else {
					cnt=1;
				}
			}
			
			if(!tmp) {
				return false;
			}
		}
		
		return true;
	}

	static boolean nextP() {
		int i, j;
		for(i = injection.length-2; i >=0; i--) {
			if(injection[i] < injection[i+1]) {
				break;
			}
		}
		
		if(i < 0) {
			return false;
		}
		
		for(j = injection.length-1; j >=0 ;j--) {
			if(injection[i] < injection[j]) {
				break;
			}
		}
		
		int tmp = injection[i];
		injection[i] = injection[j];
		injection[j] = tmp;
		
		for(int st =i+1, ed = injection.length-1; st < ed; st++, ed--) {
			tmp = injection[st];
			injection[st] = injection[ed];
			injection[ed] = tmp;
		}
		return true;
	}
}
