package test.kakao;

import java.util.*;

public class KaKao2020_1 {
	static int[][] phone = new int[4][3];
	static boolean[][] visit = new boolean[4][3];
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Pos {
		int x;
		int y;
		int count;
		
		Pos(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static int bfs(Pos pos,Pos nextNumber) {
		int count = 0;
		int result = 0;
		
		Queue<Pos> q = new LinkedList<Pos>();
		
		q.add(pos);
		visit[pos.x][pos.y] = true;
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			count++;
			if(temp.x == nextNumber.x && temp.y == nextNumber.y) {
				result = temp.count-1;
				break;
			}
			for(int i=0; i<4; i++) {
				int mx = temp.x + dx[i];
				int my = temp.y + dy[i];
				if(0<=mx && mx<=3 && 0<=my && my<=2) {
					if(!visit[mx][my]) {
						visit[mx][my] = true;
						q.add(new Pos(mx,my,count));
					}
				}
			}
		}
		return result;
	}
	public static String solution(int[] numbers, String hand) {
		String result = "";
		
		int n = 1;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				phone[i][j] = n;
				n++;
			}
		}
		
		phone[3][0] = 10;
		phone[3][1] = 0;
		phone[3][2] = 10;
		
		Pos left = new Pos(3,0,0);    //처음 왼손 엄지 손가락 위치 지정 
		Pos right = new Pos(3,2,0);	  //처음 오른손 엄지 손가락 위치 지정 
		
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) { //1,4,7번 일 때 
				result += "L";
				for(int j=0; j<3; j++) {						  //왼손 엄지손가락 위치 지정 
					if(phone[j][0] == numbers[i]) {
						left.x = j;
						left.y = 0;
					} 
				}
			}
			
			if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) { //3,6,9번 일 때
				result += "R";
				for(int j=0; j<3; j++) {						  //오른손 엄지손가락 위치 지정 
					if(phone[j][2] == numbers[i]) {
						right.x = j;
						right.y = 2;
					} 
				}
			}
			
			if(numbers[i]==2 || numbers[i]==5 || numbers[i]==8 || numbers[i]==0) { //가운데 줄 번호 일 때 
				Pos nextNumber = null;
				for(int j=0; j<4; j++) {
					if(phone[j][1] == numbers[i]) {
						nextNumber = new Pos(j,1,0);
					}
				}
				

				int leftCount = bfs(left,nextNumber); //left거리계산
				
				for(int j=0; j<visit.length; j++) {   //visit배열 초기화 
					for(int k=0; k<visit[0].length; k++) {
						visit[j][k] = false;
					}
				}
				

				int rightCount = bfs(right,nextNumber);
				
				for(int j=0; j<visit.length; j++) {   //visit배열 초기화 
					for(int k=0; k<visit[0].length; k++) {
						visit[j][k] = false;
					}
				}
				
				if(leftCount < rightCount) {
					left.x = nextNumber.x;
					left.y = nextNumber.y;
					result += "L";
				}else if(leftCount > rightCount) {
					right.x = nextNumber.x;
					right.y = nextNumber.y;
					result += "R";
				}else {						//leftCount 와 rightCount 같을 때 
					if(hand == "right") { //오른손잡이일 때 
						right.x = nextNumber.x;
						right.y = nextNumber.y;
						right.count = 0;  //right count 초기화 
						result += "R";
					}else {				//왼손잡이일 때
						left.x = nextNumber.x;
						left.y = nextNumber.y;
						left.count = 0;	//left count 초기
						result += "L";
					}
				}
				
				
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}

}
