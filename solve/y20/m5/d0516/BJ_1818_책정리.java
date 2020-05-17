package d0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1818
/*

LIS문제 이긴 했는데 이전에 알던 DP는 시간복잡도가 N^2이라서 시간초과에 걸렸다.

이분제는 LIS를 해당 위치까지 존재하는 길이의 부분수열중에서 마지막 값이 가장 작은 값을 저장하는 배열을
만들고, 매번 입력되는 값이 들어갈 위치를 이진탐색을 사용해서 들어갈 위치를 찾는 문제였다.
 * */	
public class BJ_1818_책정리 {
	static int N;//N(1 ≤ N ≤ 200,000)
	static int[] inputs;
	static int[] LIS_min;		
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		inputs = new int[N];
		LIS_min = new int[N+1];//해당 길이의 가장 작은 마지막 값
		Arrays.fill(LIS_min, Integer.MAX_VALUE);
		LIS_min[0]  = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		int len = 1;
		int cnt = 0;
		LIS_min[len] = inputs[0];
		for(int i = 1; i < N; i++) {
			int now = inputs[i];
			
			if(LIS_min[len] < now) {
				len++;
				LIS_min[len] = now;
			}else {
				int ans = find(1, len, now);
				//System.out.println("ans : " + ans);
				LIS_min[ans] = now;
				cnt++;
			}
			
			//System.out.println(Arrays.toString(LIS_min));
		}

		int result = cnt;
		System.out.println(result);
	}

	private static int find(int low, int high, int now) {
		int mid;
		
		while(high - low > 0) {
			mid = (low+high)/2;
			
			if(LIS_min[mid] < now) {
				low = mid + 1;
			}else {
				high = mid;
			}
		}
		return high;		
	}

}
