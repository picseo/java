package com.d0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4613_D4_러시아국기같은깃발 {
    public static char[] colors = {'W', 'B', 'R'};
    public static int[] where_blue = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][] flag  = new char[n][m];
            for(int i = 0 ; i < n ; i++){
                flag[i] = br.readLine().toCharArray();
            }

            //blue가 한 줄인 경우
            where_blue = new int[n-2];
            where_blue[0] = 1;
            Arrays.sort(where_blue);

            int result = Integer.MAX_VALUE;
            do{
                //System.out.println(Arrays.toString(where_blue));
                int what_colors = 0;
                int tmp = 0;
                for(int i = 0; i < m; i++){
                    if (flag[0][i] != colors[what_colors]) {
                        tmp++;
                    }
                }

                for(int i = 0; i < n-2 ; i++){
                    if(where_blue[i] == 1){
                        what_colors++;
                    }
                    for(int j = 0; j <m; j++){
                        if(flag[i+1][j] != colors[what_colors]){
                            tmp++;
                        }
                    }
                    if(where_blue[i] == 1){
                        what_colors++;
                    }
                }

                for(int i = 0; i < m; i++){
                    if (flag[n-1][i] != colors[what_colors]) {
                        tmp++;
                    }
                }

                if(result > tmp){
                    result = tmp;
                }
            }while(nextP());

            if(n > 3) {
                //blue가 두 줄 이상인 경우
                where_blue = new int[n - 2];
                where_blue[0] = 1;
                where_blue[1] = 1;
                Arrays.sort(where_blue);


                do {
                    //System.out.println(Arrays.toString(where_blue));
                    int what_colors = 0;
                    int tmp = 0;
                    for (int i = 0; i < m; i++) {
                        if (flag[0][i] != colors[what_colors]) {
                            tmp++;
                        }
                    }

                    for (int i = 0; i < n - 2; i++) {
                        if (where_blue[i] == 1) {
                            what_colors++;
                        }
                        for (int j = 0; j < m; j++) {
                            if (flag[i + 1][j] != colors[what_colors]) {
                                tmp++;
                            }
                        }
                    }

                    for (int i = 0; i < m; i++) {
                        if (flag[n - 1][i] != colors[what_colors]) {
                            tmp++;
                        }
                    }

                    if (result > tmp) {
                        result = tmp;
                    }
                } while (nextP());

            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean nextP(){
        int i, j;
        for(i = where_blue.length -2; i >= 0 ; i--){
            if(where_blue[i] < where_blue[i+1]){
                break;
            }
        }

        if(i < 0){
            return false;
        }

        for(j = where_blue.length -1 ; j >= 0 ; j--){
            if(where_blue[i] < where_blue[j]){
                break;
            }
        }

        int tmp = where_blue[i];
        where_blue[i] = where_blue[j];
        where_blue[j] = tmp;

        for(int st = i+1, ed = where_blue.length-1 ; st < ed; st++, ed--){
            tmp = where_blue[st];
            where_blue[st] = where_blue[ed];
            where_blue[ed] = tmp;
        }

        return true;
    }

    private static String src = "2\n" +
            "3 5\n" +
            "WRWRW\n" +
            "BWRWB\n" +
            "WRWRW\n" +
            "6 14\n" +
            "WWWWWWWWWWWWWW\n" +
            "WWRRWWBBBBBBWW\n" +
            "WRRRWWWBWWWWRB\n" +
            "WWBWBWWWBWRRRR\n" +
            "WBWBBWWWBBWRRW\n" +
            "WWWWWWWWWWWWWW";
}
