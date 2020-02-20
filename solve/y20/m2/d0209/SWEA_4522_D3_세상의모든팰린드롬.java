package com.day0209;

import java.util.Scanner;
/**
 * ?는 와일드 카드니까 팰린드롬을 구할때 예외처리를 해주어야 한다.
 */

public class SWEA_4522_D3_세상의모든팰린드롬 {
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
            }else if(str.charAt(0) == '?' || str.charAt(1) == '?'){
                return true;
            }else{
                return false;
            }
        }else{
            if(str.charAt(0) == str.charAt(len-1)){
                return findPal(str.substring(1, len-1));
            }else if(str.charAt(0) == '?' || str.charAt(len-1) == '?'){
                return findPal(str.substring(1, len-1));
            }else{
                return false;
            }
        }
    }
    private static String src = "2\n" +
            "hi\n" +
            "a??a";
}
