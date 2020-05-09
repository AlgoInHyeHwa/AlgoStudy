package test.programmers;
import java.util.*;

public class HDcard_2 {
	public static int solution(String[] ip, String[] langs, int[] score) {
		int result=0;
		ArrayList<Integer> answerList = new ArrayList<>();
		boolean[] visited = new boolean[ip.length];
		
		//C언어끼리는 다 같게 변경 
		for(int i=0; i<langs.length;i++) {
			if(langs[i].contains("C")) {
				langs[i] = "C";
			}
		}
		
		int ipcount = 1;
		ArrayList<Integer> arrayList = new ArrayList<>();
	
	
		for(int i=0; i<ip.length;i++) {
			if(!visited[i]) {
				arrayList.add(i);
				visited[i] = true;
				
				//System.out.println("i:"+i);
				for(int j=i+1; j<ip.length; j++) {
					if(!visited[j]) {
						if(ip[i] == ip[j]) {
							visited[j] = true;
							
							ipcount++;
							arrayList.add(j);
							
							
						}
					}
				}
				
				if(ipcount == 2) {
					if(arrayList.size()==2) {
						
						if(langs[arrayList.get(0)]==langs[arrayList.get(1)] && score[arrayList.get(0)]==score[arrayList.get(1)]) {
							answerList.add(arrayList.get(0));
							answerList.add(arrayList.get(1));
							
						}
					}
				}
				if(ipcount == 3) {
					
					if(arrayList.size()==3) {
						
						if(langs[arrayList.get(0)]==langs[arrayList.get(1)] && langs[arrayList.get(1)]==langs[arrayList.get(2)]) {
							answerList.add(arrayList.get(0));
							answerList.add(arrayList.get(1));
							answerList.add(arrayList.get(2));
							
						}
						
					}
				}
				if(ipcount == 4) {
					
					for(int k=0; k<arrayList.size(); k++) {
						answerList.add(arrayList.get(k));
					}
				}
				
				ipcount = 1;
				arrayList.clear();
				}
			
		}

		
		result = ip.length - answerList.size();
		
		
		return result;
	}
	public static void main(String[] args) {
		String[] ip_addrs = {"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"};
		String[] langs = {"Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript"};
		int[] scores = {294, 197, 373, 45, 294, 62, 373, 373};
		
		int a = solution(ip_addrs,langs,scores);
		System.out.println(a);

		
	}
	
	}

