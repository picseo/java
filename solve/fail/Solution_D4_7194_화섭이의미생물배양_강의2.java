package d0320;


import java.util.Scanner;
/*
 * 커지는 순으로가 아니라
 * 
 * 작아지는 순으로 진행을 하면 가지칠 수 있는 경우가 훨씬 더 많이 늘어나서
 * 적은 연산으로 진행할 수 있다.
 * */
public class Solution_D4_7194_화섭이의미생물배양_강의2 {

	public static int E,S,T, A, B;
	public static String[] sn;
	public static int[] tm;
	static int min;
	public static void main(String[] args)  {
		
		Scanner scann=new Scanner(System.in);
		E=scann.nextInt();
		
		for (int iT = 1; iT <= E; iT++) {
			S=scann.nextInt();
			T=scann.nextInt();
			A=scann.nextInt();
			B=scann.nextInt();
			min=Integer.MAX_VALUE;
			if(B==1){
				if((T-S)%A==0){
					min=(T-S)/A;
				}else{min=Integer.MAX_VALUE; }
			}else{
				dfs(T, 0);
			}
			System.out.printf("#%d %d\n",iT,min==Integer.MAX_VALUE?-1:min);
		}
	}
	public static void dfs(int t3, int count) {
		if(t3==S) {
			if(min>count){
				min=count;
			}
			return ;
		}
		if(t3<S ) {  
			return ;
		}
		if(t3%B==0 ) {  
			//if(t3/B < S) { - >이조건이 있으면 성공하는데 왜 필요한지 모르겠다.
				dfs( t3-A, count+1);
			//}
			dfs( t3/B, count+1);
		}else {
			dfs( t3-A, count+1);
		} 
	}
}

/*
 10 40 4 2      10*2*2
10 28 4 2       (10+4)*2
10 99 4 2
10 104 4 2
10 24 4 2
 */