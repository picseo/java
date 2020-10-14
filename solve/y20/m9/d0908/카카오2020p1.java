package d0908;

import java.util.HashMap;
import java.util.Stack;

public class īī��2020p1 {
	//500*1000�̴ϱ� ��Ž�� �����ϴٰ� �����Ѵ�.
	//��Ž�̴ϱ� ��ͷ� �ڸ��� ũ�⸦ ����� �Է��ϰ�, hashmap���� �ش� ���ڿ��� ���ڸ� �����ؼ�
	//�������� ���������� ���̸� ����, ���� ª�� ���̸� �����Ѵ�.
	static int result = 0;
	static class Point{
		String str;
		int cnt;
		public Point(String str, int cnt) {
			this.str = str;
			this.cnt = cnt;
		}
	}
	static Stack<Point> st;

	public static void main(String[] args) {
		System.out.println(solution("xababcdcdababcdcd"));
		return;
	}

	public static int solution(String s) {
		int answer = 0;
		int len = s.length();

		result = len;
		for(int i = 1; i <= len/2; i++) {
			st = new Stack<Point>();
			find(s, 0, len, i);
		}

		answer = result;
		return answer;
	}

	private static void find(String s, int start, int end, int len) {
		int last = Math.min(start+len,  end);
		String now = s.substring(start, last);

		if(st.isEmpty()) {
			st.add(new Point(now, 1));
		}else {
			Point top = st.peek();
			if(top.str.equals(now)) {
				top.cnt++;
			}else {
				st.add(new Point(now, 1));
			}
		}

		if(last == end) {
			int tmp = 0;
			while(!st.isEmpty()) {
				Point top = st.pop();
				tmp += top.str.length();
				if(top.cnt != 1) {
					tmp += (int)Math.log10(top.cnt) + 1;
				}
			}
			result = Math.min(result,  tmp);
			return;
		}else {
			find(s, last, end, len);
		}
		return;
	}
}


/*************
 
 ���� �ϴ� �� : ����� Ư¡�� �� ����ߴ�. return result += preString + �Լ�();
 ���� �����
 class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i=1; i<=(s.length()/2)+1; i++){
            int result = getSplitedLength(s, i, 1).length();
            answer = i==1 ? result : (answer>result?result:answer);
        }

        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat){
        if(s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // ����ġ -> ������� [�ݺ�Ƚ�� + �ݺ�����] ����
        if(!postString.startsWith(preString)){
            if(repeat ==1) return result += preString + getSplitedLength(postString, n, 1);
            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
        }

        return result += getSplitedLength(postString, n, repeat+1);
    }
}
 
 
 *////
