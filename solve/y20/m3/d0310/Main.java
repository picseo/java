package d0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static PriorityQueue<int[]> list;
	static int onecnt;
	static int min;
	static boolean done;
	static int[][] memo;
	
	static int[] v = {0,1,4,9,16,25};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		map = new int[10][10];
		memo = new int[10][10];
		
		list = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				Integer asum=0, bsum=0;
				for (int i = 0; i < o1.length; i++) {
					asum += o1[i];
					bsum += o2[i];
				}
				return asum.compareTo(bsum);
			}
		});
		
		onecnt = 0;
		min = Integer.MAX_VALUE;
		done = false;
		
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					onecnt++;
				}
			}
		}
		
		for(int i = 0; i < 10; i++) {
			Arrays.fill(memo[i], -1);
		}
		
		subset(new int[6],1, 0);
		
		while(!list.isEmpty()) {
			done = false;
			int[] temp = list.poll();
			dfs(temp, 0);
			if(done) {
				int sum = 0;
				for (int o = 1; o < temp.length; o++) {
					sum += temp[o];
				}
				min = Math.min(min, sum);
				break;
			}
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	
	static void dfs(int[] arr, int cnt) {
		boolean can = false;
		if(cnt==onecnt || done) {
			done = true;
			return;
		}
		for (int i = arr.length-1; i>=1; i--) {
			if(arr[i]>0) {
				for (int r = 0; r < map.length-i+1; r++) {
					for (int c = 0; c < map[r].length-i+1; c++) {						
						if(map[r][c]>0) {
							if(memo[r][c] == -1) {
								if(isStick(r, c, i)) {
									memo[r][c] = i;
									arr[i]--;
									stick(r, c, i);
									dfs(arr, cnt+v[i]);
									reverse(r, c, i);
									arr[i]++;
									can = true;
								}else {
									can = false;
								}						
							}else {
								if(memo[r][c] >= i) {
									arr[i]--;
									stick(r, c, i);
									dfs(arr, cnt+v[i]);
									reverse(r, c, i);
									arr[i]++;
									can = true;
								}else {
									can = false;
								}
							}
						}
					}
				}
				if(!can) {
					return;
				}
			}			
		}
	}
	
	
	static boolean isStick(int r, int c, int len) {
		if(!isIn(r+len-1,c+len-1)) {
			return false;
		}
		for (int i = r; i < r+len; i++) {
			for (int j = c; j < c+len; j++) {
				if(map[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void stick(int r, int c, int len) {
		for (int i = r; i < r+len; i++) {
			for (int j = c; j < c+len; j++) {				
				map[i][j] = 0;
			}
		}
	}
	
	static void reverse(int r, int c, int len) {
		for (int i = r; i < r+len; i++) {
			for (int j = c; j < c+len; j++) {				
				map[i][j] = 1;
			}
		}
	}
	
	
	static void subset(int[] arr, int start,int sum) {
		if(sum>onecnt) {
			return;
		}
		if(arr.length==start) {
			if(sum==onecnt)	list.add(Arrays.copyOf(arr, arr.length));
			return;
		}		
		for (int i = 0; i <= 5; i++) {
			arr[start] = i;
			subset(arr, start+1, sum+v[start]*i);
		}
	}
	
	static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<map.length && y<map[0].length;
	}

	static String src = 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 1 0 0 0 0 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 0 0 0\r\n" + 
			"0 0 1 1 1 1 1 0 0 0\r\n" + 
			"0 0 0 1 1 1 1 0 0 0\r\n" + 
			"0 0 0 0 1 1 1 0 0 0\r\n" + 
			"0 0 1 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0";
}