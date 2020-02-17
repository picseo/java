package swea.D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1230_D3_암호문3 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1230.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n ; i++) {
				arr[i] = sc.nextInt();
			}
			
			int ad = sc.nextInt();
			for(int i = 0; i <ad; i++) {				
				char ii = sc.next().charAt(0);
				int idx = sc.nextInt();
				int end = n-1;
				
				if(ii == 'I') {
					int how = sc.nextInt();
					int[] push = new int[how];
					for(int j = 0; j < how; j++) {
						push[j] = sc.nextInt();
						if(j+idx < n) {
							int tmp = arr[j+idx];
							arr[j+idx] = push[j];
							int next = idx+j+how;
							while(next < n) {
								int tmp2 = arr[next];
								arr[next] = tmp;
								tmp = tmp2;
								next += how;
							}
						}
					}
					
				}else if(ii == 'D') {
					int how = sc.nextInt();
						for(int in = idx; in < n-how; in++) {
							arr[in] = arr[in+how];
						}
						
						end = Math.min(n-how, n-1);
				}else if(ii == 'A') {
						int[] push = new int[idx];
						for(int j = 0; j < idx; j++) {
							push[j] = sc.nextInt();
							if(end+j < n) {
								arr[end+j] = push[j];
							}							
						}
				}	
				
			}//ad
						
			System.out.print("#"+t+" ");
			for(int i = 0; i < 10; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}		
	}

}

