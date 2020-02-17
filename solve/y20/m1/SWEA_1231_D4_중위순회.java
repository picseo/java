package algo_basic.day7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//어려워요 : node에 연결해서 트리를 만들고 싶었는데
//완전 이진 트리라고 문제에 있어서 배열에 넣었다.
public class SWEA_1231_D4_중위순회 {
	private static Node root = null;
	private static Node[] tree = new Node[102];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res\\sinput.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t<= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			//sc.nextLint(); - > String[] splited = input.split(" ");
			
			for(int i = 0; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int what = 0;
				int v = 0;
				char alph = 'A';
				int l = 0;
				int r = 0;
				
				while(st.hasMoreTokens()) {
					if(what == 0) {
						v = Integer.parseInt(st.nextToken());
					}else if(what == 1) {
						alph = st.nextToken().charAt(0);
					}else if(what == 2) {
						l = Integer.parseInt(st.nextToken());
					}else if(what == 3) {
						r = Integer.parseInt(st.nextToken());
					}
					what++;
				}
				
				if(what == 4) {
					if(v == 1) {
						tree[v] = new Node(v, alph);
						tree[l] = new Node(l, 'a');
						tree[v].l = tree[l];
						tree[r] = new Node(r, 'a');
						tree[v].r = tree[r];
					}else {
						tree[v].alph = alph;
						tree[l] = new Node(l, 'a');
						tree[v].l = tree[l];
						tree[r] = new Node(r, 'a');
						tree[v].r = tree[r];
					}
				}else if(what == 3) {
					if(v == 1) {
						tree[v] = new Node(v, alph);
						tree[l] = new Node(l, 'a');
						tree[v].l = tree[l];
					}else {
						tree[v].alph = alph;
						tree[l] = new Node(l, 'a');
						tree[v].l = tree[l];
					}
				}else if(what == 2) {
					if(v == 1) {
						tree[v] = new Node(v, alph);
					}else {
						tree[v].alph = alph;
					}
				}	
			} 
			
			System.out.print("#"+t+" ");
			inorder_traverse(tree[1]);		
			System.out.println();
		}
	}
	
	public static void inorder_traverse(Node T) {
		if(T != null) {
			inorder_traverse(T.l);
			System.out.print(T.alph);
			inorder_traverse(T.r);
		}		
	}
	
	static class Node{
		char alph;
		int v;
		Node l, r;

		Node(int v, char alph){
			this.alph = alph;
			this.v = v;
		}
	}
}
