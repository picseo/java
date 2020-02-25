package com.d0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/**
 * 입력되는 수들을 정렬한 다음에 큰수부터 3개씩 묶인다고 생각해서
 * 3의 배수에 있는 수는 값을 더해주지 않았다.
 *
 * 그리고 옷의 값이 비싸고, N이 꽤 커져서
 * 꼭 결과는 long에 저장해야한다.
 *
 * */
public class SWEA_4050_D4_재관이의대량할인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            Integer[] input = new Integer[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n ; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            //System.out.println(Arrays.toString(input));
            long result = 0;
            for(int i = 0; i < n; i++){
                if((i+1) % 3 != 0){
                    result += (long)input[i];
                }
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static String src = "2\n" +
            "4\n" +
            "3 2 3 2\n" +
            "6\n" +
            "6 4 5 5 5 5";
}
