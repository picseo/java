package solve.s0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
/*for문으로 list를 읽으려고 했는데
 * HashSet을 이용하니가 통과했다.
 * 중복이 필요없고, 있나 없나 확인만 하는건 HashSet을 써야 겠다.*/
public class SWEA_2948_D3_문자열교집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first_n = Integer.parseInt(st.nextToken());
			int second_n = Integer.parseInt(st.nextToken());
			
			HashSet<String> first = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < first_n; i++) {
				first.add(st.nextToken());
			}
			
			int result = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < second_n; i++) {
				String now = st.nextToken();
				if(first.contains(now)) {
					//System.out.println("contains : " + now);
					result++;
					first.remove(now);
				}
			}			
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static String src = "2\r\n" + 
			"2 3\r\n" + 
			"ab a\r\n" + 
			"a ac ba\r\n" + 
			"3 3\r\n" + 
			"aa bb cc\r\n" + 
			"dd cc aa";
}
