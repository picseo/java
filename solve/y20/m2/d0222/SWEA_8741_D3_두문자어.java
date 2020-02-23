package com.d0222;

import java.util.Scanner;

public class SWEA_8741_D3_두문자어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t =1 ;t <= T; t++){
            System.out.print("#" + t + " ");

            for(int i = 0; i < 3; i++){
                String input = sc.next();
                System.out.print(input.toUpperCase().charAt(0));
            }
            System.out.println();
        }
    }

    private static String src = "3\n" +
            "knuth morris pratt\n" +
            "recurrent neural network\n" +
            "advanced encryption standard";
}
