package d0428;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_2330_미생물연구실 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int[][] things = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				things[i][j] = sc.nextInt();
			}
		}
		
		//최소값으로 정렬
		Arrays.sort(things, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
//				if(o1[0] == o2[0]) {
//					return Integer.compare(o1[1], o2[1]);
//				}
				return Integer.compare(o1[0],  o2[0]);
			}
			
		});
		
//		for(int i = 0; i < N ; i++) {
//			System.out.println(Arrays.toString(things[i]));
//		}
		
		int result = 0;
		int tmp = things[0][2];
		int now_min = things[0][0];
		int now_max = things[0][1];

		for(int i = 1; i < N; i++) {//최소값이 작은 것부터 확인한다.
			if(things[i][0] <= now_max) {
				
			}else {
				result += tmp;
				tmp = things[i][2];
				now_min = things[i][0];
				now_max = things[i][1];
			}
			
			
		}
		
		
	}

}
