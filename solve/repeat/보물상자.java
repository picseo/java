package repeat;

import java.util.Scanner;
import java.util.TreeSet;

public class 보물상자 {
	static int N, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			String input = sc.next();
			
			String total = input+input.substring(0, (N/4));
			//System.out.println(total);
			
			TreeSet<Integer> ts = new TreeSet<Integer>();
			
			for(int i = 0; i < N; i++) {
				ts.add(Integer.parseInt(total.substring(i, (N/4)+i), 16));
			}
			
			int i = 0;
			for(int num : ts) {
				if(i == (ts.size()-K)) {
					System.out.println("# "+t+" " +num);
					break;
				}
				i++;
			}
		}
	}

}
