package again;

import java.util.Scanner;

public class SWEA_1244_D3_최대상금 {
	public static int[] nums = null;
	public static int result = -1;
	public static int n= 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			String input = sc.next();
			n = sc.nextInt();
			result = 0;

			int len = input.length();
			nums = new int[len];

			for(int i = 0; i < len; i++) {
				nums[i] = input.charAt(i) - '0';
			}
			
			dfs(0, 0);
			
			System.out.println("#"+t+" "+result);
		}
	}

	public static void dfs(int cur, int cnt) {
		if(cnt == n) {
			int dv = 1;
			int tmp = 0;
			for(int i = nums.length-1; i >=0 ; i--) {
				tmp += dv*nums[i];
				dv *= 10;
			}
			result = Math.max(result, tmp);
		}else {
			for(int i = cur ; i < nums.length; i++) {
				for(int j = i+1; j < nums.length; j++) {
					if(nums[i] <= nums[j]) {
						Swap(i, j);
						dfs(i, cnt+1);
						Swap(i, j);
					}
				}
			}
		}
	}


	private static void Swap(int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;		
	}

	private static String src= "10\r\n" + 
			"123 1\r\n" + 
			"2737 1\r\n" + 
			"757148 1\r\n" + 
			"78466 2\r\n" + 
			"32888 2\r\n" + 
			"777770 5\r\n" + 
			"436659 2\r\n" + 
			"431159 7\r\n" + 
			"112233 3\r\n" + 
			"456789 10";
}
