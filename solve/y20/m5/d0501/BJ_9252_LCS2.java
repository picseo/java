package d0501;

import java.util.Scanner;
import java.util.Stack;

public class BJ_9252_LCS2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String A = sc.next();
		String B = sc.next();
		
		int[][] memo = new int[A.length()+1][B.length()+1];
		
		for(int i = 1; i <= A.length(); i++) {
			for(int j = 1; j <= B.length(); j++) {
				memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
				if(A.charAt(i-1) == B.charAt(j-1)) {
					memo[i][j] = memo[i-1][j-1]+1;
				}
			}
		}
		
		sb.append(memo[A.length()][B.length()]);
		
		int x = A.length();
		int y = B.length();
		Stack<Character> st = new Stack<Character>();
		
		while(x != 0 && y!= 0) {
			if(memo[x][y] == memo[x-1][y]) {
				x--;
			}else if(memo[x][y] == memo[x][y-1]) {
				y--;
			}else {
				st.push(A.charAt(x-1));
				x--;
				y--;
			}
		}
		
		sb.append("\n");
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		sb.append("\n");
		
		System.out.println(sb);
	}
	
}
