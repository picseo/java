package d0511;

import java.util.Arrays;
import java.util.Scanner;
/*
 크레인으로 박스들을 최소한의 시간으로 옮기는 문제였다.
 
 나의 방식은 크레인과 박스들을 크기순으로 오름차순 정렬하고,
 그 뒤에 크레인이 지금 옮기려는 박스의 idx를 저장하는 crIdx를 만들었다.
 그리고 visited배열을 통해 옮겨졌는지 여부를 표시하였다.
 
  방법은 먼저 모든 크레인의 박스 idx를 가장 큰 수의 위치로 설정을 해 놓은 다음에 모든 박스들이 옮겨질때까지
  while문을 돌면서 옮길 수 있는 박스를 찾기 위해 idx--을 실행한다.
 * */

//https://www.acmicpc.net/source/4426891 어떻게 이렇게 빠른지 확인해야겠다.
public class BJ_1092_배 {
	static int N, M;
	static int[] crains;
	static Pair[] crIdx;
	static int[] boxes;
	static boolean[] visited;
	
	static class Pair{
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		crains = new int[N];
		for(int i =0 ; i < N; i++) {
			crains[i] = sc.nextInt();
		}
		Arrays.sort(crains);
		
		M = sc.nextInt();
		
		crIdx = new Pair[N];
		for(int i = 0; i < N ; i++) {
			crIdx[i] = new Pair(crains[i], M-1);
		}
		
		boxes = new int[M];
		visited = new boolean[M];
		
		for(int i =0; i < M ; i++) {
			boxes[i] = sc.nextInt();
		}
		Arrays.sort(boxes);
		
		int cnt = 0;
		int total = M;
		if(crains[N-1] < boxes[M-1]) {
			System.out.println(-1);
			return;
		}
		
		while(total > 0) {
			for(int i = 0; i < N; i++) {
				if(crIdx[i].y < 0)
					continue;
				total -= check(i);
			}
			cnt++;
		}
		System.out.println(cnt);
	}

	private static int check(int i) {
		int val = crIdx[i].x;
		int idx = crIdx[i].y;
		
		boolean find = false;
		int delete = 0;
		while(!find) {
			if(idx < 0) {
				find = true;
				continue;
			}
			
			if(boxes[idx] > val || visited[idx]) {
				idx--;
			}else{
				visited[idx] = true;
				idx--;
				delete = 1;
				find = true;
			}			
		}
		
		return delete;
	}

}
