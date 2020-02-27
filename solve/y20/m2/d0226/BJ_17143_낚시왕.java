package com.d0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 상어의 정보를 담는 class, 현재 상어가 위치한 칸을 표현하는 boolean 배열, 전체 상어의 정보를 담고 있는 list
 *
 * list를 지우는데 시간이 오래걸리나 보다
 * remove를 쓰지 말고 값만 바꿔야 겠다.
 *
 * list로 하니 작은 상어를 삭제하기위해서 for문을 돌려야 하는 귀찮은 일이 생긴다.
 * 배열로 바꿔야 겠다.
 *
 * 배열로 하니 확실히 좋은게 visited에 배열의 위치를 저장해두면
 * 현재 상어보다 큰 상어가 도착했을때 바로 작은 상어의 조건을 바꿔줄 수 있었다.
 * */
public class BJ_17143_낚시왕 {
    private static int[][] dirs  = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};//위, 아래, 오른, 왼
    private static int r, c;
    private static Shark[] list = null;
    private static int[][] visited = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new int[r+1][c+1];
        list = new Shark[m+1];
        for(int i = 1; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            list[i] =  new Shark(x, y, s, d, z);
            visited[x][y] = i;
        }

        int result = 0;
        for(int fisher = 1; fisher <= c; fisher++){//move fisher
            //System.out.println("#fisher : " + fisher);
            //catch shark
            int min_shark = 0;
            for(int i = 1; i <= r; i++){
                if(visited[i][fisher] != 0){
                    min_shark = visited[i][fisher];
                    list[min_shark].die = true;
                    result += list[min_shark].z;
                    //System.out.println("remove shark : " + list[min_shark].z);
                    break;
                }
            }

            //move sharks
            /*int numa = 0;
            for(int i = 1; i <= m; i++){
                if(!list[i].die) {
                    numa++;
                    System.out.println("shark : (x, y, z) : " + list[i].x + ", " + list[i].y + ", " + list[i].z);
                }
            }
            System.out.println("before move : "+ numa);*/

            visited = new int[r+1][c+1];
            for(int i = 1; i <= m; i++){
                if(list[i].die){
                    continue;
                }
                Shark now = list[i];
                int x = now.x;
                int y = now.y;
                int d = now.d;
                int s = now.s;
                //System.out.println("shark : (x, y, z) : " + list[i].x + ", " + list[i].y + ", " + list[i].z);

                while(s > 0){
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];

                    if(!isIn(nx, ny)){//범위를 벗어나면 방향을 바꾼다.
                        if(d == 0){
                            d = 1;
                        }else if(d == 1){
                            d = 0;
                        }else if(d == 2){
                            d = 3;
                        }else if(d == 3){
                            d = 2;
                        }
                        nx = x + dirs[d][0];
                        ny = y + dirs[d][1];
                    }

                    //System.out.println("nx : "+ nx + ", ny : " + ny + ", "+d);
                    x = nx;
                    y = ny;
                    s--;
                }

                //remove small shark
                if(visited[x][y] == 0){
                    visited[x][y] = i;
                }else{
                    if(list[visited[x][y]].z < now.z){
                        list[visited[x][y]].die = true;
                        visited[x][y] = i;
                    }else{
                        list[i].die = true;
                    }
                }

                list[i].d = d;
                list[i].x = x;
                list[i].y = y;
            }

            /*numa = 0;
            for(int i = 1; i <= m; i++){
                if(!list[i].die) {
                    numa++;
                    System.out.println("shark : (x, y, z) : " + list[i].x + ", " + list[i].y + ", " + list[i].z);
                }
            }
            System.out.println("after move : "+ numa);*/
        }
        System.out.println(result);
    }

    private static class Shark{
        int x;
        int y;
        int s;//속력
        int d;//방향
        int z;//크기
        boolean die = false;

        Shark(int x, int y, int s, int d, int z){
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    private static boolean isIn(int x, int y){
        if(x > 0 && x <= r && y > 0 && y <= c){
            return true;
        }else{
            return false;
        }
    }
    private static String src = "2 2 4\n" +
            "1 1 1 1 1\n" +
            "2 2 2 2 2\n" +
            "1 2 1 2 3\n" +
            "2 1 2 1 4";/*"100 7 7\n" +
            "3 2 2 3 9\n" +
            "3 3 1 3 3\n" +
            "3 5 1 4 7\n" +
            "3 6 2 4 6\n" +
            "2 4 1 2 8\n" +
            "1 4 2 2 4\n" +
            "4 4 1 1 5";*/
}
