package com.day0209;

import java.util.Scanner;

/**
 * *는 여러장으로 늘어날 수 있는 와일드 카드니까 *의 밖이 팰린드롬이면 무조건 팰린드롬이 된다.
 */

public class SWEA_4579_D3_세상의모든팰린드롬2 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            String input = sc.next();

            boolean res = findPal(input);
            System.out.print("#"+t+" ");
            if(res){
                System.out.println("Exist");
            }else{
                System.out.println("Not exist");
            }
        }
    }

    private static boolean findPal(String str){
        int len = str.length();
        if(len == 1){
            return true;
        }else if(len == 2){
            if(str.charAt(0) == str.charAt(1)){
                return true;
            }else if(str.charAt(0) == '*' || str.charAt(1) == '*'){
                return true;
            }else{
                return false;
            }
        }else{
            if(str.charAt(0) == '*' || str.charAt(len-1) == '*'){
                return true;
            }else if(str.charAt(0) == str.charAt(len-1)){
                return findPal(str.substring(1, len-1));
            } else{
                return false;
            }
        }
    }
    private static String src = "2\n" +
            "hi*h*i\n" +
            "adssdfjahkdf*";
}
