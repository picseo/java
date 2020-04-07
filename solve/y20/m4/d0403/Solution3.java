package d0403;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
	public static void main(String[] args) {
		/*
		 * Hello, world!	0
line [plus]	1
if (Count of eggs is 4.) {Buy milk.}	2
>_<	-1
		 * */
		String v = "24551";
		int n = 0;
		System.out.println( solution(v, n));
	}
	
	static int solution(String road, int n) {
        int answer = -1;
        int m = 0;//손상 횟수
        int max_len = 0; //현재 가장 긴 길이
        int len = 0;//현재길이
        
        List<Integer> s = new ArrayList();
        for(int i = 0; i < road.length(); i++) {
        	if(road.charAt(i) == '0') {
        		s.add(len);
        		len = 0;
        		m++;
        	}else {
        		s.add(-1*m);
        		m = 0;
        		len++;
        		if(max_len < len) {
        			max_len = len;
        		}
        	}
        }
        

    	if(n == 0) {
    		return max_len;
    	}else if(n >= m){
    		return road.length();
    	}
    	
    	
    	
        return answer;
    }
    
	//"111011110011111011111100011111"	3	18
	//"001100"	5	6
}