package com.day0216;

import java.util.*;

public class SWEA_5948_D3_새샘이의735게임2 {
    private static int[] num = new int[7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        int[] input = new int[7];
        for (int t = 1; t <= T; t++) {
            for (int i = 0; i < 7; i++) {
                input[i] = sc.nextInt();
            }

            int result = 0;
            List<Integer> list = new ArrayList();

            num[0] = 1;
            num[1] = 1;
            num[2] = 1;

            Arrays.sort(num);
            do {
                result = 0;
                for (int i = 0; i < 7; i++) {
                    if(num[i] == 1){
                        result += input[i];
                    }
                }
                if(!list.contains(result))
                    list.add(result);
            } while (nextpermutation());

            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

            result = list.get(4);
            System.out.println("#"+t+" "+result);
        }
    }


    private static boolean nextpermutation() {
        int i;
        for (i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                break;
            }
        }

        if (i < 0) {
            return false;
        }

        int j;
        for (j = num.length-1; j >= 0; j--) {
            if (num[j] > num[i]) {
                break;
            }
        }

        int tmp = num[j];
        num[j] = num[i];
        num[i] = tmp;

        for (int st = i + 1, ed = num.length - 1; st < ed; st++, ed--) {
            tmp = num[st];
            num[st] = num[ed];
            num[ed] = tmp;
        }
        return true;
    }

    private static String src = "2\n" +
            "1 2 3 4 5 6 7\n" +
            "5 24 99 76 1 77 6";
}
