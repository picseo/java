package com.day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA_8840_D3_아바바바 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T ; t++){
            long l = Long.parseLong(br.readLine());
            long result = 0;

            result = (l-2);
            if(result == 1)
                result = 1;
            else
                result = (result-result/2)*(result-result/2);
            System.out.println("#"+t+" "+result);
        }
    }
}
