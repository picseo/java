package d0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
//답은 맞았는데, for문 3개보다 재귀를 사용하는게 더 빠르게 계산된다.
public class BJ_2422_한이가아사 {
	static int N, M;
	static boolean[][] never = new boolean[201][201];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
		
			never[from][to] = true;
			never[to][from] = true;
		}
		
		int result = 0;
		for(int i = 1; i <= N-2; i++) {
			for(int j = i+1; j <= N-1; j++) {
				if(never[i][j]) {
					continue;
				}
				for(int k = j+1; k <= N; k++) {
					if(never[i][k] || never[j][k]) {
						continue;
					}else {
						result++;
					}
				}
			}
		}
		
		System.out.println(result);		
	}
}

/*
 * 메인함수에서
 	for(int i= 0;i<=N-LIMIT;i++) {//0(+1)부터 N-3(+1)까지
			find(i+1, i+1, 1);
		}
		System.out.println(answer);
	
	호출하는 재귀함수
	void find(int num1, int curNum, int count) {
		if(count == LIMIT) {
			answer++;
			return;
		}else {
			for(int i = curNum+1;i<=N;i++) {//현재값+1 부터 N까지
				if(!forbid[num1][i] && !forbid[curNum][i]) {//금지된 조합이 아니라면
					find(num1, i, count+1);//첫번째값은 고정, 다음값 넣고, 숫자개수 하나 증가해줌
				}
			}
		}
	}
 * */
