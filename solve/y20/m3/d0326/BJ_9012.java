package d0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9012 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			int st = 0;
			for(int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == '(') {
					st++;
				}else if(input.charAt(j) == ')') {
					st--;
				}
				if(st <0) {
					break;
				}
			}
			
			if(st==0) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
}
