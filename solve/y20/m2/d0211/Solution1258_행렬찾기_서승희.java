package swea.d0211;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/*결국 행렬이 시작되는 부분에서 행렬크기를 찾고
 * 행렬내부에 존재하는 수는 모두 지워주면서 하나씩 찾았다.*/
public class Solution1258_행렬찾기_서승희 {
	public static int[][] dirs = {{0, 1}, {1, 0}};//오른, 아래
	
	public static void main (String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1258.txt"));
		Scanner sc = new Scanner(System.in);
		//sc = new Scanner(src);
		
		int T= sc.nextInt();
		for(int t= 1; t<= T; t++) {
			int cnt = 0;//총 갯수
			List<SubMat> res = new ArrayList();
			int n = sc.nextInt();
			int[][] input  = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n ; j++) {
					input[i][j] = sc.nextInt();
				}
			}
			
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n ; j++) {
					if(input[i][j] != 0) {
						cnt++;
						//SubMat tmp = new SubMat(i, j, 1, 1);
						SubMat tmp = new SubMat(1, 1);
						input[i][j] = 0;
						
						int nx = i + dirs[0][0];
						int ny = j + dirs[0][1];
						while(isIn(nx, ny, n) && input[nx][ny] != 0) {
							tmp.col++;
							input[nx][ny] = 0;
							nx += dirs[0][0];
							ny += dirs[0][1];
						}
						
						nx = i + dirs[1][0];
						ny = j + dirs[1][1];
						while(isIn(nx, ny, n) && input[nx][ny] != 0) {
							tmp.row++;
							input[nx][ny] = 0;
							for(int k = 0; k < tmp.col; k++) {
								input[nx][ny+k] = 0;
							}
							nx += dirs[1][0];
							ny += dirs[1][1];
						}
						
						tmp.size = tmp.row*tmp.col;
						res.add(tmp);
					}
				}
			}
			
			
			
			//-------결과 출력--------------------------------------------------
			System.out.print("#"+t+" "+cnt+" ");
			res.sort(new Comparator<SubMat>() {

				@Override
				public int compare(SubMat o1, SubMat o2) {
					if(o1.size == o2.size) {
						return Integer.compare(o1.row, o2.row);
					}else {
						return Integer.compare(o1.size,  o2.size);
					}
				}
				
			});
			
			for(int i = 0; i < res.size(); i++) {
				System.out.print(res.get(i).row +" "+res.get(i).col+" ");
			}
			System.out.println();
			//-------결과 출력--------------------------------------------------
		}

	}
	private static boolean isIn(int x, int y, int len) {
		if(x >= 0 && x < len && y >= 0 && y < len) {
			return true;
		}else {
			return false;
		}
	}
	
	
	static class SubMat{
		int row = 0;
		int col = 0;
		int size =0;

		SubMat(int row, int col){
			this.row = row;
			this.col = col;
			this.size = row*col;
		}
		/*int st_idx;
		int end_idx;
		int row = 0;
		int col = 0;
		int size =0;
		
		SubMat(int st, int end){
			this.st_idx = st;
			this.end_idx = end;
		}
		
		SubMat(int st, int end, int col){
			this.st_idx = st;
			this.end_idx = end;
			this.col = col;
		}
		
		SubMat(int st, int end, int row, int col){
			this.st_idx = st;
			this.end_idx = end;
			this.row = row;
			this.col = col;
			this.size = row*col;
		}*/
	}
	private static String src = "1\r\n" + 
			"5\r\n" + 
			"1 2 3 4 0 \r\n" + 
			"0 0 0 0 0 \r\n" + 
			"5 0 0 0 0 \r\n" + 
			"6 0 0 0 0 \r\n" + 
			"0 0 0 0 0 ";
}
