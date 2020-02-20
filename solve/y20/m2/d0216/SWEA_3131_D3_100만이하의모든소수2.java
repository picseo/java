package com.day0216;

public class SWEA_3131_D3_100만이하의모든소수2 {
    public static int max = 1000000;
    public static boolean[] notprimes = new boolean[max+1];

    public static void main(String[] args) {

        for(int i  = 2; i <= max; i++) {
            if (notprimes[i]) {
                continue;
            }

            System.out.print(i + " ");
            boolean stop = false;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    stop = true;
                    break;
                }
            }

            if(stop){
                continue;
            }

            int tmp = i + i;
            while (tmp <= max) {
                notprimes[tmp] = true;
                tmp += i;
            }
        }
    }
}
