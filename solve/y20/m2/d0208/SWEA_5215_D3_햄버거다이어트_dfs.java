package com.day0208;

import java.util.Scanner;

public class SWEA_5215_D3_햄버거다이어트_dfs {
    private static int[] krr = new int[1000];
    private static int[] trr = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T =sc.nextInt();
        for(int t = 1; t <= T; t++){
            int n = sc.nextInt();
            int l = sc.nextInt();
            for(int i = 0; i < n ; i ++){
                trr[i] = sc.nextInt();
                krr[i] = sc.nextInt();
            }

            int res = dfs(n, 0, 0, 0, l);

            System.out.println("#"+t+" "+res);
        }
    }

    private static int dfs(int n, int cur, int tsum, int ksum, int l){
        int res = 0;
        if(ksum > l){
            return -1;
        }else if(ksum == l){
            return tsum;
        }

        if(n == cur){
             return tsum;
        }else{
            res = Math.max(dfs(n, cur+1, tsum + trr[cur], ksum + krr[cur], l), dfs(n, cur+1, tsum, ksum,l));
        }
        return res;
    }
    private static String src ="1\n" +
            "5 1000\n" +
            "100 200\n" +
            "300 500\n" +
            "250 300\n" +
            "500 1000\n" +
            "400 400";
}

