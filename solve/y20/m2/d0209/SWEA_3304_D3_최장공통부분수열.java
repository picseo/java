package com.day0209;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 처음에는 배열의 위, 왼쪽만 생각해서 값이 같은 경우에는 위의값에 1을 더하는 값으로 update했는데
 * 다시 생각해보니 왼쪽은 second의 문장을 기준으로 하는 값이고,
 * 아래쪽은 first의 문장을 기준으로 하는 값이라서
 * 그렇게 할 경우 답이 나오지 않았다.
 * 그래서 생각하다보니
 * 값이 같은 경우에는 -1, -1, 인 위치의 값에 1을 더하는게 맞는 방식이었다.
 * 결국 이 문제는 서로가 서로의 기준으로 생각하고 풀어야했다.
 * */
public class SWEA_3304_D3_최장공통부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            String first = sc.next();
            String second = sc.next();
            int f_len = first.length();
            int s_len = second.length();

            int[][] count = new int[f_len+1][s_len+1];

            for(int i = 1; i <= f_len; i++){
                for(int j = 1; j <= s_len; j++){
                    if(first.charAt(i-1) == second.charAt(j-1)){
                        count[i][j] = Integer.max(Integer.max(count[i-1][j-1]+1, count[i][j-1]), count[i-1][j]);
                    }else{
                        count[i][j] = Integer.max(count[i-1][j], count[i][j-1]);
                    }
                }
            }

            for(int[] cnt : count){
                System.out.println(Arrays.toString(cnt));
            }
            System.out.println("#"+t+" "+count[f_len][s_len]);
        }
    }
    private static String src = "3\n" +
            " acaysdfdk asdfaasdf\n" +
            " acaykp capcak \n" +
            " bbbbbb aaaaaa\n";
}
