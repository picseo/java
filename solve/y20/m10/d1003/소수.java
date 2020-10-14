package d1003;

public class ¼Ò¼ö {
	static boolean[] check = new boolean[1000001];
	
	public static void main(String[] args) {	
		StringBuilder sb = new StringBuilder();
		
		check[0] = true;
		check[1] = true;
		
		for(int i = 2; i < 1000001; i++) {
			if(check[i]) {
				continue;
			}
			
			int num = 0;
			for(int j = 2; j*j < i ; j++) {
				if(i%j == 0) {
					num++;
				}
			}
			
			if(num == 0) {
				//System.out.print(i+" ");
				sb.append(i).append(" ");
				int idx = i+i;
				while(idx < 1000001) {
					check[idx] = true;
					idx+=i;
				}
			}
		}

		System.out.println(sb.toString());
	}

}
