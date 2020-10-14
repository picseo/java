package d1002;

import java.util.Arrays;
import java.util.Scanner;

public class 최대상금 {
	static int result = -1;
	static boolean[][] visited = new boolean[1000000][11];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int num = sc.nextInt();
			int cnt = sc.nextInt();
			for(boolean[] a : visited) {
				Arrays.fill(a, false);
			}
			result = -1;
			
			int[] arr = change(num);
			
			recur(arr, cnt);
			sb.append("#"+t+" ");
			sb.append(result+"\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void recur(int[] arr, int cnt) {
		if(cnt == 0) {
			int tmp = 0;
			int gob = 1;
			for(int i = arr.length-1; i >= 0; i--) {
				tmp += arr[i]*gob;
				gob *= 10;
			}
			
			if(result < tmp) {
				result = tmp;
			}
			return;
		}
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(i == j) continue;
				
				StringBuilder sb_tmp = new StringBuilder();
				for(int k = 0; k < arr.length; k++){
					if(k == i) {
						sb_tmp.append(arr[j]);
					}else if(k == j) {
						sb_tmp.append(arr[i]);
					}else {
						sb_tmp.append(arr[k]);
					}
				}
				
				int nextint = Integer.parseInt(sb_tmp.toString());
				if(!visited[nextint][cnt]) {
					int[] next = new int[arr.length];
					for(int k = 0; k < arr.length; k++){
						if(k == i) {
							next[i] = arr[j];
						}else if(k == j) {
							next[j] = arr[i];
						}else {
							next[k] = arr[k];
						}
					}
					visited[nextint][cnt] = true;
					recur(next, cnt-1);
				}
			}
		}
	}

	private static int[] change(int num) {
		int tmp = num;
		int len = 0;
		
		while(tmp>0) {
			len++;
			tmp /= 10;
		}
		
		int[] answer = new int[len];
		int idx = 0;
		while(num>0) {
			answer[--len] = num%10;
			num/=10;
		}
		return answer;
	}

}
