package swea.D3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_1983_D2_조교의성적매기기 {
	private static String[] ABC = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res\\1983.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt()-1;
			Double[] score = new Double[n];
			double k_res = 0;
			int gab = n/10;
			
			for(int i = 0; i < n ; i++) {
				int mid = sc.nextInt();
				int fin = sc.nextInt();
				int work = sc.nextInt();
				
				double res = mid*35 + fin*45 + work*20;
				res /= 100;
				
				if(k == i)
					k_res = res;
				score[i] = res;
			}			
			System.out.println("k_res : " + k_res);
			Arrays.sort(score, new Comparator<Double>() {

				@Override
				public int compare(Double o1, Double o2) {
					return o2.compareTo(o1);
				}
				
			});
			
			System.out.println(Arrays.toString(score));
			for(int i = 0; i < n; i++) {
				if(k_res == score[i]) {
					System.out.println("now :"+i +", index : "+(i/gab));
					System.out.println("#"+t+" "+ABC[i/gab]);
					break;
				}
			}
		}
	}

}
