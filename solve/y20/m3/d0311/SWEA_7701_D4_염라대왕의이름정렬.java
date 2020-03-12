package d0311;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_7701_D4_¿°¶ó´ë¿ÕÀÇÀÌ¸§Á¤·Ä {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb  = new StringBuilder();
		int T = sc.nextInt();
		for(int t = 1;t <= T; t++) {
			sb.append("#").append(t).append("\n");
			int n = sc.nextInt();
			
			PriorityQueue<Name> pqueue = new PriorityQueue();
			for(int i = 0; i < n ; i++) {
				String tmp = sc.next();
				
				pqueue.add(new Name(tmp));
			}
			
			String pre = "-1";
			while(!pqueue.isEmpty()) {
				Name now = pqueue.poll();
				
				if(pre.compareTo(now.name) ==0) {
					continue;
				}else {
					pre = now.name;
					sb.append(now.name).append("\n");
				}
			}
			
		}
		System.out.println(sb);
	}
	
	private static class Name implements Comparable<Name>{
		String name;
		
		Name(String name){
			this.name = name;
		}

		@Override
		public int compareTo(Name o) {
			if(o.name.length() == this.name.length()) {
				return this.name.compareTo(o.name);
			}else {
				return Integer.compare(this.name.length(), o.name.length());
			}
		}		
	}
	
	private static String src = "\r\n" + 
			"2\r\n" + 
			"5\r\n" + 
			"my\r\n" + 
			"name\r\n" + 
			"is\r\n" + 
			"ho\r\n" + 
			"seok\r\n" + 
			"12\r\n" + 
			"s\r\n" + 
			"a\r\n" + 
			"m\r\n" + 
			"s\r\n" + 
			"u\r\n" + 
			"n\r\n" + 
			"g\r\n" + 
			"j\r\n" + 
			"j\r\n" + 
			"a\r\n" + 
			"n\r\n" + 
			"g";
}
