package d0518;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static String ALPA = "QWERTYUIOPASDFGHJKLZXCVBNM";
	static String alpa = "qwertyuiopasdfghjklzxcvbnm";
	
	public static void main(String[] args) {

	}
	
	public static int[] solution(int[] answers) {
        int size = answers.length;
        int[] result = new int[3];
        
        //person 1
        int now = 1;
        for(int i = 0; i < size; i++) {
        	if(answers[i] == now) {
        		result[0]++;
        	}
        	now = (now)%5+1;
        }
        
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int idx = 0;
        for(int i = 0; i < size; i++) {
        	idx = i%8;
        	if(answers[i] == two[idx]) {
        		result[1]++;
        	}
        }
        
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        idx = 0;
        for(int i = 0; i < size; i++) {
        	idx = i%10;
        	if(answers[i] == three[idx]) {
        		result[2]++;
        	}
        }
        
        int max = -1;
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
        	if(max < result[i]) {
        		max = result[i];
        		cnt = 1;
        	}else if(max == result[i]){
        		cnt++;
        	}
        }
        
        int[] answer = new int[cnt];
        idx = 0;
        for(int i = 0; i < 3; i++) {
        	if(max == result[i]) {
        		answer[idx++] = i+1;
        	}
        }
        return answer;
    }
	
	public static String solution1(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
        	char now = s.charAt(i);
        	
        	char next = ' ';
        	if(now == ' ') {
        		next = ' ';
        	}else if(ALPA.contains(""+now)) {
        		next = (char) ('A' + (((now-'A')+n)%26));
        	}else if(alpa.contains(""+now)) {
        		next = (char) ('a' + (((now-'a')+n)%26));
        	}
        	answer.append(next);
        }
        
        return answer.toString();
    }

}
