package com.d0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

/***
 * 규칙을 찾고 싶었는데 못찾겠고
 * N이 최대 10이므로 순열을 해도 10!이니까 가능하다고 생각해서
 * 모든 순열을 찾은 다음에 최대가 되는 수를 찾기로 했다.
 *
 * palin의 길이를 넣어줄때 (j-i+1)로 해야되는데 (i-j+1)로 해서 무한루프가 발생하는 문제가 생겼엇다.
 *
 * 위의 방법으로는 시간초과가 발생한다.
 * 어떻게 하면 시간을 줄일 수 있을까......
 * 팰린드롬 확인을 매번 함수를 부르지 말고 2차원 배열을 이용하기로 했다. 시도해보겠다.
 *
 * dp로 해도 안된다..... 뭐지 규칙을 찾아야 하는 건가.....
 *
 * 설마 같은 문자들을 모아두는게 가장 많은 숫자의 팰린드롬이 나오진 않겠지 했는데
 * 그게 맞는 거였다.
 * 왜인지는 잘 모르겠다.
 *
 * 예제를 생각할때 같은 문자가 3개일 때 까지만 생각했는데
 * 아마 4개까지 생각했으면 알아낼 수 있었을까??
 * 앞으로 규칙찾을때 몇가지 더 생각해봐야겠다.
 */

public class SWEA_4672_D4_수진이의팰린드롬 {
    public static char[] palin = null;
    //public static boolean[][] memo = new boolean[11][11];
    public static int[] alph = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            String input = br.readLine();

            palin = input.toCharArray();
            Arrays.fill(alph, 0);
            //Arrays.sort(palin);

            for(int i = 0; i < palin.length ; i++){
                char now = palin[i];
                alph[now -'a'] ++;
            }

            int result = 0;
            for(int i = 0; i < 26; i++){
                int n = alph[i];
                if(n != 0){
                    int tmp = (n*(n+1))/2;
                    result += tmp;
                }
            }


            /*do{
                //팰린드롬 갯수 세기4
                //System.out.println(Arrays.toString(palin));
                int tmp = 0;
                for(int i = 0; i < palin.length; i++){
                    for(int j = 0; j < palin.length-i; j++){
                        //System.out.println(Arrays.copyOfRange(palin, j, j+i+1));
//                        System.out.println("before : " +tmp);
                        if(palin[j] == palin[j+i]){
                            if(i != 0 && i!=1){
                                if(memo[j+1][j+i-1]){
//                                    System.out.println(Arrays.copyOfRange(palin, j, j+i+1));
//                                    memo[j][j+i] = true;
                                    tmp++;
                                }
                            }else{
//                                System.out.println(Arrays.copyOfRange(palin, j, j+i+1));
                                memo[j][j+i] = true;
                                tmp++;
                            }
                        }
                        //System.out.println("after : " +tmp);
                    }
                }

                if(result < tmp){
                    result = tmp;
                }
            }while(nextP());*/

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    //1.nextp
    /*private static boolean nextP(){
        int i, j;
        for(i = palin.length - 2; i >= 0; i--){
            if(palin[i] < palin[i+1]){
                break;
            }
        }

        if(i < 0){
            return false;
        }

        for(j = palin.length -1 ; j >= 0; j--){
            if(palin[i] < palin[j]){
                break;
            }
        }

        char tmp = palin[i];
        palin[i] = palin[j];
        palin[j] = tmp;

        for(int st = i+1, ed = palin.length-1; st < ed ; st++, ed--){
            tmp = palin[st];
            palin[st] = palin[ed];
            palin[ed] = tmp;
        }

        return true;
    }*/

    //팰린드롬 갯수세기
    /*private static boolean check_palin(int st, int ed, int len){
        if(len == 1){
            return true;
        }else if(len == 2){
            if(palin[st] == palin[ed]){
                return true;
            }else{
                return false;
            }
        }else{
            if(palin[st] == palin[ed]){
                return check_palin(st++, ed--, len-2);
            }else{
                return false;
            }
        }
    }*/

    private static String src = "3\n" +
            "abc\n" +
            "aaa\n" +
            "abcabc";
}
