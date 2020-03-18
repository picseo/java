package d0317;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
 * 노드로 직접 구현하는 더블 링크드 리스트!!
 * 객체라서 꼬일 줄 알았는데 잘 된다. 
 *
 */
 
public class BJ_5397 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			String str = sc.next();
			Node head = new Node(' ', null, null);
			Node where = head;
			
			for(int i = 0; i < str.length(); i++) {
				char now = str.charAt(i);
				if(now == '<') {
					if(where != head) {
						where = where.pre;
					}
				}else if(now == '>') {
					if(where.next != null) {
						where = where.next;
					}
				}else if(now == '-') {
					if(where != head) {
						if(where.next == null) {
							where.pre.next = null;
							where = where.pre;
						}else {
							where.pre.next = where.next;
							where.next.pre = where.pre;
							where = where.pre;
						}
					}
				}else {

					if(where.next == null) {
						Node last = new Node(now, where, null);
						where.next = last;
						where = last;
					}else {
						Node last = new Node(now, where, where.next);
						where.next.pre = last;
						where.next = last;
						where = last;
					}

				}
			}
			
			where = head.next;
			while(where != null) {
				sb.append(where.value);
				where = where.next;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static class Node{
		char value;
		Node pre;
		Node next;
		
		public Node(char value, Node pre, Node next) {
			this.value = value;
			this.pre = pre;
			this.next = next;
		}		
	}
	
	private static String src = "2\r\n" + 
			"<<BP<A>>Cd-\r\n" + 
			"ThIsIsS3Cr3t";
}
