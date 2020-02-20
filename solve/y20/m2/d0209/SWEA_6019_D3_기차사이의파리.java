package com.day0209;

import java.util.Scanner;

public class SWEA_6019_D3_기차사이의파리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc =new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            double d = sc.nextDouble();
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double f = sc.nextDouble();


            double how = d/(a+b);
            double result = how*f;

            System.out.printf("#%d %10.6f\n", t, result);
        }
    }
    private static String src = "1\n" +
            "250 10 15 20";
}
