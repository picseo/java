package com.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
/**
 * 부분 집합을 이용하였다.
 * */
public class SWEA_1486_D4_장훈이의높은선반 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] height = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n ; i++){
                height[i] = Integer.parseInt(st.nextToken());
            }

            int result = Integer.MAX_VALUE;
            for(int i = 0; i < (1 << n); i++){
                int tmp = 0;
                for(int j = 0; j < n ; j ++){
                    if((i & (1 << j)) > 0 ){
                        tmp += height[j];
                    }
                }
                if(tmp >= b){
                    if(result >= (tmp-b))
                        result = (tmp-b);
                }

            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static String src = "1\n" +
            " 5 16\n" +
            " 1 3 3 5 6";
}
