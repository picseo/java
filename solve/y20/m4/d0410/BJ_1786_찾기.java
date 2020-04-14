package d0410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1786_찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] origin = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		//make pi array
		int plength = pattern.length;
		int[] pi = new int[plength];
		int j = 0;
		for(int i = 1; i < plength; i++) {
			while(j > 0 && pattern[i] != pattern[j]) {
				j = pi[j-1];
			}
			
			if(pattern[i] == pattern[j]) {
				pi[i] = ++j;
			}
		}
		
		//find sub string
		int[] result = new int[origin.length];
		int cnt = 0;
		j = 0;
		for(int i = 0; i < origin.length; i++) {
			while(j > 0 && origin[i] != pattern[j]) {
				j = pi[j-1];
			}
			
			if(origin[i] == pattern[j]) {//********
				if(j == plength-1) {
					j = pi[j];
					result[cnt++] = (i - plength +2);
				}else {
					j++;
				}
			}
		}
		
		//출력
		StringBuilder sb= new StringBuilder();
		sb.append(cnt).append("\n");
		for(int i = 0; i < cnt; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}

}
