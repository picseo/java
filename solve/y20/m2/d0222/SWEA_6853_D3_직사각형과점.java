package com.d0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_6853_D3_직사각형과점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
           st = new StringTokenizer(br.readLine());
           int x1 = Integer.parseInt(st.nextToken());
           int y1 = Integer.parseInt(st.nextToken());
           int x2 = Integer.parseInt(st.nextToken());
           int y2 = Integer.parseInt(st.nextToken());

           int n = Integer.parseInt(br.readLine());
           int[] result = new int[3];
           for(int i = 0; i < n; i++){
               st = new StringTokenizer(br.readLine());
               int x = Integer.parseInt(st.nextToken());
               int y = Integer.parseInt(st.nextToken());

               if(x >= x1 && x <= x2 && y <= y2 && y >= y1){
                   if(x == x1 || x == x2 || y == y1 || y == y2){
                       result[1]++;
                   }else{
                       result[0]++;
                   }
               }else{
                   result[2]++;
               }
           }

           sb.append("#").append(t).append(" ").append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]).append("\n");
        }
        System.out.println(sb);
    }

    private static String src = "1\n" +
            "0 0 2 2\n" +
            "4\n" +
            "-1 -1\n" +
            "0 0\n" +
            "1 1\n" +
            "2 2";
}
