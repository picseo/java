package algo_basic.SWEA.mon1;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1234_D3_비밀번호 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1234.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <=10 ; t++) {
			int n = sc.nextInt();
			String input = sc.next();
			boolean[] ch = new boolean[n];

			for(int i = 0; i < n-1; i++) {

				if(ch[i])
					continue;
				int j = i+1;
				if((!ch[i] && !ch[j]) && input.charAt(i) == input.charAt(j)) {
					ch[i] = true;
					ch[j] = true;
					int ni = i-1;
					int nj = j+1;
					
					while(ni >= 0 && ch[ni]) {
						ni -= 1;
					}
					if(ni < 0)
						break;
					while(nj < n && ch[nj]) {
						nj += 1;
					}
					if(nj >= n)
						break;
					while((ni >= 0 && nj < n) && (input.charAt(ni) == input.charAt(nj))) {
						ch[ni] = true;
						ch[nj] = true;
						while(ni >= 0 && ch[ni]) {
							ni -= 1;
						}
						if(ni < 0)
							break;
						while(nj < n && ch[nj]) {
							nj += 1;
						}
						
						if(nj >= n)
							break;
					}
				}				
			}

			System.out.print("#"+t+" ");
			for(int i = 0; i < n; i++) {
				if(!ch[i]) {
					System.out.print(input.charAt(i));
				}
			}
			System.out.println();
		}
	}

}
