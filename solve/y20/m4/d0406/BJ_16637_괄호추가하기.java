package d0406;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 부분집합을 구해서 1일 때 괄호에 넣은것으로 생각하고 계산을 하였다.
 * 
 * 1이 연속으로 존재하면 괄호가 겹치게 됨으로 1이 연속으로 존재하는 경우는 가지치기 해주었다.
 * 
 * 걸렸던 부분은 처음에는 숫자가 0~9라서 '0'을 더하고 빼면서 문자랑 숫자형을 바꿀수있었는데
 * 진행을하다보면 한자리를 넘게되는 경우를 처음에는 모르고 그냥 '0'으로 바꾸어주었다가 이상한 값이 들어갔었다.
 * 
 * 그리고 계산을 쉽게 하기 위해 0번째 숫자는 미리 넣어두고 시작했다.
 * 이래야 이후에 오는 값의 형식이 일정해서 계산이 좀 더 쉽다고생각했다.
 * 
 * */
public class BJ_16637_괄호추가하기 {

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
				if((i&(1<<idx)) > 0) {//괄호에 담김
					if(input[s]=='+') {
						nums[ncnt] += (input[s+1]-'0');
					}else if(input[s] == '-') {
						nums[ncnt] -= (input[s+1]-'0');
					}else if(input[s] == '*'){
						nums[ncnt] *= (input[s+1]-'0');
					}
				}else {//괄호에 담기지 않음
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
