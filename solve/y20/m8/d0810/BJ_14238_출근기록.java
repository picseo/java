package d0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//재귀를 이용해서 구현했는데 시간 초과가 나온다.
//어떻게 시간을 줄일 수 있을까

//재귀로 푸는거는 맞았는데, memoization을 생각하지 않아서 중복계산 때문에 시간초과가 발생했나보다
public class BJ_14238_출근기록 {
	static char[] S;
	static int[] count = new int[3];
	static int[][][][][] memo = new int[51][51][51][3][3];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine().toCharArray();

		for(char now : S) {
			count[now-'A']++;
		}
		
		//재귀를 쓰면 시간초과!!!!!
		/*char[] result = new char[S.length];
		if(!recur(result, 0, 0, 0)) {
			System.out.print(-1);
		}
		System.out.println();
		return;*/
		
		//배열을 사용해서  값을 저장하며진행하자(5차원 배열)
		//int[][][][][] memo = new int[51][51][51][3][3];
		
		for(int i = 0; i < 51; i++) {
			for(int j = 0; j < 51; j++) {
				for(int k = 0; k < 51; k++) {
					for(int l = 0; l < 3; l++) {
						Arrays.fill(memo[i][j][k][l], -1);
					}
				}
			}
		}
		
		int ans = go(count[0], count[1], count[2], 0, 0);
		if(ans == 0) {
			System.out.println(-1);
		}else {
			System.out.println(back(count[0], count[1], count[2], 0, 0));
		}
		
	}

	private static String back(int a, int b, int c, int p1, int p2) {
		if(a+b+c == 0) {
			return "";
		}
		

		if(a > 0 && go(a-1, b, c, 0, p1) == 1) {
			return "A" + back(a-1, b, c, 0, p1);
		}
		
		if(b > 0 && p1 != 1) {
			if(go(a, b-1, c, 1, p1) == 1) {
				return "B" + back(a, b-1, c, 1, p1);
			}
		}
		
		if(c > 0 && p1 != 2 && p2 != 2) {
			if(go(a, b, c-1, 2, p1) == 1) {
				return "C" + back(a, b, c-1, 2, p1);
			}
		}
		return "";
	}

	private static int go(int anum, int bnum, int cnum, int p1, int p2) {
		int ans = memo[anum][bnum][cnum][p1][p2];
		
		if(anum + bnum + cnum == 0) { // 음수가 없으니까
			memo[anum][bnum][cnum][p1][p2] = 1;
 			return memo[anum][bnum][cnum][p1][p2];
		}
		
		if(ans != -1) return ans;
		
		if(anum > 0 && go(anum-1, bnum, cnum, 0, p1) == 1) {
			memo[anum][bnum][cnum][p1][p2] = 1;
 			return memo[anum][bnum][cnum][p1][p2];
		}
		
		if(bnum > 0 && p1 != 1) {
			if(go(anum, bnum-1, cnum, 1, p1) == 1) {
				memo[anum][bnum][cnum][p1][p2] = 1;
	 			return memo[anum][bnum][cnum][p1][p2];
			}
		}
		
		if(cnum > 0 && p1 != 2 && p2 != 2) {
			if(go(anum, bnum, cnum-1, 2, p1) == 1) {
				memo[anum][bnum][cnum][p1][p2] = 1;
	 			return memo[anum][bnum][cnum][p1][p2];
			}
		}		
		
		memo[anum][bnum][cnum][p1][p2] = 0;
		return memo[anum][bnum][cnum][p1][p2];
	}

	private static boolean recur(char[] result, int idx, int Brest, int Crest) {
		if(idx == S.length) {
			for(int i = 0; i < result.length; i++) {
				System.out.print(result[i]);
			}
			return true;
		}
		
		//A
		if(count[0] > 0) {
			count[0]--;
			result[idx] = 'A';
			if(recur(result, idx+1, Brest-1, Crest-1)) {
				return true;
			}
			count[0]++;
		}
		
		//B
		if(count[1] > 0 && Brest <= 0) {
			count[1]--;
			result[idx] = 'B';
			if(recur(result, idx+1, 1, Crest-1)){
				return true;
			}
			count[1]++;
		}
		
		//C
		if(count[2] > 0 && Crest <= 0) {
			count[2]--;
			result[idx] = 'C';
			if(recur(result, idx+1, Brest-1, 2)) {
				return true;
			}
			count[2]++;
		}
		
		return false;
	}

	
}
