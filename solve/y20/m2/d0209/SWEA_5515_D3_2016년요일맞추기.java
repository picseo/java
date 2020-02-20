package com.day0209;

import java.util.Scanner;

public class SWEA_5515_D3_2016년요일맞추기 {
    public static int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t =1; t <= T; t++){
            int m = sc.nextInt();
            int d = sc.nextInt();

            int start = 4;
            int how = 0;
            for(int i = 0; i < m-1; i++){
                how += months[i];
            }
            how += d -1;

            int result = (start+how)%7;
            System.out.println("#"+t+" "+result);
        }

    }
    private static String src = "2\n" +
            "1 1\n" +
            "12 31";
}
