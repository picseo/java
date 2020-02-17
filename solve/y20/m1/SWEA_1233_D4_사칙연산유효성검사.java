package algo_basic.day7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233_D4_사칙연산유효성검사 {
	private static Node[] tree = new Node[201];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res\\sinput.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			for(int i = 0;  i < n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int what = 0;
				int v = 0;
				char op = 'a';
				int lnum = 0;
				int rnum = 0;
				
				while(st.hasMoreTokens()) {
					if(what == 0) {
						v = Integer.parseInt(st.nextToken());
					}else if(what == 1) {
						op = st.nextToken().charAt(0);
					}else if(what == 2) {
						lnum =Integer.parseInt(st.nextToken()); 
					}else if(what == 3) {
						rnum =Integer.parseInt(st.nextToken());
					}
					what++;
				}
				
				if(what == 4) {
					if(i == 0) {
						tree[v]  = new Node(v, op);
						tree[v].l = new Node(lnum, 'a');
						tree[v].r = new Node(rnum, 'a');
					}else {
						tree[v].ch = op;
						tree[v].l = new Node(lnum, 'a');
						tree[v].r = new Node(rnum, 'a');
					}
				}else if(what == 3) {
					if(i == 0) {
						tree[v]  = new Node(v, op);
						tree[v].l = new Node(lnum, 'a');
					}else {
						tree[v].ch = op;
						tree[v].l = new Node(lnum, 'a');
					}
				}else if(what == 2) {
					if(i == 0) {
						tree[v]  = new Node(v, op);
					}else {
						tree[v].ch = op;
					}
				}
			}
			
			
			checkOk(tree[1]);
		}
	}
	private static boolean checkOk(Node T) {
		
		checkOk(T.l);
		System.out.println();
		checkOk(T.r);
		return true;
	}
	
	private static class Node{
		int v;
		char ch;
		Node l;
		Node r;
		
		Node(int v, char ch){
			this.v = v;
			this.ch = ch;
		}		
	}
}
