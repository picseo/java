package d0330;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1759_암호만들기 {
	static int L, C;
	static char [] input;
	static int [] permu;
	static String ms = "aioue";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		input = new char[C];
		permu = new int[C];
		for(int i = 0; i < C; i++) {
			input[i] = sc.next().charAt(0);
			if(i >= L) {
				permu[i] = 1;
			}
		}
		
		Arrays.sort(input);
		Arrays.sort(permu);
		
		do{
			int m_num = 0;
			int j_num = 0;
			
			for(int i = 0; i < C; i++) {
				if(permu[i] == 0) {
					char now = input[i];
					if(ms.contains(now+"")) {
						m_num++;
					}else {
						j_num++;
					}
				}
			}
			

			
			if(m_num >= 1 && j_num >= 2) {
				for(int i = 0; i < C; i++) {
					if(permu[i] == 0) {
						sb.append(input[i]);
					}
				}
				sb.append("\n");
			}
			
		}while(nextP());
		System.out.println(sb);
	}

	static boolean nextP() {
		int i, j;
		for(i = permu.length-2; i>=0 ; i--) {
			if(permu[i] < permu[i+1]) {
				break;
			}
		}
		
		if(i < 0) {
			return false;
		}
		
		for(j = permu.length-1; j >= 0; j--) {
			if(permu[j] > permu[i])
				break;
		}
		
		int tmp = permu[i];
		permu[i] = permu[j];
		permu[j] = tmp;
		
		for(int st = i+1, ed = permu.length-1; st <ed;st++, ed--) {
			tmp = permu[st];
			permu[st] = permu[ed];
			permu[ed] = tmp;
		}
		
		return true;
	}
}
