package com.day0208;

import java.util.Scanner;
/**
 * 5000*5000 반복문은 2초 내로 가능한가보다
 * 처음에 헷갈렸는데
 * 결국 입력이 오름차순으로 주어지므로
 * 앞에서 부터 읽으면서 주기를 계산하고
 * 입력된 최대값 전까지 해당 주기가 가질 수 있는 값을 계산하면서
 * 입력된 값들중 해당 주기에 들어가는 값이 있다면 -1을 해서 해당 값에 도달했을 때
 * res를 증가시켜 주지 않으므로서 항구에 들르는 배의 수를 최소로 만들 수 있었다.
 * */
public class SWEA_4371_D3_항구에들어오는배 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1 ; t <= T; t++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            //boolean[] check = new boolean[n];

            int res = 0;
            for(int i = 0; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            int max = arr[n-1];
            //boolean[] check = new boolean[arr[n-1]+1];

            for(int i = 1; i<n; i++){
                if(arr[i] > 0){
                    //System.out.println("arr[i] : " + arr[i]);
                    res++;
                    int now = arr[i];
                    int gab = now - 1;
                    while(now <= max){
                        //System.out.println("now : " + now);
                        for(int j = i; j < n; j++){
                            if(arr[j] == now){
                               // System.out.println("before j  : " + arr[j]);
                                arr[j] = -1;
                                //System.out.println("after j  : " + arr[j]);
                            }
                        }
                        now += gab;
                    }
                }
            }

            System.out.println("#"+t+" "+res);
        }//testcase

    }

    private static String src = "3\n" +
            "3\n" +
            "1\n" +
            "3\n" +
            "4\n" +
            "5\n" +
            "1\n" +
            "7\n" +
            "10\n" +
            "13\n" +
            "19\n" +
            "3\n" +
            "1\n" +
            "500000000\n" +
            "999999999";
}
