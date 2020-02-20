package com.day0208;

import java.util.Scanner;

public class SWEA_4299_D3_태혁이의사랑은타이밍 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1 ; t <= T ; t++){
            int d = sc.nextInt();
            int h = sc.nextInt();
            int m = sc.nextInt();

            int result = 0;
            result = (d - 11)*60*24;
            result += (h - 11)*60;
            result += (m-11);

            if(result < 0)
                result = -1;
            System.out.println("#"+t+" "+result);
        }
    }

    private static String src = "3\n" +
            "14 23 59\n" +
            "11 11 11\n" +
            "11 3 7";
}
