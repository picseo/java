package d0403;

import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		/*
		 * Hello, world!	0
line [plus]	1
if (Count of eggs is 4.) {Buy milk.}	2
>_<	-1
		 * */
		String v = ">_<";
		System.out.println( solution(v));
	}
	
	static String front = "{[<(";
	static String second = "}]>)";
	public static int solution(String inputString) {
		
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < inputString.length(); i++) {
        	char now = inputString.charAt(i);
        	if(front.contains(now+"")) {
        		stack.add(now);
        	}else if(second.contains(now+"")) {
        		if(stack.isEmpty()) {
        			return -1;
        		}else {
        			stack.pop();
        			answer++;
        		}
        	}else {
        		//괄호가 아닌 문자들은 무시
        	}
        }
        
        if(stack.isEmpty()) {
        	return answer;
        }else {
        	return -1;
        }
        
    }
    
}