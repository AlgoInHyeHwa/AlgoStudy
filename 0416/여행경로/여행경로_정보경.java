package test.programmers;
import java.util.*;

public class 여행경로_정보경 {
		
		static LinkedList<String> result = new LinkedList<>();
		
		public static void dfs(String tic[][], boolean visited[], String s, String input, int count) {
			s += "," + input;
			
			if(count == tic.length) {
				result.add(s);
			}
			
			for(int i=0; i<tic.length; i++) {
				if(tic[i][0].equals(input) && !visited[i]) {
					visited[i] = true;
					dfs(tic, visited, s, tic[i][1], count+1);
					visited[i] = false;
				}
			}
			
		}
		
		public static String[] solution(String[][] tickets) {
			for(int i=0; i<tickets.length; i++) {
				if(tickets[i][0].equals("ICN")) {
					boolean visited[] = new boolean[tickets.length];
					visited[i] = true;
					dfs(tickets, visited, "ICN", tickets[i][1],1);
					visited[i] = false;
				}
			}
			
			result.sort(null);
			
			return result.get(0).split(",");
	        
	    }
		
		public static void main(String[] args) {
			String[][] tickets =  {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
			
			solution(tickets);
	
		}

}
