package d0402;

import java.util.Scanner;

public class BJ_5607_조합 {
	static int p = 1234567891;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int t =1 ; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			int n = sc.nextInt();
			int r = sc.nextInt();
			
			//nCr = (n!)/(r!(n-r)!)
			//p = MOD
			
			long nf = 1;
			for(int i = n-r+1; i <=n; i++) {
				nf = (nf*i)%p;
			}
			
			long mo = 1;
			for(int i = 2; i <= r; i++) {
				mo = (mo*i)%p;
			}
			
			long reverse_mo = find(mo, p-2);
			long result = (nf*reverse_mo)%p;
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	//p가 너무 커서 분할정복 -> O(log p)(2뱄기 줄어들게 됨으로)
	private static long find(long mo, int i) {
		if(i == 0)
			return 1;
		long tmp = find(mo, i/2);
		long ret = (tmp*tmp)%p;
		
		if(i%2 ==0) return ret;
		else
			return (ret*mo)%p; 
	}

	private static long find_while(long a, int i) {
		long ret = 1;
		int b = i;
		while(b!=0) {
			if((b&1) > 0) ret = (ret*a)%p;
			a = (a*a)%p;
			b>>=1;
		}
		return ret;
	}
}
