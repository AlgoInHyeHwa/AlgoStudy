package test.programmers;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Printer2 {
	
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());     
        
        for(int priority : priorities) {
        	pq.offer(priority);
        } 
        
        
        int count = 0;
        
        while(!pq.isEmpty()) {
        	for(int i=0; i<priorities.length; i++) {
        		if(pq.peek() == priorities[i]) {
        			pq.poll();
        			count++;
        			if(location == i) {
        				pq.clear();
        				answer = count;
        				break;
        			}
        		}
        	}
        	
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[] priorities = {2,3,2,5,4};
		int location = 2;
		int a = solution(priorities,location);
		System.out.println(a);

	}

}
