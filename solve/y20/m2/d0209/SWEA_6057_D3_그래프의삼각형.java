package com.day0209;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_6057_D3_그래프의삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer>[] graph = new List[n+1];
            for(int i = 0; i <= n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[x].add(y);
                graph[y].add(x);
            }

            int result = 0;
            for(int i = 1; i <= n ;i++){
                int len = graph[i].size();
                //boolean big = false;
                for(int j = 0; j < len-1; j++){
                    int now = graph[i].get(j);
                    for(int k = j+1; k < len; k++){
                        for(int nk = 0; nk < graph[now].size(); nk++){
                            if(graph[now].get(nk) == graph[i].get(k)){
                                result++;
                            }
                        }
                    }
                }
            }

            result /= 3;
            System.out.println("#"+t+" "+result);
        }
    }
    private static String src = "1\n" +
            "3 3\n" +
            "1 2\n" +
            "2 3\n" +
            "1 3";
}
