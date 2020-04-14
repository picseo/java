package d0409;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

public class Prim {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		
		for(int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a][b] = c;
			adj[b][a] = c;
		}
		
		boolean[] check = new boolean[V];
		int[] key = new int[V]; //부모정점으로부터 현재 정점까지 드는 비용 저장 
		int[] p = new int[V]; //정점의 부모를 저장할 배열 
		
		//key는 무한대로 초기화 
		Arrays.fill(key, Integer.MAX_VALUE);
		
		//아무거나 하나 선택 
		p[0] = -1;
		key[0] = 0;
		
		//이미 하나 골랐으니 나머지 정점들에 대하여 
		for(int i = 0; i < V-1; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1; //찾으면 그놈의 위치를 여기 저장 
			//안골라진 친구들 중 키값이 제일 작은애를 고르자
			for(int j = 0; j < V; j++) {
				//안골라진지 검사 
				if(!check[j] && key[j] < min) {
					index = j;
					min = key[j];
				}
			}
			
			//index: 선택이 안된 정점 중 키값이 제일 작은 정점이 들어있음
			check[index] = true;
			
			//index 정점에서 출발하는 모든 간선에 대해 키 값 업데이트
			for(int j = 0; j < V; j++) {
				//check가 안되어있고 간선은 존재하고 들어있는 키값보다 지금 경로 가중치가 더 적으면 업데이트 
				if(check[j] == false && adj[index][j] != 0 && key[j] > adj[index][j]) {
					p[j] = index; 
					key[j] = adj[index][j];
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < V; i++) {
			result += key[i];
		}
		System.out.println(result);
	}
}