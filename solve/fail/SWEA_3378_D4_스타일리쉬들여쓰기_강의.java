package fail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * �˰����� �� �Ϸ���.....
 * 
 * ���α׎c��� ���� IM AD
 * IDE ��Ŭ����(�ڵ��ϼ�, �����, ���ø�)
 * ���شɷ�(���� �м�)
 * �ڵ�м�
 * 
 *  ���� ����:������ ������ �ڵ�� �ű��
 *  �Ｚ �����׽�Ʈ : ����
 *  īī�� : ���α׷��ӽ�
 *  
 *  �ڷᱸ��
 *  �˰��� ������
 *  
 *  ����ȭ : �����, ����, �޼���
 *  
 *  �˰���: �ð� > ����
 *  
 *  ���а���
 *  
 * */


/*
 * ���� ���� 
 * 
 * 3�� 1�� ������
 * 
 * �ҰŹ�, ���Թ�
 * 
 * ũ --- ��¥ �ϴ��� ��ź�� �� �� �ִ�������!!!!!!!!Ȯ���ض�!!!!!!!!!!!!!!!
 * 
 * 
 * */
public class SWEA_3378_D4_��Ÿ�ϸ����鿩����_���� {
	static int[][] m;
	static int[][] ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
					
			m = new int[p][4];//., ��, �� , �� ��ȣ
			for(int i = 0; i < p ; i++) {
				String line = br.readLine();//������ �Է¹޾Ƽ�
				//�պκп� ���� .�ǰ���
				int index = 0;
				while(line.charAt(index) == '.') {
					index++;
				}
				//�������� �ڵ� �м�
				m[i][0] = index;
				
				//��ȣ�� ������ ����ó��
				if(i > 0) {
					m[i][1] = m[i-1][1];//�Ұ�ȣ
					m[i][2] = m[i-1][2];//�߰�ȣ
					m[i][3] = m[i-1][3];//���ȣ
				}
				
				for(int j = index; j < line.length(); j++) {
					switch(line.charAt(j)) {
					case '(' : m[i][1]++; break;
					case ')' : m[i][1]--; break;
					case '{' : m[i][2]++; break;
					case '}' : m[i][2]--; break;
					case '[' : m[i][3]++; break;
					case ']' : m[i][3]--; break;
					}
				}
			}//�������� ��Ÿ�ϸ��� �ڵ� �м�  for
			
			//�� �ڵ� �м�
			ans = new int[q][4];//., ��, �� , �� ��ȣ
			for(int i = 0; i < q ; i++) {
				String line = br.readLine();//������ �Է¹޾Ƽ�
				//�պκп� ���� .�ǰ���
				int index = 0;

				//��ȣ�� ������ ����ó��
				if(i > 0) {
					ans[i][1] = ans[i-1][1];//�Ұ�ȣ
					ans[i][2] = ans[i-1][2];//�߰�ȣ
					ans[i][3] = ans[i-1][3];//���ȣ
				}

				for(int j = index; j < line.length(); j++) {
					switch(line.charAt(j)) {
					case '(' : ans[i][1]++; break;
					case ')' : ans[i][1]--; break;
					case '{' : ans[i][2]++; break;
					case '}' : ans[i][2]--; break;
					case '[' : ans[i][3]++; break;
					case ']' : ans[i][3]--; break;
					}
				}
			}//�� �ڵ�  for
			
			//ans[i][0] : �ʱⰪ 0 -> -2 : .�� ������ � ����� �ϴ���
			for(int i = 0; i < q; i++) {
				ans[i][0] = -2;//�Ⱦ��� ������ �ʱ�ȭ
			}
			
			//�ߺ� ����
			for(int R = 1; R <= 20; R++) {
				for(int C = 1; C <= 20; C++) {
					for(int S = 1; S <= 20; S++) {
						if(check(R, C, S)) {
							//������ �ڵ忡�� �ذ� �Ǵ°�?
							cal(R, C, S);
						}
					}
				}
			}
		
			sb.append("#").append(t).append(" 0");//ù��° ���� �鿩����� 0���� ����
			for(int i =0 ; i < ans.length; i++) {
				sb.append(' ').append(ans[i][0]);
			}
			sb.append("\n");
		
		}	
		System.out.println(sb);
	}//end of main

	/**
	 * ���ڵ忡�� �鿩���⸦ �� ���ο� ��� �ؾ� �ϴ��� ���ؼ� ��������
	 * */
	
	private static void cal(int r, int c, int s) {
		for (int i = 1; i < ans.length; i++) {
			int x =  ans[i-1][1]*r + ans[i-1][2]*c + ans[i-1][3]*s;
			if(ans[i][0] == -2) {
				//���� ���� ���� ������
				ans[i][0] = x;
			}else if(ans[i][0] != x) {
				//���� ���̶� �ٸ� ��� -> ���� �ƴ� -> ������ �ذ� �ƴϴ�.
				ans[i][0] = -1;
			}
		}		
	}



	/*
	 * ������ �ڵ忡�� �ذ� �Ǵ��� üũ�ؼ� ����
	 * */
	private static boolean check(int r, int c, int s) {
		for (int i = 1; i < m.length; i++) {
			if(m[i][0] != m[i-1][1]*r + m[i-1][2]*c + m[i-1][3]*s) {
				return false;
			}
		}
		return true;
	}



	private static String src = "9\r\n" + 
			"5 4\r\n" + 
			"(Follow.my.style\r\n" + 
			".........starting.from.round.brackets)\r\n" + 
			"{then.curly.brackets\r\n" + 
			".....[.and.finally\r\n" + 
			".......square.brackets.]}\r\n" + 
			"(Thank.you\r\n" + 
			"{for.showing.me\r\n" + 
			"[all\r\n" + 
			"the.secrets]})\r\n" + 
			"4 2\r\n" + 
			"(This.time.I.will.show.you\r\n" + 
			".........(how.to.use.round.brackets)\r\n" + 
			".........[but.not.about.square.brackets]\r\n" + 
			".........{nor.curly.brackets})\r\n" + 
			"(I.learned\r\n" + 
			"how.to.use.round.brackets)\r\n" + 
			"4 2\r\n" + 
			"(This.time.I.will.show.you\r\n" + 
			".........(how.to.use.round.brackets)\r\n" + 
			".........[but.not.about.square.brackets]\r\n" + 
			".........{nor.curly.brackets})\r\n" + 
			"[I.have.not.learned\r\n" + 
			"how.to.use.square.brackets]\r\n" + 
			"2 2\r\n" + 
			"(Be.smart.and.let.fear.of\r\n" + 
			"..(closed.brackets).go)\r\n" + 
			"(A.pair.of.round.brackets.enclosing\r\n" + 
			"[A.line.enclosed.in.square.brackets])\r\n" + 
			"1 2\r\n" + 
			"Telling.you.nothing.but.you.can.make.it\r\n" + 
			"[One.liner.(is).(never.indented)]\r\n" + 
			"[One.liner.(is).(never.indented)]\r\n" + 
			"2 4\r\n" + 
			"([{Learn.from.my.KungFu\r\n" + 
			"...}])\r\n" + 
			"((\r\n" + 
			"{{\r\n" + 
			"[[\r\n" + 
			"]]}}))\r\n" + 
			"1 2\r\n" + 
			"Do.not.waste.your.time.trying.to.read.from.emptiness\r\n" + 
			"(\r\n" + 
			")\r\n" + 
			"2 3\r\n" + 
			"({Quite.interesting.art.of.ambiguity\r\n" + 
			"....})\r\n" + 
			"{\r\n" + 
			"(\r\n" + 
			")}\r\n" + 
			"2 4\r\n" + 
			"({[\r\n" + 
			"............................................................]})\r\n" + 
			"(\r\n" + 
			"{\r\n" + 
			"[\r\n" + 
			"]})";
}//end of class
