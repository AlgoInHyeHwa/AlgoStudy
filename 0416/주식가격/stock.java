package test.programmers;
import java.util.*;

public class stock {
    public static int[] solution(int[] prices) {
    	
        
        int[] answer = new int[prices.length];
        int sec = 0;
    	
        for(int i=0; i<prices.length; i++) {
        	sec = 0;
    		for(int j=i+1; j<prices.length; j++) {
    			if(prices[i] <= prices[j]) { 	// 가격이 떨어지지 않을 때 
    				answer[i] = ++sec; 
    			}else {							// 가격이 떨어질 때 
    				answer[i] = ++sec;
    				break;
    			}
    			
    		}
    		
    	}

        for(int i=0; i<answer.length; i++) {
        	System.out.println(answer[i]);
        }
        return answer;
        
    }
	public static void main(String[] args) {
		int[] prices = {3,2,1,2,3};
		solution(prices);
		
	}

}