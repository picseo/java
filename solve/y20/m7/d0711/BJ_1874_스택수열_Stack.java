package algo;

import java.util.*;

//마지막에 있는 수보다 작은 수를 달라고 하면 NO
/*
 * Stack
 * import java.util.*;
 * 
 * push() -> 입력
 * pop() -> 꼭대기 값 출력 + 제거
 * peek() -> 꼭대기 값 읽기만 하기
 * empty() -> Stack 가 비었다면 true를 리턴
 * 
 * */
//빨린 푼 사람 코드를 봤더니 배열로 스택을 직접 구현하였다.
public class BJ_1874_스택수열_Stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int push_num = 1;
		
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < n ; i++) {
			int now = sc.nextInt();
			
			if(st.empty()) {//비어있을때
				while(push_num <= now) {
					sb.append("+\n");
					st.push(push_num++);
				}
				sb.append("-\n");
				st.pop();
			}else {
				if(st.peek() < now) {
					while(push_num <= now) {
						sb.append("+\n");
						st.push(push_num++);
					}
					sb.append("-\n");
					st.pop();
				}else if(st.peek() == now) {
					sb.append("-\n");
					st.pop();
				}else {
					System.out.println("NO");
					return;
				}
			}
			
		}
		
		System.out.println(sb.toString());
	}
}

