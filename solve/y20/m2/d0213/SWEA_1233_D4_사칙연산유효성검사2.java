package solve.s0213;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//�̰� tree�� �о�� checkOk�Լ����� true, false���� �����Ͽ�
//������ �������� �ƴ����� Ȯ�����ִ� �Լ����µ�
//�ű��ϰ� ������ �ƿ�ǲ�� �� ���� ������
//Ȯ���� �ߴ� ���� Ǯ�̰� �ð��� �� ������.
 
public class SWEA_1233_D4_��Ģ������ȿ���˻�2 {
	private static Node[] tree = new Node[201];
	private static String opers = "/+*-";
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
			boolean result = checkOk(tree[1]);			
			if(result) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

	private static boolean checkOk(Node T) {
		if(T != null) {
			char now = T.ch;
			
			if(opers.indexOf(now) >= 0) {
				//���簡 ������
				if(T.l == null || T.r == null) {
					return false;
				}
			}else {
				//���簡 ����
				if(T.l != null || T.r != null) {
					return false;
				}
			}
			
			if(!checkOk(T.l))
				return false;
		
			if(!checkOk(T.r))
				return false;
		}

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
