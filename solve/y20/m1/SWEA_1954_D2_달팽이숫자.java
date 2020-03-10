package SWEA;

import java.util.Scanner;
/**
 * SWEA 달팽이숫자 문제
 * 한 바퀴씩 돌아서 들어가는게 반복되므로
 * 겉에서 안으로 진행한다.
 * 내가 해줘야했던 건 꺾어야 되는 위치에서 방향을 바꾸어 주는 거였다.
 * 하고 보니 칸 수보다 칸과 칸 사이의 선의 수가 중요했다.
 * */
public class SWEA_1954_D2_달팽이숫자 {
	public static int[][] dirs= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//오, 아래, 왼, 위
	private static String src = "2    \r\n" + 
			"3   \r\n" + 
			"4 ";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

				Scanner sc = new Scanner(System.in);
				sc = new Scanner(src);
				
				int T;
				T=sc.nextInt();
				
				for(int test_case = 1; test_case <= T; test_case++)
				{
					int input = sc.nextInt();

		            int[][] pan = new int[11][11];
		            int now = 0;
		            int x = 0;
		            int y = -1;
		            
		            for(int n = input; n>0; n -=2){
		            	int len = 2*n+2*(n-2);
		                
		                for(int i = 1; i <= len; i++){
		                    now += 1;                    
		                	if(i <= n){                    	
		                        x += dirs[0][0];
		                        y += dirs[0][1];
		                    }else if( i > n && i <= (2*n)-1 ){
		                        x += dirs[1][0];
		                        y += dirs[1][1];
		                    }else if( i > (2*n)-1 && i <= (3*n)-2){
		                        x += dirs[2][0];
		                        y += dirs[2][1];
		                    }else if(i > (3*n)-2 && i < (4*n)-3){
		                    	x += dirs[3][0];
		                        y += dirs[3][1];
		                    }
		                    pan[x][y] = now;		                    
		                }//len for loop    
		                
		                if(len == 0) {
		                	now += 1;
		                	x += dirs[0][0];
	                        y += dirs[0][1];
	                        pan[x][y] = now;
		                }
		            }//input for loop
		            
		            System.out.println("#"+test_case);
		            for(int i = 0; i < input; i++){
		            	for(int j = 0; j < input; j++){
		                	System.out.print(pan[i][j] + " ");
		                }
		                System.out.println();
		            }
				}//test loop	
		
	}

}
