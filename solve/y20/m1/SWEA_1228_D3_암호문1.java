package swea.D3;

import java.io.FileInputStream;
import java.util.Scanner;
/**
 * 처음에는 10개 내에 포함되면 새로운 값으로 arr를 덮어씌었는데 이 경우 10을 넘지 않는 만큼 새로 들어올때 이미 있던 값들을
 * 뒤로 미룰 수가 없었다.
 * 그래서 다음으로는 새로 들어올 만큼 넣고도 10이내이면 바뀌는 인덱스 위치+ 새로들어오는 값 위치로 인덱스 위치에 원래 있던
 * 값을 옮겼는데 이럴 경우는 다다음 수가 밀리지 않았다.
 * 마지막으로는 while문은 사용해서 10이내인 경우동안은 계속 다음위치에 값을 미뤄서 넣어주었다.
 * 
 * **/
public class SWEA_1228_D3_암호문1 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1228.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			int[] arr = new int[20];
			
			for(int i = 0; i < n ; i++) {
				arr[i] = sc.nextInt();
			}
			
			int ad = sc.nextInt();
			for(int i = 0; i <ad; i++) {
				char ii = sc.next().charAt(0);
				int idx = sc.nextInt();
				int how= sc.nextInt();
				int[] push = new int[how];
				
				for(int j = 0; j < how; j++) {
					push[j] = sc.nextInt();
					if(j+idx < 10) {
						int tmp = arr[j+idx];
						arr[j+idx] = push[j];
						int next = idx+j+how;
						while(next < 10) {
							int tmp2 = arr[next];
							arr[next] = tmp;
							tmp = tmp2;
							next += how;
						}
					}
				}								
			}
						
			System.out.print("#"+t+" ");
			for(int i = 0; i < 10; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}		
	}

}
