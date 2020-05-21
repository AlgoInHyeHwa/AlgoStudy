import java.util.*;
class Solution {
    public static int solution(String dartResult) {
        
    	int answer = 0;
        int now = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        
        for(int i=0; i<dartResult.length(); i++) {
        	
        	if(0<=dartResult.charAt(i)-'0' && dartResult.charAt(i)-'0'<=9) {
        		
        		if(i>0 && dartResult.charAt(i)-'0'==0) {
        			if(dartResult.charAt(i-1)-'0'==1) {
        				a.set(a.size() - 1, 10);
        				
        			}else {
        				a.add(dartResult.charAt(i)-'0');
        			}
        		}
        		else {
        			a.add(dartResult.charAt(i)-'0');
        			
        		}
        	} 
        	
        	else if(dartResult.charAt(i) == 'S') {
        		
        		
        	}
        	
        	else if(dartResult.charAt(i) == 'D') {
        		a.set(a.size() - 1, a.get(a.size() - 1)*a.get(a.size() - 1));
        		
        	}
        	else if(dartResult.charAt(i) == 'T') {
        		a.set(a.size() - 1,  a.get(a.size() - 1)*a.get(a.size() - 1)*a.get(a.size() - 1));
        	}
        	
        	else if(dartResult.charAt(i) == '#') {
        		a.set(a.size() - 1, a.get(a.size() - 1)*(-1));
        	}
			else if(dartResult.charAt(i) == '*') {
				a.set(a.size() - 1, a.get(a.size() - 1)*2);
				if(a.size()>1) {
					a.set(a.size() - 2, a.get(a.size() - 2)*2);
				}
        		
			   	
			} 
        	
        
        	
        }
        
        for(int i=0; i<a.size(); i++) {
        	//System.out.println(a.get(i));
        	answer += a.get(i);
        }
        return answer;
}
}
