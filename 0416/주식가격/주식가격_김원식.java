class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i < answer.length; i++)
        {
            for(int j=i+1; j < answer.length; j++)
            {
                if(prices[i] > prices[j])
                {
                    answer[i] = j-i;
                    break;
                }
                if (j == answer.length-1)
                {
                    answer[i] = j-i;
                }
            }
        }
        return answer;
    }
}
