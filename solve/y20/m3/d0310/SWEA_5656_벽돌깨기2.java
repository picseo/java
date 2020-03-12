package d0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//최대한 많은 벽돌을 깨고, 마지막에 남아있는 벽돌의 개수 출력
//최적화 팁: 벽돌이 전부 깨지는 경우가 나타난다면, 더 이상 순열 구할필요없이 0을 출력하고 그 케이스는 종료
//어려웠던 부분: 중간중간 비어서 벽돌을 아래로 떨어뜨리는 부분
public class SWEA_5656_벽돌깨기2 {
	
	static int T, N, W, H;
	static int map[][];//, cloneMap[][];
	static int[] src;
	static int min; //현재까지 남아있는 벽돌수 중 최소개수
	static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	static int brickTotalCount; //처음 벽돌의 총 개수
	static String source = "5\n" + 
			"3 10 10\n" + 
			"0 0 0 0 0 0 0 0 0 0\n" + 
			"1 0 1 0 1 0 0 0 0 0\n" + 
			"1 0 3 0 1 1 0 0 0 1\n" + 
			"1 1 1 0 1 2 0 0 0 9\n" + 
			"1 1 4 0 1 1 0 0 1 1\n" + 
			"1 1 4 1 1 1 2 1 1 1\n" + 
			"1 1 5 1 1 1 1 2 1 1\n" + 
			"1 1 6 1 1 1 1 1 2 1\n" + 
			"1 1 1 1 1 1 1 1 1 5\n" + 
			"1 1 7 1 1 1 1 1 1 1\n" + 
			"2 9 10\n" + 
			"0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0\n" + 
			"0 1 0 0 0 0 0 0 0\n" + 
			"0 1 0 0 0 0 0 0 0\n" + 
			"1 1 0 0 1 0 0 0 0\n" + 
			"1 1 0 1 1 1 0 1 0\n" + 
			"1 1 0 1 1 1 0 1 0\n" + 
			"1 1 1 1 1 1 1 1 0\n" + 
			"1 1 3 1 6 1 1 1 1\n" + 
			"1 1 1 1 1 1 1 1 1\n" + 
			"3 6 7\n" + 
			"1 1 0 0 0 0\n" + 
			"1 1 0 0 1 0\n" + 
			"1 1 0 0 4 0\n" + 
			"4 1 0 0 1 0\n" + 
			"1 5 1 0 1 6\n" + 
			"1 2 8 1 1 6\n" + 
			"1 1 1 9 2 1\n" + 
			"4 4 15\n" + 
			"0 0 0 0 \n" + 
			"0 0 0 0 \n" + 
			"0 0 0 0 \n" + 
			"1 0 0 0 \n" + 
			"1 0 0 0 \n" + 
			"1 0 0 0 \n" + 
			"1 0 0 0 \n" + 
			"1 0 5 0 \n" + 
			"1 1 1 0 \n" + 
			"1 1 1 9 \n" + 
			"1 1 1 1 \n" + 
			"1 6 1 2 \n" + 
			"1 1 1 5 \n" + 
			"1 1 1 1 \n" + 
			"2 1 1 2 \n" + 
			"4 12 15\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(source));
		StringTokenizer tokens;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			H = Integer.parseInt(tokens.nextToken());
			
			//static 변수 초기화 
			min = Integer.MAX_VALUE;
			brickTotalCount = 0;
			
			map = new int[H][W];
			
			src = new int[W];
			for(int i = 0; i < W; i++) {
				src[i] = i;
			}

			for(int i = 0; i < H; i++) {
				tokens = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
					
					if(map[i][j] > 0) {
						brickTotalCount++;
					}
				}
			}
			
			makePermutation(N, 0, new int[N]);			
			
			sb.append("#" + tc + " " + min + "\n");
		}

		System.out.println(sb);
	}
	
	//heights: 각 열의 높이(벽돌 몇개 있는지)
	//tmp: 구슬을 어디서 떨어뜨려야 할지 저장되있음(몇번째 열에서 떨어뜨려야 하는지 저장)
	static int dropMarble(int[][] map, int[] tmp, int totalBrickCount) {
		int brokenCount = 0; //부셔버린 벽돌 개수 합
		
		Queue<Point> q = new LinkedList<>();
		
		for(int i = 0; i < tmp.length; i++) {
			int colIdx = tmp[i];

			int rowIdx = 0;
			for(int r = 0; r < H; r++) {
				if(map[r][colIdx] > 0) {
					rowIdx = r;
					break;
				}
			}

			int brickPower = map[rowIdx][colIdx];
			
			q.add(new Point(rowIdx, colIdx, brickPower));
			map[rowIdx][colIdx] = 0;
			brokenCount++;
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				int power = p.power;
				
				for(int d = 0; d < 4; d++) {
					int nx = p.x;
					int ny = p.y;
					
					for(int s = 0; s < power-1; s++) {
						nx += dirs[d][0];
						ny += dirs[d][1];
						
						if(isIn(nx, ny) && map[nx][ny] > 0) {
							q.add(new Point(nx, ny, map[nx][ny]));
							map[nx][ny] = 0;
							brokenCount++;
						}
					}
				}
			}
			
			//중간중간 빈 공간때문에 벽돌들을 맨아래로 다 떨어뜨린다.
			cleanMap(map);
		}
		
		return totalBrickCount - brokenCount;
	}
	
	static void cleanMap(int[][] m) {
		for(int c = 0; c < W; c++) {
			for(int r = H-1, nr=H-1; r>=0; r--) {
				if(m[r][c]!=0) {
					int temp = m[r][c];
					m[r][c] = 0;
					m[nr--][c] = temp;
				}
			}
		}
	}
	
	static void makePermutation(int r, int depth, int[] tmp) {
		if(r == depth) {
			//원본 map copy 
			int[][] clonedMap = new int[H][W];
			for(int row = 0; row < H; row++) {
				clonedMap[row] = map[row].clone();
			}
			
			int remainBrickCount = dropMarble(clonedMap, tmp, brickTotalCount);
			min = Math.min(remainBrickCount, min);
			return;
		}
		
		for(int i = 0; i < src.length; i++) {
			tmp[depth] = src[i];
			makePermutation(r, depth+1, tmp);
			
			//가지치기: 해당 순열로 벽돌 전부 깨버렸으면 더이상 순열 구할필요 없어서 종료
			if(min == 0) {
				return;
			}
		}
	}
	
	static class Point {
		int x, y;
		int power; //폭발 파급 효과
		
		public Point(int x, int y, int power) {
			this.x = x;
			this.y = y;
			this.power = power;
		}
		
		@Override
		public String toString() {
			return x + "," + y + "," + power;
		}
	}
	
	static boolean isIn(int x, int y) {
		return (x>=0 && y>=0 && x<H && y<W);
	}
}
