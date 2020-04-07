package d0403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * (r, c) (1, 1)
 * 
 * 처음 모든 칸엔 양분 5만큼씩 들어있다.
 * 
 * M개의 나무를 심음 -> 한 칸에 여러개나무 가능
 * 
 * 본 : 나이만큼 양분을 먹고, 나이 1증가(나이가 어린 나무부터 양분을 먹음,  부족하면 죽음)
 * 
 * 여름 : 죽은 나무가 양분이 된다. -> 죽은 나무 나이/2(소수점 아래 버림)
 * 
 * 가을: 나무가 번식, 나이가 5의 배수인 나무는 인접한 8개의 칸에 나이가 1인 나무를 만듬(범위내에서)
 * 
 * 겨울 : 양분추가
 * 
 * K년이 지난 후 나무의 갯수
 * 
 * 시뮬레이션 문제
 * 
 * 처음에는 하나의 나무 클래스의 list를 만들어서 다 넣고 풀었는데 시간초과가 났다.
 * 
 * 그래서 각 칸으로 트리의 list를 분산시켰더니 맞았다.
 * 
 * 시물레이션에서 나무처럼 움직이지 않는 것을 list를 각 칸에 만들어주고
 * 
 * 세균 문제처럼 움직이는 경우에는 list를 만드는 것이 좋은가 보다
 * */
public class BJ_16235_나무재테크 {
	static int N, M, K;
	static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	static int[][] food, A;
	static List<Integer>[][] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		food = new int[N][N];
		A = new int[N][N];
		tree = new List[N][N];
		int[][] die = new int[N][N];
		
		for(int i = 0; i < N ; i++) {
			for(int j =0; j < N; j++) {
				A[i][j] = sc.nextInt();
				food[i][j] = 5;
				tree[i][j] = new ArrayList();
			}
		}

		for(int i = 0; i < M; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int age = sc.nextInt();
			tree[x][y].add(age);
		}
		
		while(K-- > 0) {			
			//본 : 나이만큼 양분을 먹고, 
			//나이 1증가(나이가 어린 나무부터 양분을 먹음,  부족하면 죽음)
			for(int i = 0; i < N; i++) {
				Arrays.fill(die[i],  0);//초기화
				for(int j = 0; j < N;j ++) {
					if(tree[i][j].size() != 0) {
						tree[i][j].sort(null);
						
						for(int tr = 0; tr < tree[i][j].size(); tr++) {
							int now = tree[i][j].get(tr);
							if(now > food[i][j]) {
								die[i][j] += (now/2);
								tree[i][j].remove(tr);
								tr--;
							}else {
								food[i][j] -= now;
								tree[i][j].set(tr, now+1);
							}
						}
						
					}
				}
			}
			
			//여름 : 죽은 나무가 양분이 된다. -> 죽은 나무 나이/2(소수점 아래 버림)
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <N; j++) {
					food[i][j] += die[i][j];
				}
			}
			
			// 가을: 나무가 번식, 
			//나이가 5의 배수인 나무는 인접한 8개의 칸에 나이가 1인 나무를 만듬(범위내에서)
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N;j ++) {
					if(tree[i][j].size() != 0) {						
						for(int tr = 0; tr < tree[i][j].size(); tr++) {
							int now = tree[i][j].get(tr);
							if(now%5 ==0) {
								for(int d = 0; d < 8; d++) {
									int nx = i+dirs[d][0];
									int ny = j+dirs[d][1];
									
									if(nx >=0 && nx <N && ny >=0 && ny < N) {
										tree[nx][ny].add(1);
									}
								}
							}
						}
						
					}
				}
			}
			
			//겨울 : 양분추가
			for(int i = 0; i < N ; i++) {
				for(int j = 0; j < N; j++) {
					food[i][j] += A[i][j];
				}
			}
		}
		
		int result = 0;		
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N; j++) {
				result += tree[i][j].size();
			}
		}
		
		System.out.println(result);
	}
}
