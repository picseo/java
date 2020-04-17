package d0415;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*list가 아니라 배열만 이용해서도 뱀을 만들 수 있는 걸 보았다. 
 * 사과를 먹었을 때는 늘어나니까 괜찮은데
 * 사과를 먹지 않았을때는 순환하는 식으로 배열의 head와 tail을 바꾸었다.
 * 결국 배열로 연결 리스트를 만든 거였는데 그게 더 시간이 덜 들었다.
 * 
 * 나는 list로 뱀을 구현했고, 나머지는 문제에 나온대로 하였다.
 * 
 * 문제가 되었던 점은 
 * N*N이 벽으로 둘러쌓여있다는 말이 0, N+1에 벽이 있다는 인데 0, N에 있다고 생각해서 틀렸고,
 * 
 * `초후 라는 말 때문에 time을 언제 증가시켜야 할 지 고민하였다.
 * 독해력이 딸리는 나....
 * */
public class BJ_3190_뱀 {
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N;
	static int[][] map = new int[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i = 0; i <= N+1; i++) {
			map[0][i] = 1;
			map[N+1][i] = 1;
			map[i][0] = 1;
			map[i][N+1] = 1;
		}
		
		int k = sc.nextInt();
		for(int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = 3;
		}
		
		k = sc.nextInt();
		int[] times = new int[k];
		char[] where = new char[k];
		for(int i = 0; i < k; i++) {
			times[i] = sc.nextInt();
			where[i] = sc.next().charAt(0);
		}
		
		
		Queue<Point> snake = new LinkedList();
		map[1][1] = 2;
		snake.add(new Point(1, 1));//꼬리 정보를 가지고 있음
		int sdir = 1;//뱀 진행 방향
		int time = 1;//초
		int x = 1;//현재 머리 위치
		int y = 1;
		boolean end = false;
		int timesnum =0;
		
		while(!end) {
			int nx = x + dirs[sdir][0];
			int ny = y + dirs[sdir][1];
			
			if(map[nx][ny] == 1 || map[nx][ny] == 2) {
				end = true;
				continue;
			}else if(map[nx][ny] == 0) {
				Point p = snake.poll();
				map[p.x][p.y]= 0;
			}
			snake.add(new Point(nx, ny));
			map[nx][ny] = 2;
			x = nx;
			y = ny;
			
			//방향 바꾸나?
			if(timesnum < k && times[timesnum] == time) {
				if(where[timesnum] == 'D') {//오른쪽
					sdir = (sdir+1)%4;
				}else {
					sdir = (sdir+3)%4;
				}
				timesnum++;
			}
			time++;
		}
		
		System.out.println(time);
	}
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
}
