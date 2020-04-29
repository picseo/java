package d0429;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_5658_보물상자_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();//4의 배수, 8<=N<=28
			int K = sc.nextInt();//K번째 큰수
			String s = sc.next();
			String tt = s + s.substring(0, N/4-1);

			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < N; i++) {

				String hex = s.substring(i, i+N/4);
				int num = Integer.parseInt(hex, 16);//진수 입력받아서 10진수로 계산해서 저장
				if(!list.contains(num)) {
					list.add(num);
				}

				char c = s.charAt(N-1);
				s = c + s.substring(0, N-1);
			}
			Collections.sort(list, Collections.reverseOrder());
			System.out.println("#"+t+" "+list.get(K-1));
		}
		sc.close();
	}

}
