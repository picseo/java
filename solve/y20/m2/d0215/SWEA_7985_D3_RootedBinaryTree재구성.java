package solve.s0215;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 재귀로 바로 바로 출력하고 싶었는데 안되서
 * list에 저장한 다음에 출력했다.
 * */
public class SWEA_7985_D3_RootedBinaryTree재구성 {
	public static List<String>[] list = null;
	private static String arr[] = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(sc.nextLine());
			
			String input = sc.nextLine();
			arr = input.split(" ");
			int len = arr.length;
//			int[] nums = new int[len];
//			for(int i = 0; i < len; i++) {
//				if(inputs[i].charAt(0) != ' ') {
//					nums[i] = inputs[i].charAt(0) -'0';
//				}
//			}
			
//			arr = new char[len];
//			for(int i = 0; i < len; i++) {
//				if(inputs[i].charAt(0) != ' ') {
//					arr[i] = inputs[i].charAt(0);
//				}
//			}
			
			list = new List[n];
			for(int i = 0; i < n ; i++) {
				list[i] = new ArrayList<String>();
			}
			
			printroot(0, n-1, 0, len-1);
			
			System.out.print("#"+t+" ");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < list[i].size(); j++) {
					System.out.print(list[i].get(j) + " ");
				}
				System.out.println();
			}
		}//test
	}//main

	private static void printroot(int how, int num, int st, int ed) {
		int mid = st + (ed-st)/2;
		if(how == num) {
			list[how].add(arr[mid]);
		}else {
			list[how].add(arr[mid]);
			printroot(how+1, num, st, mid-1);
			printroot(how+1, num, mid+1, ed);
		}
	}
	
	private static String src = "2\r\n" + 
			"3\r\n" + 
			"3 2 7 5 6 1 4\r\n" + 
			"2\r\n" + 
			"2 1 3";
}
