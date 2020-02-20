package com.day0209;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * dfs 문제 였는데
 * 중복 가능 조함을 만드는 문제 였는데 dfs를 부를때 start값을 i값을 넘겨야 하는데
 * start값을 넘겨서 틀리고 있었다.
 * **/
public class SWEA_5986_D3_새샘이와세소수 {
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc =new Scanner(src);

        int T = sc.nextInt();
        find_prime();
        for(int t = 1; t <= T; t++){
            int n = sc.nextInt();

            int start = -1;
            int end = primes.size()-1;

            for(int i = 0; i <primes.size(); i++){
                if(primes.get(i) > n){
                    end = i;
                    break;
                }else{
                    if(start == -1){
                        start = i;
                    }
                }
            }
            System.out.println("start : " + start + ", end :"+end);
            int result  = dfs(3, 0, n, 0, start, end, new int[3]);
            System.out.println("#"+t+" "+result);

        }
    }

    private static int dfs(int n, int cur, int goal ,int sum, int start, int end, int[] arr){
        int res = 0;
        if(sum > goal){
            return 0;
        }

        if(n == cur){
            if(sum == goal){
                for(int tt : arr)
                    System.out.print(tt+" ");
                System.out.println();
                return 1;
            }else{
                return 0;
            }
        }else{
            for(int i = start; i < end; i++){
                arr[cur] = primes.get(i);
                res += dfs(n, cur+1, goal, sum+primes.get(i), i, end, arr);
            }
        }
        return res;
    }
    private static void find_prime(){
        boolean[] check = new boolean[1000];
        check[0] = true;
        check[1] = true;
        boolean dv = false;
        for(int i =2 ; i < 1000; i++){
            if(check[i])
                continue;
            for(int j = 2; j*j <= i; j++){
                if(i % j == 0){
                    dv = true;
                    break;
                }
            }

            if(!dv){
                primes.add(i);
                int now = i + i;
                while(now < 1000){
                    check[now] = true;
                    now += i;
                }
            }
        }
    }
    private static String src = "3\n" +
            "7\n" +
            "11\n" +
            "25";
}
