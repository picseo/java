package com.day0208;

import java.util.Scanner;

public class SWEA_4406_D3_모음이보이지않는사람 {
    private static String vol = "aeiou";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T ;t++){
            String input = sc.next();

            System.out.print("#"+t+" ");
            for(int i = 0; i < input.length(); i++){
                char now = input.charAt(i);
                if(vol.indexOf(now) >=0){
                    continue;
                }
                System.out.print(now);
            }
            System.out.println();

        }
    }
    private static String src = "3\n" +
            "congratulation\n" +
            "synthetic\n" +
            "fluid";
}
