package com.day0216;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_8673_D3_코딩토너먼트1 {
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1 ; t <= T; t++){
            int k = sc.nextInt();
            int len = (int)Math.pow(2, (double)k);
            result = 0;

            int[] players = new int[len];
            for(int i = 0; i < len; i++){
                players[i] = sc.nextInt();
            }
            start(players);
            System.out.println("#"+t+" "+result);
        }
    }

    private static void start(int[] input){
        int len = input.length;
        if(len == 1)
            return ;

        int[] next = new int[len/2];
        int next_idx = 0;

        for(int i = 0; i < len; i+=2){
            result += Math.abs(input[i] - input[i+1]);
            next[next_idx++] = Math.max(input[i], input[i+1]);
        }

        start(next);
    }

    private static String src = "2\n" +
            "2\n" +
            "7 1 4 3\n" +
            "3\n" +
            "31 46 13 29 27 45 10 57";
}
