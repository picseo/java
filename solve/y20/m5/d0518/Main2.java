package d0518;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main2 {
	static boolean[][] visited;
	static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = solution(6,	4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
		System.out.println(answer[0] +", "+answer[1]);
		
		System.out.println(solution2(8));
	}

	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];
        int result = -1;
        int noa = 0;
        for(int i = 0; i < m; i++) {
        	for(int j =0; j < n; j++) {
        		if(!visited[i][j] && picture[i][j] != 0) {
        			int cnt = bfs(i, j, m, n, picture);
        			if(result < cnt) {
        				result = cnt;
        			}
        			noa++;
        		}
        	}
        }       
        
        numberOfArea = result;
        maxSizeOfOneArea = noa;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

	private static int bfs(int x, int y, int m, int n, int[][] map) {
		Queue<Integer> q = new LinkedList();
		q.add(x); q.add(y);
		visited[x][y] = true;
		int result = 0;
		while(!q.isEmpty()) {
			int qx = q.poll();
			int qy = q.poll();
			result++;
			for(int d = 0; d < 4; d++) {
				int nx = qx + dirs[d][0];
				int ny = qy + dirs[d][1];
				
				if(nx >= 0 && nx < m && ny >= 0&& ny < n) {
					if(!visited[nx][ny] && map[x][y] == map[nx][ny]) {
						q.add(nx); q.add(ny);
						visited[nx][ny] = true;
					}
				}
			}
		}		
		return result;		
	}
	
	public static String solution2(int n) {
        String answer = "";
        Stack<Integer>st = new Stack<Integer>();
        n -= 1;
        if(n == 0) {
        	st.push(0);
        }          
        while(n != 0) {
        	st.push(n%4);
        	n /= 4;
        }
        
        StringBuilder result = new StringBuilder();
        String stst = st.toString();
        while(!st.isEmpty()) {
        	int now = st.pop();
        	char next = ' ';
        	if(now == 0) {
        		next = '1';
        	}else if(now == 1) {
        		next = '2';
        	}else if(now == 2) {
        		next = '4';
        	}
        	result.append(next);
        }
        
        return result.toString()+","+stst;
    }
	
}
