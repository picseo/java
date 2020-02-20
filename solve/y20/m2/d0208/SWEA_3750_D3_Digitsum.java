package com.day0208;
/***
 * long값으로 받고 싶은 경우 nextLong()을 써야 한다.
 * */
import java.util.Scanner;

public class SWEA_3750_D3_Digitsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t =1; t <= T; t++){
            long n = sc.nextLong();

            long result = recur(n);
            System.out.println("#"+t+" "+result);
        }
    }

    public static long recur(long n){
        if(n/10 == 0){
            return n;
        }else{
            long tmp = n;
            long result = 0;
            while(tmp/10 != 0){
                result += tmp%10;
                tmp /= 10;
            }
            result += tmp%10;
            return recur(result);
        }
    }
    private static String src = "3\n" +
            "1000000000000000000\n" +
            "108\n" +
            "588432";
}
