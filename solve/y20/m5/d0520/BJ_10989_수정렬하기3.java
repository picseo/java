package d0520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//input, output빨리 받는 방법을 시험하는 문제인가 보다
public class BJ_10989_수정렬하기3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[10001];
		
		for(int i = 0; i < N ; i ++) {
			int now = Integer.parseInt(br.readLine());
			cnt[now]++;			
		}
		
		for(int i = 1; i < 10001; i++) {
			while(cnt[i]-- > 0) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
