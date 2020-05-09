#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<vector<int>> v1;
vector<int> v2;
int map[100001] = {0, };

bool check(int n){
    for(int i = 0; i < v2.size(); i++){
        if(v2[i] == n)
            return false;
    }
    return true;
}

vector<int> solution(int total_sp, vector<vector<int>> skills) {
    vector<int> answer;
    vector<int> tmp;
    tmp.push_back(skills[0][0]);
    tmp.push_back(skills[0][1]);
    v1.push_back(tmp);
    map[skills[0][0]] += 2;
    map[skills[0][1]] += 1;
    
    if(check(skills[0][0]))
        v2.push_back(skills[0][0]);
    if(check(skills[0][1]))
        v2.push_back(skills[0][1]);
    for(int i = 1; i < skills.size(); i++){
        int j = 0;
        map[skills[i][0]] += 2;
        map[skills[i][1]] += 1;
        if(check(skills[i][0]))
            v2.push_back(skills[i][0]);
        if(check(skills[i][1]))
            v2.push_back(skills[i][1]);
        for(; j < v1.size(); j++){
            if(skills[i][0] == v1[j][0]){
                v1[j].push_back(skills[i][1]);
                break;
            }
        }
        if(j != v1.size() - 1){
            vector<int>tmp;
            if(map[skills[i][0]] > 0)
                map[skills[i][0]] -= 1;
            tmp.push_back(skills[i][0]);
            tmp.push_back(skills[i][1]);
            v1.push_back(tmp);
        }
    }
    for(int i = 1; i < v1.size(); i++){
        for(int j = 0; j < v1[0].size(); j++){
            if(v1[i][0] == v1[0][j])
                map[v1[i][0]] /= 2;
        }
    }
    sort(v2.begin(), v2.end());
    int cnt = 0;
    for(int i = 1; i < v2.size() + 1; i++){
        if(map[i] == 0)
            break;
        cnt += map[i];
    }
    cnt = total_sp / cnt;
    for(int i = 1; i < v2.size() + 1; i++){
        map[i] *= cnt;
        answer.push_back(map[i]);
    }
    return answer;
}