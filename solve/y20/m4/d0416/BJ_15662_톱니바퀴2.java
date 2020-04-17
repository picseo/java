package d0416;

import java.util.Scanner;
/*
 * 회전 되었을 때 값이 바뀌는 방향을 오해해서 틀렸었다.
 * 문제에 주어진 설명을 잘 읽자!
 * 
 * 푼 방법
 * 톱니바퀴들이 마주보는 위치의 번호를 tob이라는 배열에 저장해두고
 * 회전 정보가 주어진 톱니바퀴를 기준으로 왼쪽, 오른쪽으로 진행하였다.
 * 
 * 시물레이션!
 * 
 * */
public class BJ_15662_톱니바퀴2 {
	static int[][] tob ,state;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		tob = new int[T][2];
		state = new int[T][8];
		for(int i = 0; i < T; i++) {
			String input = sc.next();
			for(int j = 0;j < 8; j++) {
				state[i][j] = input.charAt(j)-'0';
			}
		}
		
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < 2; j++) {
				if(j == 0) {
					tob[i][j] = 6;
				}else {
					tob[i][j] = 2;
				}
			}
		}
		
		int k = sc.nextInt();
		for(int i = 0; i < k; i++) {
			int num = sc.nextInt()-1;
			int dir = sc.nextInt();
			int[] dirs = new int[T];
			dirs[num] = dir;
			
			//오른쪽 방향으로 진행
			for(int j = num+1; j < T; j++) {
				if(state[j-1][tob[j-1][1]] != state[j][tob[j][0]]) {
					if(dirs[j-1] == 1) {
						dirs[j] = -1;
					}else if(dirs[j-1] == -1) {
						dirs[j] = 1;
					}
				}else {
					dirs[j] = 0;
				}
			}
			
			//왼쪽
			for(int j = num-1; j >=0; j--) {
				if(state[j][tob[j][1]] != state[j+1][tob[j+1][0]]) {
					if(dirs[j+1] == 1) {
						dirs[j] = -1;
					}else if(dirs[j+1] == -1) {
						dirs[j] = 1;
					}
				}else {
					dirs[j] = 0;
				}
			}
			
			for(int j = 0; j < T; j++) {
				if(dirs[j] == 1) {
					tob[j][0] = (tob[j][0]+7)%8;
					tob[j][1] = (tob[j][1]+7)%8;
				}else if(dirs[j] == -1) {
					tob[j][0] = (tob[j][0]+1)%8;
					tob[j][1] = (tob[j][1]+1)%8;
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < T; i++) {
			if(state[i][(tob[i][0]+2)%8] == 1) {
				result++;
			}
		}
		
		System.out.println(result);
	}

}
