package d0828;

import java.util.LinkedList;
import java.util.Queue;

public class car2 {
	static LinkedList<Integer>[] needs;
	
	public static void main(String[] args) {
		int[] cook_times = {5, 3,2};
		int[][] order = {{1, 2}, {2, 3}, {1, 3}};
		int k = 3;

		int[] result = find(cook_times, order, k); 
		System.out.println(result[0] + " " + result[1]);
	}

	private static int[] find(int[] cook_times, int[][] order, int k) {
		int[] result = new int[] {0, 0};

		int cnt = cook_times.length;
		needs = new LinkedList[cnt+1];
		int[] ingreed = new int[cnt+1];
		
		for(int i = 0; i < cnt+1; i++) {
			needs[i] = new LinkedList<Integer>();
		}

		for(int i = 0; i < order.length; i++) {
			int from = order[i][0];
			int to = order[i][1];

			needs[to].add(from);
			ingreed[to]++;
		}

		//find pre step
		result[0] = find(k);
		
		//find time
		Queue<Integer> q = new LinkedList();
		for(int i = 1; i < cnt+1; i++) {
			if(ingreed[i] == 0) {
				q.add(i);
			}
		}

		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			int max = 0;
			for(int s= 0; s < size; s++) {
				int now = q.poll();
				if(now == k) {
					result[1] = time + cook_times[k-1];
					return result;
				}
				if(cook_times[now-1] > max) {
					max =cook_times[now-1];
				}
				
				for(int i = 1; i < cnt+1; i++) {
					if(needs[i].contains(now)) {
						ingreed[i]--;
						if(ingreed[i] == 0) {
							q.add(i);
						}
					}
				}
			}
			
			time += max;
		}
		
		return result;
	}

	private static int find(int k) {
		if(needs[k].size() == 0) {
			return 1;
		}
		
		int cnt = 0;
		for(int i = 0; i < needs[k].size(); i++) {
			cnt += find(needs[k].get(i));
		}
		return cnt;
	}


}
