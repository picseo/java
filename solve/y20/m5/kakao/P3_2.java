package kakao;

import java.util.HashMap;

/*
 ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]	[3, 7]
["AA", "AB", "AC", "AA", "AC"]	[1, 3]
["XYZ", "XYZ", "XYZ"]	[1, 1]
["ZZZ", "YYY", "NNNN", "YYY", "BBB"]	[1, 5]
 * */
public class P3_2 {
	static int[] nums;
	public static void main(String[] args) {
		String[] gems = {"A", "A", "A", "A", "B", "B", "A", "A"};
		//String[] gems = {"C", "A", "A", "B", "A", "B", "B", "C", "A", "A"};
		//String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] answer = solution(gems);
		System.out.println(answer[0] + " : " + answer[1]);
	}

	public static int[] solution(String[] gems) {
		int[] answer = {0, 0};
		nums = new int[100000];
		HashMap<String, Integer> count = new HashMap<String, Integer>();

		int front = 0;
		int back = gems.length - 1;
		
		answer[0] = front;
		answer[1] = back;
		
		int num = 0;
		nums[num]++;
		count.put(gems[back], num++);
		int repeat = 0;
		
		for(front = gems.length-2; front >= 0; front--) {
			String now = gems[front];
			
			if(!count.containsKey(now)) {
				nums[num]++;
				count.put(now, num++);
				repeat = 0;
			}else {
				if(now.equals(gems[back])) {
					while(now.equals(gems[back]) && front < back) {
						nums[count.get(gems[back])]--;
						back--;
					}
					if(nums[count.get(now)] == 0) {
						repeat = 0;
					}
					nums[count.get(now)]++;
					
				}else{
					nums[count.get(gems[front])]++;
					repeat++;
				}				
			}
			
			while(back > 0 &&front < back && nums[count.get(gems[back])] > 1) {
				nums[count.get(gems[back])]--;
				back--;
			}
			
			if(check(count)) {
				if(back-front < answer[1] - answer[0]) {
					answer[0] = front+1;
					answer[1] = back+1;
				}else if(back-front== answer[1]-answer[0]) {
					if(front < answer[0]) {
						answer[0] = front+1;
						answer[1] = back+1;
					}
				}
			}
			
		}

		//answer[0] = front+2+repeat;
		//answer[1] = back+1;
		System.out.println("0 :" + answer[0] + ", 1: " + answer[1]);
		for(int i = answer[0]; i < answer[1]; i++) {
			System.out.print(gems[i]);
		}
		return answer;
	}

	private static boolean check(HashMap<String, Integer> count) {
		boolean result = true;
		for(String key : count.keySet()) {
			if(nums[count.get(key)] == 0) {
				result = false;
			}
		}
		return result;
	}
}
