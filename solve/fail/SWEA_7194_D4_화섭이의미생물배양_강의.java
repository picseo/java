package d0320;

import java.util.Scanner;

public class SWEA_7194_D4_화섭이의미생물배양_강의 {
	static int E, S, T, A, B;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		E= sc.nextInt();
		for(int t = 1; t <= E; t++) {
			S = sc.nextInt();
			T = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			min = Integer.MAX_VALUE;
			if(B ==1) {
				if((T-S)%A == 0) {
					min=(T-S)/A;
				}else {
					min = Integer.MAX_VALUE;
				}
			}else {
				dfs(T, 0);
			}
			System.out.println("#"+t+" "+(min==Integer.MAX_VALUE?-1:min));
		}		
	}

	private static void dfs(int t3, int cnt) {
		if(t3 == S) {
			if(min > cnt) {
				min = cnt;
			}
			return;
		}
		
		if(t3 < S) {
			return;
		}
		
		if(t3%B == 0) {
			//if(t3/B < S) { //- >이조건이 있으면 성공하는데 왜 필요한지 모르겠다.(다 -1이 나오게 되는데?? 그리디 아닌가?)
				dfs( t3-A, cnt+1);
			//}
			//dfs(t3-A, cnt+1);
			dfs(t3/B, cnt+1);			
		}else {
			dfs(t3-A, cnt+1);
		}		
	}

	private static String src = "3\r\n" +
            "6 10 1 2\r\n" +
            "10 28 4 2\r\n" +
            "10 99 4 2";
}
