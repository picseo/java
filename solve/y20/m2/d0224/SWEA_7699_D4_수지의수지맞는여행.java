package com.d0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

/*
* 길이가 주어지지 않았으므로 bfs를 이용해서 탐색할 계획이다.
* -> 이 문제는 결국 dfs문제 였다.
* bfs로 풀려고 하니까 알파벳 정보가 겹치게 되어 원하는 값이 나오지 않았다.
* 아래쪽 A로 내려가서 모두 확인한 다음에 왼쪽 A로 가고 싶어도 bfs에서는 예외처리를 해주는 방법을
* 몰라서 왼쪽 탐색을 못했는데
* dfs를 이용하니까 아래쪽을 모두 탐색하고 나서는 visited, alph를 초기화하고
* 탐색을 하였다.
*
* 그런데 풀다보니까 보급로는 bfs로만 풀리던데 이 문제는 왜 dfs로 풀리는지 의문이 들었다.
* 아마도 보급로는 G에 도달한 값만 필요한데 dfs를 이용하게 되면 G의 위치가 아닌 부분에서 멈추는 경우가
* 생겨서 bfs를 이용해야 하고, 숫자 값이 같아도 전혀 상관이 없어서 일까
* */
public class SWEA_7699_D4_수지의수지맞는여행 {
    public static int[][] dirs = {{0, -1}, {1, 0},{0, 1}, {-1, 0}};
    private static int r = 0;
    private static int c = 0;
    private static int result = 0;
    private static boolean[] alph = new boolean[26];
    //private static int[][] visited = null;
    private static boolean[][] visited = null;
    private static char[][] map = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            result = Integer.MIN_VALUE;
            Arrays.fill(alph, false);

            map = new char[r][c];
            //visited = new int[r][c];
            visited = new boolean[r][c];

            for(int i = 0; i < r; i++){
                map[i] = br.readLine().toCharArray();
            }

            System.out.println(Arrays.toString(alph));
            for(int i = 0; i < r; i++)
                System.out.println(Arrays.toString(visited[i]));
            for(int i = 0; i < r; i++)
                System.out.println(Arrays.toString(map[i]));

            //bfs(0, 0);
            dfs(0, 0, 1);

            System.out.println(Arrays.toString(alph));
            for(int i = 0; i < r; i++)
                System.out.println(Arrays.toString(visited[i]));
            for(int i = 0; i < r; i++)
                System.out.println(Arrays.toString(map[i]));



            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int k){
        visited[x][y] = true;
        alph[map[x][y] - 'A'] = true;

        boolean visit = false;
        for(int i = 0; i < 4; i++){
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if(isIn(nx, ny) && !visited[nx][ny] && !alph[map[nx][ny] -'A']){
                visited[nx][ny] = true;
                alph[map[nx][ny] - 'A'] = true;
                dfs(nx, ny, k+1);
                alph[map[nx][ny] - 'A'] = false;
                visited[nx][ny] = false;
                visit = true;
            }
        }

        if(!visit){
            if(result < k){
                result = k;
            }
        }
    }

    /*private static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = 1;
        alph[map[x][y] - 'A'] = true;

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            int tmpx = tmp.x;
            int tmpy = tmp.y;
            boolean visit = false;
            for(int i = 0; i < 4; i++){
                int nx = tmpx + dirs[i][0];
                int ny = tmpy + dirs[i][1];
                if(isIn(nx, ny) && visited[nx][ny] == 0 && !alph[map[nx][ny] -'A']){
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = visited[tmpx][tmpy] + 1;
                    alph[map[nx][ny] - 'A'] = true;
                    visit = true;
                }
            }

            if(!visit){
                if(result < visited[tmpx][tmpy]){
                    result = visited[tmpx][tmpy];
                }
            }
        }
    }*/

    private static class Point{
        int x;
        int y;
        int k = 0;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isIn(int x, int y){
        if(x >= 0 && x < r && y >= 0 && y < c){
            return true;
        }else{
            return false;
        }
    }

    private static String src = "3\n" +
            "2 4\n" +
            "CAAB\n" +
            "ADCB\n" +
            "3 6\n" +
            "HFDFFB\n" +
            "AJHGDH\n" +
            "DGAGEH\n" +
            "5 5\n" +
            "IEFCJ\n" +
            "FHFKC\n" +
            "FFALF\n" +
            "HFGCF\n" +
            "HMCHH";
}
