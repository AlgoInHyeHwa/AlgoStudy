package test.baekjoon;

import java.util.*;

public class no2606_virus_BFS {
	static int v,e;
	static int[][] map;
	static boolean[] visited;
	static int answer=0;

	public static void dfs(int start) {
		visited[start] = true;


		for(int i=1; i<map.length;i++) {
			if( map[start][i] == 1 && !visited[i] ) {
				answer++;
				dfs(i);
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		v = sc.nextInt();
		e = sc.nextInt();

		map = new int[v+1][v+1];
		visited = new boolean[v+1];

		int temp1, temp2;

		for(int i=1; i<=e; i++) {
			temp1 = sc.nextInt();
			temp2 = sc.nextInt();
			map[temp1][temp2] = map[temp2][temp1] = 1;

		}

		dfs(1);
		System.out.println(answer);

	}

}
