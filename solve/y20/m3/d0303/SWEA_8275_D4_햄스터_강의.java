package d0303;

import java.util.Scanner;

/*
 * N : �츮 ���� 1~6
 * x : �ϳ��� �츮�� ���� �� �ִ� ������
 * m : ����̰� üũ�� Ƚ��, �ܽ��͸� ��ġ�ؼ� ��  M���� üũ�� �� ����ϴ��� ������
 * 
 * �츮 ���� �ִ� 6, �츮 ������ 0~10 -> 11^6(�־��� ����Ǽ� ) -> ��Ž ����
 * 
 * ���ǻ��� >
 * (1) M���� �� �����ϴ� ��ġ�� �������� ��� �հ� ���� ��
 * (2) �հ谡 �� ���� ��� -> ��������
 * (3) �����ϴ� ��ġ�� ���ٸ� ? -1 ���
 * 
 * �� ��츦 ������ ������ �ϹǷ� -> ��͸� ����ϸ� ���
 * **/
public class SWEA_8275_D4_�ܽ���_���� {
	static int[] cage;//������ ��� �ܽ��� ��ġ�� �غ�(�ߺ�����)
	static int N, X, M;
	static int[][] input;
	static int max;//�ܽ��� ��ġ �������� ���� �����ϴٸ�? ���� �ִ밡 �Ǵ� ��츦 ����
	static String ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt();
		for(int t= 1; t<= T; t++) {
			max = -1;
			ans = "";
			N = sc.nextInt(); //�� �츮 ����
			X = sc.nextInt(); //�� �츮 ���� ������
			M = sc.nextInt(); //üũ Ƚ��
			
			cage = new int[N+1];
			input = new int[M][3]; // left, right, sum
			
			for(int i = 0; i < M; i++) {
				input[i][0] = sc.nextInt();
				input[i][1] = sc.nextInt();
				input[i][2] = sc.nextInt();
			}
			
			perm(1,0);
			
			System.out.println("#"+t+" "+((max== -1)? max : ans));
		}
	}

	static void perm(int idx, int sum) {//idx�� �ܽ��� ������ ��ȣ
		if(idx == cage.length) { //������� üũ�� �����ϴ��� üũ
			if(check()) {
				if(max < sum) {//���� ���ΰ�� ���������� �ڿ� �ִ� ���� ����
					max = sum;
					ans = makeAns();
				}
			}
		}else {
			for(int i = 0; i <= X; i++) {
				cage[idx] = i;
				perm(idx+1, sum+i);
			}	
		}
	}
	
	static String makeAns() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(cage[i]).append(" ");
		}
		return sb.toString();
	}
	
	static boolean check() {
		for(int i = 0 ; i < M; i++) {//M���� üũ
			int tmp = 0;
			for(int j = input[i][0]; j <= input[i][1]; j++) {
				tmp += cage[j];
			}
			if(input[i][2] != tmp) {//���� �ٸ�
				return false;
			}
		}
		return true;
	}
	
	private static String src = "3\r\n" + 
			"3 5 1\r\n" + 
			"1 2 5\r\n" + 
			"3 5 2\r\n" + 
			"1 2 6\r\n" + 
			"2 3 7\r\n" + 
			"4 5 2\r\n" + 
			"1 3 15\r\n" + 
			"3 4 4";
	
}
