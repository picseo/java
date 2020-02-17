package swea.d0210;

import java.util.Scanner;
/**
 * toCharArray(); -> String을 char 배열로 만들어줌
 * 
 * 입력되는 p가 연속 값이 아니었는데 임의로 연속값이 라 생각하고 풀어서 틀렸었다.
 * 문제좀 제대로 읽읍시다.!!!!
 * ****/
public class SWEA_6485_D3_삼성시의버스노선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T= sc.nextInt();
		
		for(int t= 1; t<= T; t++) {
			int n =sc.nextInt(); //버스 노선 갯수
			int[] stops = new int[5001];
			
			for(int i = 0; i < n ; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				for(int j = a; j <= b; j++) {
					stops[j]++;
				}				
			}
			
			int p = sc.nextInt();
			
			System.out.print("#"+t+" ");
			for(int i = 0; i < p ; i++) {
				int tmp = sc.nextInt();
				System.out.print(stops[tmp]+" ");
			}
			System.out.println();
		}

	}
	
	private static String src ="1\r\n" + 
			"2\r\n" + 
			"1 3\r\n" + 
			"2 5\r\n" + 
			"5\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"5";
}
