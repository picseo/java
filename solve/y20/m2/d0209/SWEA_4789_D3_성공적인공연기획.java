package com.day0209;

import java.util.Scanner;

public class SWEA_4789_D3_성공적인공연기획 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            String input = sc.next();

            int res = 0;
            int total = input.charAt(0) -'0';
            for(int i = 1; i < input.length(); i++){
                int now = input.charAt(i) -'0';
                if(total >= i){
                    total += now;
                }else{
                    res += (i - total);
                    total = i + now;
                }
            }

            System.out.println("#"+t+" "+res);
        }
    }
   private static String src = "4\n" +
           "11111\n" +
           "09\n" +
           "110011\n" +
           "1";
}
