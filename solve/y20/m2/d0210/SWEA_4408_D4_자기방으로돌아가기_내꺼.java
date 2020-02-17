package swea.d0210;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * how값이 now.how보다 작을때만 업데이트 하는 식으로 했더니
 * 마지막 값은 끝까지 하지 못하고 나왔는데 
 * 그럼 무조건 1만 차이가 난다고 생각해서 1을 더해준 값을 결과로 냈더니 틀렸었다.
 * 
 * 이런 경우에는 how에 미리 how == now.how가 같아지는 경우에만 업데이트를 하게 했더니
 * how값이 잘 나왔다.
 * 
 * 근데 이 문제는 답참고의 방식이 더 효율적이라고 생각한다.
 * 겹치는 수는 배열에 값을 증가하는 방식으로 풀자!!!
 * **/
public class SWEA_4408_D4_자기방으로돌아가기_내꺼 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			int n = sc.nextInt();
			
			Queue<Point> students = new LinkedList<Point>();
			for(int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				students.add(new Point(x, y));
			}
			
			int[] check_ox = new int[200];
			int how = 0;
			while(!students.isEmpty()) {
				Point now = students.poll();
				if(how == now.how) {
					how = now.how + 1;
					Arrays.fill(check_ox, 0);
				}
				
				int from = now.from;
				int to = now.to;
				
				int min = (from-1) / 2;
				int max = (to-1) / 2;
				
				if(from > to) {
					min = (to-1) / 2;
					max = (from-1) / 2;
				}
				
				boolean pos = false;
				for(int k = min; k <= max; k++) {
					if(check_ox[k] == 1) {
						pos = true;
						now.how++;
						students.add(now);
						break;							
					}
				}

				if(pos)
					continue;
				
				for(int k = min; k <= max; k++) {
					check_ox[k] = 1;
				}
			}
			
			System.out.println("#"+t+" "+how);
		}
	}

	
	static class Point{
		int from;
		int to;
		int how =0;
		
		Point(int x, int y){
			this.from = x;
			this.to = y;
			this.how = 0;
		}

		@Override
		public String toString() {
			return "from=" + from + ", to=" + to + ", how=" + how;
		}
		
		
	}

	private static String src = "3  \r\n" + 
			/*"4  \r\n" + 
			"10 20 \r\n" + 
			"30 40\r\n" + 
			"50 60\r\n" + 
			"70 80\r\n" + */
			"2 \r\n" + 
			"1 3\r\n" + 
			"2 200\r\n" + 
			"3\r\n" + 
			"10 100\r\n" + 
			"20 80\r\n" + 
			"30 50\r\n"+
			"4  \r\n" + 
			"70 80\r\n" +
			"30 40\r\n" + 
			"50 60\r\n" + 			
			"10 20 \r\n";
}
