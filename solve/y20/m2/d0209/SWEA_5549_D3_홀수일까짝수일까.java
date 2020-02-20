package com.day0209;

import java.util.Scanner;
/**
 * 입력으로 주는 숫자가 기본형으로 받을 수 없는 수이고
 * 짝수, 홀수를 판단하려면 마지막 숫자만 알면 되므로
 * String으로 받은 다음 마지막 수만 고려하였다.
 * */
public class SWEA_5549_D3_홀수일까짝수일까 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            String input = sc.next();
            int len = input.length();

            int last = input.charAt(len-1)-'0';
            if(last % 2 == 0){
                System.out.println("#"+t+" "+"Even");
            }else{
                System.out.println("#"+t+" "+"Odd");
            }
        }
    }
    private static String src = "5\n" +
            "1\n" +
            "10\n" +
            "100\n" +
            "185787124368712386825387273871\n" +
            "82518881239123819238912929292";
}
