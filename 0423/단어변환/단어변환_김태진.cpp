#include <string>
#include <vector>
#include <stack>

using namespace std;

bool check(string a, string b){
    int cnt = 0;
    for(int i = 0; i < a.size(); i++){
        if(a[i]!=b[i])
            cnt++;
    }
    return (cnt == 1) ? true : false;
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    vector<vector<int>> visit;
    vector<int> map;
    vector<int> v;
    map.resize(words.size(), 0);
    for(int i = 0; i < words.size(); i++)
        visit.push_back(map);
    for(int i = 0; i < words.size(); i++){
        if(check(begin, words[i])){
            v.insert(v.begin(), i);
            if(words[i] == target)
                return 1;
        }
    }
    int temp = 0;
    while(!v.empty()){
        int front = v[0];
        v.erase(v.begin());
        temp++;
        if(words[front] == target){
            answer = temp;
            break;
        }
        for(int i = 0; i < words.size(); i++){
            if(check(words[i], words[front]) && visit[i][front] == 0 && visit[front][i] == 0){
                v.insert(v.begin(), i);
                visit[i][front] = 1;
                visit[front][i] = 1;
            }
        }
    }
    return answer;
}