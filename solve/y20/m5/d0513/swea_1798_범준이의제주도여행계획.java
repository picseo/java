package d0513;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//재귀에서 처음에는 호텔, 비행장, 놀곳을 나누지 않고 for문을 돌렸는데 나누니까 시간초과에 걸리지 않았다.
//또, 놀곳을 넣을때 호텔에 갈 수 있는지까지 고려해서  가지치기를 하는 것도 새로 배웠다.
//그리고 stack를 new ArrayList()를 통해 List<>로 저장할 수 있는 것도 배웠다.
public class swea_1798_범준이의제주도여행계획 {
	static int N, M, result;
	static int[][] graph;
	static List<Place> hotels, places;
	static Place airport;

	static boolean[] visited;
	static List<Integer> stresult;
	static Stack<Integer> stack;

	static class Place{
		int time, point;
		int idx;
		int minh;//가까운 호텔 정보
		Place(int idx, int time, int point) {
			super();
			this.idx = idx;
			this.time = time;
			this.point = point;
		}		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for(int t= 1;t <= T; t++) {
			result = 0;
			N = sc.nextInt();
			M = sc.nextInt();

			graph = new int[N][N];
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					int time = sc.nextInt();
					graph[i][j] = time;
					graph[j][i] = time;
				}
			}

			hotels = new ArrayList<>();
			places = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				char type = sc.next().charAt(0);
				int time = 0;
				int point = 0;
				if(type == 'P') {
					time = sc.nextInt();
					point = sc.nextInt();
					places.add(new Place(i, time, point));
				}else if(type == 'A') {
					airport = new Place(i, time, point);
				}else if(type == 'H') {
					hotels.add(new Place(i, time, point));
				}				
			}			

			//각 place의 가장 가까운 호텔 선택하기
			for(int i = 0; i < places.size(); i++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0; j < hotels.size(); j++) {
					if(min > graph[places.get(i).idx][hotels.get(j).idx]) {
						min = graph[places.get(i).idx][hotels.get(j).idx];
						places.get(i).minh = min;
					}
				}				
			}

			visited = new boolean[N];
			stack = new Stack<>();
			stresult = new ArrayList<>();
			findbest(0, 1, 0, 0);

			sb.append('#').append(t).append(" ").append(result).append(" ");
			for(int i = 0; i < stresult.size(); i++) {
				sb.append((Integer)stresult.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void findbest(int start, int day, int point, int time) {
		if(day == M+1 && start == 0) {
			if(result < point) {
				result = point;
				stresult = new ArrayList<>(stack);
			}
			return;
		}

		boolean ok = false;
		for(int i =0 ; i < places.size(); i++) {
			Place now = places.get(i);
			if(!visited[now.idx]) {
				int tempTime = 0;
				if(day == M) {
					tempTime = time + graph[start][now.idx]+ now.time + graph[now.idx][0]; 
				}else {
					tempTime = time + graph[start][now.idx]+ now.time + now.minh; 
				}

				if(tempTime > 540) {
					continue;
				}


				ok = true;
				visited[now.idx] = true;
				stack.push(now.idx+1);
				findbest(now.idx, day, point+now.point, time + graph[start][now.idx]+ now.time);
				visited[now.idx] = false;
				stack.pop();

			}
		}

		if(!ok) {//놀곳이 없다면
			if(day == M) {
				if(time+graph[start][0] <= 540) {
					stack.push(0+1);
					findbest(0, day+1, point, time+graph[start][0]);
					stack.pop();
				}
			}else {
				for(int i = 0; i < hotels.size(); i++) {
					if(time+graph[start][hotels.get(i).idx] <= 540) {
						stack.push(hotels.get(i).idx + 1);
						findbest(hotels.get(i).idx, day+1, point, 0);
						stack.pop();
					}
				}
			}
		}	


	}

}
