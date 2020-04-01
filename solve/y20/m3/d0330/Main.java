package d0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
//부분 집합? 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = null;
		int answer = 0;
		
		tokens = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokens.nextToken()); //물품의 총 개수
		int K = Integer.parseInt(tokens.nextToken()); //가능한 최대 무게
		
		Stuff[] stuffs = new Stuff[N];
		int[] idxArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			idxArr[i] = i;
			
			tokens = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			stuffs[i] = new Stuff(w, v);
		} //input end
		
		//make subset
		//i: 부분집합 
		
		for(int i = 0; i < (1<<N); i++) {
			int weightSum = 0;
			int valueSum = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1<<j)) != 0) {
					weightSum += stuffs[j].w;
					valueSum += stuffs[j].v;
					
					if(weightSum > K)
						break;
				}
			}
			//하나의 부분집합이 생성됨
			if(weightSum <= K)
				answer = Math.max(answer, valueSum);
		}
		
		System.out.println(answer);
	}
	
	static class Stuff {
		int w;
		int v;
		
		public Stuff(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
}


