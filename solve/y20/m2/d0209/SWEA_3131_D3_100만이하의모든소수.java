package com.day0209;

public class SWEA_3131_D3_100만이하의모든소수 {
    public static void main(String[] args) {
        int max = 1000000;
        boolean[] check = new boolean[1000001];
        check[0] = true;
        check[1] = true;

        for(int i = 0;i <= 1000000; i++){
            if(check[i]){
                continue;
            }

            int num = 0;
            for(int j = 2; j*j<i; j++){
                if(i % j == 0){
                    num++;
                }
            }

            if(num == 0){//소수
                System.out.print(i+" ");
                int del = i+i;
                while(del <= 1000000){
                    check[del] = true;
                    del += i;
                }
            }
        }

    }
}
