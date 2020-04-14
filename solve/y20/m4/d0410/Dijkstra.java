package d0410;

import java.util.Arrays;
import java.util.Scanner;

//pq X 간선이 매우 많을 때 유리!
public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 갯수
		int E = sc.nextInt(); // 간선의 갯수
		int [][] adj = new int[V][V];
		for(int i = 0; i < E; i++) {
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		int[] D = new int[V];
		Arrays.fill(D, Integer.MAX_VALUE);
		boolean[] check = new boolean[V];
		//dijkstra 시작점이 a정점이라면 D[a]=0
		D[0] = 0;
		for(int i = 0; i < V-1; i++) {
			int min = Integer.MAX_VALUE;//가장 작은 값을 기억할 변수
			int index = -1;//그 위치를 기억할 변수
			for(int j = 0;  j < V; j++) {
				//아직 처리하지 않았으면서 ,가장 짧은 거리라면
				if(!check[j] && min > D[j]) {
					min = D[j];
					index = j;
				}
			}
			
			//연결이 없는 경우 끝;
			if(index == -1) {
				break;
			}
			
			//처리된 놈으로 체크
//			check[index] = true;
//			if(index == end) {
//				break;
//			}
			//새로운 친구로부터 갈 수 있는 경로들을 업데이트
			for(int j = 0; j < V; j++) {
				//아직 처리하지 않았으면서 , 경로가 존재하고, index까지의 거리 + index부터 j까지의 거리가 D[j]보다 작다면
				if(!check[j] && adj[index][j] != 0 && D[index]+adj[index][j] < D[j]) {
					D[j] = D[index] + adj[index][j];
				}
			}
			
						
		}
		
		System.out.println(Arrays.toString(D));
	}
}
