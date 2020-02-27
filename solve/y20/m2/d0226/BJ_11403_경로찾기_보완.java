package com.d0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

/*
* list말고 배열에 저장하는게 빠를 줄 알았는데
* 의외로 list를 사용할때랑 별로 다르지 않았다.
* */
public class BJ_11403_경로찾기_보완 {
    public static int[][] result = null;
    public static int[][] input = null;
    public static int n = 0;
    public static boolean[] visited = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        input = new int[n][n];
        result = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n ; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n ; i++){
                bfs(i);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int start){
        visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < n; i++) {
                if (input[now][i] == 1) {
                    result[start][i] = 1;
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
    }

    private static String src = "7\n" +
            "0 0 0 1 0 0 0\n" +
            "0 0 0 0 0 0 1\n" +
            "0 0 0 0 0 0 0\n" +
            "0 0 0 0 1 1 0\n" +
            "1 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 1\n" +
            "0 0 1 0 0 0 0";
}
