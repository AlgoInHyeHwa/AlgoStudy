#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<string> con;

vector<int> solution(vector<string> gems) {
    vector<int> answer(2, 0);
    for(int i = 0; i < gems.size(); i++){
        bool check = true;
        for(int j = 0; j < con.size(); j++){
            if(gems[i] == con[j])
                check = false;
        }
        if(check)
            con.push_back(gems[i]);
    }
    int len = 99999, tmp = 0, si = 0, ei = 0, chk = 0;
    if(con.size() == 1){
        answer[0] = 1;
        answer[1] = 1;
        return answer;
    }
    else if(con.size() == gems.size()){
        answer[0] = 1;
        answer[1] = gems.size();
        return answer;
    }
    while(si < gems.size() - con.size()){
        vector<int> ctmp(con.size(), 0);
        while(gems[si] == gems[si + 1])
            si++;
        ei = si;
        for(int i = si; i < gems.size() && len > ei - si; i++){
            int idx = 0;
            bool pass = false;
            while(i < gems.size() - 2 && gems[i] == gems[i + 1]){
                i++; ei++;
            }
            for(; idx < con.size(); idx++){
                if(gems[i] == con[idx]){
                    pass = true;
                    break;
                }
            }
            if(pass)
                ctmp[idx]++;
            bool check = true;
            for(int j = 0; j < ctmp.size(); j++){
                if(ctmp[j] == 0){
                    check = false;
                    break;
                }
            }
            if(check){
                if(len > ei - si){
                    len = ei - si;
                    answer[0] = si + 1;
                    answer[1] = ei + 1;
                    break;
                }
            }
            ei++;
        }
        si++;
    }
    return answer;
}