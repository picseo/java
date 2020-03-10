package d0306;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class 디저트카페_강의 {
    static int N;           
    static int max;         
    static int sr;          
    static int sc;          
    static int[][] map;     
    static boolean[] visit;
    static int[][] direction = {{1,1},{1,-1},{-1,-1},{-1,1}};
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <=T; tc++) {
            max = 0;
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            visit = new boolean[101];

            for (int i = 0; i <N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j <N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for (int i = 0; i <N; i++) {
                for (int j = 0; j < N; j++) {
                    sr = i;
                    sc = j;
                    Arrays.fill(visit, false);
                    dfs(i, j, 0, 1);
                }
            }
            System.out.println("#"+tc+" "+(max==0?-1:max));
        }
    }
     
    private static void dfs(int r, int c, int dir, int cnt) {
        visit[map[r][c]] = true;
        for (int d = dir; d <4; d++) {
            int nr = r+direction[d][0];
            int nc = c+direction[d][1];
            if(nr==sr && nc == sc && cnt >=4) {
//                if(cnt >max) {
//                    max = cnt;
//                    return ;
//                }
            	max = Math.max(cnt,  max);
            	visit[map[r][c]] = false;
            	return;
            }
            if(nr >-1 && nr<N && nc>-1 && nc<N 
               && !visit[map[nr][nc]]) {         
                dfs(nr, nc, d, cnt+1);
            }
        }
//            
//   visit배열에서 현재 노드의 대한 방문 표시한 것을 해제
        visit[map[r][c]] = false;
    }
}
