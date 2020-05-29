package algorithm;

import java.util.ArrayList;

public class kakao4 {

	public static int solution(String str1, String str2) {
		
        int answer = 0;
        
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();
        
        ArrayList<String> string1 = new ArrayList<>();
        ArrayList<String> string2 = new ArrayList<>();
      
        ArrayList<String> intersection = new ArrayList<>(); //교집합 
        

        for(int i = 0; i < str1.length()-1; i++) {
        	char a = s1.charAt(i);
        	char b = s1.charAt(i+1);
        	
        	if('a' <= a && a <= 'z' && 'a' <=  b && b <= 'z') {
        		string1.add(Character.toString(a)+Character.toString(b));
        	}
        	
        }
        
        for(int i = 0; i < str2.length()-1; i++) {
        	char a = s2.charAt(i);
        	char b = s2.charAt(i+1);
        	
        	if('a' <= a && a <= 'z' && 'a' <=  b && b <= 'z') {
        		string2.add(Character.toString(a)+Character.toString(b));
        	}
        	
        }

        for(String str : string1) {
        	if(string2.remove(str)) {
        		intersection.add(str);
        	}    	
        }
        
        for(String str : string2) {
        	string1.add(str);
        }
       
        answer = (int)((double)intersection.size()/(double)string1.size() * 65536);
        
        if(string1.size() == 0) {
        	answer = 65536;
        }
        
        System.out.println(answer);

        return answer;
    }

	public static void main(String[] args) {

		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";

		solution(str1, str2);

	}
}
