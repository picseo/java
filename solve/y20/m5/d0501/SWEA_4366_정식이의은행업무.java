package d0501;

import java.util.Scanner;

public class SWEA_4366_정식이의은행업무 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			String two = sc.next();
			String three = sc.next();
			sb.append("#"+t+" ");
			long tmp = Long.parseLong(two, 2);
			long gob = 1;
			for(int i = two.length()-1; i > 0; i--, gob *= 2) {
				long two_tmp = tmp;
				if(two.charAt(i) == '0') {
					two_tmp += gob;
				}else {
					two_tmp -= gob;
				}

				String three_tmp = Long.toString(two_tmp, 3);
				int check = 0;
				if(three.length() == three_tmp.length()) {
					for(int j = 0; j < three.length(); j++) {
						if(three_tmp.charAt(j) != three.charAt(j)) {
							check++;
						}
					}
				}
				if(check == 1) {
					sb.append(Long.toString(two_tmp)).append("\n");
				}
			}
		}

		System.out.println(sb);
	}

}
