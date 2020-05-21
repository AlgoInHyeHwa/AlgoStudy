package algorithm;

public class kakao3 {
	
    public static int solution(String dartResult) {
        int answer = 0;
        int index = 0;
        
        int[] result = new int[3];
        
        for(int i = 0; i < 3; i++) {
        	result[i] = 0;
        }
        
        
        for(int i = 0; i < dartResult.length(); i++) {           
            
            if('0' <= dartResult.charAt(i) && dartResult.charAt(i) <= '9') {
            	
            	if(result[index] != 0) {
            		result[index] = result[index] * 10;
            	}
            	else {
            		result[index] = Integer.parseInt(String.valueOf(dartResult.charAt(i)));
            	}
            		
            }
            else if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T') {
            	
            	if(dartResult.charAt(i) == 'D') {
            		result[index] *= result[index];
            	}
            	else if(dartResult.charAt(i) == 'T') {
            		int temp = result[index];
            		result[index] = temp * temp * temp;
            	} 
            	
            	if(i + 1 < dartResult.length()) {
            		if(dartResult.charAt(i+1) == '*' || dartResult.charAt(i+1) == '#') {
                    	if(dartResult.charAt(i+1) == '*') {
                    		if(index > 0)
                    			 result[index - 1] *= 2;
                    		result[index] = result[index] * 2;
                    	}
                    	else if(dartResult.charAt(i+1) == '#') {
                    		result[index] = result[index] * (-1);
                    	}  
                    }
            	
            	}
            	index++;
            }
            
        }
        
        for(int j = 0; j < 3; j++) {
        	answer += result[j];
        	System.out.println(result[j]);
        }
        
        System.out.print(answer);
        
        return answer;
    }

    public static void main(String[] args) {
		
		String result = "1D2S#10S";
		
		solution(result);		
		
	}
}
