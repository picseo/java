package com.d0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
*처음에 어떻게 stack을 써서잘리는 파이프를 세어야 할지 고민을 했는데
* 결국에는 파이프의 전체 수에 레이저를 만날때 stack에 쌓여있는 파이프의 수만큼 늘어나는걸
* 더해가면 된다.*
* */
public class SWEA_5432_D4_쇠막대기자르기 {
    public static Stack<Character> st = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            char[] input = br.readLine().toCharArray();

            List<Character> list = new ArrayList<>();
            st = new Stack<>();
            int tmp = 0;
            for(int i = 0; i < input.length; i++){
                int now = input[i];

                if(now == '('){
                    if(input[i+1] == ')'){
                        list.add('L');
                        i++;
                        tmp += st.size();
                    } else if (input[i+1] == '('){
                        list.add('(');
                        st.push('(');
                        tmp += 1;
                    }
                }else if(now == ')') {
                    list.add(')');
                    st.pop();
                }
            }

            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }

    private static String src = "2\n" +
            "()(((()())(())()))(())\n" +
            "(((()(()()))(())()))(()())";
}
