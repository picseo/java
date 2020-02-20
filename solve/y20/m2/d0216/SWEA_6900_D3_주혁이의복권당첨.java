package com.day0216;

import java.util.Scanner;

public class SWEA_6900_D3_주혁이의복권당첨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            String[] numbers = new String[n];
            int[] money = new int[n];
            for(int i =0; i < n ; i++){
                numbers[i] = sc.next();
                money[i] = sc.nextInt();
            }

            int result = 0;
            for(int i = 0; i < m; i++){
                String tmp = sc.next();
                System.out.println(tmp);

                for(int j = 0; j < n ; j++){
                    boolean add = true;
                    System.out.println(numbers[j] + " , monye : " + money[j]);
                    for(int k = 0; k < 8; k++){
                        if(numbers[j].charAt(k) == '*'){
                            continue;
                        }else{
                            if(numbers[j].charAt(k) == tmp.charAt(k)){
                                continue;
                            }else{
                                add = false;
                                break;
                            }
                        }
                    }
                    if(add){
                        result += money[j];
                        break;
                    }
                }
            }

            System.out.println("#"+t+" "+result);
        }
    }

    private static String src = "1\n" +
            "4 4\n" +
            "*******1 1\n" +
            "******12 10\n" +
            "66*66**3 1000\n" +
            "87654320 1000000\n" +
            "87654320\n" +
            "85288251\n" +
            "48888812\n" +
            "12345678";
}
