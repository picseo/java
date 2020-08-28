package d0812;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 N개의 알약이 있을 때
 한 조각을 꺼내면 W | 반조각을 꺼내면 H
 2N일이 지났을 때 가능한 서로 다른 문자열의 갯수

 -> 중복순열인가?
 */
public class BJ_4811_알약 {
	static long[][] memo = new long[31][31];
	long result = 0;
	//-1: 확인 안함 , 0 : 안됨, 1 : 됨
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(long[] b : memo) {
			Arrays.fill(b, -1);
		}
		
		while(true) {
			int now = Integer.parseInt(br.readLine());
			
			if(now == 0) {
				break;
			}
			
			if(memo[now][0] != -1) {
				System.out.println(memo[now][0]);
			}else {
				System.out.println(find(now, 0));
			}
		}
	}
	
	
	/*
	 빠른 코드와 비교해보자
	 
	 static long go(int f, int h) {
		if (dp[f][h] != -1) return dp[f][h];
		if (f == 0) {
			return 1;
		} else if (h == 0) {
			return dp[f][h] = go(f-1, h+1);
		} else {
			return dp[f][h] = go(f-1, h+1) + go(f, h-1);
		}
	}
	 
	 *f가 0이면 바로 1을 return해서 계산 수가 작다
	 *나는 -1이 나올까봐 확인하는 과정을 거쳤는데, 다시 생각해보니 계산을 한 뒤에는 무조건 0이상이므로
	 *그럴필요가 없다
	 * */
	private static long find(int one, int half) {
		long ans = memo[one][half];
		
		if(one + half == 0) {
			return 1;
		}
		
		if(ans != -1) {
			return ans;
		}
		
		memo[one][half] = 0;
		if(one > 0 && find(one-1, half+1) >= 1) {
			memo[one][half] += find(one-1, half+1);
		}
		
		if(half > 0 && find(one, half-1) >= 1) {
			memo[one][half] +=  find(one, half-1);
		}
		
		return memo[one][half];
	}

}
