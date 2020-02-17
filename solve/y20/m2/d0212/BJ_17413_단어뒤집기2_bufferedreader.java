package algo_basic.SWEA.d0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_17413_단어뒤집기2_bufferedreader {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		Stack<Character> st = new Stack<>();
		
		boolean tag = false;
		for(int i = 0; i < input.length(); i++) {
			char now = input.charAt(i);
			if(tag) {
				if(now == '>') {
					tag = false;
				}
				sb.append(now);
				//System.out.print(now);
			}else {
				if(now == '<' || now == ' ') {
					while(!st.isEmpty()) {
						sb.append(st.pop());
					}					
					sb.append(now);
					
					if(now == '<')
						tag = true;					
				}else {
					st.push(now);
				}
			}			
		}
		
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}					
		System.out.println(sb);
	}
	
	private static String src ="<   space   >space space space<    spa   c e>";//"<problem>17413<is hardest>problem ever<end>"; 
			//"<int><max>2147483647<long long><max>9223372036854775807";//"one1 two2 three3 4fourr 5five 6six";//"<ab cd>ef gh<ij kl>";//"<open>tag<close>";//"baekjoon online judge";
}
