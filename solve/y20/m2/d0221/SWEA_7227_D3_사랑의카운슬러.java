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
 * -> 0~n-1개의 짝들을 만들 필요가 없고 1, 0으로 2개의 큰 팀으로 만든다음에
 * 0에서 1을 빼는 식으로 하면 되나보다
 *
 * N개 중에서 2개씩 짝짓는 방법 -> N개에서 2개씩 고르려면 엄청난 중복이 발생하게됨
 * 아주 작은 수부터 짝을 짓는다고 생각하고 풀면된다.
 * */
public class SWEA_7227_D3_사랑의카운슬러 {
    public static Jr[] jarr = new Jr[20];
    public static int[] index = new int[20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int idx = -1;
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(i == n/2) {
                    idx++;
                }
                index[i] = idx;
                jarr[i] = new Jr(x, y);
            }

            idx++; // 짝들의 갯수

            long result = Long.MAX_VALUE;
            boolean[] tmpxy = new boolean[idx];
            do{
                long tmp_res = 0;
                /*for(int i = 0; i < n ; i++){
                    System.out.print(index[i] + " ");
                }
                System.out.println();*/

                long tmpx = 0;
                long tmpy = 0;
                boolean next = false;
                for(int i = 0; i < n ; i++) {
                    if(!tmpxy[index[i]]){
                        tmpx += (long)jarr[i].x;
                        tmpy += (long)jarr[i].y;
                        tmpxy[index[i]] = true;
                    }else{
                        tmpx -= (long)jarr[i].x;
                        tmpy -= (long)jarr[i].y;
                    }

                    tmp_res = (tmpx*tmpx) + (tmpy*tmpy);
                    if(result <= tmp_res){
                        next = true;
                    }
                }
                if(next){
                    continue;
                }
                tmp_res = (tmpx*tmpx) + (tmpy*tmpy);
                //System.out.println("tmp_res : "+tmp_res);
                if(result > tmp_res)
                    result = tmp_res;

            }while(nextP(n));
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean nextP(int n){
        int i, j;
        for(i = n-2; i >=0 ; i--){
            if(index[i] < index[i+1]){
                break;
            }
        }

        if(i < 0){
            return false;
        }

        for(j = n-1; j >= 0; j--){
            if(index[j] > index[i]){
                break;
            }
        }

        int tmp = index[i];
        index[i] = index[j];
        index[j] = tmp;

        for(int st = i+1, ed = n-1; st < ed; st++, ed--){
            tmp = index[st];
            index[st] = index[ed];
            index[ed] = tmp;
        }

        return true;
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
