package com.d0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_7532_D3_세영이의SEM력연도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int tmp = e;
            while(tmp <= 260000) {
                int tmps = tmp;
                while (tmps > 365) {
                    tmps -= 365;
                }

                int tmpm = tmp;
                while (tmpm > 29) {
                    tmpm -= 29;
                }

                if (tmps == s && tmpm == m) {
                    sb.append(tmp).append("\n");
                    break;
                }

                tmp += 24;
            }
        }
        System.out.println(sb);
    }

    private static String src = "5\n" +
            "5 5 5\n" +
            "14 24 1\n" +
            "365 24 29\n" +
            "24 1 24\n" +
            "3 6 9";
}
