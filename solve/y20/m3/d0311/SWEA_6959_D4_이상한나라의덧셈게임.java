package d0311;

import java.util.Scanner;
/*
 * ���ڰ� 1000�ڸ��� �����°� int�� �޾Ƽ� ����� �ϴ��� Ʋ�ȴ�.
 * 
 * �� ������ �ᱹ ��� �� ���� ���Ѵٰ� �ص� Ƚ���� ���ұ� ������ �ڿ��� ���� ������ ���ϸ� �����ߴ�.
 * ���ٰ� ������ ������ � ������ ���ϵ� ���ڸ����� �Ǳ� ���� ���ڸ� ���� �����ؼ�
 * �ᱹ �̷��� ������ ���� �������� ���̾���.
 * 
 * **/
public class SWEA_6959_D4_�̻��ѳ����ǵ������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int result = 0;
			String n = sc.next();
			
			while(true) {
				if(n.length() == 1) {
					break;
				}
				
				result++;

				int back1 = n.charAt(n.length()-1) - '0';
				int back2 = n.charAt(n.length()-2) -'0';
				int sumb = back1+back2;
				String next = make_next(n, sumb);
				n = next;
			}
			
			if(result%2 == 1) {
				System.out.println("#"+t+" A");
			}else {
				System.out.println("#"+t+" B");
			}
		}
	}
	
	static String make_next(String front, int back) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < front.length()-2;i++) {
			sb.append(front.charAt(i));
		}
		sb.append(back);
		
		return sb.toString();
	}
	static String src = "3\r\n" + 
			"1234\r\n" + 
			"5678\r\n" + 
			"9";
}
