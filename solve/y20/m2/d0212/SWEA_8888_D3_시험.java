package algo_basic.SWEA.d0212;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 인풋을 빨리 받는 방법을 알게해주는 문제였다.
 * Scanner보다 bufferedReader가 훨씬 빠르다.
 * 
 * **/
public class SWEA_8888_D3_시험 {
	private static int[] scores;
	private static int[] hows;
	private static int[] p_scores;
	private static int[][] input;
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res\\8888.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = null;
			
			st = new StringTokenizer(br.readLine());
			int nn = Integer.parseInt(st.nextToken());//input1.charAt(0) - '0';
			int tt = Integer.parseInt(st.nextToken());//input1.charAt(2) - '0';
			int pp = Integer.parseInt(st.nextToken())-1;//input1.charAt(4) - '0' - 1;
			
			scores = new int[tt];//각 문제의 점수
			hows = new int[nn]; //각 사람들이 문제 푼 횟수
			p_scores = new int[nn]; //각 사람들의 문제 푼 회수
			input = new int[nn][tt];
			
			//input 입력 받기, 각 문제의 점수 찾기
			for(int i = 0; i < nn; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < tt; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
					if(input[i][j] == 0) {
						scores[j]++;
					}
				}
			}
			
			/*for(int[] a : input) 
				System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(scores));
*/
			//각 사람들이 문제 푼 횟수, 각 사람들의 점수
			for(int i = 0; i < nn; i++) {
				int how = 0;
				int p_score = 0;
				for(int j = 0; j < tt; j++) {
					if(input[i][j] == 1) {
						how++;
						p_score += scores[j];
					}
				}
				hows[i] = how;
				p_scores[i] = p_score;
			}
			
			
			/*System.out.println(Arrays.toString(hows));
			System.out.println(Arrays.toString(p_scores));
*/
			//지학이의 등수 계산
			int ji_score = p_scores[pp];
			int ji_grade = 1;
			for(int i = 0; i < nn; i++) {
				if(i == pp) {
					continue;
				}
				if(p_scores[i] > ji_score) {
					ji_grade++;
				}else if(p_scores[i] == ji_score) {
					if(hows[i] > hows[pp]) {
						ji_grade++;
					}else if(hows[i] == hows[pp]) {
						if(i < pp) {
							ji_grade++;
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(ji_score).append(" ").append(ji_grade).append("\n");
		}//testcase
		System.out.println(sb.toString());
	}	
}