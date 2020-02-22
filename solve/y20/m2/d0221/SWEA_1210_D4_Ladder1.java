package com.day0221;

/**
 * 처음에는 길을 따라가는 거니까 dfs라 생각했는데
 * 이문제는 사다리타기여서 전혀 그럴 필요가 없었다.
 * 왼, 오 이동시에만 방향을 잘 처리해주면
 * 이전의 정보가 없어도 진행하는 데는 문제가 없었기 때문이다.
 * 그래서 while, for문을 이용해서 구현하였다.
 * */
import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1210_D4_Ladder1 {
    public static int[][] map = new int[100][100];
    public static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10 ; t++){
            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100 ;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //find start potision
            int result = 0;
            for(int i = 0; i < 100; i++){
                int x = 0;
                int y = i;
                int type = 2;
                boolean find = false;

                if(map[x][y] == 0){
                    continue;
                }

                while(x < 99){//x가 98일때 까지만 보아야 nx가 99일때의 상태를 확인하고 break할 수 있다.
                    if(type == 2){
                        for(int j = 0; j < 3; j++){
                            int nx = x + dirs[j][0];
                            int ny = y + dirs[j][1];

                            if(isIn(nx, ny)){
                                if(map[nx][ny] == 1){
                                    x = nx;
                                    y = ny;
                                    type = j;
                                    break;
                                }else if(map[nx][ny] == 2){
                                    result = i;
                                    find = true;
                                    break;
                                }
                            }
                        }
                    }else if(type == 1){
                        for(int j = 0; j < 3; j++){
                            if(j == 0)
                                continue;

                            int nx = x + dirs[j][0];
                            int ny = y + dirs[j][1];

                            if(isIn(nx, ny)){
                                if(map[nx][ny] == 1){
                                    x = nx;
                                    y = ny;
                                    type = j;
                                    break;
                                }else if(map[nx][ny] == 2){
                                    result = i;
                                    find = true;
                                    break;
                                }
                            }
                        }
                    }else if(type == 0){
                        for(int j = 0; j < 3; j++){
                            if(j == 1){
                                continue;
                            }
                            int nx = x + dirs[j][0];
                            int ny = y + dirs[j][1];

                            if(isIn(nx, ny)){
                                if(map[nx][ny] == 1){
                                    x = nx;
                                    y = ny;
                                    type = j;
                                    break;
                                }else if(map[nx][ny] == 2){
                                    result = i;
                                    find = true;
                                    break;
                                }
                            }
                        }
                    }
                    if(find){
                        break;
                    }
                }

                if(find){
                    break;
                }
            }//열 찾기 for문

            sb.append("#").append(n).append(" ").append(result).append("\n");
        }//testcase
        System.out.println(sb);
    }

    public static boolean isIn(int x, int y){
        if(x >= 0 && x < 100 && y >= 0 && y < 100){
            return true;
        }else{
            return false;
        }
    }

}
