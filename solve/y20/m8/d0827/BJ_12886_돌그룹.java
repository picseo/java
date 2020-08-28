package d0827;

import java.util.Scanner;
//무조건 도착만 하면 되는 경우를 저장하는 문제!!!!!!!!!!!
//도달만하면 된다.
//abc의 값의 범위가 500이지만 더하고 빼기 때문에 1500까지 고려해야 한다.

//전체 값이 정해져 있기 때문에 
//여기서 중요한 점은 a, b, c의 값이 셔플이 되고 같게 본다는것! (1, 2, 3) == (3, 1, 2)

public class BJ_12886_돌그룹 {
	static int A, B, C;
	static boolean[][] memo = new boolean[1501][1501];
	static int total = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		total = A+B+C;
		if(total%3 != 0) {
			System.out.println(0);
			return;
		}
		
		find(A, B);

		System.out.println((memo[total/3][total/3] ? 1 : 0));
		
	}

	private static void find(int a, int b) {
		if(memo[a][b]) {return ;}
		
		memo[a][b] = true;
		
		int c = total - a - b;
		if(a != b) {
			if(a > b) {
				find(a-b, b+b);
			}else {
				find(a+a, b-a);
			}
		}
		
		if(a != c) {
			if(a > c) {
				find(a-c, c+c);
			}else {
				find(a+a, c-a);
			}
		}
		
		if(c != b) {
			if(c > b) {
				find(c-b, b+b);
			}else {
				find(c+c, b-c);
			}
		}
	}

	
}
