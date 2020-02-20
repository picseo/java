package com.day0209;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_4698_D3_테네스의특별한소수 {
    public static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        makePrimes();

        for(int t= 1; t<= T; t++){
            int d = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = 0;

            for(int i = 0; i < primes.size(); i++){
                int now = primes.get(i);
                if(a <= now && now <= b){
                    int dv = 1000000;
                    while(dv > 0){
                        if(now / dv == d) {
                            res++;
                            break;
                        }
                        now %= dv;
                        dv /= 10;
                    }
                }else if(now > b){
                    break;
                }
            }

            System.out.println("#"+t+" "+res);
        }
    }
    private static void makePrimes(){
        boolean[] check = new boolean[1000001];
        check[0] = true;
        check[1] = true;

        for(int i = 2; i <= 1000000; i++) {
            if (check[i]) continue;
            boolean primeox = false;

            for (int j = 2; j * j < i; j++) {
                if (i % j == 0) {
                    primeox = true;
                    break;
                }
            }

            if (!primeox) {
                primes.add(i);
                int del = i+i;
                while(del <= 1000000){
                    check[del] = true;
                    del += i;
                }
            }
        }
    }
    private static String src = "2\n" +
            "3 10 30\n" +
            "7 1 1000000";
}
