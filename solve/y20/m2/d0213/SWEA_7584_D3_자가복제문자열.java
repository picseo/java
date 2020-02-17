package algo_basic.SWEA.d0213;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_7584_D3_자가복제문자열 {
	public static boolean[] toten9 = new boolean[100000001];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res\\sinput.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		int len = 1;
		toten9[0] = false;
		
		while(idx < 10) {
			toten9[idx] = false;
			for(int i = 1; i <= len; i++) {
				toten9[idx + i] = !toten9[idx-i]; 
			}		
			
			idx += (len+1);
			len = len*2 + 1;

		}
		System.out.println(Arrays.toString(toten9));
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
		}
	}
}

/*
4
3
7
10
100000
*/