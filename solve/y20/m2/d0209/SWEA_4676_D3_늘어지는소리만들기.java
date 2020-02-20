package com.day0209;

import java.util.Scanner;

public class SWEA_4676_D3_늘어지는소리만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            String input = sc.next();
            int h_how = sc.nextInt();
            int[] nums = new int[input.length()+1];
            for(int i = 0; i < h_how; i++){
                nums[sc.nextInt()]++;
            }

            System.out.print("#"+t+" ");
            for(int i = 0; i < input.length()+1; i++){
                while((nums[i]--) != 0){
                    System.out.print("-");
                }

                if(i < input.length())
                    System.out.print(input.charAt(i));
            }
            System.out.println();
        }
    }

    private static String src = "2\n" +
            "wow\n" +
            "3\n" +
            "2 3 2\n" +
            "hoi\n" +
            "3\n" +
            "0 0 0";
}
