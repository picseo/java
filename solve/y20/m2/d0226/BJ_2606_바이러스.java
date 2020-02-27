package com.d0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

/*
* 1번 컴퓨터와의 연결된 컴퓨터의 수를 원하는 문제였다.
* 연결정보는 bfs!
*
* */
public class BJ_2606_바이러스 {
    private static List<Integer>[] graph = null;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new List[n];
        for(int i = 0; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            graph[from].add(to);
            graph[to].add(from);
        }

        bfs(0, n);
        System.out.println(result);
    }

    private static void bfs(int start, int n){
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < graph[now].size(); i++){
                int next = graph[now].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    result++;
                    queue.add(next);
                }
            }
        }
    }

    private static String src = "7\n" +
            "6\n" +
            "1 2\n" +
            "2 3\n" +
            "1 5\n" +
            "5 2\n" +
            "5 6\n" +
            "4 7";
}
