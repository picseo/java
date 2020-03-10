package d0305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_지희의고장난버튼_강의 {
	static int X;
	static int min;
	static boolean[] btn;
	static int[] memo;//2
	static int size;//2
	
	public static void main(String[] args) throws Exception{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t= 1; t <= T; t++) {		
		//min값을 초기화 Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;
		//btn배열 값을 boolean으로 받음(1- > true, 0->false)
			StringTokenizer st;
			btn = new boolean[10];//수가 작으면 그때그때 만드는게 더 낫다!!!!!!!!(승희가 들음)
			st = new StringTokenizer(br.readLine().trim(), " ");
			int num;
			for(int i = 0; i < 10; i++) {
				num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					btn[i] = true;
				}
			}
			X = Integer.parseInt(br.readLine().trim());
			size = (int)Math.sqrt(X);//2
			memo = new int[size];//2
		//처리(깊이가 있는 문제 -> dfs) => 재귀함수
			find(X, 0);

		
		//출력
		//min == Integer.MAX_VALUE ? -1 : min
		min = (min == Integer.MAX_VALUE) ? -1 : min;
		System.out.println("#"+t+" " +min);
	}
}
		
	private static int find(int x, int cnt) {
		if(x < size && memo[x] != 0) {
			return memo[x];
		}
	//base case => 종료조건
		if(isMake(x+"")) {
			int count = len(x)+1;
			// x값이 주어진 모든 수로 누룰 수 있는지 검사
			//  x길이를 리턴
			if(cnt == 0) {
				min = count; //계산 버튼을 위해  1을 더한다.
			}
			
			if(x < size) {
				memo[x] = count;
			}
			return count;
		}

		//처리
		//result 값을 -1로 초기화
		int result = -1;
		//2~ 제곱근 까지 반복(i)
		//end = (int)Math.sqrt(x)+1
		for(int i = 2 ; i*i < x; i++) {
		// i는 x의 약수, 모든 수로 누룰수 있는지 검사
			if(x % i == 0 && isMake(i+ "")) {
				//i의 길이를 구해, 
				int len1 = len(i) + 1;// 곱하기 버튼을 추가
				//몫이 x의 약수이면서 모든 수로 누룰수 있는지 검사 -->  재귀호출
				int len2 = find(x/i, cnt+1);
			

				//몫이 -1이 아니면 => x의 약수, 모든 수로 누룰 수 
				if(len2 > -1) {
					//i의 길이와 몫이 길이를 + * =
					result = len1 + len2;
					//결과가 min값과 비교해서 갱신
					if(result < min && x == X) {
						min = result;
					}
				}
			}
		}
		if(x < size) {
			memo[x] = result;
		}
		return result;
	}
	
	private static int len(int x) {//숫자의 길이를 셀 수 있다.
		return (int)Math.log10(x) + 1;
	}
	
	
	private static boolean isMake(String x) {
		for(char c : x.toCharArray()) {
			if(!btn[c-'0']) {
				return false;
			}
		}
		return true;
	}
	
	private static String src = "100\r\n" + 
			"0 0 0 1 1 0 1 0 0 1\r\n" + 
			"34396\r\n" + 
			"1 1 0 0 0 0 0 1 1 0\r\n" + 
			"1000000\r\n" + 
			"0 0 0 0 1 0 0 0 1 1\r\n" + 
			"844898\r\n" + 
			"1 1 0 1 0 0 1 0 1 0\r\n" + 
			"68008\r\n" + 
			"0 0 0 0 0 0 0 0 0 1\r\n" + 
			"793881\r\n" + 
			"1 0 1 1 0 1 1 0 1 1\r\n" + 
			"396335\r\n" + 
			"1 1 0 0 0 1 1 0 0 1\r\n" + 
			"658395\r\n" + 
			"0 0 0 0 0 1 0 0 0 0\r\n" + 
			"34375\r\n" + 
			"0 0 0 0 0 0 1 0 0 0\r\n" + 
			"23976\r\n" + 
			"1 0 0 0 1 0 1 0 1 1\r\n" + 
			"844\r\n" + 
			"0 0 0 0 0 0 1 0 0 0\r\n" + 
			"666\r\n" + 
			"1 1 0 0 0 1 0 1 0 0\r\n" + 
			"180945\r\n" + 
			"0 0 0 0 1 1 0 1 1 1\r\n" + 
			"57475\r\n" + 
			"0 1 0 0 0 0 0 0 0 0\r\n" + 
			"123321\r\n" + 
			"0 0 0 0 1 0 1 0 1 0\r\n" + 
			"6\r\n" + 
			"0 1 0 0 0 0 0 0 0 0\r\n" + 
			"1111\r\n" + 
			"1 0 0 1 0 1 1 0 1 1\r\n" + 
			"47206\r\n" + 
			"1 1 1 1 1 0 0 0 0 1\r\n" + 
			"920\r\n" + 
			"1 0 0 0 0 1 0 0 0 0\r\n" + 
			"5500\r\n" + 
			"0 0 0 1 0 1 0 0 0 0\r\n" + 
			"83025\r\n" + 
			"1 0 0 0 0 0 0 1 1 0\r\n" + 
			"60900\r\n" + 
			"1 0 0 0 1 0 0 1 0 1\r\n" + 
			"7\r\n" + 
			"0 1 0 0 0 0 0 0 0 0\r\n" + 
			"13431\r\n" + 
			"0 0 0 0 1 0 0 0 0 0\r\n" + 
			"78144\r\n" + 
			"0 0 1 0 0 0 1 0 0 0\r\n" + 
			"2222\r\n" + 
			"1 0 0 0 0 1 1 0 1 0\r\n" + 
			"86506\r\n" + 
			"0 1 0 0 0 0 1 0 1 0\r\n" + 
			"86811\r\n" + 
			"0 0 0 1 0 0 0 0 0 0\r\n" + 
			"890109\r\n" + 
			"1 0 1 0 1 0 1 0 1 0\r\n" + 
			"20\r\n" + 
			"1 1 1 0 0 1 0 0 0 1\r\n" + 
			"285499\r\n" + 
			"1 0 0 0 0 1 0 0 0 0\r\n" + 
			"5555\r\n" + 
			"0 0 0 0 0 0 1 0 0 0\r\n" + 
			"396\r\n" + 
			"1 1 1 1 0 0 0 0 0 0\r\n" + 
			"310\r\n" + 
			"1 1 0 0 0 1 0 0 0 0\r\n" + 
			"15110\r\n" + 
			"0 0 0 0 0 0 1 0 1 0\r\n" + 
			"4128\r\n" + 
			"0 1 0 1 0 0 0 0 0 1\r\n" + 
			"9\r\n" + 
			"0 0 0 0 1 1 1 0 1 0\r\n" + 
			"8\r\n" + 
			"0 1 0 0 0 0 0 0 0 0\r\n" + 
			"12221\r\n" + 
			"0 0 0 0 0 0 0 0 1 0\r\n" + 
			"782144\r\n" + 
			"0 0 0 1 0 1 1 0 0 1\r\n" + 
			"994661\r\n" + 
			"0 1 0 0 0 1 1 0 0 0\r\n" + 
			"1666\r\n" + 
			"0 0 1 0 0 0 0 0 0 0\r\n" + 
			"8888\r\n" + 
			"0 0 0 1 0 0 0 0 0 0\r\n" + 
			"10989\r\n" + 
			"1 0 0 1 1 1 0 0 0 0\r\n" + 
			"5\r\n" + 
			"0 0 0 1 1 0 0 0 0 0\r\n" + 
			"443433\r\n" + 
			"0 1 0 1 0 1 0 0 0 0\r\n" + 
			"45\r\n" + 
			"0 0 1 0 0 1 1 1 0 0\r\n" + 
			"772527\r\n" + 
			"0 0 0 1 0 0 1 1 0 0\r\n" + 
			"587972\r\n" + 
			"0 0 1 0 0 1 0 1 0 0\r\n" + 
			"2772\r\n" + 
			"0 0 0 1 0 0 0 1 0 0\r\n" + 
			"7777\r\n" + 
			"0 1 1 0 0 1 1 1 1 0\r\n" + 
			"225575\r\n" + 
			"1 0 1 1 1 1 1 1 0 0\r\n" + 
			"326066\r\n" + 
			"0 1 0 0 1 1 0 0 0 0\r\n" + 
			"55141\r\n" + 
			"1 1 0 0 0 0 1 1 0 0\r\n" + 
			"1\r\n" + 
			"0 0 1 0 1 0 1 1 0 0\r\n" + 
			"666242\r\n" + 
			"0 0 0 1 1 1 1 0 0 0\r\n" + 
			"66633\r\n" + 
			"1 1 1 1 0 0 1 1 0 0\r\n" + 
			"2132\r\n" + 
			"0 1 0 0 0 0 1 1 1 0\r\n" + 
			"881166\r\n" + 
			"0 0 0 0 1 0 0 0 0 0\r\n" + 
			"19536\r\n" + 
			"0 1 0 1 1 0 0 1 0 0\r\n" + 
			"17743\r\n" + 
			"1 1 0 1 0 0 0 0 0 0\r\n" + 
			"980003\r\n" + 
			"1 1 0 1 1 1 1 1 0 1\r\n" + 
			"474936\r\n" + 
			"1 0 1 1 0 1 0 0 1 1\r\n" + 
			"802800\r\n" + 
			"0 0 0 0 0 0 0 0 0 1\r\n" + 
			"89991\r\n" + 
			"1 0 1 1 0 0 1 0 0 0\r\n" + 
			"20222\r\n" + 
			"0 0 0 0 0 0 1 0 0 0\r\n" + 
			"85536\r\n" + 
			"0 0 0 1 0 0 0 0 0 1\r\n" + 
			"9333\r\n" + 
			"0 0 0 0 0 1 0 0 0 0\r\n" + 
			"378125\r\n" + 
			"1 0 1 0 0 0 0 0 0 0\r\n" + 
			"440040\r\n" + 
			"0 1 1 1 1 0 0 0 1 0\r\n" + 
			"11131\r\n" + 
			"1 0 0 1 1 1 1 0 0 1\r\n" + 
			"6990\r\n" + 
			"1 1 0 1 1 0 1 1 1 1\r\n" + 
			"876496\r\n" + 
			"0 1 0 0 0 0 0 0 0 1\r\n" + 
			"17991\r\n" + 
			"0 0 0 1 0 0 0 0 1 0\r\n" + 
			"8838\r\n" + 
			"0 1 1 1 0 1 1 0 0 0\r\n" + 
			"100914\r\n" + 
			"0 0 1 0 0 0 0 0 1 1\r\n" + 
			"929822\r\n" + 
			"0 1 0 0 0 0 0 0 1 0\r\n" + 
			"1584\r\n" + 
			"1 1 1 0 0 0 1 0 0 0\r\n" + 
			"2\r\n" + 
			"0 1 0 0 0 0 0 1 0 0\r\n" + 
			"7117\r\n" + 
			"0 0 1 0 1 0 0 0 1 0\r\n" + 
			"44448\r\n" + 
			"0 0 1 1 0 1 0 1 0 1\r\n" + 
			"285846\r\n" + 
			"0 1 0 1 0 0 0 1 0 1\r\n" + 
			"229632\r\n" + 
			"0 0 1 1 1 0 0 0 1 1\r\n" + 
			"114004\r\n" + 
			"1 0 0 1 1 0 0 0 0 0\r\n" + 
			"3\r\n" + 
			"0 0 0 0 1 1 0 0 0 0\r\n" + 
			"45444\r\n" + 
			"0 0 0 1 0 0 0 0 0 0\r\n" + 
			"98901\r\n" + 
			"1 0 0 1 0 0 1 0 0 1\r\n" + 
			"89239\r\n" + 
			"0 1 0 0 1 1 1 1 1 1\r\n" + 
			"468617\r\n" + 
			"0 1 0 0 0 0 0 0 0 1\r\n" + 
			"199191\r\n" + 
			"1 0 0 1 0 0 1 0 0 0\r\n" + 
			"654480\r\n" + 
			"0 0 1 0 0 0 1 0 0 0\r\n" + 
			"222666\r\n" + 
			"0 0 0 0 0 1 0 1 0 0\r\n" + 
			"290625\r\n" + 
			"1 1 0 0 1 0 0 0 0 0\r\n" + 
			"4\r\n" + 
			"0 0 1 0 1 1 0 1 1 0\r\n" + 
			"245282\r\n" + 
			"0 0 0 0 1 0 0 0 0 0\r\n" + 
			"78144\r\n" + 
			"0 0 0 0 0 0 0 0 0 1\r\n" + 
			"891\r\n" + 
			"1 0 0 0 1 0 1 0 1 1\r\n" + 
			"968469\r\n" + 
			"1 1 1 1 1 0 1 1 1 1\r\n" + 
			"11763\r\n" + 
			"0 1 0 0 0 1 0 1 0 1\r\n" + 
			"55959\r\n" + 
			"1 0 0 1 0 0 1 0 0 0\r\n" + 
			"606\r\n" + 
			"";
}
