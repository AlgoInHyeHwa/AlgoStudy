import java.util.*;

class Solution {
    public long calculate(PriorityQueue<Integer> a){
        long sum = 0;
        while(!a.isEmpty())
            sum += Math.pow(a.poll(), 2);
        return sum;
    }
    
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> work = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : works){
            work.offer(i);
        }
        
        for(int i = 0; i < n; i++){
            int max = (int)work.poll();
            if(max <= 0)
                break;
            work.offer(max - 1);
        }
        
        return calculate(work);
    }
}