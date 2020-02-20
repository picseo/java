package com.day0208;

import java.util.Scanner;
/*
*처음에 저장해야 되는 정보가 너무 많다고 생각해서 고민을 했는데
* 경우의 수를 생각해보니 N이 최대 1000이므로
* 1자리는 1000가지, 2자리는 999가지, 3자리는 998가지, 4자리는 997가지 최대 경우였다.
* 각 자리수의 경우의수는 1자리는 10(0~9), 2자리는 90(10~99), 3자리는 900(100~999), 4자리는 9000(1000~9999)
* 결국 답은 4자리 안에서 나온다고 생각했고, boolean 10000크기의 배열을 사용하여 존재여부를 저장했다.
*
* */
public class SWEA_3809_D3_화섭이의정수나열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc =new Scanner(src);

        int T = sc.nextInt();
        for(int t= 1; t <= T; t++){
            System.out.print("#"+t+" ");
            int n = sc.nextInt();
            int[] nums = new int[n];
            boolean[] check = new boolean[10000];//0~9999

            for(int i = 0; i < n ; i++){
                nums[i] = sc.nextInt();
            }

            for(int i = 0; i <= n-4; i++){
                int num = nums[i];
                check[num] = true;
                num *= 10;
                num += nums[i+1];
                check[num] = true;
                num *= 10;
                num += nums[i+2];
                check[num] = true;
                num *= 10;
                num += nums[i+3];
                check[num] = true;
            }

            //n-3
            int ii = n-3;
            if(ii >= 0) {
                int num = nums[ii];
                check[num] = true;
                num *= 10;
                num += nums[ii + 1];
                check[num] = true;
                num *= 10;
                num += nums[ii + 2];
                check[num] = true;
            }
            //n-2
            ii = n-2;
            if(ii >= 0) {
                int num = nums[ii];
                check[num] = true;
                num *= 10;
                num += nums[ii + 1];
                check[num] = true;
            }
            //n-1
            ii = n-1;
            int num = nums[ii];
            check[num] = true;


            for(int i =0; i < 10000; i++){
                if(!check[i]){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    private static String src = "6\n" +
            "3\n" +
            "3 0 1\n" +
            "11\n" +
            "9 8 7 6 5 4 3 2 1 1 0\n" +
            "10\n" +
            "9 0 8 7 6 5 4 3 2 1\n" +
            "100\n" +
            "3 6 7 5 3 5 6 2 9 1 2 7 0 9 3 6 0 6 2 6\n" +
            "1 8 7 9 2 0 2 3 7 5 9 2 2 8 9 7 3 6 1 2\n" +
            "9 3 1 9 4 7 8 4 5 0 3 6 1 0 6 3 2 0 6 1\n" +
            "5 5 4 7 6 5 6 9 3 7 4 5 2 5 4 7 4 4 3 0\n" +
            "7 8 6 8 8 4 3 1 4 9 2 0 6 8 9 2 6 6 4 9\n" +
            "100\n" +
            "7 2 7 5 4 7 4 4 5 8 1 5 7 7 0 5 6 2 0 4\n" +
            "3 4 1 1 0 6 1 6 6 2 1 7 9 2 4 6 9 3 6 2\n" +
            "8 0 5 9 7 6 3 1 4 9 1 9 1 2 6 4 2 9 7 8\n" +
            "3 9 5 5 2 3 3 8 4 0 6 8 2 5 5 0 6 7 1 8\n" +
            "5 1 4 8 1 3 7 3 3 5 3 0 6 0 6 5 3 2 2 2\n" +
            "1\n" +
            "3";
}
