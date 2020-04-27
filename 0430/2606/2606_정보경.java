package test.baekjoon;

import java.util.*;

public class no2606_virus_BFS {
	static int v,e;
	static int[][] map;
	static boolean[] visited;
	static int answer;
	
	public static void bfs(int start, int[][] map, boolean[] visited, int answer) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0; i<map.length; i++) {
				if(!visited[map[i][1]] && temp==map[i][0]) {
					visited[map[i][0]] = true;
					q.add(map[i][1]);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		map = new int[e][2];
		visited = new boolean[v+1];
		answer = 0;
		
		for(int i=0; i<e; i++) {
			for(int j=0; j<2; j++) {
				map[i][j] = sc.nextInt();
				
			}
		}
	
		bfs(1, map, visited, 0);
		
	}

}
