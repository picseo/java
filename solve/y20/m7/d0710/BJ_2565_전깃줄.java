package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 LIS(Longest increasing substring?)
 증가하는 가장 긴 수열을 찾는 문제였다.
 
 입력되는게 A전기줄을 기준으로 정렬되서 들어오지 않아서 
 전기줄이 있을 수 있는 값(1~500)을 모두 받을 수 있는 배열을 만들어서 저장하였다.
 
 그리고 A는 정렬이 되어있으므로, 줄이 연결되어있는 경우에 현재 줄보다 최대값이 작은 memo의 값중에서
 값이 가장 큰걸 골라서 값을 갱신하였다.
 값을 바꾸어주면서  Max값도 필요할때마다 업데이트 해주었다.
 
 그런 후에 총 전깃줄 갯수에서 - Max를 해서 없애야 하는 최솟값을 구하는 방법을 사용하였다. 
 */
public class BJ_2565_전깃줄 {
	static int[][] lines = new int[501][2];
	static int[][] memo = new int[501][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int Max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			lines[from][0] = from; 
			lines[from][1] = to;
		}
		
		for(int i = 1; i <501; i++) {
			if(lines[i][0] == 0) {
				continue;
			}
			
			memo[i][1] = lines[i][1];
			memo[i][0] = 1;
			
			for(int j = i-1; j >=0 ; j--) {
				if(lines[j][0] == 0 || memo[j][1] > lines[i][1]) {
					continue;
				}
				
				memo[i][0] = Math.max(memo[j][0]+1, memo[i][0]);
			}
			
			Max = Math.max(memo[i][0], Max);
		}
		
		int result = N - Max;
		System.out.println(result);
	}

}
