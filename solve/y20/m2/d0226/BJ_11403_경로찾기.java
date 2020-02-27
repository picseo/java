package com.d0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

/*
* 연결정보를 뭍는 문제여서 bfs를 이용하였다.
* 다른 문제들이랑 달랐던건 bfs실행할때마다 visited를 초기화하는 점이 였다.
* */

public class BJ_11403_경로찾기 {
    public static int[][] result = null;
    public static int[][] input = null;
    public static int n = 0;
    public static List<Integer>[] graph = null;
    public static boolean[] visited = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        input = new int[n][n];
        result = new int[n][n];
        graph = new List[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n ; j++){
                int now = Integer.parseInt(st.nextToken());
                if(now == 1){
                    graph[i].add(j);
                }
            }
        }


        for(int i = 0; i < n ; i++){
            visited = new boolean[n];
            if(!visited[i]){
                bfs(i);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < graph[now].size(); i++){
                int next = graph[now].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    result[start][next] = 1;
                    queue.add(next);
                }else{
                    if(next == start){
                        result[start][start] = 1;
                    }
                }
            }
        }
    }

    private static String src = "3\n" +
            "0 1 0\n" +
            "0 0 1\n" +
            "1 0 0\n";
}
