package d0908;

import java.util.*;

public class Ä«Ä«¿À2020p2 {

	public static void main(String[] args) {
		System.out.println(solution("()))((()"));

	}
	
	 public static String solution(String p) {
	        String answer = "";
	        
	        answer = find(p);
	        
	        return answer;
	 }
	 
	 private static String find(String p) {
		if(p.equals("")) {
			return "";
		}
		
		int mid = 0;
		String tmp = "";
		for(mid = 2; mid <= p.length(); mid+=2) {
			tmp = p.substring(0, mid);
			String next = "";
			if(balancecheck(tmp)) {
				if(mid != p.length()) {
					next = p.substring(mid);
				}
				
				if(rightcheck(tmp)) {
					return tmp+find(next);
				}else {
					return "("+find(next)+")"+reverse(tmp);
				}
			}
		}
		
		return tmp;
	}

	private static String reverse(String p) {
		String now = "";

		for(int i = 1; i < p.length()-1; i++) {
			if(p.charAt(i) == '(') {
				now += ")";
			}else {
				now += "(";
			}
		}
		
		return now;
	}

	public static boolean balancecheck(String p) {
		 int left = 0;
		 int right = 0;
		 
		 for(int i = 0; i < p.length(); i++) {
			 char now = p.charAt(i);
			 
			 if(now == '(') {
				 left ++;
			 }else {
				 right++;
			 }
		 }
		 
		 if(left == right) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 
	 public static boolean rightcheck(String p) {
		 Stack<Character> st = new Stack<Character>();
		 
		 for(int i = 0; i < p.length(); i++) {
			 char now = p.charAt(i);
			 
			 if(now == ')') {
				 if(st.isEmpty() || st.peek() == ')') {
					 return false;
				 }else {
					 st.pop();
				 }
			 }else {
				 st.add('(');
			 }
		 }
		 return true;
	 }
	 
}
