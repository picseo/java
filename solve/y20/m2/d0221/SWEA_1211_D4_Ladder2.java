package com.day0221;

/**
 * Ladder1이랑 다른 점은
 * 1은 2를 만나면 결과를 update해주고 그만두면 되지만
 *
 * Ladder2는 x값이 99가 된경우에 현재까지의 거쳐온 길이가 이미 존재하는 min값보다
 * 작으면 update를 해야한다.
 * 그리고 중간에 끝낼 수 없고, 끝까지 모두 탐색해야 한다.
 * */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1211_D4_Ladder2 {
    public static int[][] map = new int[100][100];
    public static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res\\input2.txt"));
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
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 100; i++){
                int x = 0;
                int y = i;
                int type = 2;
                int tmp = 1;

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
                                    tmp += 1;
                                    if(nx == 99 && min >= tmp){
                                        min = tmp;
                                        result = i;
                                    }
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
                                    tmp += 1;
                                    if(nx == 99 &&min >= tmp){
                                        min = tmp;
                                        result = i;
                                    }
                                    break;
                                }
                            }
                        }
                    }else if(type == 0) {
                        for (int j = 0; j < 3; j++) {
                            if (j == 1) {
                                continue;
                            }
                            int nx = x + dirs[j][0];
                            int ny = y + dirs[j][1];

                            if (isIn(nx, ny)) {
                                if (map[nx][ny] == 1) {
                                    x = nx;
                                    y = ny;
                                    type = j;
                                    tmp += 1;
                                    if (nx == 99 &&min >= tmp) {
                                        min = tmp;
                                        result = i;
                                    }
                                    break;
                                }
                            }
                        }
                    }
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
