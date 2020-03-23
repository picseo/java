package again;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 처음에는 5*5가 들어갈 수 있는 칸은 무조건 5*5가 들어가는 것이라고 생각해서
 * greedy 알고리즘으로 접근했다. 그래서 len : 5- > 1로 줄여가면서 
 * 그 공간에 들어갈 수 있는 가장 큰 사각형을 넣었는데 틀려서 찾아보니
 * 
 * 큰 사각형이 들어갈 수 있는 공간은 작은 사각형들도 들어갈 수 있는 곳이므로 모두
 * 고려해야 했다.
 * 
 * 그래서 나는 바보같이 len의 순서를 nextP로 모둔 순서를 고려해보았지만
 * 
 * 이 경우에는 여러 종류를 섞어서 나오는 경우를 확인할 수 없었다.
 * 
 * 결국 재귀를 이용해서 완탐을 하는게 답이라는 것을 보고 다시 풀었다.......
 * 
 * */
public class BJ_17136_완전탐색 {
	static int[] nums = new int[6];
	static boolean[][] input = new boolean[10][10];
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		result = Integer.MAX_VALUE;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(sc.nextInt() == 1) {
					input[i][j] = true;
				}
			}
		}
		
		check(0);

//		for(int i = 1; i < 6; i++) {
//			if(nums[i] > 5) {
//				result = -1;
//				break;
//			}else {
//				cnt += nums[i];
//			}
//		}
//
//		if(result != -1) {
//			result = cnt;
//		}

		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
	}

	private static void check(int idx) {
		if(idx == 100) {
			int sum = 0;
			for(int i = 1; i < 6; i++) {
				sum += nums[i];
			}
			
			if(sum != -1 && result > sum) {
				result = sum;
			}
			return;
		}
		
		int x = idx/10;
		int y = idx%10;
		
		if(!input[x][y]) {
			check(idx+1);
			return;
		}
		
		boolean out = false;
		for(int len = 5; len >= 1; len--) {
			out = false;
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					if(!isIn(x+i, y+j) || !input[x+i][y+j]) {
						out = true;
						break;
					}
				}
				if(out) {
					break;
				}
			}
			
			if(out)
				continue;

			nums[len]++;
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					input[x+i][y+j] = false;
				}
			}
			
			boolean out_of_range = false;;
			for(int i = 1; i < 6; i++) {
				if(nums[i] > 5) {
					out_of_range = true;
					break;
				}
			}
			
			if(!out_of_range) {
				check(idx + len);
			}
			
			nums[len]--;
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					input[x+i][y+j] = true;
				}
			}
		}

	}

	/*private static void check(int x, int y, int len) {
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(!isIn(x+i, y+j) || !input[x+i][y+j]) {
					return;
				}
			}
		}

		nums[len]++;
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				input[x+i][y+j] = false;
			}
		}


	}*/

	private static boolean isIn(int x, int y) {
		if(x >= 0 && x < 10 && y >=0 && y < 10) {
			return true;
		}else {
			return false;
		}
	}
}