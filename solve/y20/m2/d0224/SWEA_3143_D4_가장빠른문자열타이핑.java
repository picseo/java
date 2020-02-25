package com.d0224;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_3143_D4_가장빠른문자열타이핑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int t = 1 ; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            System.out.println(a);
            System.out.println(b);
            int alen = a.length();
            int blen = b.length();

            int result = 0;
            for(int i = 0; i < alen; ){
                if(i+blen <= alen && a.substring(i, i+blen).equals(b)){
                    System.out.println(a.substring(i, i+blen));
                    i += blen;
                }else{
                    System.out.println(a.charAt(i));
                    i++;
                }
                result++;
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    private static String src = "2\n" +
            "banana bana\n" +
            "asakusa sa";
}
