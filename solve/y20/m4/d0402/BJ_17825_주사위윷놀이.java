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
 * 
 * 말판을 자세히 보면 30이 두개 있다
 * 그런데 이것을 생각하지 못하고 말판에 써있는 값이 30일때 자꾸  t== 3으로 바꿔버리니까 이상한 값이 나왔다.
 * 이문제에서는 t==0일때만 새로운 루트로 갈 수 있으므로
 * t==0일때만 if문에서 t의 값을 바꿔주게 했더니 답을 얻을 수 있었다.
 * 
 * 또한 말의 중복순열을 dfs를 이용해서 구했는데 이것을 
 * bitmasking을 이용해서 할 수 있다고 한다.
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
		int[][] horse = new int[4][2]; // 0 : t, 1 : where
		
		int res = 0;		
		for(int i = 0; i < 10; i++) {
			int now = tmp[i]; // 현재 말의 번호
			int t = horse[now][0];
			int w = horse[now][1];
			
			if(t == -1) {
				return -1;//도착칸에 도착한 말은 선택할 수 없다. -> 더이상 볼 필요가 없다.
			}
			
			int wn = w + num[i];
			if(wn < st[t].length) {//범위 내에 존재하는가
				for(int j = 0; j < 4; j++) {
					if(j == now || horse[j][0] == -1)
						continue;
					if(st[horse[j][0]][horse[j][1]] == st[t][wn]) {
						//16, 22, 24, 26, 28 중복되는 값이므로 다르게 처리해야 한다.
						if(st[t][wn] == 16||st[t][wn] == 22||st[t][wn] == 24||st[t][wn] == 26||st[t][wn] == 28||st[t][wn] == 30) {
							if(horse[j][0] == t && horse[j][1] == wn) {
								return -1;
							}
						}else {
							return -1;//도달하게 되는 칸에 이미 다른 말이 있을 수 없으므로 이 루트는 적합하지 않다.
						}
					}
				}
				
				//도착하는 칸에 다른 말이 없다면
				int next = st[t][wn];
				res += next;
				if(t == 0 && st[t][wn] == 10) {
					horse[now][0] = 1;
					horse[now][1] = 0;
				}else if(t == 0 &&st[t][wn] == 20) {
					horse[now][0] = 2;
					horse[now][1] = 0;
				}else if(t == 0 &&st[t][wn] == 30) {
					horse[now][0] = 3;
					horse[now][1] = 0;
				}else {
					horse[now][1] = wn;
				}				
			}else {
			 //범위를 벗어나면 도착칸에 들어간것을 의미한다.
				horse[now][0] = -1;
				horse[now][1] = -1;
			}
			
		}		
		
		return res;
	}
	
}

//1 2 3 4 1 2 3 4 1 2 -> 190
//1 1 1 1 1 1 1 1 1 1 -> 133
//5 1 2 3 4 5 5 3 2 4 -> 214
//5 5 5 5 5 5 5 5 5 5 -> 130