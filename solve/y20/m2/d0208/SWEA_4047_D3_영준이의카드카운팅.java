package com.day0208;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4047_D3_영준이의카드카운팅 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        char[] cards = {'S', 'D', 'H', 'C'};
        int[] res = new int[4];
        boolean[][] check = new boolean[4][13];

        for(int t = 1; t<= T; t++){
            System.out.print("#"+t+" ");
            String input = sc.next();
            Arrays.fill(res, 13);
            for(boolean[] checks : check)
                Arrays.fill(checks, false);
            boolean repeat = false;

            for(int i = 0; i < input.length(); i += 3){
                char card = input.charAt(i);
                int card_num = 0;
                for(int j = 0; j < 4; j++){
                    if(card == cards[j]){
                        card_num = j;
                        break;
                    }
                }

                int num = input.charAt(i+1) -'0';
                num *= 10;
                num += input.charAt(i+2)-'0';

                if(check[card_num][num-1]){
                    repeat = true;
                    break;
                }else{
                    check[card_num][num-1] = true;
                    res[card_num]--;
                }
            }

            if(repeat){
                System.out.print("ERROR\n");
            }else{
                for(int i = 0; i < 4; i++){
                    System.out.print(res[i] + " ");
                }
                System.out.println();
            }
        }
    }
    private static String src = "3\n" +
            "S01D02H03H04\n" +
            "H02H10S11H02\n" +
            "S10D10H10C01 ";
}
