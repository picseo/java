package algo_basic.day6.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6808_D3_규영이와인영이의카드게임_teacher {
	private static int[] iyCards, kyCards;
	private static int iyWin, kyWin;
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			//테스트 케이스 마다 멤버 변수들 초기화하기
			iyWin = 0;
			kyWin = 0;
			
			kyCards = new int[9];
			iyCards = new int[9];

			//모든 카드 번호를 저장할 배열
			int [] allCards = new int[18+1];
			for(int i = 1; i < allCards.length; i++) {
				allCards[i] = i;//0~18까지 설정
			}
			
			for(int i = 0; i < 9 ; i++) {
				kyCards[i] = sc.nextInt();
				allCards[kyCards[i]] = 0;
			}
			
			for(int i = 0, j =0 ; i < allCards.length; i++) {
				if(allCards[i]>0) {
					iyCards[j++] = allCards[i];
				}
			}
			
			//중간 점검!! 카드 추출 확인
			//System.out.println(Arrays.toString(kyCards) + " : " + Arrays.toString(iyCards));
			
			//nextpermutation은 정렬한 상태붙터 시작해야한다.
			//인영이 카드를 이용해서 순열을 만들고 크기 비교하자.
			//nextpermutation은 꼭 do_while을 이용하자
			Arrays.sort(iyCards);
			do{
				int ii = 0;
				int gg = 0;
				for(int i = 0; i < 9; i++) {
					int iCard = iyCards[i];
					int kCard = kyCards[i];
					if(kCard < iCard) {
						ii += kCard + iCard;
					}else {
						gg += kCard + iCard;
					}					
				}
				
				if(ii > gg) {
					iyWin++;
				}else if(ii < gg){
					kyWin++;
				}
			}while(nextPermutation());
			
			sb.append(kyWin).append(" ").append(iyWin).append('\n');
		}
		System.out.println(sb);
	}
	
	private static boolean nextPermutation() {
		int i;
		for(i = iyCards.length-1 -1 ; i >= 0; i--) {
			if(iyCards[i] < iyCards[i+1]) {//i가 결정되는 순간.
				break;
			}
		}
		
		if(i<0) {
			return false;
		}
		
		int j;
		for(j = iyCards.length - 1; j >= 0; j--) {
			if(iyCards[j] > iyCards[i]) {
				break;
			}
		}
		
		
		int tmp = iyCards[j];
		iyCards[j] = iyCards[i];
		iyCards[i] = tmp;
		
		for(int k = i+1, l = iyCards.length - 1; k < l ; k++, l--) {
			tmp = iyCards[k];
			iyCards[k] = iyCards[l];
			iyCards[l] = tmp; 
		}
		
		return true;
	}
	
	
	private static String src = "\r\n" + 
			"4\r\n" + 
			"1 3 5 7 9 11 13 15 17\r\n" + 
			"18 16 14 12 10 8 6 4 2\r\n" + 
			"13 17 9 5 18 7 11 1 15\r\n" + 
			"1 6 7 9 12 13 15 17 18";

}
