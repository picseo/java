package d0306;

import java.util.Scanner;
/**
 * 음수 끼리 나올때의 계산을 이상하게 하고 있었다......
 * 앞으로는 식을 굳이 줄이려고 노력하지 말아야겠다.
 * */
public class SWEA_극한의빌딩 {
	public static long[][] nums = new long[14][2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		
		nums[0][0] = 0;
		nums[0][1] = 1;
		for(int i = 1; i < 14; i++) {
			nums[i][0] = nums[i-1][0]*9 + nums[i-1][1];
			nums[i][1] = nums[i-1][1]*10;
		}
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			long result = 0;
			long from = sc.nextLong();
			long to = sc.nextLong();
			
			if(from >0 && to >0) {
				//System.out.println("result : " + from + ", to : " + to);
				result = (to -1 - check(to) +check(1)) -(from -1 - check(from) +check(1));
			}else if(from < 0 && to <0){
				result = (-1 - to -check(to) +check(-1)) - (-1 - from -check(from) +check(-1));
				if(result < 0)
					result *= -1;
			}else{
				result = (-1 - from -check(from) +check(-1)) + 1 + (to -1 - check(to) +check(1));
			}
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static long check(long num) {
		int i = 0;
		long result = 0;
		if(num <0) {
			num *= -1;
		}
		while(num > 0) {
			long now = num%10;
			if(now > 4) {
				result += (nums[i][0]*(now-1) + nums[i][1]);
			}else {
				result += nums[i][0]*now;
			}
			num /= 10;
			i++;
		}

		return result;
	}

	private static String src =
			"5\r\n" + 
			"-15 -1\r\n" + 
			"1 15\r\n" + 
			"-10 999999999999\r\n" + 
			"-999999999999 9\r\n"+
			"-999999999999 1";
}
