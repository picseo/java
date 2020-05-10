package d0510;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BJ_5052_전화번호목록 {
	//문제 어디에도 0으로 시작하지 않는다는 말이 없었는데, 예시로 주어진 것들이 0으로 시작하지 않아서
	//0으로 시작하는 것을 안 고려해서 틀렸었다. 문제를 잘 읽자!!!!!!! 맘대로 추가하지 말자!!!!!!!
	
	//앞부분이 다른 번호로 저장되어있으면 안되는 것이므로
	//일단 길이 순으로 정렬을 한 뒤
	//새로운 입력이 있을 때만다 앞부분부터 한글자로 시작해서 전체 길이까지 확인하면서 이미 존재하는지 확인한다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			
			String[] inputs = new String[N];
			
			for(int i = 0; i < N; i++) {
				inputs[i] = sc.next();
			}
			
			Arrays.sort(inputs);
			
			boolean check = true;
			HashSet<String> hs = new HashSet<String>();
			for(int i = 0; i < N; i++) {
				int len = inputs[i].length();
				int start = 0;
				int end = 1;
				while(end != len+1) {
					String tmp = inputs[i].substring(start, end);
					if(hs.contains(tmp)) {
						check = false;
						break;
					}
					end++;
				}
				
				if(check) {
					hs.add(inputs[i]);
				}else {
					break;
				}				
			}
			
			if(check) {
				sb.append("YES");
			}else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
