package SWEA;

import java.util.Scanner;
/**
 * ���ڿ��� �ִ� 15�̴ϱ�
 * ���ڰ� ������ ���� �κ��� 
 * ' '�� ä�������� �ȴ�.
 * */
public class SWEA_5356_D3_�Ǽ����Ǽ��ηθ��ؿ� {
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
