package d0517;

import java.util.Scanner;
//결과의 범위가 long이 되는 걸 아는지 물어보는 문제
public class BJ_2399_거리의합 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] inputs = new long[N];
		for(int i = 0; i < N ; i++) {
			inputs[i] = sc.nextLong();
		}
		
		long result = 0;
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N; j++) {
				if(i != j)
					result += Math.abs(inputs[i]-inputs[j]);
			}
		}
		
		System.out.println(result);
	}

}
