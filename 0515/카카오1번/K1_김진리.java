package algorithm;

public class kakao1 {
	
	public static String solution(int[] numbers, String hand) {
		
		String answer = "";
		int Lx = 0;
		int Ly = 3;
		int Rx = 2;
		int Ry = 3;
		int Mx,My;
		int x,x1,y,y1;
		
		for(int i = 0; i < numbers.length; i++) {
			
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				Lx = 0;
				answer = answer + "L";
				
				if(numbers[i] == 1) {
					Ly = 0;
				}
				else if(numbers[i] == 4) {
					Ly = 1;
				}
				else if(numbers[i] == 7) {
					Ly = 2;
				}
				
			}			
			else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				Rx = 2;
				answer = answer + "R";
				
				if(numbers[i] == 3) {
					Ry = 0;
				}
				else if(numbers[i] == 6) {
					Ry = 1;
				}
				else if(numbers[i] == 9) {
					Ry = 2;
				}
				
			}
			else if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
				Mx = 1;					
				if(numbers[i] == 2) {					
					My = 0;
					//왼손과의 거리 
					x = Mx - Lx;
					y = My - Ly;
					
					//오른손과의 거리 
					x1 = Mx - Rx;
					y1 = My - Ry;
					
					if((Math.abs(x)+Math.abs(y)) < (Math.abs(x1)+Math.abs(y1))) {
						answer = answer + "L";
						Lx = Mx;
						Ly = My;
					}
					else if((Math.abs(x)+Math.abs(y)) > (Math.abs(x1)+Math.abs(y1))) {
						answer = answer + "R";
						Rx = Mx;
						Ry = My;
					}
					else {
						if(hand == "left") {
							Lx = Mx;
							Ly = My;
							
							answer = answer + "L";
						}
						else if(hand == "right") {
							Rx = Mx;
							Ry = My;
							
							answer = answer + "R";
						}
					}	
					
				}
				
				else if(numbers[i] == 5) {
					My = 1;
					//왼손과의 거리 
					x = Mx - Lx;
					y = My - Ly;
					
					//오른손과의 거리 
					x1 = Mx - Rx;
					y1 = My - Ry;
					
					if((Math.abs(x)+Math.abs(y)) < (Math.abs(x1)+Math.abs(y1))) {
						answer = answer + "L";
						Lx = Mx;
						Ly = My;
					}
					else if((Math.abs(x)+Math.abs(y)) > (Math.abs(x1)+Math.abs(y1))) {
						answer = answer + "R";
						Rx = Mx;
						Ry = My;
					}
					else {
						if(hand == "left") {
							Lx = Mx;
							Ly = My;
							
							answer = answer + "L";
						}
						else if(hand == "right") {
							Rx = Mx;
							Ry = My;
							
							answer = answer + "R";
						}
					}	
					
				}
				
				else if(numbers[i] == 8) {
					My = 2;
					//왼손과의 거리 
					x = Mx - Lx;
					y = My - Ly;
					
					//오른손과의 거리 
					x1 = Mx - Rx;
					y1 = My - Ry;
					
					if((Math.abs(x)+Math.abs(y)) < (Math.abs(x1)+Math.abs(y1))) {
						answer = answer + "L";
						Lx = Mx;
						Ly = My;
					}
					else if((Math.abs(x)+Math.abs(y)) > (Math.abs(x1)+Math.abs(y1))) {
						answer = answer + "R";
						Rx = Mx;
						Ry = My;
						
					}
					else {
						if(hand == "left") {
							Lx = Mx;
							Ly = My;
							
							answer = answer + "L";
						}
						else if(hand == "right") {
							Rx = Mx;
							Ry = My;
							
							answer = answer + "R";
						}
					}	
					
				}
				else if(numbers[i] == 0) {
					My = 3;
					//왼손과의 거리 
					x = Mx - Lx;
					y = My - Ly;
					
					//오른손과의 거리 
					x1 = Mx - Rx;
					y1 = My - Ry;
				
					
					if((Math.abs(x)+Math.abs(y)) < (Math.abs(x1)+Math.abs(y1))) {
						answer = answer + "L";
						Lx = Mx;
						Ly = My;
					}
					else if((Math.abs(x)+Math.abs(y)) > (Math.abs(x1)+Math.abs(y1))) {
						answer = answer + "R";
						Rx = Mx;
						Ry = My;
					}
					else {
						
						if(hand == "left") {
							Lx = Mx;
							Ly = My;
							
							answer = answer + "L";
						}
						else if(hand == "right") {
							Rx = Mx;
							Ry = My;
							
							answer = answer + "R";
						}
					}	
					
				}
			}
			
			
		}
		
		
		return answer;
		
		
		
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = "right";
		System.out.println(solution(numbers, hand));
		
	}

}
