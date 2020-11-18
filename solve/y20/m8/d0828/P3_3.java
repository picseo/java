package d0828;

import java.util.Arrays;
import java.util.HashMap;

/*
 왼쪽, 오른쪽 index두개를 가지고 탐색을 하면서
 조건에 맞을 경우 answer를 업데이트 한다.
 * */
/*
 ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]	[3, 7]
["AA", "AB", "AC", "AA", "AC"]	[1, 3]
["XYZ", "XYZ", "XYZ"]	[1, 1]
["ZZZ", "YYY", "NNNN", "YYY", "BBB"]	[1, 5]
 * */
public class P3_3 {
	static int[] nums;
	public static void main(String[] args) {
		//String[] gems = {"A", "A", "A", "A", "B", "B", "A", "A"};
		//String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		//String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		int[] answer = solution(gems);
		System.out.println(answer[0] + " : " + answer[1]);
	}

	public static int[] solution(String[] gems) {
		int[] answer = {2, 100};
		
		//보석의 총갯수 세기
		int cnt = 0;
		HashMap nums = new HashMap<String, Integer>();
		int[] gnums = new int[gems.length];
		
		for(int i = 0; i < gems.length; i++) {
			if(nums.get(gems[i]) == null) {
				nums.put(gems[i], cnt++);
			}
			
			int num = (int) nums.get(gems[i]);
			gnums[i] = num;
		}
		
		System.out.println(Arrays.toString(gnums));
		int[] check = new int[cnt];
		
		int st = 0;
		int ed = 0;
		
		while(true) {
			if(ed == gems.length || repeat(check, gnums[st])) {
				check[gnums[st++]]--;				
			}else {
				check[gnums[ed++]]++;
			}
			
			if(full(check, answer, st, ed)) {
				answer[0] = st+1;
				answer[1] = ed;
			}
			
			if(st == gems.length) {
				break;
			}
		}
		
		return answer;
	}

	private static boolean full(int[] check, int[] ans, int st, int ed) {
		boolean fill = true;
		for(int i = 0; i < check.length; i++) {
			if(check[i] == 0) {
				fill = false;
			}
		}
		
		if(fill) {
			if(ans[1] - ans[0] + 1 == st - ed && st < ans[0])
				return true;
			
			if(ans[1] - ans[0] + 1 > ed - st) {
				return true;
			}
		}
		return false;
	}

	private static boolean repeat(int[] check, int now) {
		if(check[now] > 1) {
			return true;
		}
		return false;
	}

	

	
}
