package com.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/***
 * 성수의 실력이 가장 높아지려면
 * N개 중에서 큰 k개를 구하고
 * k개를 작은 것에서 큰것 순으로 듣는 것이 최대라고
 * 생각된다.
 */

public class SWEA_6719_D4_성수의프로그래밍강좌시청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T; t++){
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] soo = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n ; i++){
                soo[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(soo);
            System.out.println(Arrays.toString(soo));
            int[] select = new int[k];
            select = Arrays.copyOfRange(soo, soo.length - k ,soo.length);
            System.out.println(Arrays.toString(select));

            double result = 0;
            for(int i = 0; i < k ;i++){
                result += (double)select[i];
                result /= 2;
            }

            sb.append(String.format("%.6f", result)).append("\n");
        }
        System.out.println(sb);
    }

    private static String src = "3\n" +
            "2 2\n" +
            "2 3\n" +
            "2 1\n" +
            "2 3\n" +
            "5 3\n" +
            "9 5 2 3 5";
}
