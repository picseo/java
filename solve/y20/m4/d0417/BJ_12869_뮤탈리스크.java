package d0417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 001, 010, 100 이 결국엔 같다고 생각을 했기때문에
 * 매번 Arrays.sort를 이용해서 정렬을 한 뒤에 dp를 하였다.
 * 
 * 그런데 이런 문제는 재귀를 돌리는게 제일 빠르게 해결되는것 같다
 * 
 * */
public class BJ_12869_뮤탈리스크 {
	static int N;
	static int[] input;
	static int[][][] memo = new int[61][61][61];
	static int[][][] minus = {{{0,0,9}}, 
			{{0,9, 3}, {0,3, 9}},
			{{9, 3, 1}, {9,1,3}, {3, 1, 9}, {3, 9, 1}, {1, 3, 9}, {1, 9, 3}}			
	};

	public static void main(String[] args) throws Exception{
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N = sc.nextInt();
		N = Integer.parseInt(br.readLine());
		input = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			//input[i] = sc.nextInt();
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		for(int[][]a : memo) {
			for(int[] b : a) {
				Arrays.fill(b, -1);
			}
		}

		memo[0][0][0] = 0;
		memo[input[0]][input[1]][input[2]] = recur(input.clone(), 0, N);//배열, 횟수, 길이

		System.out.println(memo[input[0]][input[1]][input[2]]);
	}


	static int recur(int[] tmp, int cur, int len) {
		if(memo[tmp[0]][tmp[1]][tmp[2]] != -1) {
			return memo[tmp[0]][tmp[1]][tmp[2]];
		}

		int res = Integer.MAX_VALUE;
		int start = len-1;
		for(int i = 0; i < minus[start].length; i++) {
			int[] new_tmp = new int[3];

			int nlen = 0;
			for(int j = 0; j < 3; j++) {
				if(tmp[j] - minus[start][i][j] <= 0) {
					new_tmp[j] = 0;
				}else {
					nlen++;
					new_tmp[j] = tmp[j] - minus[start][i][j];
				}
			}
			Arrays.sort(new_tmp);

			int val = recur(new_tmp, cur+1, nlen)+1;
			if(res > val) {
				res = val;
			}
		}
		memo[tmp[0]][tmp[1]][tmp[2]] = res;
		return memo[tmp[0]][tmp[1]][tmp[2]];
	}//recur

}
