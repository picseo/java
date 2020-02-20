package com.day0208;

import java.util.Scanner;
/**
 * 시간이 초과되었다.........dp로 풀어봐야지
 * */
public class SWEA_4466_D3_최대성적표만들기_dfs {
    public static int[] scores = new int[101];
    public static int result = 0;
    public static int n = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t<=T; t++) {
            n = sc.nextInt();
            int k = sc.nextInt();
            for (int i = 0; i < n; i++) {
                scores[i] = sc.nextInt();
            }

            result = 0;
            dfs(k, 0, new boolean[n], new int[n]);

            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs(int k, int cur, boolean[] visit, int[] tmp){
        if(k == cur){
            int res = 0;
            for(int num : tmp){
                res += num;
            }
            if(res > result){
                result = res;
            }
            return ;
        }else{
            for(int i = 0; i <n ; i++){
                if(!visit[i]){
                    visit[i] = true;
                    tmp[cur] = scores[i];
                    dfs(k, cur+1, visit, tmp);
                    visit[i] = false;
                }
            }
        }
    }

    private static String src = "2\n" +
            "3 1\n" +
            "100 90 80\n" +
            "3 2\n" +
            "100 90 80";
}
