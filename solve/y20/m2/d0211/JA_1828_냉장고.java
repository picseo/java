package swea.d0211;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//결국 정렬이 답이다!
public class JA_1828_냉장고 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int n = sc.nextInt();
		Queue<MnMx> queue = new LinkedList();
		
		for(int i = 0; i < n ; i++) {
			int min = sc.nextInt() + 270;
			int max = sc.nextInt() + 270;
			
			queue.add(new MnMx(min, max, 0));
		}
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			MnMx now = queue.poll();
			int min = now.min;
			int max = now.max;
			int how = now.how+1;
			while(!queue.isEmpty()) {
				MnMx tmp = queue.poll();
				int tmp_min = tmp.min;
				int tmp_max = tmp.max;
				if(tmp_max >= max && tmp_min <= min){
					continue;
				}
				
				if(how == tmp.how) {
					queue.add(tmp);
					break;
				}
				tmp.how++;
				
				if((tmp_min >= min && tmp_min <= max) && max < tmp_max) {
					min = tmp_min;
				}else if((tmp_max <= max && tmp_max >= min) && tmp_min < min) {
					max = tmp_max;
				}else if(tmp_max <= max && tmp_min >= min){
					min = tmp_min;
					max = tmp_max;
				}else{
					queue.add(tmp);
				}
			}
			queue.add(new MnMx(min, max, how));
			if(size == queue.size()) {
				break;
			}
		}
		
		System.out.println(queue.size());
	}

	static class MnMx {
		int min;
		int max;
		int how = 0;
		
		MnMx(int min, int max, int how){
			this.min = min;
			this.max = max;
			this.how = how;
		}
	}
	
	private static String src = "91\r\n" + 
			"3 5\r\n" + 
			"12 37\r\n" + 
			"16 23\r\n" + 
			"140 143\r\n" + 
			"437 522\r\n" + 
			"55 95\r\n" + 
			"608 2898\r\n" + 
			"4614 5026\r\n" + 
			"5729 9521\r\n" + 
			"0 0\r\n" + 
			"0 6\r\n" + 
			"4 25\r\n" + 
			"-24 15\r\n" + 
			"112 297\r\n" + 
			"480 603\r\n" + 
			"52 733\r\n" + 
			"1712 2578\r\n" + 
			"593 2453\r\n" + 
			"695 769\r\n" + 
			"0 0\r\n" + 
			"-9 0\r\n" + 
			"7 22\r\n" + 
			"23 73\r\n" + 
			"-161 113\r\n" + 
			"152 454\r\n" + 
			"193 778\r\n" + 
			"827 2057\r\n" + 
			"1287 7767\r\n" + 
			"2439 2794\r\n" + 
			"0 0\r\n" + 
			"1 3\r\n" + 
			"-42 10\r\n" + 
			"18 39\r\n" + 
			"230 269\r\n" + 
			"86 339\r\n" + 
			"210 817\r\n" + 
			"2673 3451\r\n" + 
			"3054 3717\r\n" + 
			"4176 4969\r\n" + 
			"0 0\r\n" + 
			"-3 1\r\n" + 
			"-43 37\r\n" + 
			"52 54\r\n" + 
			"76 202\r\n" + 
			"258 553\r\n" + 
			"51 647\r\n" + 
			"2066 2387\r\n" + 
			"3100 4254\r\n" + 
			"2391 7004\r\n" + 
			"0 0\r\n" + 
			"0 2\r\n" + 
			"-49 21\r\n" + 
			"-73 58\r\n" + 
			"161 217\r\n" + 
			"423 651\r\n" + 
			"316 682\r\n" + 
			"345 2107\r\n" + 
			"2454 6382\r\n" + 
			"5106 9322\r\n" + 
			"0 0\r\n" + 
			"-9 7\r\n" + 
			"48 49\r\n" + 
			"-36 3\r\n" + 
			"-122 110\r\n" + 
			"635 710\r\n" + 
			"220 292\r\n" + 
			"2013 3319\r\n" + 
			"4155 6749\r\n" + 
			"2609 9557\r\n" + 
			"0 0\r\n" + 
			"3 7\r\n" + 
			"2 12\r\n" + 
			"-94 62\r\n" + 
			"318 368\r\n" + 
			"412 665\r\n" + 
			"591 800\r\n" + 
			"810 1967\r\n" + 
			"3365 4434\r\n" + 
			"3019 3715\r\n" + 
			"0 0\r\n" + 
			"2 3\r\n" + 
			"14 26\r\n" + 
			"49 54\r\n" + 
			"329 364\r\n" + 
			"174 370\r\n" + 
			"766 878\r\n" + 
			"68 2986\r\n" + 
			"3920 6792\r\n" + 
			"832 5078\r\n" + 
			"0 0\r\n" + 
			"-9 4";
}
