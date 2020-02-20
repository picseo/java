package com.day0209;

import java.util.Scanner;

public class SWEA_5789_D3_현주의상자바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] boxes = new int[n];

            for(int i = 1; i <= q; i++){
                int l = sc.nextInt();
                int r = sc.nextInt();
                for(int j = l-1; j < r; j++){
                    boxes[j] = i;
                }
            }

            System.out.print("#"+t+" ");
            for(int box : boxes){
                System.out.print(box + " ");
            }
            System.out.println();
        }
    }

    private static String src = "1\n" +
            "5 2\n" +
            "1 3\n" +
            "2 4";
}
