package algo_basic.day5;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1224_D4_계산기3 {
	public static Stack<Character> st_char = new Stack<>();
	public static List<Character> post = new ArrayList();
	public static Stack<Integer> st_int = new Stack<>();
	public static String check = "*+";
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1224.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t<= 10 ;t++) {
			int len = sc.nextInt();
			String input = sc.next();
			
			makestr2post(input);
			
			int result = calculate();
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	public static int calculate() {
		for(int i = 0; i < post.size(); i++) {
			char now = post.get(i);
			if(check.indexOf(now) >= 0) {//숫자아님
				int b = st_int.pop();
				int a = st_int.pop();
				if(now == '+') {
					st_int.push(a+b);
				}else {
					st_int.push(a*b);
				}
			}else {// 숫자임
				st_int.push(now-'0');
			}
		}
		return st_int.pop();
	}
	
	public static void makestr2post(String input) {
		for(int i = 0; i < input.length(); i++) {
			char tmp  = input.charAt(i);
			if(tmp == '(') {
				st_char.push(tmp);
			}else if(tmp == ')') {
				while(!st_char.isEmpty()) {
					char top = st_char.pop();
					if(top == '(') {
						break;
					}else {
						post.add(top);
					}
				}
			}else if(tmp == '+' || tmp == '*') {
				int tmp_lv = level(tmp);
				while(!st_char.isEmpty()) {
					char top = st_char.peek();
					int top_lv = level(top);
					if(tmp_lv <= top_lv) {
						post.add(st_char.pop());
					}else {
						break;
					}
				}
				st_char.push(tmp);
			}else {
				post.add(tmp);
			}			
		}		
		while(!st_char.isEmpty()) {
			post.add(st_char.pop());
		}
		//System.out.println(post);
	}

	public static int level(char tmp) {
		if(tmp == '*')
			return 3;
		else if(tmp == '+')
			return 2;
		else if(tmp == '(' || tmp == ')')
			return 1;
		else
			return 0;
	}
}
