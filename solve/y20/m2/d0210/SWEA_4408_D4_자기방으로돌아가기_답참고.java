package swea.d0210;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * boolean배열과   이중 for문을 이용해서 밖에 for에서 도는 횟수만큼 세고 싶었는데 틀렸다.
 * 복도  배열을 int 배열로 만든다음에 해당 복도를 지나가는 사람들의 횟수를 ++시키고 
 * 마지막에 그 값들 중 최대값을 찾으니까 답이 나왔다.
 * **/
public class SWEA_4408_D4_자기방으로돌아가기_답참고 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t<= T; t++) {
			int n = sc.nextInt();
			
			Queue<Point> students = new LinkedList();
			for(int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				students.add(new Point(x, y));
			}
			
			int[] check = new int[200];
			while(!students.isEmpty()) {
				Point now = students.poll();
				
				int from = now.from;
				int to = now.to;
				
				int min = (from-1) / 2;
				int max = (to-1) / 2;
				
				if(from > to) {
					min = (to-1) / 2;
					max = (from-1) / 2;
				}
				for(int k = min; k <= max; k++) {
					check[k]++;
				}				
			}
			
			/*int max = Integer.MIN_VALUE;
			for(int k = 0; k < 200; k++) {
				if(max < check[k])
					max = check[k];
			}	
			System.out.println("#"+t+" "+max);*/
			Arrays.sort(check);
			System.out.println("#"+t+" "+check[199]);
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
	}
	private static String src = "4  \r\n" + 
			"4  \r\n" + 
			"10 20 \r\n" + 
			"30 40\r\n" + 
			"50 60\r\n" + 
			"70 80\r\n" + 
			"2 \r\n" + 
			"1 3\r\n" + 
			"2 200\r\n" + 
			"3\r\n" + 
			"10 100\r\n" + 
			"20 80\r\n" + 
			"30 50\r\n"+
			"4  \r\n" + 
			"70 80\r\n" +
			"70 80\r\n" +
			"70 80\r\n" +
			"30 40\r\n" + 
			"60 50\r\n" + 			
			"10 20 \r\n";
}
