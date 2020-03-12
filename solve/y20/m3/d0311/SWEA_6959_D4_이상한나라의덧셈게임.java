package d0311;

import java.util.Scanner;
/*
 * 숫자가 1000자리가 나오는걸 int로 받아서 계산을 하느라 틀렸다.
 * 
 * 이 문제는 결국 어느 것 부터 더한다고 해도 횟수는 같았기 때문에 뒤에서 부터 수들을 더하며 진행했다.
 * 같다고 생각한 이유는 어떤 순서로 더하든 한자리수로 되기 전의 두자리 값이 존재해서
 * 결국 이러나 저러나 같지 않을까라는 것이었다.
 * 
 * **/
public class SWEA_6959_D4_이상한나라의덧셈게임 {
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
