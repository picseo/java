package com.day0208;

import java.util.Scanner;

public class SWEA_3282_D3_01knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t<= T; t++){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] c = new int[n+1];
            int[] v = new int[n+1];
            for(int i = 1; i < n+1 ; i++){
                v[i] = sc.nextInt();
                c[i] = sc.nextInt();
            }

            int[][] dim = new int[k+1][n+1];
            for(int i = 1; i < k+1; i++){
                for(int j = 1; j < n+1; j++){
                    if(i - v[j] >= 0)
                        dim[i][j] = Math.max(dim[i-v[j]][j-1] + c[j], dim[i][j-1]);
                    else
                        dim[i][j] = dim[i][j-1];
                }
            }

            System.out.println("#"+t+" "+dim[k][n]);
        }
    }

    private static String src = "1\n" +
            " 4 5\n" +
            " 1 2\n" +
            " 3 2\n" +
            " 4 4\n" +
            " 2 3";
}

