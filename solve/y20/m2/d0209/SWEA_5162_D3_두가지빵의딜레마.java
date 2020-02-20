package com.day0209;

import java.util.Scanner;
/**
 * 그냥 많은 갯수를 사고 싶다. - > 싼 걸로 가득 채운다.
 * */
public class SWEA_5162_D3_두가지빵의딜레마 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t<=T; t++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int res = 0;
            if(a < b){
                res = c/a;
            }else{
                res = c/b;
            }
            System.out.println("#"+t+" "+res);
        }
    }

    private static String src = "2\n" +
            "3 5 6\n" +
            "6 8 20";
}
