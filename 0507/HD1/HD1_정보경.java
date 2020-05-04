package test.programmers;

public class HDcard_1 {
	public static int[] solution(String[] purchase) {
		int[] answer = new int[5];
		int[] allPur = new int[365];
		
		int[][] date = new int[purchase.length][2];
		int[] money = new int[purchase.length];
		
		for(int i=0; i<purchase.length; i++) {
			String[] pur = purchase[i].split(" ");
			String[] p = pur[0].split("/");
			
			date[i][0] = Integer.parseInt(p[1]);
			date[i][1] = Integer.parseInt(p[2]);
			
			money[i] = Integer.parseInt(pur[1]);
		}
		
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int i=0; i<purchase.length; i++) {
			if(date[i][0]==1) {
				for(int j=date[i][1]-1; j<date[i][1]-1+30; j++) {
					allPur[j] += money[i];
				}
			}else{
				for(int j=0; j<date[i][0]-1; j++) {
					date[i][1] += days[j];
				}
				
				for(int j=date[i][1]-1; j<date[i][1]-1+30; j++) {
					allPur[j] += money[i];
				}
			}
		}
		
		for(int i=0; i<allPur.length; i++) {
			System.out.println(allPur[i]);
		}
		
		for(int i=0; i<allPur.length;i++) {
			if(0<=allPur[i] && allPur[i]<10000) {
				answer[0]++;
			}
			else if(10000<=allPur[i] && allPur[i]<20000) {
				answer[1]++;
			}
			else if(20000<=allPur[i] && allPur[i]<50000) {
				answer[2]++;
			}
			else if(50000<=allPur[i] && allPur[i]<100000) {
				answer[3]++;
			}else {
				answer[4]++;
			}
		}
		
		for(int i=0; i<answer.length;i++){
			System.out.print(answer[i]+" ");
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String[] purchase = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
		
		solution(purchase);

	}

}
