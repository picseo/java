package com.d0224;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1966_D2_숫자를정렬하자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            int n = sc.nextInt();
            int[] input = new int[n];
            for(int i = 0; i < n ; i++){
                input[i] = sc.nextInt();
            }

            Arrays.sort(input);
            System.out.print("#"+t+" ");
            for(int i = 0; i < n ; i++){
                System.out.print(input[i] + " ");
            }
            System.out.println();
        }
    }
}
