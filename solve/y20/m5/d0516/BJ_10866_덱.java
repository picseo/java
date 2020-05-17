package d0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
//Deque를 사용해보았다. ArrayDeque로 부른다.
public class BJ_10866_덱 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		Deque<Integer> dq = new ArrayDeque<Integer>();
		StringBuilder sb  = new StringBuilder();
		
		while((N--)>0) {
			st = new StringTokenizer(br.readLine());
			
			String code = st.nextToken();
			if(code.equals("push_back")) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}else if(code.equals("push_front")) {
				dq.addFirst(Integer.parseInt(st.nextToken()));
			}else if(code.equals("pop_front")) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.pollFirst()).append("\n");
				}
			}else if(code.equals("pop_back")){
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.pollLast()).append("\n");
				}
			}else if(code.equals("size")) {
				sb.append(dq.size()).append("\n");
			}else if(code.equals("empty")) {
				if(dq.isEmpty()) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}else if(code.equals("front")) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.peekFirst()).append("\n");
				}
			}else if(code.equals("back")) {
				if(dq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(dq.peekLast()).append("\n");
				}
			}
			
		}
		System.out.println(sb);
	}

}
