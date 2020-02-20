package com.day0216;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_8658_D3_Summation {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            int n = 10;
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                int tmp = sc.nextInt();

                nums[i] = find(tmp);
            }

            Arrays.sort(nums);
            System.out.println("#"+t+" "+nums[nums.length - 1] + " "+nums[0]);
        }

    }
    private static int find(int tmp){
        int dv = 10000000;
        int result = 0;

        while (dv > 0) {
            result += (tmp/dv);
            tmp %= dv;
            dv /= 10;
        }

        return result;
    }
    private static String src = "2\n" +
            "182 371 29 49 28 21 928 11 5 1\n" +
            "13 400 3010 2011 1111 40 4 103 301 100111";
}
