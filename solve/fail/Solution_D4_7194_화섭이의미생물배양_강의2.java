package d0320;


import java.util.Scanner;
/*
 * Ŀ���� �����ΰ� �ƴ϶�
 * 
 * �۾����� ������ ������ �ϸ� ����ĥ �� �ִ� ��찡 �ξ� �� ���� �þ��
 * ���� �������� ������ �� �ִ�.
 * */
public class Solution_D4_7194_ȭ�����ǹ̻������_����2 {

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
			//if(t3/B < S) { - >�������� ������ �����ϴµ� �� �ʿ����� �𸣰ڴ�.
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