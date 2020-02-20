package com.day0209;

import java.util.Scanner;

public class SWEA_5688_D3_세제곱근을찾아라 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t<= T; t++){
            long result = -1;
            long n = sc.nextLong();

            for(long i = 1; i*i*i <= n; i++){
                if(i*i*i == n){
                    result = i;
                    break;
                }
            }

            System.out.println("#"+t+" "+result);
        }
    }

    private static String src = "3\n" +
            "27\n" +
            "7777\n" +
            "64";
}
