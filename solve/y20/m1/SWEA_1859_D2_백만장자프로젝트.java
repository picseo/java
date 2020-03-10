package SWEA;

import java.util.Scanner;

public class SWEA_1859_D2_백만장자프로젝트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int days = sc.nextInt();
			
			int[] value = new int[days];
			for(int i = 0; i < days; i++) {
				value[i] = sc.nextInt();				
			}		
			
			//search
			int Max =value[days-1];
			long result = 0;
			
			for(int i = days-1; i>=0; i--) {
				if(value[i] > Max) {
					Max = value[i];
				}else {
					result += (Max - value[i]);
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
