package test.programmers;
import java.util.*;

public class HDcard_3 {
	public static String solution(String[] reg_list, String new_id){
		String result = "";
		int n = new_id.length();
		
		String new_id_s = "";
		int new_id_n=0;
		
		//숫자가 언제 시작하는지 판별 
		for(int i=0; i<new_id.length();i ++) {
			if(Character.isDigit(new_id.charAt(i))) { //숫자가 있으면 
				n = i;
				new_id_n = Integer.parseInt(new_id.substring(i));
				break;
			};
		}

		
		//new_id의 S부분 
		new_id_s = new_id.substring(0, n); 
		
		boolean flag = false;
		
		for(int i=0; i<reg_list.length; i++) {
			if(reg_list[i].contains(new_id_s)) {	 //new_id의 S가 reg_list에 포함되는 지 
				if(new_id_n!=0) {	 // new_id의 n이 있을 경우 
					result = id_n(reg_list,new_id_s,new_id_n);
					break;
				}
				else {  	// new_id의 n이 없을 경우
					for(int j=0; j<reg_list.length;j++){
						if(result.equals(reg_list[j])) {
							flag = true;
							result = id_n(reg_list,new_id_s,1);
							break;
						}
					}
				}
				
				if(!flag) {
					result = new_id;
				}
				
			}
				
			}
		
				
		
		return result;
	}
	public static String id_n(String[] reg_list, String new_id_s, int new_id_n ){
		String result = "";
		boolean flag = true;
		while(true) {
			result = new_id_s + Integer.toString(new_id_n);
		    flag = true;
			for(int i=0; i<reg_list.length;i++){
				if(result.equals(reg_list[i])) {
					flag = false;
					new_id_n++;
				}
			}
			if(flag) {
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String new_id = "apple";
		String[] reg_list = {"apple1", "orange", "banana3"};

		
		String a= solution(reg_list, new_id);
		System.out.println(a);
		
		
	}

}
