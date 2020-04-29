package d0415;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 처음에 네방향을 확인하는 것을 그 방향에 속한 모든 칸들을 보는 것으로 잘 못 해석한것과 
 * 뒤 돌아가는 방향은 처음 들어온 값을 기준으로 해야 하는데 그것을 회전시키다가 잘 못된 방향으로 보냈었다.
 * 
 * 풀긴했는데 고쳐야하는 점은
 * 왼쪽방향으로 가고 싶을 때, -1을 하는 것보다는 +3을 한 뒤 모듈러를 하는게 더 좋았릉 것같다.
 * 
 * 사방이 막힌 것을 네방향을 회전하면서 확인하기 보다는 if문으로 입장하자마자 확인을 했다면 더 빨리 뒤돌아 나올 수 있었다.
 * 이렇게 하는 경우 현재 방향의 반대니까 그냥 빼주기만 하면 된다.크으 멋지다.
 * 
 * if(a[x+1][y] != 0 && a[x-1][y] != 0 && a[x][y+1] != 0 && a[x][y-1] != 0){
            if(a[x-dx[d]][y-dy[d]] == 1){
                break;
            }else{
                x -= dx[d];
                y -= dy[d];
            }    
        }else{
            d = (d+3)%4;
            if(a[x+dx[d]][y+dy[d]] == 0){
                x+= dx[d];
                y+=dy[d];
            }
        }  
 * 
 * */
public class BJ_14503_로봇청소기 {
	static int[][] dirs = {{-1, 0}, {0, 1}, {1,0}, {0, -1}};
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int sx = sc.nextInt();
		int sy = sc.nextInt();
		int d = sc.nextInt();
		
		map = new int[N][M];
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j <M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		boolean stop = false;
		int cnt = 0;//회전 횟수
		while(!stop) {
			//현재 위치 청소
			map[sx][sy] = -1;
			
			//방향 탐색(왼쪽)
			int nextd = d - 1;
			if(nextd < 0) {
				nextd = 3;
			}
			
			int nx = sx + dirs[nextd][0];
			int ny = sy + dirs[nextd][1];
			boolean ok = false;
			if(map[nx][ny] == 0) {
				ok = true;
			}
			
			if(ok) {//빈칸이 존재 ->방향 바꿈, 한칸 전진
				d = nextd;
				sx += dirs[nextd][0];
				sy += dirs[nextd][1];
				cnt = 0;
			}else { // 빈칸이 존재하지 않음
				cnt++;
				d = nextd;
				if(cnt == 4) {//네방향 모두 없음
					int back = (d+2)%4;
					nx = sx + dirs[back][0];
					ny = sy + dirs[back][1];
					
					if(map[nx][ny] == 1) {
						stop = true;
					}else {
						sx += dirs[back][0];
						sy += dirs[back][1];
						cnt = 0;						
					}					
				}
			}
			
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == -1) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < N && y >=0 && y < M) {
			return true;
		}
		return false;
	}
}
