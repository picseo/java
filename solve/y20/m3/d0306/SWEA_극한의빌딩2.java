package d0306;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;
/*아른사람코드*/
public class SWEA_극한의빌딩2 {
	static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String num1 = st.nextToken();
			String num2 = st.nextToken();

			result = solve(num2) - solve(num1);
			if(num1.charAt(0) == '-' && num2.charAt(0) != '-')
				result--;
			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
	}

	public static long solve(String tmp){
		int i = 0;
		long test = 0;
		boolean minus = false;
		if(tmp.charAt(0) == '-'){
			i = 1;
			minus = true;
		}
		for (int leng = tmp.length(); i < leng; i++) {
			int notFour = tmp.charAt(i) - '0';
			notFour = notFour >= 4 ? notFour - 1 : notFour;
			test += (notFour) * (long)Math.pow(9, leng - i - 1);
		}
		if(minus) test = -test;
		return test;
	}


	private static String src =
			"4\r\n" + 
					"-1 999999999999\r\n" + 
					"-10 999999999999\r\n" + 
					"-999999999999 10\r\n"+
					"-999999999999 1";
}
