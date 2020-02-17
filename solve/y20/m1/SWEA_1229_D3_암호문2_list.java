package algo_basic.day7;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1229_D3_암호문2 {
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res\\sinput.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1 ; t<=10; t++) {
			int n = sc.nextInt();
			
			List<Integer> list = new LinkedList<>();
			for(int i =0; i < n ; i++) {
				list.add(sc.nextInt());
			}
			
			int ad = sc.nextInt();
			for(int i = 0; i < ad; i++) {
				char c = sc.next().charAt(0);
				
				if(c == 'I') {
					int idx = sc.nextInt();
					int num = sc.nextInt();
					for(int j = 0; j < num ; j++) {
						int input = sc.nextInt();
						list.add(idx++,  input);
					}
				}else if(c == 'D') {
					int idx = sc.nextInt();
					int num = sc.nextInt();
					for(int j = 0; j < num ; j++) {
						list.remove(idx);
					}
				}
			}
			
			System.out.print("#"+t+" ");
			for(int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+ " ");
			}
			System.out.println();
		}
		
	}
}
