package d0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.acmicpc.net/source/3805809
public class BJ_1089_엘리베이터 {
	static int N;
	static double total;
	static String[][] num = {{"###","#.#","#.#", "#.#", "###"},//0 
			{"..#","..#","..#", "..#", "..#"},//1
			{"###","..#","###", "#..", "###"},//2
			{"###","..#","###", "..#", "###"},//3
			{"#.#","#.#","###", "..#", "..#"},//4
			{"###","#..","###", "..#", "###"},//5
			{"###","#..","###", "#.#", "###"},//6
			{"###","..#","..#", "..#", "..#"},//7
			{"###","#.#","###", "#.#", "###"},//8
			{"###","#.#","###", "..#", "###"}//9
	};
	
	static char[][] input;
	static int[] ables, count;
	
	public static void main(String[] args) throws IOException{
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N = sc.nextInt();
		N = Integer.parseInt(br.readLine());
		input = new char[5][(4*N)-1];
		
		for(int i = 0; i < 5; i++) {
			//input[i] = sc.next().toCharArray();
			input[i] = br.readLine().toCharArray();
		}
		
//		for(int i =0; i < 5; i++) {
//			System.out.println(input[i]);
//		}
		
		//각 칸의 가능한 숫자들을 찾는다.
		ables = new int[N];
		count = new int[N];
		double total_count = 1;
		for(int i =0, idx = 0; i < 4*N-1; i += 4, idx++) {
			find(i, idx);
			total_count *= count[idx];
		}
		
		//System.out.println(total_count);
		
//		for(int i = 0; i < N; i++) {
//			System.out.println("ables["+i+"] : " + ables[i]);
//		}
		
		total = 0;		
		//calcul(0, N, 0);
		
		double jari = 1;
		for(int i = N-1; i >=0; i--) {
			int tmp = (int)(total_count/count[i]);
			for(int j = 0; j < 10; j++) {
				if((ables[i] & (1<<j)) > 0) {
					total += (j*tmp)*jari;
				}
			}
			jari *= 10;
		}
		
		if(total_count == 0) {
			System.out.println(-1);
		}else {
			System.out.printf("%.5f", (total/total_count));
		}
	}

//	private static void calcul(int cur, int n, int tmp) {
//		if(cur == n) {
//			//System.out.println(tmp);
//			total += tmp;
//			return;
//		}
//		
//		for(int i =0; i < 10; i++) {
//			if((ables[cur] & (1<<i)) > 0) {
//				calcul(cur+1, n, tmp*10 + i);
//			}
//		}
//	}

	static void find(int start, int idx) {
		
		for(int i = 0; i < 10; i++) {
			boolean ok = true;
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < 3; k++) {
					char numnum = num[i][j].charAt(k);
					char inputnum = input[j][start+k];
					
					if(inputnum != numnum && numnum == '.') {
						ok =false;
						break;
					}
				}
				if(!ok) {
					break;
				}
			}
			
			if(ok) {
				count[idx]++;
				ables[idx] = ables[idx] | (1<<i);
			}
		}
		
	}
}
