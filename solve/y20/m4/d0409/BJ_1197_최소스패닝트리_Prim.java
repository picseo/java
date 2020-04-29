package d0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//인접 행렬로 풀었더니 메모리 초과가 난다.
public class BJ_1197_최소스패닝트리_Prim {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] adj = new int[V][V];
		int[] p = new int[V];
		int[] key = new int[V];
		boolean[] check = new boolean[V];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			
			adj[from][to] = val;
			adj[to][from] = val;
		}
		
		int result = 0;		
		Arrays.fill(key, Integer.MAX_VALUE);
		p[0] = -1;//부모 
		key[0] = 0;//신장트리에서 그 점으로 갈때 가지는 최소값
		
		for(int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int index = 0;
			
			for(int j = 0; j < V; j++) {
				if(!check[j] && key[j] < min) {
					min = key[j];
					index = j;
				}
			}
			
			check[index] = true;
			
			for(int j = 0; j < V; j++) {				
				if(!check[j] && adj[index][j] != 0 && key[j] > adj[index][j]) {
					key[j] = adj[index][j];
					p[j] = index;
				}
			}
		}
		
		for(int i = 0; i < V; i++) {
			result += key[i];
		}
		
		System.out.println(result);
	}
}
