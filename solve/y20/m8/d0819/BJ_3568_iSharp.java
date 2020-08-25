package d0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 �������δ� �ѱ����� ������ �־ ���ڱ��̰� �涧 ����� �̻��ϰ� ������ִ°�
 ���� ���ߴ�
 
 �� �׽�Ʈ���̽� �����ؼ� �Ẹ��!!
 
 (���ڿ�, �Ľ�)
 * */
public class BJ_3568_iSharp {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String basic = st.nextToken();
		StringBuilder sb = new StringBuilder();
		
		while(st.hasMoreTokens()) {
			sb.append(basic);
			String now = st.nextToken();
			
			for(int i = now.length()-1; i>=0; i--) {
				char cnow = now.charAt(i);
				
				if(cnow == '&' || cnow == '*') {
					sb.append(cnow);
				}else if(cnow == ']' || cnow == ';' || cnow == ',') {
					continue;
				}else if(cnow == '[') {
					sb.append("[]");
				}else if(cnow >= 'a' && cnow <= 'z' || cnow >='A' && cnow <= 'Z'){
					sb.append(" " + now.substring(0, i+1) + ";\n");
					break;
				}
			}
		}
		
		System.out.println(sb.toString());

	}

}
