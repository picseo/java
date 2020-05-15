package d0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//어제 풀었던 달이차오른다와 같게 생각했는데 그건 역시 잘못이었다. 문제를 맘대로 생각하지 말자
/*
 달이 차오른다는 최소 길을 구하는 것이여서 배 칸마다 cnt를 구해야 겠지만
 이번 문제는 최소길이가 아니라 가질 수 있는 문서의 최대 값을 구하는 거라서 
 key를 들고 다니지 않고, 전역 배열로 가지고 있어도 된다.
 
 또한 중요한 점은 아직 열쇠가 없는 곳이라면 문마다 만들어진 queue에 다가 잠시 저장해둔 후에
 열쇠를 발견하면 문의 queue에 달린 것들을 q로 다시 담는 방식으로 진행하면 bfs의 정의를 망치치 않고 진행할 수 있다.
 
 bfs는 분신을 만들어서 뿌리는것!
 * */
public class BJ_9328_열쇠 {
	static int N, M;
	static char map[][];
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static String ABC = "QWERTYUIOPASDFGHJKLZXCVBNM";
	static String abc = "qwertyuiopasdfghjklzxcvbnm";
	static boolean[] keys;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N+2][M+2];
			for(char[] a : map) {
				Arrays.fill(a,  '.');
			}
			
			for(int i = 1; i < N+1; i++) {
				String input = br.readLine();
				for(int j = 1; j < M+1; j++) {
					map[i][j] = input.charAt(j-1);
				}
			}

			String input = br.readLine();
			keys = new boolean[27];
			if(!input.equals("0")) {
				for(int i = 0; i < input.length(); i++) {
					keys[input.charAt(i)-'a'] = true;
				}
			}

			int result = bfs(0, 0);

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer>[] doors = new LinkedList[26];
		for(int i =0 ; i < 26; i++) {
			doors[i] = new LinkedList<Integer>();
		}
		
		boolean[][] visited = new boolean[N+2][M+2];

		visited[x][y] = true;
		q.add(x); q.add(y); 
		
		int max = 0;
		while(!q.isEmpty()) {
			int xx = q.poll();
			int yy = q.poll();
			
			for(int d= 0; d < 4; d++) {
				int nx = xx + dirs[d][0];
				int ny = yy + dirs[d][1];
				
				if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] != '*') {
					if(map[nx][ny] == '.') {
						visited[nx][ny] = true;
						q.add(nx); q.add(ny);
					}else if(map[nx][ny] == '$') {
						visited[nx][ny] = true;
						max++;
						map[nx][ny] = '.';
						q.add(nx); q.add(ny);
					}else if(ABC.contains(""+map[nx][ny])) {//door
						if(keys[map[nx][ny] - 'A']) {
							visited[nx][ny] = true;
							map[nx][ny] = '.';
							q.add(nx); q.add(ny);
						}else {
							doors[map[nx][ny]-'A'].add(nx);
							doors[map[nx][ny]-'A'].add(ny);
						}
					}else if(abc.contains(""+map[nx][ny])) {
						visited[nx][ny] = true;
						
						if(!keys[map[nx][ny]-'a']) {
							while(!doors[map[nx][ny]-'a'].isEmpty()) {
								q.add(doors[map[nx][ny]-'a'].poll());
							}
						}
						
						keys[map[nx][ny]-'a'] = true;
						q.add(nx); q.add(ny);
					}
				}
			}
		}
		
		return max;
	}

	static boolean isIn(int x, int y) {
		return x >=0 && x < N+2 && y >=0 && y < M+2;
	}
}
