package algorithm;

public class kakao2 {

	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
        	
        	String a1 = "";
        	String a2 = "";

    		for(int k = arr1[i]; k > 0; k /= 2) {
    			a1 = String.valueOf(k%2) + a1;
    		}    			   
			
			for(int l = a1.length(); l < n; l++) {
				 a1 = '0' + a1;
			}
			
    		for(int k = arr2[i]; k > 0; k /= 2) {
    			a2 = String.valueOf(k%2) + a2;
    		}    			   
			
			for(int l = a2.length(); l < n; l++) {
				 a2 = '0' + a2;
			}

        	answer[i] = "";

        	for(int j = 0 ; j < a1.length(); j++) {
        		if(a1.charAt(j) == '1' || a2.charAt(j) == '1') {

            		answer[i] += '#';
            	}
            	else if(a1.charAt(j) == '0' && a2.charAt(j) == '0') {

            		answer[i]+= ' ';
            	}
        	}
                	
        	System.out.println(answer[i]);
        	
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		
		solution(n,arr1,arr2);		
		
	}
	
}
