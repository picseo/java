package d0908;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//query는 키워드가 중복 될수있다. 갯수를 새어야 한다. => HaspMap을 이용하자
//startwith, endwith

//trie나 문자열을 정렬한 후 이분탐색으로 시간을 줄여야 한다고 한다.
public class 카카오2020p4 {
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	static ArrayList<String>[] wordlist;

	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

		int[] answer = solution(words, queries);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		int wordlen = words.length;
		wordlist = new ArrayList[wordlen+1];
		for(int i =0; i <= wordlen; i++) {
			wordlist[i] = new ArrayList();
		}

		//길이에 맞춰서 나누어둔다.
		for(int i =0; i < wordlen; i++) {
			int len = words[i].length();

			wordlist[len].add(words[i].substring(0));
		}

		for(int i = 0; i < queries.length; i++) {
			String now = queries[i].substring(0);
			//System.out.println("now : " + now);
			//이미 계산 되었으면 하지 않음
			if(!hm.isEmpty() && hm.containsKey(now)) {
				answer[i] = hm.get(now);
				continue;
			}

			//계산 과정
			if(now.charAt(0) == '?') {//앞이 ?일때
				int len = questionlen(now, 0);

				if(len == now.length()) {
					hm.put(now, wordlist[now.length()].size());
				}else {
					String tmp = now.substring(len);
					//System.out.println("tmp : " + tmp);
					hm.put(now, 0);
					for(int j = 0; j < wordlist[now.length()].size(); j++) {
						if(wordlist[now.length()].get(j).endsWith(tmp)) {
							//System.out.println("ok : " + wordlist[now.length()].get(j));
							hm.replace(now, hm.get(now)+1);
						}
					}
				}
				answer[i] = hm.get(now);
			}else {
				int len = questionlen(now, 1);

				if(len == now.length()) {
					hm.put(now, wordlist[now.length()].size());
				}else {
					len = now.length()-len;
					String tmp = now.substring(0, len);
					//System.out.println("tmp : " + tmp);
					hm.put(now, 0);
					for(int j = 0; j < wordlist[now.length()].size(); j++) {
						if(wordlist[now.length()].get(j).startsWith(tmp)) {
							//System.out.println("ok : " + wordlist[now.length()].get(j));
							hm.replace(now, hm.get(now)+1);
						}
					}
				}

				answer[i] = hm.get(now);
			}
		}

		return answer;
	}

	public static int questionlen(String p, int type) {//물음표의 길이
		int len = 0;

		if(type == 0) {//앞이 ?
			for(int i = 0 ; i < p.length(); i++) {
				if(p.charAt(i) == '?') {
					len++;
				}else {
					break;
				}
			}
		}else {
			for(int i = p.length()-1; i>=0; i--) {
				if(p.charAt(i) == '?') {
					len++;
				}else {
					break;
				}
			}
		}

		return len;
	}

}
