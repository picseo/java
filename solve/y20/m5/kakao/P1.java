package kakao;

import java.util.LinkedList;
import java.util.Queue;

/*
 [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
 * */
public class P1 {
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int[][] buttons = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 2}};
	public static void main(String[] args) {
		
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		System.out.println(solution(numbers, "right"));

	}

	static class Point{
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static boolean isIn(int x, int y) {
		return x >=0 && x < 4 && y >= 0 && y < 3;
	}
	
	static int bfs(int x, int y, int target) {
		Queue<Point> q = new LinkedList();
		boolean[][] visited = new boolean[4][3];
		
		q.add(new Point(x, y));
		visited[x][y] = true;
		
		int len = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Point now = q.poll();
				
				if(buttons[target][0] == now.x && buttons[target][1] == now.y) {
					return len;
				}
				
				for(int d= 0; d < 4; d++) {
					int nx = now.x + dirs[d][0];
					int ny = now.y + dirs[d][1];
					
					if(isIn(nx, ny) && !visited[nx][ny]) {
						q.add(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
			len++;
		}
		
		return -1;
	}
	
	public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        Point L = new Point(3, 0);
        Point R = new Point(3, 2);
        
        for(int i = 0; i < numbers.length; i++) {
        	int now = numbers[i];
        	
        	if(now == 1 || now == 4 || now == 7) {
        		answer.append("L");
        		L.x = buttons[now][0];
        		L.y = buttons[now][1];
        	}else if(now == 3 || now == 6 || now == 9) {
        		answer.append("R");
        		R.x = buttons[now][0];
        		R.y = buttons[now][1];
        	}else {//2, 5, 8, 0
        		int left = bfs(L.x, L.y, now);
        		int right = bfs(R.x, R.y, now);
        		
        		if(left == right) {
        			if(hand.equals("left")) {
        				answer.append("L");
                		L.x = buttons[now][0];
                		L.y = buttons[now][1];
        			}else {
        				answer.append("R");
                		R.x = buttons[now][0];
                		R.y = buttons[now][1];
        			}
        		}else if(left < right) {
        			answer.append("L");
            		L.x = buttons[now][0];
            		L.y = buttons[now][1];
        		}else {
        			answer.append("R");
            		R.x = buttons[now][0];
            		R.y = buttons[now][1];
        		}
        	}
        }
        return answer.toString();
    }
}
