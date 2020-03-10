package d0303;

import java.util.Scanner;

/*
 * N : 우리 갯수 1~6
 * x : 하나의 우리에 있을 수 있는 마릿수
 * m : 경근이가 체크한 횟수, 햄스터를 배치해서 이  M번의 체크를 다 통과하는지 봐야함
 * 
 * 우리 갯수 최대 6, 우리 마릿수 0~10 -> 11^6(최악의 경우의수 ) -> 완탐 가능
 * 
 * 주의사항 >
 * (1) M번을 다 만족하는 배치가 여러개인 경우 합계 많은 거
 * (2) 합계가 다 같은 경우 -> 오름차순
 * (3) 만족하는 배치가 없다면 ? -1 출력
 * 
 * 각 경우를 끝까지 가봐야 하므로 -> 재귀를 사용하면 어떨까
 * **/
public class SWEA_8275_D4_햄스터_강의 {
	static int[] cage;//가능한 모든 햄스터 배치를 해봄(중복순열)
	static int N, X, M;
	static int[][] input;
	static int max;//햄스터 배치 여러가지 종류 가능하다면? 합이 최대가 되는 경우를 선택
	static String ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt();
		for(int t= 1; t<= T; t++) {
			max = -1;
			ans = "";
			N = sc.nextInt(); //총 우리 갯수
			X = sc.nextInt(); //각 우리 가능 마릿수
			M = sc.nextInt(); //체크 횟수
			
			cage = new int[N+1];
			input = new int[M][3]; // left, right, sum
			
			for(int i = 0; i < M; i++) {
				input[i][0] = sc.nextInt();
				input[i][1] = sc.nextInt();
				input[i][2] = sc.nextInt();
			}
			
			perm(1,0);
			
			System.out.println("#"+t+" "+((max== -1)? max : ans));
		}
	}

	static void perm(int idx, int sum) {//idx는 햄스터 케이지 번호
		if(idx == cage.length) { //경근이의 체크와 부합하느지 체크
			if(check()) {
				if(max < sum) {//같은 값인경우 사전순으로 뒤에 있는 값은 무시
					max = sum;
					ans = makeAns();
				}
			}
		}else {
			for(int i = 0; i <= X; i++) {
				cage[idx] = i;
				perm(idx+1, sum+i);
			}	
		}
	}
	
	static String makeAns() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(cage[i]).append(" ");
		}
		return sb.toString();
	}
	
	static boolean check() {
		for(int i = 0 ; i < M; i++) {//M번의 체크
			int tmp = 0;
			for(int j = input[i][0]; j <= input[i][1]; j++) {
				tmp += cage[j];
			}
			if(input[i][2] != tmp) {//갯수 다름
				return false;
			}
		}
		return true;
	}
	
	private static String src = "3\r\n" + 
			"3 5 1\r\n" + 
			"1 2 5\r\n" + 
			"3 5 2\r\n" + 
			"1 2 6\r\n" + 
			"2 3 7\r\n" + 
			"4 5 2\r\n" + 
			"1 3 15\r\n" + 
			"3 4 4";
	
}
