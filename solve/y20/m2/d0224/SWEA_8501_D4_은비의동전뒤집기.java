package com.d0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
/*
* N이 엄청 커서 순열을 모두 구할 수 없다는 것을 알았다
* 이런 문제는 규칙을 찾는 수 밖에 없나보다
* 이문제는 N-1의 결과들에 N을 추가하게 되면
* N이 짝수번째 위치에 들어가게 되면 (N-1)째에 뒤집힌 개수와 같게 생기게 된다.(왜냐하면 짝수번 뒤집혀서 결국엔 뒷면이 되므로)
* N이 홀수번째 위치에 들어가게 되면 (N-1)!개수 + (N-1)째에 뒤집힌 개수가 된다.(홀수번이므로 (N-1)!개에서 모두 1개씩 뒷면이 추가))
*
* 그리고는 수가 너무 커져서 1000000007로 나누라는 조건이 있었는데
* 이러한 조건이 있으면 무조건 long을 사용해야겠다.
* */
public class SWEA_8501_D4_은비의동전뒤집기 {
    public static long[] memo = new long[1001];
    public static long dv = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long num = 1;
        for(int i = 2; i <= 1000; i++){
            long tmp = 0;
            for(int j = 0; j < i; j++){
                if(j%2 == 0){
                   tmp += memo[i-1]%dv;
                }else{
                   tmp += (memo[i-1]+num)%dv;
                }
                tmp %= dv;
            }
            memo[i] = tmp%dv;
            num *= (long)i;
            num %= dv;
            System.out.println("i  : " + i +", memo[i] : " + memo[i]);
        }

        for(int t = 1; t <= T ;t ++){
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(t).append(" ").append(memo[n]).append("\n");
        }
        System.out.println(sb);
    }

    private static String src = "6\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "4\n" +
            "5\n" +
            "1000";
}
