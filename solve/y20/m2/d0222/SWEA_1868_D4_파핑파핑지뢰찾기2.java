package com.d0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

//bfs - > 연결된 덩어리 갯수 찾기??
//주변에 지뢰가 없는 부분부터 터뜨리고 (for, for로 전체 탐색해서 주변에 지뢰가 없는 칸을 만나면 bfs를 해서
// 주변을 다 확인
// 그후에 다시 for, for을 통해서 남아있는 부분을 세면 될 것 같은데 시간초과가 나온다. 어떻게해야하지

/*
* 다른 사람의 풀이를 보고 왔다.
* 문제를 풀려고 생각한 방식은 나랑 비슷했다.(가장 많이 열리는 걸 열고, 그 다음에 차근차근"
* 이 사람도 큐에 들어가는거에 중복이 생겨서 시간초과가 났다고 한다.
* 탐색의 중복을 줄이는 것이 중요하다고 한다.
*
* ->결국 visited를 통해서 중복을 줄이니 통과했다.
* */
public class SWEA_1868_D4_파핑파핑지뢰찾기2 {
    public static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static char[][] map = null;
    public static int n = 0;

    public static boolean[][] visited = null;
    public static Queue<Point> q = new LinkedList<>();
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());

            map = new char[n][n];
            visited = new boolean[n][n];

            for(int i = 0; i < n ; i++){
                map[i] = br.readLine().toCharArray();
            }

            int result = 0;
            for(int i = 0; i < n ; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] != '.') continue;

                    int bomb = 0;
                    for(int k = 0; k < 8; k++){
                        int nx = i + dirs[k][0];
                        int ny = j + dirs[k][1];

                        if(isIn(nx, ny) && map[nx][ny] == '*'){
                            bomb++;
                        }
                    }

                    if(bomb == 0){
                        result++;
                        q.add(new Point(i, j));
                        bfs();
                    }
                }
            }

            for(int i = 0; i < n ; i++){
                for(int j = 0; j < n ; j++){
                    if(map[i][j] == '.'){
                        result++;
                    }
                }
            }
            //System.out.println("end");
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(){
        while(!q.isEmpty()){
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            visited[x][y] = true;
            int bomb = 0;
            for(int i = 0; i < 8; i++){
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if(isIn(nx, ny) && map[nx][ny] == '*'){
                    bomb++;
                }
            }
            //System.out.println("bomb : " + bomb);
            map[x][y] = (char)('0'+bomb);
            if(bomb == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];

                    if (isIn(nx, ny) && map[nx][ny] == '.'&&!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    private static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isIn(int x, int y){
        if(x >=0 && x < n && y >= 0 && y < n){
            return true;
        }else{
            return false;
        }
    }

    private static String src = "2\n" +
            "3\n" +
            "..*\n" +
            "..*\n" +
            "**.\n" +
            "5\n" +
            "..*..\n" +
            "..*..\n" +
            ".*..*\n" +
            ".*...\n" +
            ".*...";
}
