package test.programmers;

public class TargetNumber {
	static public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
	
	static public int dfs(int[] numbers, int node, int sum, int target) {
		if(node == numbers.length) {
			if(sum == target) 
				return 1;
			return 0;
		}
		return dfs(numbers, node+1, sum+numbers[node], target)
				+ dfs(numbers, node+1, sum-numbers[node], target);
	}
	
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 5;
		
		int solution = solution(numbers,target);
		System.out.println(solution);
	}

}
