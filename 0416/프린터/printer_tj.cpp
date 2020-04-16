#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    
    queue<pair<int, int>> q;
    priority_queue<int> q2;
    
    for(int i = 0; i < priorities.size(); i++){
        q.push(make_pair(i, priorities[i]));
        q2.push(priorities[i]);
    }
    
    while(!q.empty()){
        if(q.front().second == q2.top()){
            if(q.front().first == location){
                return answer + 1;
            }
            else{
                answer++;
                q.pop();
                q2.pop();
            }
        }
        else{
            q.push(q.front());
            q.pop();
        }
    }
    
    return answer;
}