package com.day0209;

import java.util.*;
/**
 * dfs를 만들때 지금 만드는게 순열인지 조합인지 제대로 생각하고 해야겠다.
 * 조합을 만들고 싶어서 dfs사용햇더니 처음에 순열로 만들어져서
 * 인덱스 오류가 났엇다.
 * 조합은 visit배열을 사용하지 않고, start 변수를 이용해서 탐색할 범위를 줄여주고
 * 순열은 visit배열을 이용해서 모든 수들을 여러번째에 오게 만들어준다.
 * **/
public class SWEA_5948_D3_새샘이의735게임 {
    private static Integer[] nums = new Integer[35];
    private static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t= 1; t <= T; t++){
            int result = 0;
            idx = 0;
            Arrays.fill(nums, 0);

            int[] input = new int[7];

            for(int i = 0; i < 7; i++){
                input[i] = sc.nextInt();
            }

            dfs(3, 0, 0, new int[3], input);
            //System.out.println(Arrays.toString(nums));

            Arrays.sort(nums);
            //System.out.println(Arrays.toString(nums));
            int cnt = 1;
            int pre = nums[idx-1];
            idx -= 2;
            while(idx >= 0){
                if(pre != nums[idx]){
                    cnt++;
                    pre = nums[idx];
                    if(cnt == 5){
                        result = pre;
                        break;
                    }
                }
                idx--;
            }

            System.out.println("#"+t+" "+result);
        }
    }

    private static void dfs(int n, int cur, int start, int[] tmp, int[] input){
        if(n == cur){
            int tmp_res = 0;
            for(int now :  tmp){
                tmp_res += now;
                //System.out.println("now : " + now);
            }
            //idx++;
            //System.out.println("idx : "+ idx);
            nums[idx++] = tmp_res;

            //System.out.println(tmp_res);
            return;
        }else{
            for(int i = start; i < input.length; i++){
                tmp[cur] = input[i];
                dfs(n, cur+1, i+1 , tmp, input);
            }
        }
    }

    private static String src = "2\n" +
            "1 2 3 4 5 6 7\n" +
            "5 24 99 76 1 77 6";
}
