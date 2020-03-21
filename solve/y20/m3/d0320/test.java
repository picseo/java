package d0320;

import java.util.Scanner;
/*
 * 여기서는 목표값이 현재값보다 크면 - 버튼이 있어도 사용하지 않는게 최소횟수로 목표에 도달하는 방법이라
 * 는 것을 배울 수 있다.
 * */
public class test {
	static int s, e;
	static int min = 40;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		e = sc.nextInt();
		
		remote(s, 0);
		
		System.out.println(min);
	}

	private static void remote(int temp, int cnt) {
		if(cnt > min) {
			return;
		}
		
		if(temp == e) {
			if(cnt<min) {
				min=cnt;
			}
			return;
		}
		
		if(temp < e) {
			remote(temp+10, cnt+1);
			remote(temp+5, cnt+1);
			remote(temp+1, cnt+1);
		}else {
			remote(temp-10, cnt+1);
			remote(temp-5, cnt+1);
			remote(temp-1, cnt+1);
		}
		
		
	}
}
