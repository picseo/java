package com.day0208;

import java.util.Scanner;

public class SWEA_3975_D3_승률비교하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);
        int T = sc.nextInt();
        for(int t = 1; t<= T; t++){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            double d = sc.nextDouble();

            double alice = (a/b)*100;
            double bob = (c/d)*100;

            System.out.print("#"+t+" ");
            if(alice > bob){
                System.out.println("ALICE");
            }else if(alice == bob){
                System.out.println("DRAW");
            }else{
                System.out.println("BOB");
            }
        }
    }
    private static String src = "3\n" +
            "1 2 2 4\n" +
            "4 5 2 5\n" +
            "1 9 5 6";
}
