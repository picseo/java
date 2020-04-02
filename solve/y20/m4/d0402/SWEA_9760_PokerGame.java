package d0402;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_9760_PokerGame {
	static String[] name = {"Straight Flush", "Four of a Kind", "Full House", "Flush", "Straight", 
	"Three of a kind", "Two pair", "One pair", "High card"};
	//S, D, H, C : 0, 1, 2, 3
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int result = 8;//"High card"
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			char[] mn = new char[5];//무늬
			int[] num = new int[5];
			result = 8;
			
			boolean same = true;
			for(int i = 0; i < 5; i++) {
				String input = sc.next();
				mn[i] = input.charAt(0);
				if(i!= 0) {
					if(mn[i] != mn[i-1]) {
						same = false;
					}
				}				
				
				char next = input.charAt(1);
				if(next == 'K') {
					num[i] = 13;
				}else if(next == 'Q') {
					num[i] = 12;
				}else if(next == 'J') {
					num[i] = 11;
				}else if(next == 'A') {
					num[i] = 1;
				}else if(next == 'T'){
					num[i] = 10;
				}else{
					num[i] = next-'0';
				}
			}
//			
//			System.out.println(mn);
//			System.out.println(Arrays.toString(num));
			
			if(same) {//모두 같은 그림이라면
				boolean seq = true;
				Arrays.sort(num);
				
				for(int i = 1; i < 5; i++) {
					if(num[i-1] == 1 && num[i] == 10) {
						continue;
					}else if(num[i-1]+1 != num[i]) {
						seq = false;
					}
				}
				
				if(seq) {
					result = 0;//"Straight Flush"
				}else {
					result = 3;//"Flush"
				}
			}else {//여러 그림이 섞여 있다면
				
				int[] check_num = new int[14];
				int max = -1;
				for(int i = 0; i < 5; i++) {
					check_num[num[i]]++;
					if(max < check_num[num[i]]) {
						max = check_num[num[i]];
					}
				}
								
				int[] count = new int[5];
				for(int i = 1; i < 14; i++) {
					int cc = check_num[i];
					count[cc]++;
				}
				
				if(max == 4) {
					result = 1;//"Four of a Kind"
				}else if(max == 3) {
					if(count[2] == 1) {
						result = 2;//"Full House"
					}else if(count[1] == 2){
						result = 5;//"Three of a kind"
					}
				}else if(max == 2) {
					if(count[2] == 2) {
						result = 6;//"Two pair"
					}else if(count[2] == 1) {
						result = 7;//"One pair"
					}
				}else if(max == 1) {
					
					boolean seq = true;
					Arrays.sort(num);
					
					for(int i = 1; i < 5; i++) {
						if(num[i-1] == 1 && num[i] == 10) {
							continue;
						}else if(num[i-1]+1 != num[i]) {
							seq = false;
						}
					}
					
					if(seq) {
						result = 4;//"Straight"
					}
					
				}
				
			}
			
			sb.append(name[result]).append("\n");
		}
		System.out.println(sb);
	}
	
/* 	
 * static String[] name = {"Straight Flush", "Four of a Kind", "Full House", "Flush", "Straight", 
	"Three of a kind", "Two pair", "One pair", "High card"};
 * */
	
}
