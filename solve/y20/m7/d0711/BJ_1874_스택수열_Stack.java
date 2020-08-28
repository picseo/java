package algo;

import java.util.*;

//�������� �ִ� ������ ���� ���� �޶�� �ϸ� NO
/*
 * Stack
 * import java.util.*;
 * 
 * push() -> �Է�
 * pop() -> ����� �� ��� + ����
 * peek() -> ����� �� �б⸸ �ϱ�
 * empty() -> Stack �� ����ٸ� true�� ����
 * 
 * */
//���� Ǭ ��� �ڵ带 �ô��� �迭�� ������ ���� �����Ͽ���.
public class BJ_1874_���ü���_Stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int push_num = 1;
		
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < n ; i++) {
			int now = sc.nextInt();
			
			if(st.empty()) {//���������
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

