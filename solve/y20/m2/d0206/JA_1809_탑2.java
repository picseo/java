package alog_basic.jungol;

import java.util.Scanner;
import java.util.Stack;
	/**
	 * arr값을 다 쓴 다음에 결과 저장용으로 사용하면 왜
	 * 오류가 나게 될까?
	 * 
	 * **/
public class JA_1809_탑2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] res = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = n-1; i >= 0 ; i--) {
			int now = arr[i];
			if(!st.isEmpty()) {
				int top = arr[st.peek()];
				if(now < top) {
					st.push(i);
				}else{
					while(!st.isEmpty()) {
						int idx = st.peek();
						if(now >= arr[idx]) {
							res[idx] = i+1;
							st.pop();
						}else {
							break;
						}					
					}
				}
			}
			st.push(i);
		}
		
		while(!st.isEmpty()) {
			int idx = st.pop();
			res[idx] = 0;
		}
		
		for(int i = 0; i < n ; i++){
			System.out.print(res[i] + " ");
		}
	}
	
	public static String src = "5\r\n" + 
			"6 9 5 7 4";
}


