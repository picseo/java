package page.SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 세로로 읽으면서 빨 -> 파로 바뀌는 부분만 숫자를 세면 되는 문제였다.
 * 위쪽이 n극이므로 빨간색이 나오기 전의 파란색은 신경쓰지 않고
 * 빨간색이 나온 후 파란색으로 바뀌는 부분만 신경쓰면 되는 거였다.
 * 파란색에서 빨간색으로 바뀌는 것은 전혀 방해 요소가 아니므로 신경쓰지 않아도 된다.
 * 그런데 막상 풀려니 헷갈려서 오래걸렸다.
 * 
 * */
public class SWEA_1220_D3_Magnetic {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1220.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			System.out.print("#"+t+" ");
			int n = sc.nextInt();
			int[][]mag = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j =0; j < n; j++) {
					mag[i][j] = sc.nextInt();
				}
			}
			
			//빨 true, 파 false;
			int result = 0;
			for(int j = 0; j < n; j++) {
				boolean check = false;
				for(int i = 0; i < n ; i++) {
					if(mag[i][j] == 1) {
						check = true;
					}else if(mag[i][j] == 2) {
						if(check) {
							result++;
							check = false;
						}			
					}					
				}//i loop
			}	//j loop	
			
			System.out.println(result);
		}//testcase		
	}
}

