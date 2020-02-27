package com.d0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

//정보들을 입력받아 graph를 만들고 bfs를 돌린 횟수만큼 result를 증가시켜주었다.
public class SWEA_7465_D4_창용마을무리의개수_bfs {
    public static boolean[] visited = null;
    public static List<Integer>[] graph = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            System.out.println("#"+t);
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[n+1];
            graph = new List[n+1];
            for(int i = 0; i <= n ; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
                graph[to].add(from);
            }

            for(int i = 0; i < n ; i++){
                System.out.println("graph["+i+"] : "+graph[i]);
            }
            int result = 0;
            for(int i = 1; i <= n ; i++){
                if(!visited[i]){
                    result++;
                    bfs(i);
                    System.out.println(Arrays.toString(visited));
                }
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.println("now : "+ now);
            for(int i = 0; i < graph[now].size(); i++){
                int next = graph[now].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
            System.out.println(queue);
        }
    }
    private static String src = "2\n" +
            "6 5\n" +
            "1 2\n" +
            "2 5\n" +
            "5 1\n" +
            "3 4\n" +
            "4 6\n" +
            "6 8\n" +
            "1 2\n" +
            "2 5\n" +
            "5 1\n" +
            "3 4\n" +
            "4 6\n" +
            "5 4\n" +
            "2 4\n" +
            "2 3";
}
