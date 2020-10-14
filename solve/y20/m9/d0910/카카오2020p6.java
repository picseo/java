package d0910;

import java.util.Arrays;

//��Ž���� Ȯ��? 
// �� ģ���� n���� ��ġ���� �ݽð質 �ð�� Ž��, 
// �ٸ� ģ���� �װſ� ��ġġ �ʴ°ɷ� Ž��
// �׷��� ��� Ž���� �� �ִ� ��� �� ������� ������ -> (n*2)^8
public class īī��2020p6 {
	public static boolean[] visited;
	public static boolean ok = false;

	public static void main(String[] args) {
		System.out.println(solution(20, new int[] {0, 10}, new int[] {1,1}));
	}	

	public static int solution(int n, int[] weak, int[] dist) {
		int answer = -1;
		

		visited = new boolean[dist.length];
		
		for(int i = 1; i <= dist.length; i++) {
			find(n,dist, weak, 0, new int[i]);
			if(ok) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	private static void find(int n, int[] dist, int[] weak, int idx, int[] tmp) {
		if(idx == tmp.length) {
			System.out.println(Arrays.toString(tmp));
			for(int i = 0; i < weak.length; i++) {
				check(n, weak, i, tmp);
			}
			return ;
		}

		for(int i = 0; i < dist.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmp[idx] = dist[i];
				find(n, dist, weak,idx+1, tmp);
				visited[i] = false;
			}
		}
		return;
	}

	private static void check(int n, int[] weak, int start, int[] dist) {
		int[] tmp = new int[weak.length];

		int idx = 0;
		for(int i = start; i < weak.length; i++) {
			tmp[idx++] = weak[i];
		}
		for(int i = 0; i < start; i++) {
			tmp[idx++] = weak[i]+n;
		}

		int cnt = 0;
		int now = -1;
		idx = 0;
		for(int i = 0; i < weak.length; i++) {
			if(tmp[i] <= now) {
				cnt++;
			}else {
				if(idx < dist.length) {
					now = tmp[i] + dist[idx++];
					i--;
				}
			}			
		}

		if(cnt == weak.length) {
			ok = true;
		}
		return;
	}


}
