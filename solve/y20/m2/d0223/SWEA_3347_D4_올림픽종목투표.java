package com.d0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * A를 다입력받은 다음에
 * B를 입력받을 때만다 arr를 0부터 읽어나가다가 B보다 이하의 값을 가진 A를 찾으면
 * 그 위치의 result를 증가시켜주고, 만약 answer위치의 result값보다 커진다면
 * answer의 값을 j로 update해주는 간단한 문제였다.
 * **/
public class SWEA_3347_D4_올림픽종목투표 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //int[] brr = new int[m];
            int[] result = new int[n];
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m ; i++){
                //brr[i] = Integer.parseInt(st.nextToken());
                int now = Integer.parseInt(st.nextToken());
                for(int j = 0; j < n; j++){
                    if(arr[j] <= now){
                        result[j]++;
                        if(result[answer] < result[j]){
                            answer = j;
                        }
                        break;
                    }
                }
            }

            answer += 1;
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static String src = "2\n" +
            "4 3\n" +
            "5 3 1 4\n" +
            "4 3 2\n" +
            "6 6\n" +
            "3 1 4 1 5 9\n" +
            "2 6 5 3 5 9";
}
