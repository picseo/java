package d0520;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
//		int[] res = solution(10, 2);
//		System.out.println(res[0] + " ,  " + res[1]);
		
		//System.out.println(solution2(new int[] {70, 80, 50}, 100));
		
		//solution3(5, new int[] {1, 2, 5});
		System.out.println(Arrays.toString(solution4(2, 8)));
	}

	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int row = 0;
        int col = 0;
        for(col = 1; col <= yellow; col++) {
        	if(yellow%col != 0) {
        		continue;
        	}
        	row = yellow/col;
        	if(row > col) {
        		continue;
        	}
        	
        	//check
        	int check = (row + 2)*2 + col*2;
        	if(check == brown) {
        		answer[0] = col+2;
        		answer[1] = row+2;
        		break;
        	}
        }
        
        return answer;
    }
	
	public static int solution2(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int front_idx = 0;
        int back_idx = people.length - 1;
        
        int cnt = 0;
        while(front_idx <= back_idx) {
        	int now = people[back_idx--];
        	if(now + people[front_idx] <= limit) {
        		now += people[front_idx++];
        	}
        	
        	cnt++;
        }
        
        answer = cnt;
        return answer;
    }
	
	public static int solution3(int n, int[] money) {
        int answer = 0;
        int[] memo = new int[n+1];
        
        for(int i = 0; i < money.length; i++) {
        	for(int j = money[i]; j <= n; j++ ) {
        		int idx = j-money[i];
        		if(idx > 0) {
        			memo[j] = memo[j] + memo[j-money[i]];
        		}else if(idx==0) {
        			memo[j] += 1;
        		}
        	}
        }
        
        answer = memo[n];
        return answer;
    }
	
	public static int[] solution4(int n, int s) {
        int[] answer = new int[n];
        
        double tmp = s/n;
        
        if((int)tmp == 0) {
        	answer = new int[1];
        	answer[0] = -1;
        }else {
        	if(s%n == 0) {//나누어떨어짐
        		for(int i = 0; i < n; i++) {
        			answer[i] = s/n;
        		}
        	}else {
        		int lest = s - (int)tmp*n;
        		for(int i = 0; i < n; i++) {
        			answer[i] = s/n;
        		}
        		
        		int idx = n-1;
        		while(lest > 0) {
        			answer[idx--]++;
        			lest--;
        		}
        	}
        }
        return answer;
    }
}
