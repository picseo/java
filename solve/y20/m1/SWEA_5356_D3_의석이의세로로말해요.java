package SWEA;

import java.util.Scanner;
/**
 * 문자열이 최대 15이니까
 * 문자가 들어오지 않은 부분은 
 * ' '로 채워넣으면 된다.
 * */
public class SWEA_5356_D3_의석이의세로로말해요 {
	private static String src = "2\r\n" + 
			"ABCDE\r\n" + 
			"abcde\r\n" + 
			"01234\r\n" + 
			"FGHIJ\r\n" + 
			"fghij\r\n" + 
			"AABCDD\r\n" + 
			"afzz\r\n" + 
			"09121\r\n" + 
			"a8EWg6\r\n" + 
			"P5h3kx";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		
		char[][] words = new char[16][16];
		
		for(int t = 1; t <= T; t++) {
			for(int r = 0; r < 5; r++) {
				String input = sc.next();
			
				for(int i = 0; i <15; i++) {
					words[r][i] = ' ';
					if(i < input.length()) {
						words[r][i] = input.charAt(i);
					}
				}
			}
			
			sb.append("#").append(t).append(" ");
			
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 5; j++) {
					if(words[j][i] != ' ') {
						sb.append(words[j][i]);
					}
				}
			}
			sb.append("\n");			
		}
		
		System.out.print(sb);
	}

}
