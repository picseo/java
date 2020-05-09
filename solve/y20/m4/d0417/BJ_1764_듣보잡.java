package d0417;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
//먼저 나오는 듣못을 hashset에 저장을 한 다음에
//보못에서 나오는 이름이 이미 hash에 있으면 듣보잡이므로
//TreeSet에 넣어준다.(TreeSet에 넣으므로써 결과는 정렬되어 나오게 된다.

//이문제는 그냥 입력되는 모든 값을 배열에 받은 후에 정렬을 하고 두개씩 있는 이름만 출력하는게
//메모리도 적게 든다.
public class BJ_1764_듣보잡 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<String> ts = new HashSet();
		TreeSet<String> result = new TreeSet();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			String input = sc.next();
			ts.add(input);
		}
		
		for(int i = 0; i < M; i++) {
			String input = sc.next();
			if(ts.contains(input)) {
				result.add(input);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(result.size()).append("\n");
		for(String name : result) {
			sb.append(name).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
