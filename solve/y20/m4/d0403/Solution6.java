package d0403;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution6 {
	public static void main(String[] args) {
		String[] v = {"/"};
		String[] n = {"mkdir /a",
				"mkdir /a/b",
				"mkdir /a/b/c",
				"cp /a/b /",
				"rm /a/b/c"};
		String[] answer = solution(v, n);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		//System.out.println( solution(v, n));
	}
	
	static String[] solution(String[] directory, String[] command) {
        String[] answer = null;
        List<String> result = new ArrayList();
        
        for(int i = 0; i < directory.length; i++) {
        	result.add(directory[i]);
        }
        
        for(int i = 0; i < command.length; i++) {
        	StringTokenizer st = new StringTokenizer(command[i]);
        	String comm = st.nextToken();
        	String tree = st.nextToken();
        	
        	if(comm.equals("mkdir")) {
        		result.add(tree);
        	}else if(comm.equals("cp")) {
        		String dest = st.nextToken();
        		int sub = 0;
        		for(int l = tree.length()-1; l >=0; l--) {
        			if(tree.charAt(l) == '/') {
        				sub = l;
        				break;
        			}
        		}
        		
        		for(int j = 0; j < result.size(); j++) {
        			if(!result.get(j).contains(tree)) {
        				continue;
        			}
        			
        			boolean find = true;
        			
        			for(int len = 0; len < tree.length(); len++) {
        				if(tree.charAt(len) != result.get(j).charAt(len)) {
        					find = false;
        				}
        			}
        			
        			if(find && result.get(j).length() > tree.length()) {
        				if(result.get(j).charAt(tree.length()) == '/') {
        					find = true;
        				}else {
        					find = false;
        				}
        			}
        			
        			if(find) {
        				if(!dest.equals("/"))
        					result.add(dest+result.get(j));
        				else 
        					result.add(dest+result.get(j).substring(sub+1));
        			}
        		}
        		
        	}else if(comm.equals("rm")) {
        		for(int j = 0; j < result.size(); j++) {
        			if(!result.get(j).contains(tree)) {
        				continue;
        			}
        			
        			boolean rm = true;
        			for(int len = 0; len < tree.length(); len++) {
        				if(tree.charAt(len) != result.get(j).charAt(len)) {
        					rm = false;
        				}
        			}
        			
        			if(rm && result.get(j).length() > tree.length()) {
        				if(result.get(j).charAt(tree.length()) == '/') {
        					rm = true;
        				}else {
        					rm = false;
        				}
        			}
        			
        			if(rm ) {
            				result.remove(j);
            				j--;        	     
        			}
        			
        		}
        	}
        	
//        	System.out.println("-----------------------");
//        	for(int a = 0; a < result.size(); a++) {
//        		System.out.println(result.get(a));
//        	}
        }
        
        answer = new String[result.size()];
        for(int i = 0; i<result.size(); i++) {
        	answer[i] = result.get(i);
        }
        return answer;
    }
	
}