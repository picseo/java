package d0305;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
 * ������ķ� �ϴ°� �� ������ �� ����.
 * 
 * */
public class SWEA_5684_D4_� {
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

			//dfs ����Ŭ Ž��
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
		
		if(visited[now]) {//start�� �ƴѵ� �ݺ��Ǵ� ��� ���ѷ����� �߻������ϹǷ� �����ֱ�
			return ;
		}
		
		if(result <= length) {//����ġ��� �ð��� ���δ�.
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