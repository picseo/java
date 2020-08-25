package d0819;

import java.util.Arrays;
import java.util.Scanner;

/*
  재귀를 이용 -> (a, b), (a, c), (b, c)를 진행한다.
  
 중요한 점은 a, b, c모두 500까지 될 수 있으므로 3개의 상태를 저장하려면 
 1500*1500*1500 = 10억*4byte -> 2GB이므로 너무 커진다
 
그래서 총량이 유지된다는 것을 기억해서
 A, B중 2가지만 저장한 뒤에 나머지 값은 sum-A-B를 이용해서 구해서 사용하면 된다.
 
 그리고, 도달하기만 하면 되므로 boolean배열로 상태를 저장한다.
 
 
 * */
public class BJ_12886_돌그룹 {
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
