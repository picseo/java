package d0523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//System.out.println(solution(1987));
		//System.out.println(solution2(1000000000));
		
		//121, int[][] jj = {{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};
		//int[][] jj = {{2, 1}, {3, 2}, {3, 5}, {5, 4}, {5, 6}};
		int[][] jj = {{1, 2}};
		int[] result = solution3(999, jj);
		System.out.println(Arrays.toString(result));
	}

	//주어진 p보다 큰 최소 아름다운 수 년도
	static public int solution(int p) {
        int answer = p+1;
        
        while(true) {
        	if(check(answer)) {
        		break;
        	}        	
        	answer++;
        }
        return answer;
    }

	private static boolean check(int p) {
		String ps = p+"";
		int check1 = 0;
		for(int i = 0; i < ps.length(); i++) {
			int now = ps.charAt(i) -'0';
			if((check1 & (1<<now)) > 0) {
				return false;
			}
			check1 |= (1<<now);
		}
		return true;
	}
	
	//3진법으로 나타낼 수 있는 n번째 수
	public static long solution2(long n) {
        long answer = 0;
        
        long gob = 1;
        while(n > 0) {
        	long tmp = n%2;
        	answer += gob*tmp;
        	n /= 2;
        	gob *= 3;
        }
        
        return answer;
    }
	
	//tree

    static List<Integer>[] list;
    static int[] memo;
	public static int[] solution3(int total_sp, int[][] skills) {
		int size = skills.length+1;
		int[] answer = new int[size];
		memo = new int[size];
		list = new List[size];
        for(int i = 0; i < size; i++) {
        	list[i] = new ArrayList();
        }
        
        for(int i = 0; i < skills.length; i++) {
        	int a = skills[i][0]-1;
        	int b = skills[i][1]-1;
        	
        	list[a].add(b);
        }
        int total = 0;
        Arrays.fill(memo, -1);
        for(int next = 0; next < size; next++) {
        	answer[next] = Count_leaf(next);
        	total += answer[next];
        }
        
        int gob = total_sp/total;
        for(int i =0 ; i < answer.length; i++) {
        	answer[i] *= gob;
        }
        
        return answer;
    }

	private static int Count_leaf(Integer now) {
		if(memo[now] != -1) {
			return memo[now];
		}
		
		if(list[now].isEmpty()) {
			memo[now] = 1;
			return 1;
		}
		
		int cnt = 0;
		for(int i =0; i < list[now].size(); i++) {
			int next = list[now].get(i);
			cnt += Count_leaf(next);
		}
		
		memo[now] = cnt;
		return memo[now];
	}
	
}
