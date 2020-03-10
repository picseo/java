package d0303;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * visited를 만들때 방향도 고려해야 한다는게 이문제의 중요 포인트였다.
 * 근데 나는 이걸 생각했는데도 왜 못했을까....
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

/*
 * bfs를 통해 도달하고 싶은 점이 있다면
 * poll()을 통해서 해당 좌표가 나왔을 때 처리를 해주어야 하나보다 
 * nx, ny값을보고 ex, ey가 맞다면 값을 return해 줬었는데 계속 5개 정도 오답이 나왔다.
 * 
 * */
public class SWEA_8382_D4_방향전환_내가하던거 {
    private static int[][] dirs = {{1, 0}, {0, 1},{-1, 0},  {0, -1}};//짝수 : 세로, 홀수 : 가로
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken())+100;
            int sy = Integer.parseInt(st.nextToken())+100;
            int ex = Integer.parseInt(st.nextToken())+100;
            int ey = Integer.parseInt(st.nextToken())+100;

            result = Integer.MAX_VALUE;
            visited = new int[2][201][201];
            for(int j = 0; j < 2; j++)
                for(int i = 0; i < 201; i++)
                    Arrays.fill(visited[j][i], -1);
            bfs(sx, sy, ex, ey);

            if(result == Integer.MAX_VALUE)
                result = 0;
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int sx, int sy, int ex, int ey){
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(sx, sy, 1, 0));
        queue.add(new Point(sx, sy, 0, 0));
        visited[0][sx][sy] = 0;
        visited[1][sx][sy] = 0;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            //다음부턴 꼭 이부분에서  x, y를 체크해야 겟다.
            if(now.x == ex && now.y == ey) {
            	result = Math.min(now.cnt,  result);
            	continue;
            }
            
            int now_cnt = now.cnt;
            for(int i = 0; i < 4; i++){
                if(now.dir%2 == i%2){
                    continue;
                }
                int nx = now.x + dirs[i][0];
                int ny = now.y + dirs[i][1];
                if(isIn(nx, ny)){
                    int ndir = i%2;
                    if(visited[ndir][nx][ny] == -1) {
                        visited[ndir][nx][ny] = now_cnt+1;
                        queue.add(new Point(nx, ny, i, now_cnt + 1));
                    }
                }
            }
        }
    }

    private static class Point{
        int x;
        int y;
        int dir;
        int cnt;

        Point(int x, int y, int dir, int cnt){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    private static int[][][] visited = null;

    private static boolean isIn(int x, int y){
        if(x >= 0 && x <= 200 && y >= 0 && y <= 200){
            return true;
        }else{
            return false;
        }
    }

	public static String src = "3\r\n" + 
			"0 0 1 0\r\n" + 
			"-1 -1 0 0\r\n" + 
			"0 0 0 2";
}
