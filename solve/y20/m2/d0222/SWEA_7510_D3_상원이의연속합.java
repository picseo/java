package com.d0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
/*
* 연속합은 직접 연속된 걸 다 해보는 거였다.
* **/
public class SWEA_7510_D3_상원이의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br =  new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T; t++){
            int n = Integer.parseInt(br.readLine());

            int tmp = 0;
            int result = 0;
            int front = 0;
            for(int i = 1; i <= n; i++){
                tmp += i;

                while(tmp > n){
                    tmp -= (front++);
                }

                if(tmp == n){
                    result++;
                }
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static String src = "4\n" +
            "1\n" +
            "15\n" +
            "42\n" +
            "54321";
}
