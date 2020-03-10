package d0306;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/* �̰Ŵ� �ٽ�Ǯ��� �Ѵ�.
 * 
 * Set�� ��ȣ�� ���� �о�ü��� ����.
 * Hashmap�� ��ȣ�� ���� �о�� �� �����Ƿ� �̰� ����ؾ߰ڴ�.
 * 
 * bfs �ϸ� �ȴ�.
 * */
public class SWEA_7988_D4_������� {
	static HashMap<String, Integer> player;
	static int K;
	static boolean[][] map;
	static int[] teamInfo;
	static boolean result;
	static int pcnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			K = sc.nextInt();
			
			map = new boolean[K*2][K*2];//(K���� �Է��� �־������� ���� ���� ������ �� �ִ� �ο�(K*2))
			player = new HashMap<>();
			pcnt = 0;
			
			for(int i = 0; i < K; i++) {
				String first = sc.next();
				String second = sc.next();
				
				if(!player.containsKey(first)) {
					player.put(first, pcnt++);
				}
				
				if(!player.containsKey(second)) {
					player.put(second, pcnt++);
				}
				
				map[player.get(first)][player.get(second)] = true;
				map[player.get(second)][player.get(first)] = true;
			}
			
			teamInfo = new int[pcnt];
			
			result = true;
			for(int i = 0; i < pcnt; i++) {
				if(teamInfo[i] == 0) {
					teamInfo[i] = 1;
					bfs(i);
				}
			
				if(!result)
					break;
			}		
			
			sb.append("#").append(t).append(" ").append((result)?"YES":"NO").append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList();
		queue.add(idx);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i = 0; i < 2*K; i++) {
				if(map[now][i]) {
					if(teamInfo[i] != 0 && teamInfo[i] == teamInfo[now]) {
						result  = false;
						return;
					}
					
					if(teamInfo[i] == 0) {
						teamInfo[i] = teamInfo[now] == 1? 2:1;
						queue.add(i);
					}
				}
			}
		}
	}
	
	private static String src = "3\r\n" + 
			"2\r\n" + 
			"Alex Tom\r\n" + 
			"Paul Alex\r\n" + 
			"4\r\n" + 
			"A B\r\n" + 
			"B C\r\n" + 
			"C D\r\n" + 
			"D A\r\n" + 
			"3\r\n" + 
			"z d\r\n" + 
			"d u_i\r\n" + 
			"z u_i";
}
