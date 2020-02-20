package com.day0208;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_3499_D3_퍼펙트셔플 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T ;t++){
            Queue<String> first = new LinkedList<>();
            Queue<String> second = new LinkedList<>();
            Queue<String> result = new LinkedList<>();

            int n = sc.nextInt();
            int half = n/2;
            if(n%2 == 1){
                half += 1;
            }
            for(int i = 0; i < half; i++){
                first.add(sc.next());
            }
            for(int i = half; i < n; i++){
                second.add(sc.next());
            }

            while(!second.isEmpty()){
                result.add(first.poll());
                result.add(second.poll());
            }
            if(!first.isEmpty()){
                result.add(first.poll());
            }

            System.out.print("#"+t+" ");
            while(!result.isEmpty()){
                System.out.print(result.poll()+" ");
            }
            System.out.println();
        }
    }
    private static String src = "3\n" +
            "6\n" +
            "A B C D E F\n" +
            "4\n" +
            "JACK QUEEN KING ACE\n" +
            "5\n" +
            "ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";
}
