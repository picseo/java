package com.d0225;

import java.io.IOException;
import java.util.*;

/**
 * n번의 키를 안다는 것은 n보다 작은 번호들의 화살표를 타고 올라가면 n을 지나고
 * n의 화살표를 타고 나가면 n보다 큰 번호들을 모두 지난다고 생각했다.
 *
 * 그래서 bfs를 돌면서
 * start에서 갈 수 있는 수들을 표시하는 cnt_f와
 * start가 지나가는 큰수들에 표시를 해주는 cnt_b를 저장했다
 *
 * 처음에는 예시로 준 그래프를 보면서 cnt_f를 graph[n].size()로 할 수 있을 줄 알앗는데
 * 만약 그 위로 번호가 더 있게 되면 답이 나오지 않게 되어 오답이 나왓다.
 *
 * cnt_f는 현재 start보다 큰 수들의 갯수
 * cnt_b는 현재 start보다 작은 수들의 갯수(자기자신도 포함한다.)
 *
 * 키를 알려면 모든 번호들의 정보를 알아야 하므로 cnt_f + cnt_b = n이 되어야 한다.
 * */
public class SWEA_5643_D4_키순서 {
    public static List<Integer>[] graph = null;
    public static int[] cnt_b = null;
    public static int[] cnt_f = null;
    public static int n = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            n = sc.nextInt();
            int m = sc.nextInt();

            graph = new List[n+1];
            for(int i = 0; i < n+1 ; i++){
                graph[i] = new ArrayList<>();
            }
            cnt_b = new int[n+1];
            cnt_f = new int[n+1];

            for(int i = 0; i < m; i++){
                int from = sc.nextInt();
                int to = sc.nextInt();

                graph[from].add(to);
            }

            for(int i = 1; i <= n; i++){
                bfs(i);
                System.out.println(Arrays.toString(cnt_b));
                System.out.println(Arrays.toString(cnt_f));
            }

            int result = 0;
            for(int i = 1; i <= n; i++){
                if((cnt_b[i] + cnt_f[i]) == n){
                    result++;
                }
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int start){
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            cnt_b[now]++;
            for(int i = 0; i < graph[now].size(); i++){
                int next = graph[now].get(i);
                if(!visited[next]){
                    cnt_f[start]++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    private static String src = "1      \n" +
            "7     \n" +
            "7      \n" +
            "1 5    \n" +
            "3 4\n" +
            "5 4\n" +
            "4 2\n" +
            "4 6\n" +
            "6 7\n" +
            "5 2";
}
