package com.d0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_4261_D4_빠른휴대전화키패드 {
    public static String[] num2char = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            int result = 0;
            int s_len = s.length();
            String words = null;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n ; i++){
                boolean not = false;
                words = st.nextToken();
                if(words.length() != s_len){
                    continue;
                }

                for(int j = 0; j < s_len; j++){
                    int now = s.charAt(j) -'0';
                    if(num2char[now].indexOf(words.charAt(j)) < 0){
                        not = true;
                        break;
                    }
                }

                if(!not){
                    result++;
                }
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static String src = "3\n" +
            "6666 3\n" +
            "tomo mono dak\n" +
            "52 2\n" +
            "ja la\n" +
            "366 3\n" +
            "dom fon tom";
}
