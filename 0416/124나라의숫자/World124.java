package test.programmers;

import java.util.*;

public class World124 {

	static public String solution(int n) {
		String answer = "";
		int remainder;
		
		while(n > 0) {
			remainder = n%3;
			n = n/3;
			
			if(remainder == 0) {
				remainder = 4;
				n = n-1;
			}
			
			answer = remainder + answer;
			

		}
		

	    
		return answer;
	}  
		
	public static void main(String[] args) {
		 
		System.out.println(solution(12));

	}

}
