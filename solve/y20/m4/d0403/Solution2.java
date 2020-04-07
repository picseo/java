package d0403;

import java.util.Stack;

public class Solution2 {
	public static void main(String[] args) {
		/*
		 * Hello, world!	0
line [plus]	1
if (Count of eggs is 4.) {Buy milk.}	2
>_<	-1
		 * */
		String v = "24551";
		String[] sheets = {"24553", "24553", "24553", "24553"};
		System.out.println( solution(v, sheets));
	}
	
	static int solution(String answer_sheet, String[] sheets) {
        int answer = -1;
        
        for(int i = 0; i < sheets.length-1; i++) {
        	for(int j = i+1; j < sheets.length; j++) {
            	int len = 0;//연속 길이
            	int cnt = 0;//문항수
            	int max_len = 0;
            	
        		if(i == j) {
        			continue;
        		}else {
        			for(int a = 0; a < answer_sheet.length(); a++) {
        				char now = sheets[i].charAt(a);
        				if(now == sheets[j].charAt(a) && answer_sheet.charAt(a) != now) {//오답일때
        					cnt++;
        					len++;
        					if(max_len < len) {
        						max_len = len;
        					}
        				}else {
        					len = 0;
        				}
        			}
        			
        			int tmp = cnt + (max_len*max_len);
        			if(tmp > answer) {
        				answer = tmp;
        			}
        		}
        	}
        }
        return answer;
    }
    
}