package com.day0216;

import java.util.*;

public class SWEA_9280_D3_진용이네주차타워 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1 ; t <= T; t++){
            int result = 0;

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] parking = new int[n];
            for(int i = 0; i < n ; i++){
                parking[i] = sc.nextInt();
            }

            int[] cars = new int[m+1];
            for(int i = 1; i <= m ; i++){
                cars[i] = sc.nextInt();
            }

            Queue<Integer> queue = new LinkedList<Integer>();
            int[] occupy = new int[n];
            for(int i = 0; i < m+m; i++){
                int input = sc.nextInt();
                int carnum = Math.abs(input);

                if(input < 0){
                    //parkinglot
                    int where = -1;
                    for(int j = 0; j < n; j++){
                        if(occupy[j] == carnum){
                            where = j;
                            break;
                        }
                    }
                    //차가 나감
                    result += parking[where] * cars[carnum];
                    if(!queue.isEmpty())
                        occupy[where] = queue.poll();
                    else
                        occupy[where] = 0;
                }else if(input > 0){
                    //parkinglot -> 빈공간 찾기
                    int where = -1;
                    for(int j = 0; j < n; j++){
                        if(occupy[j] == 0){
                            where = j;
                            break;
                        }
                    }
                    //차가 들어옴
                    if(where == -1) {
                        queue.add(carnum);//줄세있음
                    }else{
                        occupy[where] = carnum;
                    }
                }
            }
            System.out.println("#"+t+" "+result);
        }
    }

    private static String src = "2\n" +
            "3 4\n" +
            "2\n" +
            "3\n" +
            "5\n" +
            "2\n" +
            "1\n" +
            "3\n" +
            "8\n" +
            "3\n" +
            "2\n" +
            "-3\n" +
            "1\n" +
            "4\n" +
            "-4\n" +
            "-2\n" +
            "-1\n" +
            "2 4\n" +
            "5\n" +
            "2\n" +
            "100\n" +
            "500\n" +
            "1000\n" +
            "2000\n" +
            "3\n" +
            "1\n" +
            "2\n" +
            "4\n" +
            "-1\n" +
            "-3\n" +
            "-2\n" +
            "-4";
}
