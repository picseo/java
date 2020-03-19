package d0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 처음에 정렬된다는 개념만 생각하고 PriorityQueue를 이용했는데
 * 그러다 보니 1단계의 얘들만 보고 싶었는데 우선순위때문에 2단계인 노드가 먼저 나와 값이 이상했다.
 * 
 * 그렇다고 queue를 사용하기에는 정렬이 힘들었다.
 * 
 * 선생님의 코드를 참고해보니 list를 이용해서 값을 저장하고
 * 필요할때만 sort하는 방식을 사용했다.
 * 
 * 여기서 중요하다고 생각되는 점은 list를 삭제할때 인덱스를 1씩 빼주어야 한다는 점인것 같다.(size가 달라지기 때문에 
 * 필요한 조치이다.)
 * 
 * */
public class SWEA_2382_미생물격리_list {
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N, M, K;
	static List<Node> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			list = new ArrayList();
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				int where = x*N+y;
				list.add(new Node(where, num, dir));
			}

			Collections.sort(list);
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < list.size(); j++) {
					Node now = (Node) list.get(j);
					int x = now.where/N;
					int y = now.where%N;

					int nx = x + dirs[now.dir][0];
					int ny = y + dirs[now.dir][1];
					now.where = (nx*N)+ny;
					if(nx == 0 || nx == N-1 || ny == 0 || ny == N-1) {
						//미생물 수를 줄인다.
						now.num = now.num/2;
						//방향을 바꾼다.
						if(now.dir == 0) {
							now.dir = 1;
						}else if(now.dir == 1){
							now.dir = 0;
						}else if(now.dir == 2) {
							now.dir = 3;
						}else if(now.dir == 3) {
							now.dir = 2;
						}
						
						if(now.num == 0) {
							list.remove(j);
							j--;//다시 이자리로 와야 하므로 하나 빼준다.
						}
					}
				}

				Collections.sort(list);
				Node tmpa = null;
				for(int j = 0; j < list.size(); j++) {
					Node now = list.get(j);
					if(j == 0) {
						tmpa = now;
					}else {
						if(tmpa.where == now.where) {
							tmpa.num += now.num;
							list.remove(j);
							j--;
						}else {
							tmpa = now;
						}
					}	
				}
//				for(int j = 0; j < list.size()-1; j++) {
//					Node now = list.get(j);
//					Node next = list.get(j+1);
//					
//					if(now.where == next.where) {
//						now.num += next.num;
//						list.remove(j+1);
//						j--;
//					}
//				}
			}

			int result = 0;
			for(int j = 0; j < list.size(); j++) {
				Node now = list.get(j);
				result += now.num;
			}

			System.out.println(result);
		}

	}

	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < N && y >= 0  && y < N) {
			return true;
		}else {
			return false;
		}
	}

	static class Node implements Comparable<Node>{
		int where;
		int num;
		int dir;

		public Node(int where, int num, int dir) {
			this.where = where;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public int compareTo(Node o) {
			if(this.where == o.where) {
				return Integer.compare(o.num,  this.num);
			}
			return Integer.compare(this.where,  o.where);
		}
	}
	private static String src = "10\r\n" + 
			"7 2 9\r\n" + 
			"1 1 7 1\r\n" + 
			"2 1 7 1\r\n" + 
			"5 1 5 4\r\n" + 
			"3 2 8 4\r\n" + 
			"4 3 14 1\r\n" + 
			"3 4 3 3\r\n" + 
			"1 5 8 2\r\n" + 
			"3 5 100 1\r\n" + 
			"5 5 1 1\r\n" + 
			"10 17 46\r\n" + 
			"7 5 724 2\r\n" + 
			"7 7 464 3\r\n" + 
			"2 2 827 2\r\n" + 
			"2 4 942 4\r\n" + 
			"4 5 604 4\r\n" + 
			"7 2 382 1\r\n" + 
			"6 5 895 3\r\n" + 
			"8 7 538 4\r\n" + 
			"6 1 299 4\r\n" + 
			"4 7 811 4\r\n" + 
			"3 6 664 2\r\n" + 
			"6 8 868 2\r\n" + 
			"7 6 859 2\r\n" + 
			"4 6 778 2\r\n" + 
			"5 4 842 3\r\n" + 
			"1 3 942 1\r\n" + 
			"1 1 805 3\r\n" + 
			"3 2 350 3\r\n" + 
			"2 5 623 2\r\n" + 
			"5 3 840 1\r\n" + 
			"7 1 308 4\r\n" + 
			"1 8 323 3\r\n" + 
			"2 3 82 3\r\n" + 
			"2 6 115 2\r\n" + 
			"8 3 930 1\r\n" + 
			"6 2 72 1\r\n" + 
			"2 1 290 3\r\n" + 
			"4 8 574 4\r\n" + 
			"8 5 150 3\r\n" + 
			"8 2 287 2\r\n" + 
			"2 8 909 2\r\n" + 
			"2 7 588 2\r\n" + 
			"7 3 30 3\r\n" + 
			"5 8 655 3\r\n" + 
			"3 8 537 1\r\n" + 
			"4 2 350 3\r\n" + 
			"5 6 199 1\r\n" + 
			"5 5 734 2\r\n" + 
			"3 3 788 1\r\n" + 
			"8 4 893 1\r\n" + 
			"1 4 421 4\r\n" + 
			"6 3 616 2\r\n" + 
			"1 2 556 4\r\n" + 
			"7 8 8 1\r\n" + 
			"5 2 702 2\r\n" + 
			"4 4 503 3\r\n" + 
			"10 5 28\r\n" + 
			"3 3 796 1\r\n" + 
			"7 2 798 2\r\n" + 
			"2 6 622 1\r\n" + 
			"3 5 179 3\r\n" + 
			"7 8 888 4\r\n" + 
			"5 8 634 3\r\n" + 
			"1 8 646 1\r\n" + 
			"3 7 433 4\r\n" + 
			"6 7 416 1\r\n" + 
			"2 7 651 3\r\n" + 
			"6 4 476 2\r\n" + 
			"5 6 712 4\r\n" + 
			"1 7 869 4\r\n" + 
			"6 1 789 2\r\n" + 
			"8 8 585 3\r\n" + 
			"7 6 426 1\r\n" + 
			"1 5 154 2\r\n" + 
			"1 2 692 1\r\n" + 
			"2 4 549 3\r\n" + 
			"2 1 60 2\r\n" + 
			"4 8 996 4\r\n" + 
			"8 2 437 2\r\n" + 
			"3 6 195 2\r\n" + 
			"1 3 734 4\r\n" + 
			"3 8 355 2\r\n" + 
			"1 1 945 1\r\n" + 
			"2 5 558 2\r\n" + 
			"7 7 144 2\r\n" + 
			"10 22 26\r\n" + 
			"2 2 450 4\r\n" + 
			"6 3 659 1\r\n" + 
			"5 8 24 2\r\n" + 
			"3 7 649 2\r\n" + 
			"3 2 22 3\r\n" + 
			"1 3 905 4\r\n" + 
			"7 8 625 3\r\n" + 
			"6 7 824 3\r\n" + 
			"7 3 159 1\r\n" + 
			"2 7 297 4\r\n" + 
			"7 2 270 2\r\n" + 
			"4 5 985 1\r\n" + 
			"7 1 627 2\r\n" + 
			"3 4 625 4\r\n" + 
			"8 5 972 4\r\n" + 
			"6 6 432 4\r\n" + 
			"6 8 142 1\r\n" + 
			"7 7 900 1\r\n" + 
			"4 1 974 2\r\n" + 
			"4 2 760 4\r\n" + 
			"1 4 550 2\r\n" + 
			"5 7 624 4\r\n" + 
			"4 6 694 1\r\n" + 
			"4 3 593 3\r\n" + 
			"3 1 152 4\r\n" + 
			"1 8 926 1\r\n" + 
			"10 7 15\r\n" + 
			"3 4 227 1\r\n" + 
			"4 7 109 1\r\n" + 
			"3 7 487 2\r\n" + 
			"2 3 627 2\r\n" + 
			"6 1 520 4\r\n" + 
			"7 3 596 4\r\n" + 
			"2 6 525 4\r\n" + 
			"1 5 116 3\r\n" + 
			"7 7 771 4\r\n" + 
			"4 4 520 2\r\n" + 
			"7 5 763 1\r\n" + 
			"5 4 829 3\r\n" + 
			"5 2 578 3\r\n" + 
			"6 8 200 2\r\n" + 
			"3 8 760 4\r\n" + 
			"10 24 12\r\n" + 
			"6 5 887 2\r\n" + 
			"2 3 428 1\r\n" + 
			"2 1 540 2\r\n" + 
			"8 1 356 4\r\n" + 
			"1 7 485 4\r\n" + 
			"5 1 357 3\r\n" + 
			"7 6 271 2\r\n" + 
			"6 2 22 1\r\n" + 
			"6 1 41 2\r\n" + 
			"8 2 565 2\r\n" + 
			"8 5 855 1\r\n" + 
			"6 3 734 1\r\n" + 
			"10 22 44\r\n" + 
			"2 2 963 1\r\n" + 
			"8 4 635 4\r\n" + 
			"4 1 938 4\r\n" + 
			"8 7 511 3\r\n" + 
			"6 8 825 4\r\n" + 
			"6 7 934 3\r\n" + 
			"3 7 701 4\r\n" + 
			"2 7 534 2\r\n" + 
			"5 2 705 1\r\n" + 
			"3 5 300 2\r\n" + 
			"6 2 855 4\r\n" + 
			"7 7 877 4\r\n" + 
			"1 7 443 1\r\n" + 
			"1 2 313 1\r\n" + 
			"3 3 932 2\r\n" + 
			"1 8 831 2\r\n" + 
			"1 1 90 2\r\n" + 
			"2 6 145 3\r\n" + 
			"2 3 740 4\r\n" + 
			"5 3 759 4\r\n" + 
			"1 6 181 1\r\n" + 
			"8 6 608 4\r\n" + 
			"5 6 556 2\r\n" + 
			"2 4 541 4\r\n" + 
			"2 1 174 2\r\n" + 
			"6 1 601 1\r\n" + 
			"7 5 84 4\r\n" + 
			"4 3 970 3\r\n" + 
			"8 8 503 1\r\n" + 
			"3 4 171 3\r\n" + 
			"5 7 913 4\r\n" + 
			"8 1 232 3\r\n" + 
			"7 6 539 4\r\n" + 
			"3 8 648 1\r\n" + 
			"8 2 944 2\r\n" + 
			"2 5 508 2\r\n" + 
			"5 1 87 1\r\n" + 
			"5 8 88 4\r\n" + 
			"2 8 681 2\r\n" + 
			"1 5 758 2\r\n" + 
			"3 1 690 3\r\n" + 
			"6 4 620 3\r\n" + 
			"5 4 783 1\r\n" + 
			"6 6 748 1\r\n" + 
			"10 9 38\r\n" + 
			"2 7 955 1\r\n" + 
			"7 7 25 4\r\n" + 
			"4 2 496 2\r\n" + 
			"1 4 342 1\r\n" + 
			"7 5 72 1\r\n" + 
			"3 7 429 2\r\n" + 
			"5 2 812 3\r\n" + 
			"8 6 36 2\r\n" + 
			"1 6 994 3\r\n" + 
			"1 5 838 1\r\n" + 
			"3 4 131 4\r\n" + 
			"7 2 11 2\r\n" + 
			"6 3 650 3\r\n" + 
			"7 3 353 2\r\n" + 
			"1 7 454 2\r\n" + 
			"8 3 256 4\r\n" + 
			"5 5 213 2\r\n" + 
			"6 5 80 1\r\n" + 
			"2 1 676 4\r\n" + 
			"4 6 561 3\r\n" + 
			"2 5 653 3\r\n" + 
			"3 5 923 3\r\n" + 
			"8 2 259 3\r\n" + 
			"4 4 781 2\r\n" + 
			"1 1 313 2\r\n" + 
			"3 6 938 3\r\n" + 
			"2 6 700 3\r\n" + 
			"4 1 215 2\r\n" + 
			"4 8 39 3\r\n" + 
			"5 1 954 3\r\n" + 
			"6 7 774 1\r\n" + 
			"5 8 541 4\r\n" + 
			"3 1 885 4\r\n" + 
			"7 8 867 2\r\n" + 
			"2 8 825 1\r\n" + 
			"5 6 598 3\r\n" + 
			"6 6 80 3\r\n" + 
			"8 1 405 2\r\n" + 
			"10 16 11\r\n" + 
			"5 7 87 3\r\n" + 
			"2 5 686 1\r\n" + 
			"6 7 64 2\r\n" + 
			"6 8 873 3\r\n" + 
			"5 6 762 2\r\n" + 
			"8 4 268 3\r\n" + 
			"7 3 307 4\r\n" + 
			"1 7 809 3\r\n" + 
			"5 5 293 3\r\n" + 
			"5 1 345 3\r\n" + 
			"4 1 114 4\r\n" + 
			"10 8 19\r\n" + 
			"3 1 52 4\r\n" + 
			"6 8 423 3\r\n" + 
			"7 3 498 4\r\n" + 
			"7 5 633 3\r\n" + 
			"7 7 392 3\r\n" + 
			"6 6 458 4\r\n" + 
			"3 8 830 3\r\n" + 
			"5 1 799 3\r\n" + 
			"1 1 540 3\r\n" + 
			"4 8 567 3\r\n" + 
			"1 6 897 3\r\n" + 
			"5 4 230 1\r\n" + 
			"2 6 229 3\r\n" + 
			"1 5 147 1\r\n" + 
			"4 1 754 2\r\n" + 
			"3 3 569 1\r\n" + 
			"7 8 515 4\r\n" + 
			"2 4 528 4\r\n" + 
			"2 1 962 2\r\n" + 
			"10 24 36\r\n" + 
			"6 6 923 3\r\n" + 
			"7 6 910 2\r\n" + 
			"2 1 278 2\r\n" + 
			"2 5 164 3\r\n" + 
			"8 6 505 4\r\n" + 
			"2 8 970 1\r\n" + 
			"1 1 85 2\r\n" + 
			"1 6 194 1\r\n" + 
			"5 3 572 1\r\n" + 
			"7 4 611 4\r\n" + 
			"6 2 565 4\r\n" + 
			"1 3 609 4\r\n" + 
			"1 7 74 2\r\n" + 
			"6 5 573 4\r\n" + 
			"5 1 31 3\r\n" + 
			"7 7 779 3\r\n" + 
			"7 1 391 3\r\n" + 
			"8 5 364 3\r\n" + 
			"7 8 474 1\r\n" + 
			"5 6 547 3\r\n" + 
			"2 6 195 2\r\n" + 
			"3 7 754 4\r\n" + 
			"1 8 912 1\r\n" + 
			"3 8 415 1\r\n" + 
			"5 8 434 4\r\n" + 
			"5 7 958 4\r\n" + 
			"2 7 700 3\r\n" + 
			"4 5 974 1\r\n" + 
			"4 7 376 4\r\n" + 
			"3 1 111 1\r\n" + 
			"3 6 486 1\r\n" + 
			"8 4 545 1\r\n" + 
			"5 2 237 3\r\n" + 
			"4 2 850 2\r\n" + 
			"2 4 793 2\r\n" + 
			"6 3 877 2\r\n" + 
			"20 5 30\r\n" + 
			"1 14 823 3\r\n" + 
			"6 14 595 4\r\n" + 
			"10 6 1310 3\r\n" + 
			"13 7 1487 3\r\n" + 
			"15 3 258 4\r\n" + 
			"14 15 1286 4\r\n" + 
			"7 7 1128 1\r\n" + 
			"3 10 1503 3\r\n" + 
			"18 8 1881 3\r\n" + 
			"6 17 598 3\r\n" + 
			"1 16 756 4\r\n" + 
			"18 11 1435 2\r\n" + 
			"12 18 1386 3\r\n" + 
			"4 9 48 3\r\n" + 
			"1 9 1840 2\r\n" + 
			"17 8 1599 3\r\n" + 
			"12 5 1328 3\r\n" + 
			"13 12 1794 1\r\n" + 
			"3 1 1432 4\r\n" + 
			"14 9 1497 1\r\n" + 
			"6 2 841 4\r\n" + 
			"10 9 648 1\r\n" + 
			"2 16 633 3\r\n" + 
			"12 3 1990 3\r\n" + 
			"12 6 578 1\r\n" + 
			"8 1 1487 1\r\n" + 
			"6 13 193 1\r\n" + 
			"11 10 1834 1\r\n" + 
			"5 16 529 2\r\n" + 
			"5 14 1392 4";
}
