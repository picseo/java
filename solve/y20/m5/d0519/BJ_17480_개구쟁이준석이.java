package d0519;

import java.util.HashSet;
import java.util.Scanner;

public class BJ_17480_개구쟁이준석이 {
	static int N;
	static int[] count, inputs;
	static String word;
	static StringBuilder poham = new StringBuilder();
	static HashSet<String> hs = new HashSet<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		count = new int[26];
		inputs = new int[26];
		int len = 0;
		
		for(int i = 0; i < 4; i++) {
			char alpa = sc.next().charAt(0);
			int cnt = sc.nextInt();
			
			inputs[(alpa-'a')] = cnt;
			poham.append(alpa);
			len += cnt;
		}
		
		word = sc.next();
		
		int st = 0;
		int ed = 0;
		
		while(st < word.length() && ed < word.length()) {
			if(poham.toString().contains(word.charAt(ed)+"")) {
				if(ed-st+1 == len) {
					count[word.charAt(ed)] += 1;
					count[word.charAt(st)] -= 1;
					st++;
				}else if(ed-st+1 < len){
					count[word.charAt(ed)] += 1;
				}
				
				if(ed-st+1 == len) {
					check(st, ed);
				}
			}else {
				st = ed+1;
			}
			ed++;
		}
		
		System.out.println(hs.size());
	}
	
	private static void check(int st, int ed) {
		
		
	}

	private static String reverse(int st, int ed) {
		StringBuilder rev = new StringBuilder();
		
		for(int i = ed; i >= st; i--) {
			rev.append(word.charAt(i));
		}
		
		return rev.toString();
	}
	
}
