#include <string>
#include <vector>

using namespace std;

int solution(vector<string> ip_addrs, vector<string> langs, vector<int> scores) {
    int answer = 0;
    vector<pair<string, int>> ips;
    for(int i = 0; i < ip_addrs.size(); i++){
        bool check = false;
        for(int j = 0; j < ips.size(); j++){
            if(ips[j].first.compare(ip_addrs[i]) == 0){
                ips[j].second++;
                check = true;
            }
        }
        if(!check)
            ips.push_back(make_pair(ip_addrs[i], 1));
    }
    
    for(int i = 0; i < ips.size(); i++){
        if(ips[i].second > 3)
            answer += ips[i].second;
        else if(ips[i].second == 3){
            vector<string> temp(3, "");
            int index = 0;
            for(int j = 0; j < ip_addrs.size(); j++){
                if(ip_addrs[j].compare(ips[i].first) == 0){
                    if(langs[j].compare("C") == 0 || langs[j].compare("C++") == 0 || langs[j].compare("C#") == 0 )
                        temp[index] = "C";
                    else
                        temp[index] = langs[j];
                    index++;
                }
            }
            if(temp[0].compare(temp[1]) == 0 && temp[1].compare(temp[2]) == 0)
                answer += 3;
        }
        else if(ips[i].second == 2){
            vector<int> temp(2, 0);
            int index = 0;
            for(int j = 0; j < ip_addrs.size(); j++){if(ip_addrs[j].compare(ips[i].first) == 0){
                    temp[index] = scores[j];
                    index++;
                }
            }
            if(temp[0] == temp[1])
                answer += 2;
        }
    }
    if(answer == 0)
        return -1;
    else
        return ip_addrs.size() - answer;
}