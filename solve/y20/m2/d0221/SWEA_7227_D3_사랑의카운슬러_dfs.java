package com.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 짝을 만들어야 해서 지렁이들의짝꿍을 nextpermu에 0~ n을  2로 나눈 수만큼의 갯수까지의 수를
 * 두개씩 넣어서 같은 값을 가진 지렁이들 끼리 팀으로 나누어주려고 했는데
 * 시간이 오버된다.....
 *
 * N개 중에서 2개씩 짝짓는 방법 -> N개에서 2개씩 고르려면 엄청난 중복이 발생하게됨
 * 아주 작은 수부터 짝을 짓는다고 생각하고 풀면된다.
 *
 * dfs를 이용한 방법
 * */
public class SWEA_7227_D3_사랑의카운슬러_dfs {
    public static Jr[] jarr = null;
    public static boolean[] index = new boolean[20];
    public static long result = 0;
    public static int n = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            result = Long.MAX_VALUE;
            jarr = new Jr[n];
            Arrays.fill(index, false);
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                jarr[i] = new Jr(x, y);
            }

            dfs(-1, 0);


            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int pos, int num){
        if(num == n/2){
            long tmp_res = 0;
            long tmpx = 0;
            long tmpy = 0;
            for(int i = 0; i < n ; i++) {
                if (index[i]) {
                    tmpx += jarr[i].x;
                    tmpy += jarr[i].y;
                } else {
                    tmpx -= jarr[i].x;
                    tmpy -= jarr[i].y;
                }
            }
            tmp_res = (tmpx*tmpx) + (tmpy*tmpy);
            if(result > tmp_res){
                result = tmp_res;
            }
            return ;
        }

        for(int i = pos+1; i < n ; i++){
            if(!index[i]){
                index[i] = true;
                dfs(i, num+1);
                index[i] = false;
            }
        }
    }

    private static class Jr{
        long x;
        long y;

        Jr(int x, int y){
            this.x = (long)x;
            this.y = (long)y;
        }

        @Override
        public String toString() {
            return "x=" + x +
                    ", y=" + y+ " ";
        }
    }

    private static String src = "2\n" +
            "4\n" +
            "6 0\n" +
            "3 3\n" +
            "-7 2\n" +
            "-4 -1\n" +
            "2\n" +
            "-100000 100000\n" +
            "100000 -100000";
}
