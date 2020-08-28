package d0828;

import java.lang.reflect.Array;
import java.util.*;

public class goodmorning {
	static int[] arr = {1, 2, 3};
	static boolean[] visited = new boolean[arr.length];
	
	public static void main(String[] args) {
		System.out.println("Subset");//부분 집합
		Subset(new boolean[arr.length], 0);
		
		System.out.println("부분집합(bitmask이용)");
		Subset_bit();
		
		System.out.println("Permutation");//순열
		Permutation(new int[arr.length], 0);
		
		System.out.println("NP");
		do {
			System.out.println(Arrays.toString(arr));
		}while(NPermutation());
		
		arr = new int[] {1, 2, 3};
		
		visited = new boolean[arr.length];
		System.out.println("Repermutation");//중복순열
		Repermutation(new int[arr.length], 0);
		
		System.out.println("Combintation");
		Combination(new int[arr.length-1], 0, 0);
		
		System.out.println("Recombination");
		Recombination(new int[arr.length-1], 0, 0);
	}

	private static void Recombination(int[] ans, int idx, int adx) {
		if(adx != ans.length && idx == arr.length) {
			return;
		}
		
		if(adx == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			ans[adx] = arr[i];
			Recombination(ans, i, adx+1);
		}
	}

	private static void Combination(int[] ans, int idx, int adx) {
		if(adx != ans.length && idx == arr.length) {
			return;
		}
		
		if(adx == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			ans[adx] = arr[i];
			Combination(ans, i+1, adx+1);
		}
	}

	private static void Repermutation(int[] tmp, int idx) {
		if(idx == arr.length) {
			System.out.println(Arrays.toString(tmp));
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			tmp[idx] = arr[i];
			Repermutation(tmp, idx+1);			
		}
	}

	private static boolean NPermutation() {
		int i, j;
		for(i = arr.length-2; i >= 0; i--) {
			if(arr[i] < arr[i+1]) {
				break;
			}
		}
		
		if(i < 0) {
			return false;
		}
		
		for(j = arr.length-1; j >= 0; j--) {
			if(arr[i] < arr[j]) {
				break;
			}
		}
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
		for(int st = i+1, ed = arr.length-1; st < ed; st++, ed--) {
			tmp = arr[st];
			arr[st] = arr[ed];
			arr[ed] = tmp;
		}
		return true;
	}

	private static void Permutation(int[] ans, int idx) {
		if(idx == arr.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		
		for(int i =0; i < arr.length; i++) {
			if(!visited[i]) {
				ans[idx] = arr[i];
				visited[i] = true;
				Permutation(ans, idx+1);
				visited[i] = false;
			}
		}
	}

	private static void Subset_bit() {
		int length = arr.length;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < (1<<length); i++) {
			for(int j = 0; j < length; j++) {
				if((i &(1<<j)) > 0) {
					sb.append(arr[j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void Subset(boolean[] tmp, int idx) {
		if(idx == tmp.length) {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < tmp.length; i++) {
				if(tmp[i]) {
					sb.append(arr[i]+" ");
				}
			}
			
			System.out.println(sb.toString());
			return ;
		}
			
		//선택
		tmp[idx] = true;
		Subset(tmp, idx+1);
		tmp[idx] = false;
		
		//고르지 않음
		Subset(tmp, idx+1);	
	}
	
	

	
	
}
