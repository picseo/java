package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 재관이의대량할인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
}
