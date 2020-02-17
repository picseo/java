package alog_basic.jungol;

import java.util.Scanner;
import java.util.Stack;

//앞에서 뒤로 풀어보기
public class JA_1809_탑3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		Stack<Wall> st = new Stack<>();
		for(int i = 1; i <= n; i++) {
			int newh = sc.nextInt();//새로운 높이를 받아온다.
			while(!st.isEmpty()) {
				if(st.peek().height < newh) {
					st.pop();
				}else {
					break;
				}
			}			
			if(st.isEmpty()) {
				sb.append("0 ");
			}else {
				sb.append(st.peek().idx+ " ");
			}
			st.push(new Wall(newh, i));
		}
		System.out.println(sb);
	}
	
	static class Wall{
		int height;
		int idx;
		public Wall(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}		
	}
	public static String src = "5\r\n" + 
			"6 9 5 7 4";
}


