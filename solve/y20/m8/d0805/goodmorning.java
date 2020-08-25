package d0805;

import java.lang.reflect.Array;
import java.util.*;

public class goodmorning {
	static int[] arr = {1, 2, 3};
	static boolean[] visited = new boolean[arr.length];
	
	public static void main(String[] args) {
		/*System.out.println("Subset");//부분 집합
		Subset(new boolean[arr.length], 0);
		
		System.out.println("부분집합(bitmask이용)");
		Subset_bit();*/
		
		/*System.out.println("Permutation");//순열
		Permutation(new int[arr.length], 0);
		
		System.out.println("NP");
		do {
			System.out.println(Arrays.toString(arr));
		}while(NPermutation());
		
		arr = new int[] {1, 2, 3};
		*/
		
		/*System.out.println("Repermutation");//중복순열
		Repermutation(new int[arr.length], 0);*/
		
		System.out.println("Combintation");
		Combination(new int[arr.length-1], 0, 0);
		
		System.out.println("Recombination");
		Recombination(new int[arr.length-1], 0, 0);
	}

	private static void Recombination(int[] tmp, int idx, int r) {
		if(r == tmp.length) {
			System.out.println(Arrays.toString(tmp));
			return;
		}
		
		if(idx == arr.length)
			return;
		
		tmp[r] = arr[idx];
		Recombination(tmp, idx, r+1);
		Recombination(tmp, idx+1, r);
		
	}

	private static void Combination(int[] tmp, int idx, int r) {
		if(r == tmp.length) {
			System.out.println(Arrays.toString(tmp));
			return;
		}
		
		if(idx == arr.length)
			return;
		
		tmp[r] = arr[idx];
		Combination(tmp, idx+1, r+1);
		Combination(tmp, idx+1, r);
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

	private static void Subset_bit() {
		int bitcheck =0;
		int n = arr.length;
		for(int i = 0; i < (1 << n); i++) {
			for(int j = 0; j < n; j++) {
				if((i & ( 1<<j)) > 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
		
	}

	private static boolean NPermutation() {
		int i, j;
		for(i = arr.length - 2; i >= 0; i--) {
			if(arr[i+1] > arr[i]) {
				break;
			}
		}
		
		if(i < 0) {
			return false;
		}
		
		for(j = arr.length - 1 ; j >= 0; j--) {
			if(arr[i] < arr[j]) {
				break;
			}
		}
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
		//st가 i+1부터인걸 까먹었다 ㅇㅅㅇ 헿
		for(int st = i+1, ed = arr.length-1; st < ed; st++, ed--) {
			tmp = arr[st];
			arr[st] = arr[ed];
			arr[ed] = tmp;
		}		
		return true;
	}

	private static void Permutation(int[] check, int idx) {
		if(idx == arr.length) {
			System.out.println(Arrays.toString(check));
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				check[idx] = arr[i];
				visited[i] = true;
				Permutation(check, idx+1);
				visited[i] = false;
			}
		}		
	}

	private static void Subset(boolean[] check, int num) {
		if(num == arr.length) {
			for(int i = 0; i < arr.length; i++) {
				if(check[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		check[num] = false;
		Subset(check, num+1);
		check[num] = true;
		Subset(check, num+1);
	}
	
	
}
