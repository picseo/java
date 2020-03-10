package d0305;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
 * 인접행렬로 하는게 더 편했을 것 같다.
 * 
 * */
public class SWEA_5684_D4_운동 {
	public static int result = -1;
	public static List<int[]> [] list = null;
	public static boolean[] visited = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T  = sc.nextInt();
		for(int t = 1 ; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			result = Integer.MAX_VALUE;
			visited = new boolean[n];
			
			list = new List[n];
			for(int i = 0; i < n ; i++){
				list[i] = new ArrayList();
			}

			for(int i =0 ; i < m; i++) {
				int from = sc.nextInt() - 1;
				int to = sc.nextInt() - 1;
				int weight = sc.nextInt();

				list[from].add(new int[] {to, weight});
			}

			//dfs 사이클 탐색
			for(int i = 0; i < n; i++) {
				Arrays.fill(visited,  false);
				dfs(i, i, 0);
			}
			
			if(result == Integer.MAX_VALUE)
				result = -1;

			System.out.println("#"+t+" "+result);
		}
	}

	private static void dfs(int start, int now, int length) {
		//System.out.println("start : " + start + ", now  : " + now + " ,  length : " + length);
		if(start == now && visited[now]) {
			if(result > length) {
				result = length;
			}
			return ;
		}
		
		if(visited[now]) {//start가 아닌데 반복되는 경우 무한루프가 발생가능하므로 끝내주기
			return ;
		}
		
		if(result <= length) {//가지치기로 시간을 줄인다.
			return ;
		}
		
		visited[now] = true;
		for(int i = 0; i < list[now].size(); i++) {
			int next = list[now].get(i)[0];
			int next_len = list[now].get(i)[1];
			dfs(start, next, length+next_len);
		}
	}
	
	private static String src = "1      \r\n" + 
			"3 4    \r\n" + 
			"1 2 1  \r\n" + 
			"3 2 1  \r\n" + 
			"1 3 5\r\n" + 
			"2 3 2";
}