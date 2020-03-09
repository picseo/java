package solve.s0216;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA_5684_D4_운동 {
	public static long result = -1;
	public static List<Line> [] list = null;
	public static int[] visited = null;
	public static LinkedList<Line> linked = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T  = sc.nextInt();
		for(int t = 1 ; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			result = Integer.MAX_VALUE;
			visited = new int[n];

			list = new List[n];
			for(int i = 0; i < n ; i++){
				list[i] = new ArrayList();
			}

			linked = new LinkedList<Line>();
			
			for(int i =0 ; i < m; i++) {
				int from = sc.nextInt() - 1;
				int to = sc.nextInt() - 1;
				int weight = sc.nextInt();

				list[from].add(new Line(from, to, weight));
			}

			//dfs 사이클 탐색
			for(int i = 0; i < n; i++) {
				if(visited[i] == 0) {
					dfs2(i);
				}
				linked.clear();
			}
			
			if(result == Integer.MAX_VALUE)
				result = -1;

			System.out.println("#"+t+" "+result);
		}
	}
	
	
	private static class Line{
		int from;
		int to;
		long weight;
		public Line(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}	
	}

	private static void dfs(int start, int now) {
		int len = list[now].size();
		//System.out.print(now + "- ");
		for(int i = 0; i < len; i++) {
			int next = list[now].get(i).to;
			long next_len = list[now].get(i).weight;

			if(visited[next] == -1) {
				long tmp = calculate(next);
				tmp += next_len;
				if(result > tmp) {
					result = tmp;
				}
			}

			if(visited[next] == 0) {
				visited[next] = -1;
				linked.add(list[now].get(i));
				dfs(start, next);
				visited[next] = 1;
			}
		}
	}

	private static void dfs2(int now) {
		int len = list[now].size();
		if(visited[now] != 0) {
			if(visited[now] == -1) {
				long tmp = calculate(now);
				if(result > tmp) {
					result = tmp;
				}
			}
			
			if(visited[now] ==1) {
				visited[now] = 2;
			}
			return;
		}
		
		visited[now] = -1;
		for(int i = 0; i < len; i++) {
			linked.add(list[now].get(i));
			dfs2(list[now].get(i).to);
			linked.remove(list[now].get(i));
		}
		visited[now] = 1;
	}
	
	private static long calculate(int start) {
		long tmp = 0;
		for(int i = linked.size()-1; i >=0; i--) {
			if(linked.get(i).from == start) {
				tmp += linked.get(i).weight;
				break;
			}else {
				tmp += linked.get(i).weight;
			}
		}		
		return tmp;
	}
	
	private static String src = "1      \r\n" + 
			"4 5    \r\n" + 
			"1 2 20  \r\n" + 
			"2 1 1  \r\n" + 
			"1 3 2\r\n" + 
			"3 4 5\r\n" + 
			"4 2 1";
}