package page.SWEA;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1221_D3_GNS {
	private static String[] nums = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res\\1221.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			String testcase = sc.next();
			int n = sc.nextInt();
			int[] str2num = new int[n];
			for(int i = 0; i < n ; i++) {
				String input = sc.next();
				
				for(int j = 0; j < 10; j++) {
					if(input.equals(nums[j])) {
						str2num[i] = j;
					}
				}
			}
			
			Arrays.sort(str2num);
			System.out.println("#"+t);
			for(int i = 0; i < n ; i++) {
				System.out.print(nums[str2num[i]]+ " ");
			}
			System.out.println();
			
		}

	}

}
