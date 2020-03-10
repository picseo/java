package d0306;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_¹ú²ÜÃ¤Ãë {
	static int N, M, C;
	static int[][] map;
	static int[] maxmap;
	static int result = 0;
	static int[] num;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t= 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			maxmap = new int[N*(N-M+1)];
			result = Integer.MIN_VALUE;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			makeMax();
			//System.out.println(Arrays.toString(maxmap));


			findMax(2, 0, new int[2], 0);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void findMax(int n, int cur, int[] tmp, int idx) {
		if(n == cur) {
			if((tmp[0]/(N-M+1)) == (tmp[1]/(N-M+1)) && tmp[0]+M-1 >= tmp[1]) {
				return;
			}
			
			int tmpres = maxmap[tmp[0]] + maxmap[tmp[1]];
//			System.out.println("result : " + result);
//			System.out.println("( "+tmp[0] +", "+tmp[1]+" ) : " + tmpres);
			if(result < tmpres) {
				result = tmpres;
			}
			return;
		}else {
			for(int i = idx; i < N*(N-M+1); i++) {
				tmp[cur] = i;
				findMax(n, cur+1, tmp, i+1);
			}
		}
	}
	
	private static void makeMax() {
		for(int r = 0; r < N; r++) {//row
			for(int i = 0; i < N-M+1; i++) {//row³»ÀÇ À§Ä¡
				int max = Integer.MIN_VALUE;
				for(int j = 1; j < (1<<M); j++) {
					int tmpc = 0;
					int tmp = 0;
					for(int k = 0; k < M ; k++) {
						if((j & (1 << k)) > 0) {
							tmp += map[r][i+k]* map[r][i+k];
							tmpc += map[r][i+k];
						}
					}
					if(tmpc <= C){
						if(max < tmp) {
							max = tmp;
						}
					}
				}
				maxmap[r*(N-M+1) + i] = max;
			}
		}
		
	}

	private static String src = "10\r\n" + 
			"4 2 13\r\n" + 
			"6 1 9 7\r\n" + 
			"9 8 5 8\r\n" + 
			"3 4 5 3\r\n" + 
			"8 2 6 7\r\n" + 
			"3 3 10\r\n" + 
			"7 2 9\r\n" + 
			"6 6 6\r\n" + 
			"5 5 7\r\n" + 
			"4 1 10\r\n" + 
			"8 1 8 2\r\n" + 
			"4 6 1 6\r\n" + 
			"4 9 6 3\r\n" + 
			"7 4 1 3\r\n" + 
			"4 3 12\r\n" + 
			"8 8 6 5\r\n" + 
			"5 2 7 4\r\n" + 
			"8 5 1 7\r\n" + 
			"7 8 9 4\r\n" + 
			"5 2 11\r\n" + 
			"7 5 9 9 6\r\n" + 
			"7 3 7 9 3\r\n" + 
			"1 7 1 4 5\r\n" + 
			"1 7 9 2 6\r\n" + 
			"6 6 8 3 8\r\n" + 
			"6 3 20\r\n" + 
			"8 5 2 4 3 1\r\n" + 
			"4 3 6 1 1 8\r\n" + 
			"4 4 1 2 3 1\r\n" + 
			"1 7 4 9 6 1\r\n" + 
			"6 5 1 2 8 4\r\n" + 
			"3 1 4 5 1 3\r\n" + 
			"7 2 11\r\n" + 
			"2 8 2 5 2 8 6\r\n" + 
			"2 3 7 4 6 4 8\r\n" + 
			"3 7 8 3 9 4 4\r\n" + 
			"8 8 5 9 3 6 9\r\n" + 
			"9 7 6 2 4 1 3\r\n" + 
			"2 9 2 8 9 7 3\r\n" + 
			"2 1 7 2 7 8 3\r\n" + 
			"8 3 12\r\n" + 
			"9 1 6 7 5 4 6 7\r\n" + 
			"9 5 1 8 8 3 5 8\r\n" + 
			"5 2 6 8 6 9 2 1\r\n" + 
			"9 2 1 8 7 5 2 3\r\n" + 
			"6 5 5 1 4 5 7 2\r\n" + 
			"1 7 1 8 1 9 5 5\r\n" + 
			"6 2 2 9 2 5 1 4\r\n" + 
			"7 1 1 2 5 9 5 7\r\n" + 
			"9 4 20\r\n" + 
			"5 2 4 8 3 7 6 2 1\r\n" + 
			"7 9 8 5 8 2 6 3 6\r\n" + 
			"1 9 4 6 7 5 3 1 1\r\n" + 
			"4 4 7 6 2 2 8 1 7\r\n" + 
			"9 6 8 5 7 3 7 9 5\r\n" + 
			"7 3 1 4 1 1 8 5 3\r\n" + 
			"4 6 8 9 4 5 3 8 8\r\n" + 
			"1 3 4 2 4 1 1 3 6\r\n" + 
			"5 9 2 3 5 2 4 8 5\r\n" + 
			"10 5 30\r\n" + 
			"7 4 7 5 9 3 6 4 6 7\r\n" + 
			"8 9 8 4 5 7 8 9 2 9\r\n" + 
			"6 5 3 4 6 4 7 6 3 2\r\n" + 
			"4 7 4 3 4 7 3 3 4 3\r\n" + 
			"3 5 6 4 8 8 2 1 8 6\r\n" + 
			"3 7 9 7 1 7 6 2 8 9\r\n" + 
			"3 6 1 6 8 9 7 7 5 1\r\n" + 
			"4 3 5 6 2 1 2 6 3 6\r\n" + 
			"3 4 9 2 1 5 9 9 6 3\r\n" + 
			"9 9 7 3 7 5 5 5 8 4\r\n" + 
			"";
}
