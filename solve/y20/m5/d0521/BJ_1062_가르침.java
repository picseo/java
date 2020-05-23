package d0521;

import java.util.Scanner;
//anta, tica는 무조건 나온다는 조건이 있으므로 일단 antic을 모르면 어떤 글자도 못읽게 된다.
//그래서 5개까지는 무조건 antic을 배운다고 생각했고, 그 후에는 두 글자 사이에 존재하는 글자만 고려하면 된다고 생각해서 substring으로 잘라서 저장한 후 check했다.
//남은 글자수는 완탐으로 하나씩 확인해서 풀었다.

//더 효율적으로 하려면 모든 문장을 비트마스크로 저장해두고
//새로 만들어진 배운 문자 비트마스크랑 &을 해서 문장 비트마스크랑 같은 값이 나오는지 확인하는 방법을 사용한다
public class BJ_1062_가르침 {
	//antic
	static boolean[] alpa = new boolean[26];
	static int result = 0;
	static String[] words;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		words = new String[N];
		for(int i = 0; i < N; i++) {
			String input = sc.next();
			words[i] = input.substring(4, input.length()-4);
		}
		
		alpa['a'-'a'] = true;
		alpa['n'-'a'] = true;
		alpa['t'-'a'] = true;
		alpa['i'-'a'] = true;
		alpa['c'-'a'] = true;
		
		if(K < 5) {
			result = 0;
		}else {
			find(0, K-5);
		}
		
		System.out.println(result);
	}
	
	private static void find(int where, int num) {
		if(num == 0) {
			int cnt = check();
			if(result < cnt) {
				result = cnt;
			}
			return;
		}
		
		for(int i = where+1; i < 26;i ++) {
			if(!alpa[i]) {
				alpa[i] = true;
				find(i, num-1);
				alpa[i] = false;
			}
		}
	}

	private static int check() {
		int cnt = 0;
		for(int i =0; i < words.length; i++) {
			boolean ok = true;
			for(int j = 0; j < words[i].length(); j++) {
				if(!alpa[words[i].charAt(j)-'a']) {
					ok = false;
					break;
				}
			}
			
			if(ok) cnt++;
		}
		return cnt;
	}
	
	
}
