package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 "100-200*300-500+20"	60420
"50*6-3*2"	300
 * */
public class P2 {
	static int[] what = {0,1,2};
	static long[] num;
	static List<Integer>[] exp;
	public static void main(String[] args) {
		String input ="50*6-3*2";
		System.out.println(solution(input));
	}

	public static long solution(String expression) {
        long answer = 0;
        StringTokenizer st = new StringTokenizer(expression, "*|-|+");
        long[] number = new long[100];
        int idx = 0;
        
        while(st.hasMoreTokens()) {
        	number[idx++] = Long.parseLong(st.nextToken());
        }
        
        exp = new List[3];
        for(int i = 0; i < 3; i++) {
        	exp[i] = new ArrayList();
        }
        int eidx = 0;
        for(int i = 0; i < expression.length(); i++) {
        	switch(expression.charAt(i)) {
        	case '+':
        		exp[0].add(eidx++);
        		break;
        	case '-':
        		exp[1].add(eidx++);
        		break;
        	case '*':
        		exp[2].add(eidx++);
        		break;
        	}
        }
        
        long max = 0;
        do {
        	//System.out.println(Arrays.toString(what));
        	num = number.clone();
        	for(int i = 0; i < 3; i++) {
        		if(exp[what[i]].size() != 0) {
        			cal(what[i]);
        		}
        	}
        	
        	for(int i = 0; i < num.length; i++) {
        		long tmp = Math.abs(num[i]);
        		if(tmp != Long.MAX_VALUE && max < tmp) {
        			max = tmp;
        		}
        	}
        	
        }while(nextP());
        
        answer = max;
        return answer;
    }
	
	private static void cal(int x) {
		for(int i =0; i < exp[x].size(); i++) {
			int idx = exp[x].get(i);
			
			int pre = idx;
			while(pre > 0 && num[pre] == Long.MAX_VALUE) {
				pre--;
			}
			int back = idx+1;
			while(num[back] == Long.MAX_VALUE) {
				back++;
			}
			
			long result = 0;
			if(x == 0) {
				result = num[pre] + num[back];
			}else if(x == 1) {
				result = num[pre] - num[back];
			}else {
				result = num[pre] * num[back];
			}
			
			num[pre] = Long.MAX_VALUE;
			num[back] = result;
		}
	}

	static boolean nextP() {
		int i, j;
		for(i = what.length-2; i >= 0; i--) {
			if(what[i+1] > what[i]) {
				break;
			}
		}
		
		if(i < 0) {
			return false;
		}
		
		for(j = what.length-1; j>=0 ; j--) {
			if(what[i] < what[j]) {
				break;
			}
		}
		
		int tmp = what[i];
		what[i] = what[j];
		what[j] = tmp;
		
		for(int st = i+1, ed = what.length-1; st < ed; st++, ed--) {
			tmp = what[st];
			what[st] = what[ed];
			what[ed] = tmp;
		}
		
		return true;
	}
	
}
