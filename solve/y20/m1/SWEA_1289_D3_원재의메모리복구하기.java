package algo_basic.day1;

import java.util.Scanner;

public class SWEA_1289_D3_원재의메모리복구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		
		int t=sc.nextInt();
		
		for(int i=1; i<=t; i++) {
			String str=sc.next();
			char[] str2=str.toCharArray();
			int count=0;
			
			if(str2[0]=='1')
				count++;
		
			for (int j=1; j<str.length();j++) {
				if(str2[j-1]!=str2[j]) {
					count++;
				}
			
			}
			
			System.out.printf("#%d %d\n",i,count);
			
			
		}
	}

}
