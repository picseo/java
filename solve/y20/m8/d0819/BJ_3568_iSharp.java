package d0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 조건으로는 한글자인 변수명만 주어서 글자길이가 길때 결과를 이상하게 출력해주는걸
 보지 못했다
 
 꼭 테스트케이스 생각해서 써보기!!
 
 (문자열, 파싱)
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
