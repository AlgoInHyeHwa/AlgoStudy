package test.programmers;

import java.util.Stack;

public class IronBar {
    static public int solution(String arrangement) {
        int answer = 0;
         
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<arrangement.length();i++) {
        	if( arrangement.charAt(i) == '(' )
        		stack.add(arrangement.charAt(i));
        	else {
        		stack.pop();
        		if( arrangement.charAt(i-1) == '(' )
        			answer += stack.size();
        		else
        			answer++;
        	}

        } 
        return answer;
     
    }    
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(arrangement.length());
		int a = solution(arrangement);
		

	}

}
