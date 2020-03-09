package solve.s0211;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//결국 연결된 뭉텅이들을 찾는게 목적이었다. - > bfs를 이용
public class JA_1863_종교 {
	private static boolean[] visited;
	private static List<Integer>[] students;
	private static Queue<Integer> queue = new LinkedList();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);

		int n = sc.nextInt();
		int m = sc.nextInt();

		students = new List[n+1];
		for(int i = 1; i < n+1 ; i++) {
			students[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			students[from].add(to);
			students[to].add(from);
		}

		visited = new boolean[n+1];
		int cnt = 0;
		for(int i = 1; i < students.length; i++) {
			if(!visited[i]) {
				cnt++;
				bfs(i);
			}
		}

		System.out.println(cnt);
	}

	private static void bfs(int input) {
		visited[input] = true;
		queue.add(input);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i = 0; i < students[now].size(); i++) {
				int tmp = students[now].get(i);
				if(!visited[tmp]) {
					visited[tmp] = true;
					queue.add(tmp);
				}
			}
		}
	}

	private static String src = "10 9\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"1 5\r\n" + 
			"1 6\r\n" +
			"1 7\r\n" + 
			"1 8\r\n" + 
			"1 9\r\n" + 
			"1 10";
}