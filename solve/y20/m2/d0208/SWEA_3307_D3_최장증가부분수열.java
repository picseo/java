package com.day0208;

import java.util.Arrays;
import java.util.Scanner;
/**
 * dp로 푸는 문제라서 쉽게 푼다고 좋아했는데
 * 이전에 푼 dp가 닶이 dim배열의 가장 마지막 값에 있어서
 * 당연히 이것도 그렇다고 생각하고 dim[n-1]을 답으로 출력했는데
 * 이 문제에서는 dim배열의 값중 최대값을 알아야 하므로
 * 따로 max값을 구해서 출력해주어야 했다.
 * 그걸 몰라서 3번이나 틀렸다.(반성반성)
 * */
public class SWEA_3307_D3_최장증가부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] dim = new int[n];

            int max = Integer.MIN_VALUE;
            Arrays.fill(dim, 1);
            for(int i = 0; i < n ; i++) {
                arr[i] = sc.nextInt();
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] <= arr[i]) {
                        dim[i] = Math.max(dim[i], dim[j] + 1);
                    }
                }
                if (max < dim[i])
                    max = dim[i];
            }

            System.out.println("#"+t+" "+max);
        }
    }

    private static String src = "3\n" +
            " 5\n" +
            " 1 3 2 5 4 \n" +
            " 5\n" +
            " 1 6 2 3 4 \n" +
            " 6\n" +
            " 4 2 3 1 5 6\t";
}
