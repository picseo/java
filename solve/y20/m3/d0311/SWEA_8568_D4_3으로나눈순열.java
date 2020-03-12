package d0311;

import java.util.Scanner;
/*
 * �տ��� ���� ������� �����Ͽ���
 * 
 * ���� ���� �ٲٰ� �������� �ٲٸ� ������ ���� �����ϴ� �� �켱���� �ϰ�
 * �׷� ���� ���� ���� ���� ���ʿ� �ִ� ������ �ٲپ��־���.
 * **/
public class SWEA_8568_D4_3���γ������� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			int n = sc.nextInt();
			int[] nums = new int[n+1];
			
			for(int i = 1; i <= n; i++) {
				int tmp = sc.nextInt();
				nums[i] = tmp%3;
			}
			
			int cnt = 0;
			int i, j;
			int idx = -1;
			for(i = 1; i < n ; i++) {
				if(nums[i] != i%3) {
					idx = -1;
					for(j = i+1; j <n+1; j++) {
						if(nums[j] != j%3 && nums[j] == i%3) {
							if(nums[i] == j%3) {
								idx = j;
								break;
							}else {
								if(idx == -1) {
									idx = j;
								}
							}
						}
					}
					
					int tmp = nums[idx];
					nums[idx] = nums[i];
					nums[i] = tmp;
					cnt++;
				}
			}
			
			
			
			System.out.println("#"+t+" " + cnt);
		}
		

	}

	private static String src = "4\r\n" + 
			"3\r\n" + 
			"1 2 3\r\n" + 
			"3\r\n" + 
			"2 1 3\r\n" + 
			"3\r\n" + 
			"2 3 1\r\n" + 
			"9\r\n" + 
			"6 8 2 9 3 7 1 5 4";
}
