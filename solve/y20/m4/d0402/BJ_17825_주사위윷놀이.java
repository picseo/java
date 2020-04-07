package d0402;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 4^10 -> 2^20 - 1024*1024 - > 1000000(백만)
 * 완탐 문제라고 생각했다.
 * 
 * 1억번 연산에 1초!!!!
 * 
 * 근데 맵을 어떻게 타야 할 지 모르겠다.
 *
 * 10, 20, 30에 걸리지 않으면 2씩 증가한다.
 * 25 에서 시작하면 5씩 증가해서 40까지 된다.
 * 
 *  40을 넘으면 도착한 것이다.
 *  
 *  10에서 출발하면 13, 16, 19, 25
 *  20에서 22, 24, 25
 *  
 * 
 * 
 * 이동을 마칠때마다 점수가 추가된다.
 */
public class BJ_17825_주사위윷놀이 {
	static int[] num = new int[10];
	static int result = 0;
	static int[][] st = {{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40}, 
			{10, 13, 16, 19, 25, 30, 35, 40},
			{20, 22, 24, 25, 30, 35, 40},
			{30, 28, 27, 26, 25, 30, 35, 40}
			};
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			num[i] = sc.nextInt();
		}
		
		System.out.println(st[0].length);
		System.out.println(st[1].length);
		System.out.println(st[2].length);
		System.out.println(st[3].length);
		dfs(10, 0, new int[10]);
		
		System.out.println(result);
	}

	private static void dfs(int n, int cur, int[] tmp) {
		if(n == cur) {
			int res = count(tmp);
			if(result < res) {
				result = res;
			}
		}else {
			for(int i = 0; i < 4; i++) {
				tmp[cur] = i;
				dfs(n, cur+1, tmp);
			}
		}
	}

	private static int count(int[] tmp) {
		Node[] horse = new Node[4];
		for(int i = 0; i <4; i++) {
			horse[i] = new Node();
		}
		
		int res = 0;
		
		for(int i = 0; i < 10; i++) {
			int t = horse[tmp[i]].t_num;
			int w = horse[tmp[i]].where;
			
			if(t == -1) {
				return -1;//도착칸에 도착한 말은 선택할 수 없다.
			}
			
			if(w + num[i] < st[t].length) {//범위 내에 존재하는가
				for(int j = 0; j < 4; j++) {
					if(j == tmp[i] || horse[j].t_num == -1)
						continue;
					if(st[horse[j].t_num][horse[j].where] == st[t][w+num[i]]) {
						return -1;
					}
				}
				
				//도착하는 칸에 다른 말이 없다면
				res += st[t][w+num[i]];
				if(st[t][w+num[i]] == 10) {
					horse[tmp[i]].t_num = 1;
					horse[tmp[i]].where = 0;
				}else if(st[t][w+num[i]] == 20) {
					horse[tmp[i]].t_num = 2;
					horse[tmp[i]].where = 0;
				}else if(st[t][w+num[i]] == 30) {
					horse[tmp[i]].t_num = 3;
					horse[tmp[i]].where = 0;
				}else {
					horse[tmp[i]].where = w+num[i];
				}				
			}else {
			 //범위를 벗어나면 도착칸에 들어간것을 의미한다.
				horse[tmp[i]].t_num = -1;
			}
			
		}		
		
		return res;
	}

	static class Node{
		int t_num = 0;//시작위치
		int where = 0;//몇번째인지
		public Node() {
		}		
	}
	
}

//1 2 3 4 1 2 3 4 1 2 -> 190
//1 1 1 1 1 1 1 1 1 1 -> 133
//5 1 2 3 4 5 5 3 2 4 -> 214
//5 5 5 5 5 5 5 5 5 5 -> 130