package d0402;

import java.util.Arrays;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char[] input = sc.next().toCharArray();
		
		int length = input.length;		
		int result = Integer.MIN_VALUE;
		
		for(int i =0; i < 1<<(length/2) ; i++) {
			char[] tmp = new char[length];
			int[] nums = new int[length];
			int ncnt = 0;
			int cnt = 0;
			
			boolean seq = false;
			for(int j = 1; j < length/2-1; j++) {
				if((i&(1<<j)) > 0) {
					if((i&(1<<j-1)) > 0 || (i&(1<<j+1)) > 0) {
						seq = true;
						break;
					}
				}
			}
			
			if(seq) {
				continue;
			}
			
			nums[ncnt] = input[0]-'0';			
			for(int s = 1; s < length; s += 2) {
				int idx = s/2;
				if((i&(1<<idx)) > 0) {
					if(input[s]=='+') {
						nums[ncnt] += (input[s+1]-'0');
					}else if(input[s] == '-') {
						nums[ncnt] -= (input[s+1]-'0');
					}else if(input[s] == '*'){
						nums[ncnt] *= (input[s+1]-'0');
					}
				}else {
					nums[++ncnt] = input[s+1]-'0';
					tmp[cnt++] = input[s];
				}
			}
			
			int res = nums[0];
			for(int s = 0; s < cnt; s++) {
				if(tmp[s]=='+') {
					res += nums[s+1];
				}else if(tmp[s] == '-') {
					res -= nums[s+1];
				}else if(tmp[s] == '*'){
					res *= nums[s+1];
				}
			}
			if(res > result) {
				result = res;
			}			
		}
		
		System.out.println(result);
	}

}
