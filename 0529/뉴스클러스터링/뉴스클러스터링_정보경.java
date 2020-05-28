import java.util.*;

class Solution {
	public static List<String> splitWords(String str) {
		List<String> words = new ArrayList<>();
		
		str = str.toLowerCase();
		
		for(int i=0; i<str.length()-1; i++) {
			if('a'<=str.charAt(i) && str.charAt(i)<='z'
					&& 'a'<=str.charAt(i+1) && str.charAt(i+1)<='z') {
				words.add(Character.toString(str.charAt(i))
						+ Character.toString(str.charAt(i+1)));
			} 
		}
		
		return words;
	}

	public static int solution(String str1, String str2) {
		int answer = 0;

		List<String> str1words = splitWords(str1);
		List<String> str2words = splitWords(str2);
	    List<String> union = new ArrayList<>();
	    List<String> intersec = new ArrayList<>();
	    
		for(String str: str1words) {
			if(str2words.remove(str)) {
				intersec.add(str);
			}
			union.add(str);
		}
		
		for(String str: str2words) {
			union.add(str);
		}
		
		if(union.size() == 0) {
			answer = 65536;
		}else {
			answer = (int)(((double)intersec.size() / (double)union.size()) * 65536);
		}
		
		return answer;
	}
}
