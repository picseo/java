package d0910;

import java.util.Arrays;

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


		System.out.println("Repermutation");//중복순열
		Repermutation(new int[arr.length], 0);

		System.out.println("Combintation");
		Combination(new int[arr.length-1], 0, 0);

		System.out.println("Recombination");
		Recombination(new int[arr.length-1], 0, 0);
	}

	private static void Recombination(int[] tmp, int idx, int tidx) {
		if(tidx == tmp.length) {
			System.out.println(Arrays.toString(tmp));
			return;
		}
	
		for(int i = idx; i < arr.length; i++) {
			tmp[tidx] = arr[i];
			Combination(tmp, i, tidx+1);
		}
	}

	private static void Combination(int[] tmp, int idx, int tidx) {
		if(tidx == tmp.length) {
			System.out.println(Arrays.toString(tmp));
			return;
		}
		
		if(idx == arr.length) {
			return;
		}
		tmp[tidx] = arr[idx];
		Combination(tmp, idx+1, tidx+1);
		Combination(tmp, idx+1, tidx);
	}

	private static void Repermutation(int[] tmp, int idx) {
		if(idx == arr.length) {
			System.out.println(Arrays.toString(tmp));
			return;
		}
		
		for(int i =0 ; i < arr.length; i++) {
			tmp[idx] = arr[i];
			Repermutation(tmp, idx+1);
		}
	}

	private static boolean NPermutation() {
		int i, j;
		for(i = arr.length-2; i>=0; i--) {
			if(arr[i] < arr[i+1]) {
				break;
			}
		}
		
		if(i < 0) {
			return false;
		}
		
		for(j = arr.length-1; j>=0; j--) {
			if(arr[i] < arr[j]) {
				break;
			}
		}
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
		for(int st= i+1, ed = arr.length-1; st < ed; st++, ed--) {
			tmp = arr[st];
			arr[st] = arr[ed];
			arr[ed] = tmp;
		}
		return true;
	}

	private static void Permutation(int[] tmp, int idx) {
		if(idx == arr.length) {
			System.out.println(Arrays.toString(tmp));
			return;
		}
		
		for(int i =0 ; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmp[idx] = arr[i];
				Permutation(tmp, idx+1);
				visited[i] = false;
			}
		}
	}

	private static void Subset_bit() {
		int n = arr.length;
		for(int j = 0; j < (1 << n); j++) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				if( (j & (1 << i) ) > 0) {
					sb.append(arr[i]+" ");
				}
			}
			System.out.println(sb.toString());
		}
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

		tmp[idx] = true;
		Subset(tmp, idx+1);
		tmp[idx] = false;
		Subset(tmp, idx+1);
	}




}
