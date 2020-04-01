package d0401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/*
 * 위상 정렬이라는 문제 유형이라고 한다.
 * 진입 차수를 줄여가는 방식으로 풀었다.
 * 
 * */
public class BJ_2623_음악프로그램 {
	static int N, M;	
	static int result = 0;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		//graph 생성
		List<Integer>[] graph = new List[N+1];
		int[] in = new int[N+1];
		for(int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList();
		}
		
		for(int i = 0; i < M ; i++) {
			int num = sc.nextInt();
			int start = sc.nextInt();
			for (int j = 0; j < num-1; j++) {
				int end =  sc.nextInt();
				graph[start].add(end);
				start = end;
				in[end]++;
			}					
		}

		/*
		 * 나는 앞 점이 가져야 하는 정보를 뒤에 있는 모든 점이라고 생각했는데
		 * 다른 사람의 코드에서는 한단계씩만 고려해서 풀었다.
		 * 
		 * int start = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K - 1; j++) {
				int end = Integer.parseInt(st.nextToken());
				list[start].add(end);
				start = end;
				pre[end]++;
			}
			1->2->3인경우에 
			1-> 2, 2->3만 확인을 하는것 같다.
			이 방법이면 이중for문을 돌지 않아도 되니까 좋을것같다.
		 * */
		//graph는 자기 앞에 와야 하는 번호들을 의미한다.
		for(int i = 1; i < N+1; i++) {
			System.out.print(i +" : " );
			for(int j = 0; j < graph[i].size(); j++) {
				System.out.print(graph[i].get(j) + " " );
			}
			System.out.println();
		}
		
		System.out.println(Arrays.toString(in));
		
		Queue<Integer> queue = new LinkedList();
		for(int i = 1; i < N+1; i++) {
			if(in[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			sb.append(now).append("\n");
			result++;
			
			for(int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				in[next]--;
				if(in[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		if(result != N) {
			System.out.println(0);
		}else {
			System.out.print(sb);
		}
	}
	
}
