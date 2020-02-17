package algo_basic.day1;

import java.util.Scanner;

public class SWEA_2056_D1_연월일달력 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 1; i <= t; i++) {
			System.out.printf("#%d ",i);
			String ymd = sc.next();
			String yyyy = ymd.substring(0, 4);
			String mm = ymd.substring(4, 6);
			String dd = ymd.substring(6, 8);

			int month = Integer.parseInt(mm);
			int day = Integer.parseInt(dd);

			StringBuilder out2 = new StringBuilder();
			switch (month) {
			case 1:	case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (day < 1 || day > 31)
					out2.append("-1").append("\n");
				else
					out2.append(yyyy).append("/").append(mm).append("/").append(dd).append("\n");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (day < 1 || day > 30)
					out2.append("-1").append("\n");
				else
					out2.append(yyyy).append("/").append(mm).append("/").append(dd).append("\n");
				break;

			case 2:
				if (day < 1 || day > 28)
					out2.append("-1").append("\n");
				else
					out2.append(yyyy).append("/").append(mm).append("/").append(dd).append("\n");
				break;
			default:
				out2.append("-1").append("\n");

			}
			System.out.print(out2);

		}

	}

}
