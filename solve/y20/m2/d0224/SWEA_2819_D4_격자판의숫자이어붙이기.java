package com.d0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

/**
 * int 배열 자체로 비교하고 싶었는데, 그렇게 되니까 23이 아니라 16이 나와서 고민했었는데
 * 이게 아마 dfs들어가기 전에 만든 tmp배열의 수를 의미하는것 같다
 * 시작 위치를 16개로 잡고 만들었으니까
 *
 * 그래서 중복을 고민하기 싫어서 tmp에 저장된 값을 어차피 7자리니까
 * 7자리 int로 만든다음에 hashset에 넣으니까 정답이 나왔다.
 *
 * 배열의 같음은 너무 어렵다.
 * 배열의 값만 옮기는 clone을 사용해봤더니 다 다른 배열로 인식해서
 * 모든 경우의 수가 나왔다.
 * 배열을 hashset에 넣으면 배열의 내용이 아니라 주소로 구분하는 것같다.
 *
 * hashset에는 되도록 기본형만 넣어보자
 * 아니면 배열을 어떻게 주소가 아니라 값으로 인식하게 할 수 있는지 찾아보던가
 *
 * */
public class SWEA_2819_D4_격자판의숫자이어붙이기 {
    private static int[][] map = new int[4][4];
    private static int result = 0;
    private static int[][] dirs ={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static HashSet<Integer> hs = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            result = 0;
            hs = new HashSet<>();

            for(int i = 0; i < 4; i++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int j = 0; j < 4; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    int[] tmp = new int[7];
                    tmp[0] = map[i][j];
                    dfs(i, j, 1, tmp);
                }
            }

            result = hs.size();
            System.out.println(" set : " + hs.size());

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int len, int[] tmp){
        if(len == 7){
            //System.out.println(Arrays.toString(tmp));
            int tmp_res = 0;
            int dv = 1;
            for(int i = 6; i >=0; i--){
                tmp_res +=(tmp[i]*dv);
                dv *= 10;
            }

            System.out.println(tmp_res);
            hs.add(tmp_res);
        }else{
            for(int i = 0; i < 4 ; i++){
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if(isIn(nx, ny)){
                    tmp[len] = map[nx][ny];
                    dfs(nx, ny, len+1, tmp);
                }
            }
        }

    }

    private static boolean isIn(int x, int y){
        if(x>=0 && x< 4 && y>=0 && y<4){
            return true;
        }else{
            return false;
        }
    }

    private static String src = "1\n" +
            " 1 1 1 1\n" +
            " 1 1 1 2\n" +
            " 1 1 2 1\n" +
            " 1 1 1 1";
}
