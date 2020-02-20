package com.day0208;

import java.util.Scanner;

public class SWEA_3431_D3_준환이의운동관리 {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();

        for(int t =1; t<=T; t++){
            int l = sc.nextInt();
            int u = sc.nextInt();
            int x = sc.nextInt();

            if(x < l){
                System.out.println("#"+t+" "+(l-x));
            }else if(x >=l && x <= u){
                System.out.println("#"+t+" "+0);
            }else{
                System.out.println("#"+t+" "+(-1));
            }
        }
    }

    private static String src = "3\n" +
            "300 400 240\n" +
            "300 400 350\n" +
            "300 400 480";
}
