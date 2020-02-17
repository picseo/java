package swea.d0211;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 입력받은 카드들을 색깔별로 나눈 다음에
 * 각 카드의 수가 3으로 나누어 떨어지는 수라면 다음단계로 넘어간다. 3으로 나누어떨어지지 않으면 false
 * 각 카드의 배열을 nextpermutation을 이용해서 모든 순열을 찾으면서 그 중 한번이라도 
 * 조건에 맞게 된다면  true값을 준다.
 * */
public class SWEA_6781_D3_삼삼트리플게임 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T= sc.nextInt();
		for(int t= 1; t<= T; t++) {
			boolean result = false;
			char[] chars = sc.next().toCharArray();
			char[] colors = sc.next().toCharArray();
			
			int rnum = 0, gnum = 0, bnum = 0;
			for(int i = 0; i < colors.length ; i++) {
				if(colors[i] == 'R') {
					rnum++;
				}else if(colors[i] == 'G') {
					gnum++;
				}else if(colors[i] == 'B') {
					bnum++;
				}
			}
			
			int[] Rcards = new int[rnum];
			int ridx = 0;
			int[] Gcards = new int[gnum];
			int gidx =0 ;
			int[] Bcards = new int[bnum];
			int bidx = 0;
			
			for(int i = 0; i < colors.length ; i++) {
				if(colors[i] == 'R') {
					Rcards[ridx++] = chars[i]-'0';
				}else if(colors[i] == 'G') {
					Gcards[gidx++] = chars[i]-'0';
				}else if(colors[i] == 'B') {
					Bcards[bidx++] = chars[i]-'0';
				}
			}
			
			//red check
			if(ridx%3 == 0 && gidx % 3 == 0 && bidx % 3 == 0) {
				if(ridx != 0) {
					Arrays.sort(Rcards);
					do{
						boolean r_check = true;
						for(int i = 0; i < ridx; i+=3) {
							if(Rcards[i] == Rcards[i+1] && Rcards[i+1] == Rcards[i+2]) {
							}else if(Rcards[i+1] - Rcards[i] == 1 && Rcards[i+2] - Rcards[i+1] == 1){
							}else {
								r_check = false;
							}
						}
						if(r_check) {
							result = r_check;
							break;
						}
					}while(next_permutation(Rcards));
				}
				//green check
				if(gidx != 0) {
					Arrays.sort(Gcards);
					do{
						boolean g_check = true;
						for(int i = 0; i < gidx; i+=3) {
							if(Gcards[i] == Gcards[i+1] && Gcards[i+1] == Gcards[i+2]) {
							}else if(Gcards[i+1] - Gcards[i] == 1 && Gcards[i+2] - Gcards[i+1] == 1){
							}else {
								g_check = false;
							}
						}
						if(g_check) {
							result = g_check;
							break;
						}
					}while(next_permutation(Gcards));
				}
				//blue check
				if(bidx != 0) {
					Arrays.sort(Bcards);
					do{
						boolean b_check = true;
						for(int i = 0; i < bidx; i+=3) {
							if(Bcards[i] == Bcards[i+1] && Bcards[i+1] == Bcards[i+2]) {
							}else if(Bcards[i+1] - Bcards[i] == 1 && Bcards[i+2] - Bcards[i+1] == 1){
							}else {
								b_check = false;
							}
						}
						if(b_check) {
							result = b_check;
							break;
						}
					}while(next_permutation(Bcards));
				}
			}
			if(result)
				System.out.println("#"+t+"Win");
			else {
				System.out.println("#"+t+"Continue");
			}
		}

	}
	
	private static boolean next_permutation(int[] input) {
		int i;
		//작아지는 부분을 찾는다
		int len = input.length;
		for(i = len-1 -1; i >= 0; i--) {
			if(input[i] < input[i+1]) {
				break;
			}
		}
		
		if(i < 0)
			return false;
		
		int j;
		for(j = len-1; j >= 0; j--) {
			if(input[j] > input[i]) {
				break;
			}
		}
		
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
		
		for(int st = i+1, end = len-1; st < end;st++, end--) {
			tmp = input[st];
			input[st] = input[end];
			input[end] = tmp;
		}
		
		return true;
	}
	private static String src = "\r\n" + 
			"5\r\n" + 
			"123123345\r\n" + 
			"RRRRRRRRR\r\n" + 
			"222333456\r\n" + 
			"RRRRRRRRR\r\n" + 
			"123444555\r\n" + 
			"RRBRRRRRR\r\n" + 
			"111345666\r\n" + 
			"RRBGGGRRR\r\n" + 
			"222333111\r\n" + 
			"RGBRGBRGB";
}
