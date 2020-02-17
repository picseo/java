package algo_basic.day1;

public class SWEA_2027_D1_대각선출력하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(i==j) {
					System.out.print("#");
				}
				else {
					System.out.print("+");
				}
			}
			System.out.println();
		}

	}

}
