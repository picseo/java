package algo_basic.SWEA.d0206;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * dfs라 생각했는데 안풀린다.
 * dfs로는 순환이 되는 그래프의 경우 최대 값을 찾을 수가 없게된다.
 * 한번 지나갔다 온 점도 다른 길로 접근하면 최대가 될수 있으므로 false, true를 잘 해주어야 한다.
 * 
 * **/
public class SWEA_2814_D3_최장경로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			int n = sc.nextInt();//점의갯수
			int m = sc.nextInt();//간선의 갯수
			
			List<Integer>[]  graph = new List[n];
			for(int i = 0; i < n; i++) {
				graph[i] = new ArrayList();
			}
			
			for(int i = 0; i < m; i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				
				graph[x].add(y);
				graph[y].add(x);
			}
			
			//최장 경로의 길이를 찾기
			int Max = Integer.MIN_VALUE;
			for(int i = 0; i < n ; i++) {
				boolean[] visited = new boolean[n];
				visited[i] = true;
				int tmp = find_long(i,0,graph,visited);
				if(tmp > Max)
					Max = tmp;
			}
			System.out.println("#"+t+" "+Max);
		}

	}

	private static int find_long(int now, int len, List<Integer>[] graph, boolean[] visited) {		
		int res = len;
		boolean check = false;
		for(int i = 0; i < graph[now].size(); i++) {
			int tmp = graph[now].get(i);
			if(!visited[tmp]) {
				check = true;
				visited[tmp] = true;
				int tmp_res = find_long(tmp, len+1, graph, visited);
				if(tmp_res > res)
					res = tmp_res;
				visited[tmp] = false;
			}
		}	
		
		if(!check) {
			return len+1;
		}else {
			return res;
		}
		
	}
	
	private static String src = "4\r\n" + 
			"1 0\r\n" + 
			
			"3 2\r\n" + 
			"1 2\r\n" + 
			"3 2\r\n" +
			
			"6 5\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"2 4\r\n" + 
			"2 5\r\n" + 
			"2 6\r\n" +
			
			"9 11\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"2 4\r\n" + 
			"2 5\r\n" + 
			"2 6\r\n" + 
			"4 7\r\n" + 
			"5 7\r\n" + 
			"5 8\r\n" +
			"6 9\r\n" + 
			"7 8\r\n" + 
			"8 9\r\n";
}
