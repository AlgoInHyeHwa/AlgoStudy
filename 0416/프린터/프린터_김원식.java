import java.util.Collections;
import java.util.PriorityQueue;

/* 우선순위 큐(PriorityQueue) */
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int priority;
        
        // 기본 : 최솟값 기준 우선순위
        // Collection.reverseOrder() : 최댓값 기준 우선순위
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 우선순위 큐 적용
        for(int i=0; i < priorities.length; i++){
            priority = priorities[i];
            pq.offer(priority);
        }
        
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(pq.peek() == priorities[i]){
                    pq.poll();
                    answer++;
                    if(location == i){
                        pq.clear();
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
