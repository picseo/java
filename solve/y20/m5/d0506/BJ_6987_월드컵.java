package d0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//필수 조건 : 각 나라의 총 횟수가 5여야한다.
//승, 패 총합이 같아야 한다.
//무승부는 짝수여야 한다.

public class BJ_6987_월드컵 {
	static int[] win = new int[6];
	static int[]lose = new int[6];
	static int[] draw = new int[6];
	static boolean ok = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for(int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			int total_count = 0;
			ok = false;
			for(int i = 0; i < 6; i++) {
				win[i] = Integer.parseInt(st.nextToken());
				draw[i] = Integer.parseInt(st.nextToken());
				lose[i] = Integer.parseInt(st.nextToken());
				total_count += (win[i] + draw[i] + lose[i]);
			}

			if(total_count != 30) {
				ok = false;
			}else {
				check(0, 1, 0);
			}

			sb.append((ok?1:0) + " ");
		}
		sb.append("\n");
		System.out.println(sb);
	}

	private static void check(int first, int second, int count) {
		if(ok) {
			return ;
		}

		if(count == 15) {
			ok = true;
			return;
		}

		int t1 = first;    // team 1
		int t2 = second;    // team 2
		if(second > 5) {
			t1 += 1;
			t2 = t1+1;
		}
		
		if(t1 > 5) {//더이상 볼필요없음
			return;
		}
		
		// team 1의 승리가 가능하다면
		if(win[t1] > 0 && lose [t2] >0) {
			win[t1]--;
			lose[t2]--;
			check(t1, t2+1, count+1);
			win[t1]++;
			lose[t2]++;
		}
		// team 2의 승리가 가능하다면
		if(lose[t1] > 0 && win [t2] >0) {
			lose[t1]--;
			win[t2]--;
			check(t1, t2+1, count+1);
			lose[t1]++;
			win[t2]++;
		}
		// team 1,2 가 무승부가 가능하다면
		if(draw[t1] > 0 && draw[t2] >0) {
			draw[t1]--;
			draw[t2]--;
			check(t1, t2+1, count+1);
			draw[t1]++;
			draw[t2]++;
		}  

	}

}
