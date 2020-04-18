#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int max_cnt = 0;
vector<vector<string>> t;
vector<bool> visit;

void DFS(string s, vector<string> &answer, vector<string> &temp, int cnt){
    temp.push_back(s);
    
    if(max_cnt < cnt){
        max_cnt = cnt;
        answer = temp;
    }
    
    for(int i = 0; i < t.size(); i++){
        if(s == t[i][0] && !visit[i]){
            visit[i] = true;
            DFS(t[i][1], answer, temp, cnt + 1);
            visit[i] = false;
        }
    }
    
    temp.pop_back();
}

vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer, temp;
    t = tickets;
    visit.resize(tickets.size(), false);
    sort(t.begin(), t.end());
    DFS("ICN", answer, temp, 0);
    return answer;
}