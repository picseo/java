package com.day0209;

import java.util.Scanner;

public class SWEA_4751_D3_다솔이의다이아몬드장식 {
    private static String[][] save = {{"..#..", ".#.."}, {".#.#.", "#.#."}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            String input = sc.next();
            int n = input.length();

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < n; j++){
                    if(i == 0 || i ==4){
                        if(j == 0){
                            System.out.print(save[0][0]);
                        }else{
                            System.out.print(save[0][1]);
                        }
                    }else if(i == 1 || i ==3){
                        if(j == 0){
                            System.out.print(save[1][0]);
                        }else{
                            System.out.print(save[1][1]);
                        }
                    }else{
                        if(j == 0){
                            System.out.print("#."+input.charAt(j)+".#");
                        }else{
                            System.out.print("."+input.charAt(j)+".#");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
    private static String src = "2\n" +
            "D\n" +
            "APPLE";
}
