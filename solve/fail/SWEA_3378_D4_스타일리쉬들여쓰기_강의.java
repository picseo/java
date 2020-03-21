package fail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 알고리즘을 잘 하려면.....
 * 
 * 프로그럄언어 문법 IM AD
 * IDE 이클립스(자동완성, 디버깅, 템플릿)
 * 독해능력(문제 분석)
 * 코드분석
 * 
 *  구현 능혁:생각의 절차를 코드로 옮기기
 *  삼성 역량테스트 : 백준
 *  카카오 : 프로그래머스
 *  
 *  자료구조
 *  알고리즘 설계기법
 *  
 *  최적화 : 입출력, 변수, 메서드
 *  
 *  알고리즘: 시간 > 공간
 *  
 *  수학공식
 *  
 * */


/*
 * 문제 관련 
 * 
 * 3원 1차 방정식
 * 
 * 소거법, 대입법
 * 
 * 크 --- 진짜 일단은 완탄을 할 수 있는지부터!!!!!!!!확인해랏!!!!!!!!!!!!!!!
 * 
 * 
 * */
public class SWEA_3378_D4_스타일리쉬들여쓰기_강의 {
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
					
			m = new int[p][4];//., 소, 중 , 대 괄호
			for(int i = 0; i < p ; i++) {
				String line = br.readLine();//한줄을 입력받아서
				//앞부분에 나온 .의개수
				int index = 0;
				while(line.charAt(index) == '.') {
					index++;
				}
				//마스터의 코드 분석
				m[i][0] = index;
				
				//괄호의 개수는 누적처리
				if(i > 0) {
					m[i][1] = m[i-1][1];//소괄호
					m[i][2] = m[i-1][2];//중괄호
					m[i][3] = m[i-1][3];//대괄호
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
			}//마스터의 스타일리쉬 코드 분석  for
			
			//내 코드 분석
			ans = new int[q][4];//., 소, 중 , 대 괄호
			for(int i = 0; i < q ; i++) {
				String line = br.readLine();//한줄을 입력받아서
				//앞부분에 나온 .의개수
				int index = 0;

				//괄호의 개수는 누적처리
				if(i > 0) {
					ans[i][1] = ans[i-1][1];//소괄호
					ans[i][2] = ans[i-1][2];//중괄호
					ans[i][3] = ans[i-1][3];//대괄호
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
			}//내 코드  for
			
			//ans[i][0] : 초기값 0 -> -2 : .의 갯수를 몇개 들어써야 하는지
			for(int i = 0; i < q; i++) {
				ans[i][0] = -2;//안쓰는 값으로 초기화
			}
			
			//중복 순열
			for(int R = 1; R <= 20; R++) {
				for(int C = 1; C <= 20; C++) {
					for(int S = 1; S <= 20; S++) {
						if(check(R, C, S)) {
							//마스터 코드에서 해가 되는가?
							cal(R, C, S);
						}
					}
				}
			}
		
			sb.append("#").append(t).append(" 0");//첫번째 줄의 들여쓰기는 0으로 일정
			for(int i =0 ; i < ans.length; i++) {
				sb.append(' ').append(ans[i][0]);
			}
			sb.append("\n");
		
		}	
		System.out.println(sb);
	}//end of main

	/**
	 * 내코드에서 들여쓰기를 각 라인에 몇개씩 해야 하는지 구해서 저장하자
	 * */
	
	private static void cal(int r, int c, int s) {
		for (int i = 1; i < ans.length; i++) {
			int x =  ans[i-1][1]*r + ans[i-1][2]*c + ans[i-1][3]*s;
			if(ans[i][0] == -2) {
				//답을 구한 적이 없으면
				ans[i][0] = x;
			}else if(ans[i][0] != x) {
				//기존 값이랑 다른 경우 -> 답이 아님 -> 유일한 해가 아니다.
				ans[i][0] = -1;
			}
		}		
	}



	/*
	 * 마스터 코드에서 해가 되는지 체크해서 리턴
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
