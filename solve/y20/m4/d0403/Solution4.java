package d0403;

import java.util.Iterator;
import java.util.TreeMap;

public class Solution4 {
	public static void main(String[] args) {
//		String[][] v = {{"ACCOUNT1", "100"},
//				{"ACCOUNT2", "150"},
//				{"ACCOUNT10", "150"}};
//		String[][] n = {{"1", "SAVE", "ACCOUNT2", "100"},
//				{"2", "WITHDRAW", "ACCOUNT1", "50"},
//				{"1", "SAVE", "ACCOUNT2", "100"},
//				{"4", "SAVE", "ACCOUNT3", "500"},
//				{"3", "WITHDRAW", "ACCOUNT2", "30"}};
		String[][] v = {{"ACCOUNT1", "100"},
				{"ACCOUNT2", "150"}};
		String[][] n = {{"1", "SAVE", "ACCOUNT2", "100"},
				{"2", "WITHDRAW", "ACCOUNT1", "50"},
				{"1", "SAVE", "ACCOUNT2", "100"},
				{"4", "SAVE", "ACCOUNT3", "500"},
				{"3", "WITHDRAW", "ACCOUNT2", "30"}};
		String[][] answer = solution(v, n);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i][0] + " : " + answer[i][1]);
		}
		//System.out.println( solution(v, n));
	}
	
	static String[][] solution(String[][] snapshots, String[][] transactions) {
        String[][] answer = null;
        TreeMap<String, Integer> snap = new TreeMap<String, Integer>();
        
        for(int i = 0; i < snapshots.length; i++) {
        	String key = snapshots[i][0];
        	int bal = Integer.parseInt(snapshots[i][1]);
        	snap.put(key, bal);
        }
        
        boolean[] checkId = new boolean[100001];
        for(int i = 0; i < transactions.length; i++) {
        	int id = Integer.parseInt(transactions[i][0]);
        	if(!checkId[id]) {//처음 읽는다면 진행
        		String key = transactions[i][2];
        		int bal = 0;
        		if(snap.containsKey(key)) { //이미 스냅샷에 있을때
        			bal = snap.get(key);
        		}else {//스냅샷에 없을때
        			snap.put(key, bal);
        		}
        		
        		int diff = Integer.parseInt(transactions[i][3]);
        		if(transactions[i][1].equals("SAVE")) {
        			snap.replace(key, bal+diff);
        		}else if(transactions[i][1].equals("WITHDRAW")) {
        			snap.replace(key, bal-diff);
        		}
        		checkId[id] = true;
        	}else {//이미 읽었다면 무시
        		continue;
        	}
        }
        
        Iterator iter = snap.keySet().iterator();
        int i =0;
        answer = new String[snap.size()][2];
        while(iter.hasNext()) {
        	String key = (String) iter.next();
        	answer[i][0] = key;
        	answer[i][1] = snap.get(key).toString();
        	i++;
        }
        return answer;
    }
    
}