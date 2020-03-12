package d0310;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static int[] nums = new int[6];
	static boolean[][] input = new boolean[10][10];
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
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
	private static boolean isIn(int x, int y) {
		if(x >= 0 && x < 10 && y >=0 && y < 10) {
			return true;
		}else {
			return false;
		}
	}
	
	static String src = 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0";
}
