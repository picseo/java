package d0410;

import java.util.Arrays;

public class KMP_ssh {
	static char[] origin, pattern;
	static int[] pi;
	
	static void findpi() {
		pi = new int[pattern.length];
		
		int j = 0;
		for(int i = 1; i < pattern.length; i++) {
			while(j > 0 && pattern[i] != pattern[j]) {
				j = pi[j-1];
			}
			
			if(pattern[j] == pattern[i]) {
				pi[i] = ++j;
			}
		}
	}
	
	static int kmp() {
		int j = 0;
		int cnt = 0;
		for(int i = 0; i < origin.length; i++) {
			while(j > 0 && origin[i] != pattern[j]) {
				j = pi[j-1];
			}
			
			if(pattern[j] == origin[i]) {
				if(j == pattern.length-1) {
					System.out.println("same");
					j = pi[j];
					cnt = i - pattern.length + 1;
				}else
					j++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		pattern = "ababa".toCharArray();
		origin = "bcababa".toCharArray();
		
		findpi();
		System.out.println("where" + kmp());
		
		System.out.println(Arrays.toString(pi));
		
	}

}
