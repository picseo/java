package com.d0223;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * bfs를 이용해서 마지막으로 연락받는 번호 중 가장 큰 것을 출력
 * 각 노드는 자신이 몇번째(depth)에 연락을 받았는지 알아야 한다.
 * 그리고 global변수로 현재 최대 번호는 depth가 무엇인지 알아야 한다.
 *
 * 단일 방향 그래프이므로 list로 만들때 입력되는 순서에 맞게 그래프를 만들어야 한다.
 *
 *
 * 헤맸던 부분 : res_dep깊이가 깊어지거나 같을때 res_dep랑 result를 update해 주었는데
 * 이때 res_dep가 update될때 result값이 tmp보다 작으면 update하려했는데
 * 이렇게 되니 낮은 res_dep에서 엄청 큰 값이 result에 들어갔을때 값이 변경되지 않고 유지 되엇다.
 *
 * */
public class SWEA_1238_D4_Contact {
    public static List<Integer>[] Graph = null;
    public static int result = 0;
    public static int res_dep = 0;
    public static int[] visited = null;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res\\1238.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        for(int t =1 ; t <= 10; t++){
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Graph = new List[101];
            visited = new int[101];
            result = 0;
            res_dep = 0;

            for(int i = 0 ; i < 101 ; i++){
                Graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < len; i+=2){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                //이부분은 중복되는 입력을 확인하고 이미 있으면 받지 않으려고 만든 코드이다.없어도 상관은 없는데 시간을 줄이려면 있어야 할 것 같다.
//                boolean repeat = false;
//                for(int j = 0; j < Graph[from].size(); j++) {
//                    if(Graph[from].get(j) == to){
//                        repeat = true;
//                        break;
//                    }
//                }
//                if(!repeat) {
                    Graph[from].add(to);
                //}
            }

            bfs(start, 1);//시작 번호, 깊이
//            System.out.println("res_depth : " + res_dep);
            /*System.out.println(Arrays.toString(visited));
            for(int i = 1; i < 101; i++){
                if(res_dep == visited[i]){
                    result = i;
                }
            }*/
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int start, int depth){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = depth;
        queue.add(start);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(res_dep < visited[tmp]){
                res_dep = visited[tmp];
                result = tmp;
            }else if(res_dep == visited[tmp]){
                if(result < tmp)
                    result = tmp;
            }
            for(int i = 0; i < Graph[tmp].size(); i++){
                int now = Graph[tmp].get(i);
                if(visited[now] == 0){
                    visited[now] = visited[tmp] + 1;
                    queue.add(now);
                }
            }
        }
    }


}
