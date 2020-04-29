package d0410;

import java.util.Scanner;

public class BJ_16916_부분문자열 {
	static char[] origin, pattern;
	static int[] pi;
	
	static void findPi() {
		pi = new int[pattern.length];
		
		int j = 0;
		for(int i = 1; i < pattern.length; i++) {
			while(j > 0 && pattern[i] != pattern[j]) {
				j = pi[j-1];
			}
			
			if(pattern[i] == pattern[j]) {
				pi[i] = ++j;
			}
		}
	}
	
	static boolean kmp() {
		boolean result = false;
		int j = 0;
		for(int i = 0; i < origin.length; i++) {
			while(j > 0 && origin[i] != pattern[j]) {
				j = pi[j-1];
			}
			
			if(origin[i] == pattern[j]) {
				if(j == pattern.length-1) {
					j = pi[j];
					result = true;
				}else
					j++;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		origin = sc.next().toCharArray();
		pattern = sc.next().toCharArray();
		
		findPi();
		if(kmp()) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}
