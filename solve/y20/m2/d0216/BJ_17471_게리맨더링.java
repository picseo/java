package solve.s0216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/*�κ������� ��Ʈ �����ڸ� �̿��ؼ� ���߰�
 * ������ bfs�� �̿��ؼ� ���ߴ�.*/
public class BJ_17471_�Ը��Ǵ��� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int n = sc.nextInt();
		//System.out.println("n : " + n);
		int[] pps = new int[n];
		for(int i = 0; i < n ; i++) {
			pps[i] = sc.nextInt();
		}
		//System.out.println(Arrays.toString(pps));
		
		List<Integer>[] list = new List[n+1];
		for(int i = 0; i < n ; i++) {
			list[i] = new ArrayList();
		}
		
		for(int i = 0; i < n; i++) {
			int how = sc.nextInt();
			for(int j = 0; j < how; j++) {
				list[i].add(sc.nextInt()-1);
			}
		}
		
		//System.out.println(list);
		
		int result = Integer.MAX_VALUE;
		//���ű��� ���Ե� ������ ���� -> �κ����� -> ����!
		boolean[] visited = new boolean[n];
		int[] sec = new int[n];
		for(int i = 0; i < (1 <<n); i++) {
			Arrays.fill(visited,  false);
			//1, 0���� Ȯ��
			for(int j = 0; j < n; j++) {
				if((i & 1<<j) > 0) {//1
					sec[j] = 1;
				}else {
					sec[j] = 0;
				}
			}
			
			//0�� ���� graphŽ��,
			//cnt : ���� �� (2�� �ƴ� ��� ����� �ʿ����)
			//nums_1 : 1���� ����� �� 
			//nums_0 : 0���� ����� �� 
			
			int cnt = 0;
			int[] nums = new int[2];
			Queue<Integer> queue = new LinkedList();
			for(int c = 0; c < n; c++) {
				if(!visited[c]) {
					int sector = sec[c];
					nums[sector] += pps[c];
					cnt++;
					queue.add(c);
					visited[c] = true;
					while(!queue.isEmpty()) {
						int now = queue.poll();
						for(int q = 0; q < list[now].size(); q++) {
							int q_now = list[now].get(q);
							if(!visited[q_now] && sector == sec[q_now]) {
								visited[q_now] = true;
								nums[sec[q_now]] += pps[q_now];
								queue.add(q_now);
							}
						}
					}
				}
			}//graphŽ�� for��
			
			if(cnt != 2) {
				continue;
			}
			
			int gab = Math.abs(nums[0] - nums[1]);
			if(result > gab) {
				result = gab;
			}
		}//for��
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}

	}

	private static String src = "6\r\n" + 
			"2 3 4 5 6 7\r\n" + 
			"2 2 3\r\n" + 
			"2 1 3\r\n" + 
			"2 1 2\r\n" + 
			"2 5 6\r\n" + 
			"2 4 6\r\n" + 
			"2 4 5";
}
