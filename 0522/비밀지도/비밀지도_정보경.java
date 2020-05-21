package test.programmers;
import java.util.*;

public class 비밀지도 {

	private static String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	        String[] a1 = new String[n];
	        String[] a2 = new String[n];
	        
	        for(int i=0; i<n; i++) {
	        	a1[i] = "";
	        	a2[i] = "";
	        }
	        
	        for(int i=0; i<n; i++){
	            while(arr1[i]>0){
	                a1[i] = Integer.toString(arr1[i]%2) + a1[i];
	                arr1[i] = arr1[i]/2;
	                
	            }
	           
	        }
	        
	        
	        for(int i=0; i<n; i++) {
	        	for(int j=a1[i].length(); j<n; j++) {
	        		a1[i] = "0" + a1[i];
	        	}
	        }

	        
	        for(int i=0; i<n; i++){
	            while(arr2[i]>0){
	                a2[i] = Integer.toString(arr2[i]%2) + a2[i];
	                arr2[i] = arr2[i]/2;
	                
	            }
	        }
	        
	        for(int i=0; i<n; i++) {
	        	for(int j=a2[i].length(); j<n; j++) {
	        		a2[i] = "0" + a2[i];
	        	}
	        }
	        

	        
	        for(int i=0;i<n; i++) {
	        	answer[i] = "";
	        }
	        for(int i=0; i<n; i++) {
	        	for(int j=0; j<n; j++) {
	        		if(a1[i].charAt(j) == '1'|| a2[i].charAt(j)=='1') {
		        		answer[i] += "#"; 
		        	}
	        		else {
	        			answer[i] += " ";
	        		}
	        	}
	        	
	        }
	        
	        for(String a: answer) {
	        	System.out.println(a);
	        }
	       
	        return answer;
	}

	 
	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		
		String[] a = solution(n,arr1,arr2);
		

	}

}
