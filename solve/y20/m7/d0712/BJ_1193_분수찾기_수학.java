package algo;

import java.util.Scanner;
/* ��Ģã�� ����*/
public class BJ_1193_�м�ã��_���� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int start = 0;
		int add = 1;
		while(true) {
			start += (add++);
			
			int back = 0;
			int front = 0;
			
			if(N <= start) {
				back = start - N + 1;
				front = add - back;
				
				if(add%2 == 1)
					System.out.println(front+"/"+back);
				else
					System.out.println(back+"/"+front);
				break;
			}
		}

	}

}
