package algo_basic.SWEA.d0212;

import java.util.Scanner;
import java.util.Stack;

public class BJ_17413_단어뒤집기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		String input = sc.nextLine();
		Stack<Character> st = new Stack<>();
		
		boolean tag = false;
		for(int i = 0; i < input.length(); i++) {
			char now = input.charAt(i);
			if(tag) {
				if(now == '>') {
					tag = false;
				}
				System.out.print(now);
			}else {
				if(now == '<' || now == ' ') {
					while(!st.isEmpty()) {
						System.out.print(st.pop());
					}					
					System.out.print(now);
					
					if(now == '<')
						tag = true;					
				}else {
					st.push(now);
				}
			}			
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop());
		}					
		System.out.println();
	}
	
	private static String src ="<   space   >space space space<    spa   c e>";//"<problem>17413<is hardest>problem ever<end>"; 
			//"<int><max>2147483647<long long><max>9223372036854775807";//"one1 two2 three3 4fourr 5five 6six";//"<ab cd>ef gh<ij kl>";//"<open>tag<close>";//"baekjoon online judge";
}
