package d0403;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution5 {
	public static void main(String[] args) {
		String[][] v = {{"doc1", "t1", "t2", "t3"},
			    {"doc2", "t0", "t2", "t3"},
			    {"doc3", "t1", "t6", "t7"},
			    {"doc4", "t1", "t2", "t4"},
			    {"doc5", "t6", "t100", "t8"}};
		String[] n = {"t1", "t2", "t3"};
		String[] answer = solution(v, n);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		//System.out.println( solution(v, n));
	}
	
	static String[] solution(String[][] dataSource, String[] tags) {
        String[] answer = null;
        
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i <tags.length; i++) {
        	hs.add(tags[i]);
        }
        
        PriorityQueue<Result> pq = new PriorityQueue();
        
        for(int i = 0; i < dataSource.length; i++) {
        	String name = dataSource[i][0];
        	int cnt = 0;
        	for(int j = 1; j < dataSource[i].length; j++) {
        		if(hs.contains(dataSource[i][j])) {
        			cnt++;
        		}
        	}
        	if(cnt != 0)
        		pq.add(new Result(name, cnt));
        }
        
        answer = new String[pq.size()];
        int i = 0;
        while(!pq.isEmpty()) {
        	Result now = pq.poll();
        	answer[i++] = now.name;
        }
        return answer;
    }
    
	static class Result implements Comparable<Result>{
		String name;
		int tag_num;
		
		public Result(String name, int tag_num) {
			this.name = name;
			this.tag_num = tag_num;
		}

		@Override
		public int compareTo(Result o) {
			if(this.tag_num == o.tag_num) {
				return this.name.compareTo(o.name);
			}else {
				return Integer.compare(o.tag_num,  this.tag_num);
			}
		}	
	}
	
}