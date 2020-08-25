package d0819;

import java.util.Arrays;
import java.util.Scanner;

/*
  ��͸� �̿� -> (a, b), (a, c), (b, c)�� �����Ѵ�.
  
 �߿��� ���� a, b, c��� 500���� �� �� �����Ƿ� 3���� ���¸� �����Ϸ��� 
 1500*1500*1500 = 10��*4byte -> 2GB�̹Ƿ� �ʹ� Ŀ����
 
�׷��� �ѷ��� �����ȴٴ� ���� ����ؼ�
 A, B�� 2������ ������ �ڿ� ������ ���� sum-A-B�� �̿��ؼ� ���ؼ� ����ϸ� �ȴ�.
 
 �׸���, �����ϱ⸸ �ϸ� �ǹǷ� boolean�迭�� ���¸� �����Ѵ�.
 
 
 * */
public class BJ_12886_���׷� {
	public static boolean[][] memo = new boolean[1501][1501];
	static int sum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		sum = A + B + C;
			
		if(sum%3 != 0) {
			System.out.println(0);
			return;
		}
		
		find(A, B);
		if(memo[sum/3][sum/3]) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}	
		return;
	}

	private static void find(int a, int b) {
		if(memo[a][b]) {
			return ;
		}
		
		memo[a][b] = true;
		
		int[] arr = {a, b, sum-(a+b)};
		for(int i = 0; i < 2; i++) {
			for(int j = i+1; j<3; j++) {
				if(arr[i] != arr[j]) {
					if(arr[i] < arr[j]) {
						find(arr[i]+arr[i], arr[j]-arr[i]);
					}else {
						find(arr[i]-arr[j], arr[j]+arr[j]);
					}
				}
			}
		}
		
	}
}
