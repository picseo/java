package d0416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/*
 * 집과 치킨 집 가지의 거리가 계속 사용될 것 같아서 미리 dist라는 배열에 최소인 치킨집번호와 거리를 저장해두었다.
 * 그뒤에는 치킨집 중에서 M개를 고르기 위해 nextP를 사용하였고,
 * 
 * 매 경우마다 dist를 이용해서 포함된 것중, 가장 작은 거리를 찾아 치킨거리의 합을 찾고
 * result보다 작을때는 업데이트를 해주었다.
 * 
 * 다음에는 nextP말고 재귀로 구현해보자
 * 
 * */
public class BJ_15686_치킨배달 {
	static int N, M;
	static boolean[] check = new boolean[14];
	static int[] pick;
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[" + x + "," + y + "]";
		}		
	}
	
	static boolean nextP() {
		int i, j;
		for(i = pick.length-2; i >= 0 ; i--) {
			if(pick[i] < pick[i+1]) {
				break;
			}
		}
		
		if(i < 0 ) {
			return false;
		}
		
		for(j = pick.length-1; j >=0; j--) {
			if(pick[j] > pick[i]) {
				break;
			}
		}
		
		int tmp = pick[i];
		pick[i] = pick[j];
		pick[j] = tmp;
		
		for(int st = i+1, ed = pick.length-1; st < ed; st++, ed--) {
			tmp = pick[st];
			pick[st] = pick[ed];
			pick[ed] = tmp;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		List<Point> houses = new ArrayList<Point>();
		List<Point> chicken = new ArrayList<Point>();
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int n = sc.nextInt();
				
				if(n == 1) {
					houses.add(new Point(i,j));
				}else if(n == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		
		Point [][] dist = new Point[houses.size()][chicken.size()];
		
		for(int i = 0; i < houses.size(); i++) {
			Point house = houses.get(i);
			for(int j = 0; j < chicken.size(); j++) {
				Point nowc = chicken.get(j);
				
				int len = Math.abs(house.x - nowc.x) + Math.abs(house.y - nowc.y);
				dist[i][j] = new Point(j, len);
			}
			
			Arrays.sort(dist[i], new Comparator<Point>() {
				public int compare(Point p1, Point p2) {
					return Integer.compare(p1.y,  p2.y);
				}
			});
		}

		pick = new int[chicken.size()];
		for(int i =0; i < M; i++) {
			pick[i] = 1;
		}
		Arrays.sort(pick);
		
		int result = Integer.MAX_VALUE;
		do {
			int tmp = 0;
			for(int i = 0; i < dist.length; i++) {
				for(int j = 0; j < dist[i].length; j++) {
					if(pick[dist[i][j].x] == 1) {
						tmp += dist[i][j].y;
						break;
					}
				}
			}
			if(result > tmp) {
				result = tmp;
			}
		}while(nextP());
		
		System.out.println(result);
	}

	
}
