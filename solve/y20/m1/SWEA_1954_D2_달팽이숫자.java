package SWEA;

import java.util.Scanner;
/**
 * SWEA �����̼��� ����
 * �� ������ ���Ƽ� ���°� �ݺ��ǹǷ�
 * �ѿ��� ������ �����Ѵ�.
 * ���� ������ߴ� �� ����� �Ǵ� ��ġ���� ������ �ٲپ� �ִ� �ſ���.
 * �ϰ� ���� ĭ ������ ĭ�� ĭ ������ ���� ���� �߿��ߴ�.
 * */
public class SWEA_1954_D2_�����̼��� {
	public static int[][] dirs= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//��, �Ʒ�, ��, ��
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
