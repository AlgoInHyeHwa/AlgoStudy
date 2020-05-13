package test.baekjoon;

import java.util.*;

public class No1932_정수삼각형_DP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int height = sc.nextInt();
		int[][] map = new int[height][height];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j <= i; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=height-1; i>=1; i--) { //맨 밑줄부터 비교하면서 올라가기 
			for(int j=0; j<i; j++) {
				int left = map[i][j] + map[i-1][j];
				int right = map[i][j+1] + map[i-1][j];
				
				if(left>right) {
					map[i-1][j] = left;
				}else {
					map[i-1][j] = right;
				}
				
			}
		}
		
		System.out.println(map[0][0]);
	}

}
