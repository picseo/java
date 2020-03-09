package solve.s0213;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 //recur을 이용해서 해결하고 싶었는데
//못하겠어서 tree를 쭉 읽어 string을 만들고
//홀수번째에는 숫자, 짝수번째에는 연산자가 있는지를 확인하였다.
public class SWEA_1233_D4_사칙연산유효성검사 {
	private static Node[] tree = new Node[201];
	private static String opers = "/+*-";
	private static StringBuilder sb = new StringBuilder();
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
					if(v==1) {
						tree[v]  = new Node(v, op);
						tree[lnum] = new Node(lnum, 'a');
						tree[v].l = tree[lnum];
						tree[rnum] = new Node(rnum, 'a');
						tree[v].r = tree[rnum];
					}else {
						tree[v].ch = op;
						tree[lnum] = new Node(lnum, 'a');
						tree[v].l = tree[lnum];
						tree[rnum] = new Node(rnum, 'a');
						tree[v].r = tree[rnum];
					}
				}else if(what == 3) {
					if(i == 0) {
						tree[v]  = new Node(v, op);
						tree[lnum] = new Node(lnum, 'a');
						tree[v].l = tree[lnum];
					}else {
						tree[v].ch = op;
						tree[lnum] = new Node(lnum, 'a');
						tree[v].l = tree[lnum];
					}
				}else if(what == 2) {
					if(i == 0) {
						tree[v]  = new Node(v, op);
					}else {
						tree[v].ch = op;
					}
				}
			}
			
			System.out.print("#"+t+" ");
			checkOk(tree[1]);
			String output = sb.toString();
			//System.out.println(output);
			sb.delete(0,sb.length());
			boolean result = true;
			for(int i =0 ; i <output.length(); i++) {
				if(i%2 == 0) {
					if(opers.indexOf(output.charAt(i)) >= 0) {
						result = false;
						break;
					}
				}else {
					if(output.charAt(i) >= '0' && output.charAt(i) <= '9') {
						result = false;
						break;
					}
				}
			}
			
			if(result) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			/*if(checkOk(tree[1])) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}*/
		}
	}

	private static void checkOk(Node T) {
		if(T != null) {
			char now = T.ch;
			/*
			if(opers.indexOf(now) >= 0) {
				//현재가 연산자
				if(T.l == null || T.r == null) {
					return false;
				}
			}else {
				//현재가 숫자
				if(T.l != null || T.r != null) {
					return false;
				}
			}*/
			
			/*if(T.l == null && T.r==null) {
				if(opers.indexOf(now) >= 0) {
					return false;
				}
			}else {
				if(now >= '0' && now <= '9') {
					if(T.l != null && opers.indexOf(T.l.ch) >= 0) {
						return false;
					}
					if(T.r != null && opers.indexOf(T.r.ch) >= 0) {
						return false;
					}
				}
			}*/
			
			checkOk(T.l);
			sb.append(now);
			checkOk(T.r);
		}
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
