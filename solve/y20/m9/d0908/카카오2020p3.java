package d0908;

import java.util.*;
//ȸ��, �̵����� ���踦 ����, �ڹ��� ������ ��� Ȩ�� ä�� �� ������ ���� �ִ�.

//�ڹ��踦 (N+30) *(N+30) �� ������ (�������� 30, 30), ��� N*N��ġ���� ���踦 ȸ���ϸ鼭 �׶�����
//�ڹ��谡 ��� ä������ �� Ȯ���ϰ�, ��� ä�����ٸ� true�� ��������


public class īī��2020p3 {
	static int[][] map;
	static int[][] new_key;
	static int N, M;

	public static void main(String[] args) {
		int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
		int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
		System.out.println(solution(key, lock)?"true":"false");
	}

	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;

		N = key.length;
		M = lock.length;

		int len = lock.length + 60;
		int llen = lock.length;
		map = new int[len][len];

		for(int i =0; i < llen; i++) {
			for(int j = 0; j < llen; j++) {
				map[i+30][j+30] = lock[i][j];
			}
		}

		/*for(int i =0; i < llen; i++) {
			for(int  j = 0; j < llen; j++) {
				System.out.print(map[i+30][j+30]);
			}
			System.out.println();
		}*/

		new_key = new int[key.length][key.length];
		for(int i =0; i < key.length; i++) {
			new_key[i] = key[i].clone();
		}

		for(int i =0; i <4; i++) {
			if(i != 0) {
				make_newkey(i);
			}
			
			for(int x = 30-N+1; x < 30+M; x++) {
				for(int y = 30-N+1; y < 30+M; y++) {
					if(match(x, y)) {
						return true;
					}
				}
			}
		}

		return answer;
	}

	private static boolean match(int sx, int sy) {
		int[][] tmp_map = new int[map.length][map.length];
		
		for(int i = 0; i < tmp_map.length; i++) {
			tmp_map[i] = map[i].clone();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(new_key[i][j] == 1) {
					if(tmp_map[sx+i][sy+j] == 1) {
						return false;
					}
					tmp_map[sx+i][sy+j] = 1;
				}
			}
		}
		
		boolean answer = true;
		for(int i =0; i < M; i++) {
			for(int  j = 0; j < M; j++) {
				if(tmp_map[i+30][j+30] != 1) {
					answer = false;
					break;
				}
			}
		}
		return answer;
	}

	private static void make_newkey(int num) {
		int len = new_key.length;
		int[][] tmp = new int[len][len];


		for(int i = len-1; i >=0; i--) {//y -> x
			for(int j = 0; j < len; j++) {//x -> y
				tmp[j][len-(i+1)] = new_key[i][j];
			}
		}
		
		for(int i = 0; i < len; i++) {
			new_key[i] = tmp[i].clone();
		}
	}


}
