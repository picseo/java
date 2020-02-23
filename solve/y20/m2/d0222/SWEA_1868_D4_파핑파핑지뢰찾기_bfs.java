package com.d0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
//visited를 안넣어 시간초과가 났었다.
public class SWEA_1868_D4_파핑파핑지뢰찾기_bfs {
    public static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static char[][] map = null;
    public static boolean[][] visited = null;

    public static int n = 0;
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
                    int bomb = 0;
                    for(int ii = 0; ii < 8; ii++){
                        int nx = i + dirs[ii][0];
                        int ny = j + dirs[ii][1];
                        if(isIn(nx, ny) && map[nx][ny] == '*'){
                            bomb++;
                        }
                    }

                    if(bomb == 0 && map[i][j] == '.' && !visited[i][j]){
                        result++;
                        bfs(i, j);
                    }
                }
            }

            for(int i = 0; i < n ; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] == '.'){
                        result++;
                        bfs(i, j);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            int bomb = 0;
            for(int i = 0; i < 8; i++){
                int nx = now.x + dirs[i][0];
                int ny = now.y + dirs[i][1];
                if(isIn(nx, ny) && map[nx][ny] == '*'){
                    bomb++;
                }
            }

            map[now.x][now.y] = (char)('0'+bomb);
            if(bomb == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = now.x + dirs[i][0];
                    int ny = now.y + dirs[i][1];
                    if (isIn(nx, ny) && map[nx][ny] == '.'&&!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
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
