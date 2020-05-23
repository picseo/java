package d0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 각 열의 돌이 위치할 곳을 저장하고 이용하는 방법인데
 각행의 열마다 위치를 저장하는게 너무 헷갈린데 근데 이렇게 하면 시간이 훅줄어든다!!!!!!************
 * */
public class BJ_3025_돌던지기 {
	static int R, C;
	static char[][] map;
	
	static int[] wr;
	static int[][] wc;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		wc = new int[C+1][R+1];
		wr = new int[C+1];
		for(int i = 0; i < C; i++) {
			wc[i][0] = i;
			wr[i] = 1;
			setting(i);//채울 곳을 설정
		}
//		
//		System.out.println(Arrays.toString(wr));
//		System.out.println();
//		for(int[] row : wc) {
//			System.out.println(Arrays.toString(row));
//			System.out.println();
//		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t =0 ; t < T; t++) {
			int s = Integer.parseInt(br.readLine())-1;
			
			int row = wr[s]-1;
			int col = wc[s][row];
			map[row][col] = 'O';
			
//			for(char[] rr : map) {
//				System.out.println(rr);
//			}
			
			for(int i = 0; i < C; i++) {
				setting(i);//채울 곳을 설정
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j =0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void setting(int s) {
		while(true) {
			int col = wc[s][wr[s]-1];
			
			if(wr[s] > 1 && map[wr[s]-1][col] != '.') {
				--wr[s]; continue;
			}
			
			if(wr[s] == R) break;
			
			if(map[wr[s]][col] == 'X') {break;}
			
			if(map[wr[s]][col] == '.') {
				wc[s][wr[s]++] = col;
			}else {
				if(col >0 && map[wr[s]][col-1] == '.' && map[wr[s]-1][col-1] == '.') {
					wc[s][wr[s]++] = col-1;
				}else if(col+1<C && map[wr[s]][col+1] == '.' && map[wr[s]-1][col+1] == '.') {
					wc[s][wr[s]++] = col+1;
				}else {
					break;
				}
			}
		}
	}
	
	
}
