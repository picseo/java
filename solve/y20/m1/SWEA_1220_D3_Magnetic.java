package page.SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * ���η� �����鼭 �� -> �ķ� �ٲ�� �κи� ���ڸ� ���� �Ǵ� ��������.
 * ������ n���̹Ƿ� �������� ������ ���� �Ķ����� �Ű澲�� �ʰ�
 * �������� ���� �� �Ķ������� �ٲ�� �κи� �Ű澲�� �Ǵ� �ſ���.
 * �Ķ������� ���������� �ٲ�� ���� ���� ���� ��Ұ� �ƴϹǷ� �Ű澲�� �ʾƵ� �ȴ�.
 * �׷��� ���� Ǯ���� �򰥷��� �����ɷȴ�.
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
			
			//�� true, �� false;
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

