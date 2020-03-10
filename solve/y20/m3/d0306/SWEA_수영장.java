package d0306;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_¼ö¿µÀå {
	static int[] prices = new int[4];
	static int[] days = new int[12];
	static int[] min = new int[12];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = prices[3];
			int tmp = 0;
			for(int i = 0; i < 12; i++) {
				min[i] = Math.min(prices[0]*days[i], prices[1]);
				tmp += min[i];
			}
			if(result > tmp)
				result = tmp;
			
			for(int i = 0; i < (1<<12);i++) {
				tmp = 0;
				boolean[] check = new boolean[12];
				
				for(int j = 0; j < 12; j++) {
					if((i & (1<<j)) > 0) {
						if(j < 10) {
							for(int k =0; k < 3; k++) {
								check[j+k] = true;
							}
						}else {
							if(j == 10) {
								check[j+1] = true;
							}
							check[j] = true;
						}
						tmp += prices[2];
					}
				}
				
				for(int j = 0; j < 12; j++) {
					if(!check[j]) {
						tmp += min[j];
					}
				}
				
				if(result > tmp)
					result = tmp;			
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static String src = "10\r\n" + 
			"10 40 100 300\r\n" + 
			"0 0 2 9 1 5 0 0 0 0 0 0\r\n" + 
			"10 100 50 300\r\n" + 
			"0 0 0 0 0 0 0 0 6 2 7 8\r\n" + 
			"10 70 180 400\r\n" + 
			"6 9 7 7 7 5 5 0 0 0 0 0\r\n" + 
			"10 70 200 550\r\n" + 
			"0 0 0 0 8 9 6 9 6 9 8 6\r\n" + 
			"10 80 200 550\r\n" + 
			"0 8 9 15 1 13 2 4 9 0 0 0\r\n" + 
			"10 130 360 1200\r\n" + 
			"0 0 0 15 14 11 15 13 12 15 10 15\r\n" + 
			"10 180 520 1900\r\n" + 
			"0 18 16 16 19 19 18 18 15 16 17 16\r\n" + 
			"10 100 200 1060\r\n" + 
			"12 9 11 13 11 8 6 12 8 7 15 6\r\n" + 
			"10 170 500 1980\r\n" + 
			"19 18 18 17 15 19 19 16 19 15 17 18\r\n" + 
			"10 200 580 2320\r\n" + 
			"12 28 24 24 29 25 23 26 26 28 27 22";
}
