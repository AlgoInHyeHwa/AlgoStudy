#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> s;
vector<int> e;
vector<string> name;
vector<string> content;

bool cmp(pair<string, int> a, pair<string, int> b){
    if(a.second < b.second)
        return true;
    else
        return false;
}

string solution(string m, vector<string> musicinfos) {
    string answer = "";
    for(int i = 0; i < m.size(); i++){
        int idx = 0;
        
        while(m.find("#", idx) != string::npos){
            idx = m.find("#", idx);
            char lower_alphabet = m[idx-1]-'A'+'a';
            string alphabet;
            alphabet += lower_alphabet;
            m.replace(idx-1, 2, alphabet);
        }
    }
    
    for(int i = 0; i < musicinfos.size(); i++){
        int idx = 0;
        
        while(musicinfos[i].find("#", idx) != string::npos){
            idx = musicinfos[i].find("#", idx);
            char lower_alphabet = musicinfos[i][idx-1]-'A'+'a';
            string alphabet;
            alphabet += lower_alphabet;
            musicinfos[i].replace(idx-1, 2, alphabet);
        }
    }
    
    for(int i = 0; i < musicinfos.size(); i++){
        int temp_start = 0;
        int temp_arrive = 0;
        
        string hour = musicinfos[i].substr(0,2);
        string minute = musicinfos[i].substr(3,2);
        
        temp_start = stoi(hour)*60 + stoi(minute);
        
        hour = musicinfos[i].substr(6,2);
        minute = musicinfos[i].substr(9,2);
        
        temp_arrive = stoi(hour)*60 + stoi(minute);
        
        s.push_back(temp_start);
        e.push_back(temp_arrive);
        
        int j;
        string temp_name;
        for(j = 12; musicinfos[i][j] != ','; j++)
            temp_name += musicinfos[i][j];
        name.push_back(temp_name);
        
        j++;
        string temp_content;
        for(int k = j; k < musicinfos[i].size(); k++)
            temp_content += musicinfos[i][k];
        content.push_back(temp_content);
    }
    
    int max_play = 0;
    vector<pair<string, int>> reserve;
    
    for(int i = 0; i < s.size(); i++){
        int diff = e[i]-s[i];
        string total_content;
        
        for(int j = 0; j < diff; j++)
            total_content += content[i][j % content[i].size()];
        
        if(total_content.find(m) != string::npos){
            if(diff > max_play){
                reserve.clear();
                
                max_play = diff;
                reserve.push_back({name[i], i});
            }
            else if(diff == max_play)
                reserve.push_back({name[i], i});
        }
    }
    
    if(reserve.size() == 0)
        answer = "(None)";
    else if(reserve.size() == 1)
        answer = reserve[0].first;
    else{
        sort(reserve.begin(), reserve.end(), cmp);   
        answer = reserve[0].first;
    }
    
    return answer;
}