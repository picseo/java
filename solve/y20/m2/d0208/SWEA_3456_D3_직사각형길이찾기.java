package com.day0208;

import java.util.Scanner;

public class SWEA_3456_D3_직사각형길이찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t<= T; t++){
            boolean[] check = new boolean[101];
            for(int i = 0; i < 3; i++){
                int tmp = sc.nextInt();
                if(check[tmp])
                    check[tmp] = false;
                else
                    check[tmp] = true;
            }

            for(int i = 0; i < 101; i++){
                if(check[i]){
                    System.out.println("#"+t+" "+i);
                }
            }
        }
    }

    private static String src = "3\n" +
            "1 1 2\n" +
            "4 3 4\n" +
            "5 5 5";
}

