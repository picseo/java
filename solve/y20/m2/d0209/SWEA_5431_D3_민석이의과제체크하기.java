package com.day0209;

import java.util.Scanner;

public class SWEA_5431_D3_민석이의과제체크하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t<= T; t++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean[] people = new boolean[n+1];

            for(int i = 0; i < k; i++){
                people[sc.nextInt()]= true;
            }

            System.out.print("#"+t+" ");
            for(int i = 1 ; i <= n; i++){
                if(!people[i]){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
    }
    private static String src = "2\n" +
            "5 3\n" +
            "2 5 3\n" +
            "7 2\n" +
            "4 6";
}
