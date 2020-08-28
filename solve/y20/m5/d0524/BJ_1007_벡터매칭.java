package d0524;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//그냥 순열로 풀면 풀 수 없지만 +, -로 이루어진 순열을 구하는 건 가능하므로
//+, -로 이루어진 순열을 구해서 가능한 모든 값을 구한 후 그중 가장 작은 값을 결과값으로 리턴했다.

//재귀, dfs로 푸는게 더 빠르게 진행된다. 앞의 결과는 바꾸지 않고 나머지들을 계산할 수 있어서 그런것같다.
public class BJ_1007_벡터매칭 {
	static class Point{
		double x, y;
		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	static List<Point> points;
	static int[] idx;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			
			points = new ArrayList<Point>();
			idx = new int[N];
			for(int i = 0; i < N; i++) {
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				
				if(i >= N/2) {
					idx[i] = 1;
				}
				
				points.add(new Point(x, y));
			}
			
			double min = Double.MAX_VALUE;
			
			do {
				Point tmp = new Point(0, 0);
				for(int i= 0; i < N; i++) {
					if(idx[i] == 1) {
						tmp.x += points.get(i).x;
						tmp.y += points.get(i).y;
					}else {
						tmp.x -= points.get(i).x;
						tmp.y -= points.get(i).y;
					}
				}
				
				double res = Math.sqrt(tmp.x*tmp.x + tmp.y*tmp.y);
				if(min > res) {
					min = res;
				}
			}while(nextP());
			
			System.out.println(min);
		}
	}
	
	private static boolean nextP() {
		int i, j;
		
		for(i = idx.length-2; i >= 0; i--) {
			if(idx[i] < idx[i+1]) {
				break;
			}
		}
		
		if(i < 0) {
			return false;
		}
		
		for(j = idx.length-1; j >=0 ; j--) {
			if(idx[j] > idx[i]) {
				break;
			}
		}
		
		int tmp = idx[j];
		idx[j] = idx[i];
		idx[i] = tmp;
		
		for(int st = i+1, ed = idx.length-1; st < ed; st++, ed--) {
			tmp = idx[st];
			idx[st] = idx[ed];
			idx[ed] = tmp;
		}
		return true;
	}

	
	
}
