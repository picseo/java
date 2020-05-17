package d0517;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 힙은 최대값과 최소값을 효율적으로 구해 주는 자료 구조이다. 
 힙 안에 원소를 순서에 상관 없이 넣기만 해도 힙은 logN의 시간복잡도만으로 최대, 최소 원소를 루트로서 가지고 있다
 따라서 힙을 활용해 중간값을 구하기 위해서는 주어진 값들을 큰 값들은 최소힙에 작은 값들은 최대힙으로 절반씩 나누어 
 그 경계에 있는 값들을 구하면 된다.

최대힙의 크기가 최소힙보다 1만큼 더 크거나 같게끔 하면 중간값은 항상 최대힙에 포함된다. 
새로운 값이 들어오면 최대힙이 1더 큰 경우엔 최소힙에, 최소힙과 최대힙이 크기가 같은 경우엔 최대힙에 넣는다. 
힙의 연산처럼 일단 모양 규칙을 맞춘 뒤 대소 관계 규칙에 대해 생각하는 것이다. 
새로 최대힙이나 최소힙에 들어간 값은 힙의 구조를 다시 이루는 과정에서 올바르지 않은 원소가 들어온 경우 
루트로 가게된다. 
루트로 가게된 원소를 반대 힙의 루트와 비교해서 최대힙의 최대 원소가 최소힙의 최소 원소보다 큰 경우 
위치를 바꿔주기만 하면 된다.
 * */
public class BJ_1655_가운데를말해요 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int[] inputs = new int[N];

		PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return Integer.compare(o1, o2);
					}

				});

		PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return Integer.compare(o2, o1);
					}

				});
		//max_heap에 작은 값들을 저장, min_heap에 큰값을 저장.
		inputs[0] = sc.nextInt();
		max_heap.add(inputs[0]);
		sb.append(max_heap.peek()).append("\n");

		for(int i = 1 ; i < N ; i++) {
			inputs[i] = sc.nextInt();

			if(min_heap.size()+1 == max_heap.size()) {
				min_heap.add(inputs[i]);
				
				if(max_heap.peek() > min_heap.peek()) {
					int tmp = max_heap.poll();
					max_heap.add(min_heap.poll());
					min_heap.add(tmp);
				}
			}else {//둘이 크기가 같을때
				max_heap.add(inputs[i]);
				
				if(max_heap.peek() > min_heap.peek()) {
					int tmp = max_heap.poll();
					max_heap.add(min_heap.poll());
					min_heap.add(tmp);
				}
			}

			sb.append(max_heap.peek()).append("\n");
		}

		System.out.println(sb);
	}



}
