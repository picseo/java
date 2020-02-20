package com.day0208;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_4466_D3_최대성적표만들기 {

    private static Object Integer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t<=T; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Integer[] scores = new Integer[n];
            for (int i = 0; i < n; i++) {
                scores[i] = sc.nextInt();
            }

            int result = 0;
            Arrays.sort(scores, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

            for(int i = 0; i < k; i++){
                result += scores[i];
            }

            System.out.println("#" + t + " " + result);
        }
    }

    private static String src = "2\n" +
            "3 1\n" +
            "100 90 80\n" +
            "3 2\n" +
            "100 90 80";
}
