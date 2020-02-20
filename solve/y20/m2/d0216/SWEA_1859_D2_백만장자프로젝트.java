package com.day0216;

import java.util.Scanner;

public class SWEA_1859_D2_백만장자프로젝트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t =  1; t <= T; t++){
            int n = sc.nextInt();
            long[] value = new long[n];

            for(int i = 0; i < n; i++){
                value[i] = sc.nextLong();
            }

            long result = 0;
            long max = value[n-1];

            for(int i = n-2; i >= 0; i--){
                if(max >= value[i]){
                    result += (max -value[i]);
                }else{
                    max = value[i];
                }
            }

            System.out.println("#"+t+" "+result);
        }
    }

    private static String src = "3\n" +
            " 3\n" +
            " 10 7 6\n" +
            " 3\n" +
            " 3 5 9\n" +
            " 5\n" +
            " 1 1 3 1 2\t";
}
