package com.d0223;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_8556_D3_북북서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc = new Scanner(src);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            String input = sc.next();

            List<Character> list = new ArrayList<>();
            for(int i = 0; i < input.length(); ){
                char now  = input.charAt(i);
                if(now == 'n'){
                    list.add('n');
                    i += 5;
                }else if(now == 'w'){
                    list.add('w');
                    i+=4;
                }
            }

            int son = 0;
            int mother = 1;

            if(list.get(list.size()-1) == 'n'){
                son = 0;
            }else{
                son = 90;
            }
            for(int i = list.size()-2; i >= 0; i--){
                char now = list.get(i);
                son *= 2;
                mother *= 2;
                if(now == 'n'){
                    son -= 90;
                }else if(now == 'w'){
                    son += 90;
                }
            }


            //System.out.println(list);
            while((son%2 == 0) && (mother%2 == 0)){
                son /=2;
                mother/=2;
            }

            if(mother == 1)
                System.out.println("#"+t+" " + son);
            else
                System.out.println("#"+t+" " + son + "/" + mother);
        }
    }

    private static String src = "6\n" +
            "north\n" +
            "west\n" +
            "northwest\n" +
            "northnorthwest\n" +
            "westwestwestnorth\n" +
            "westnorthnorthwest";
}
