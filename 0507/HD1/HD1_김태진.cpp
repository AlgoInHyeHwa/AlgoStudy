#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> purchase) {
    vector<int> answer;
    answer.resize(5);
    vector<int> mon;
    mon.push_back(31);
    mon.push_back(28);
    mon.push_back(31);
    mon.push_back(30);
    mon.push_back(31);
    mon.push_back(30);
    mon.push_back(31);
    mon.push_back(31);
    mon.push_back(30);
    mon.push_back(31);
    mon.push_back(30);
    // 0 브론즈, 1 실버, ...
    vector<int> cal(365, 0);
    for(int i = 0; i < purchase.size(); i++){
        int temp = 0;
        temp += purchase[i][5] - '0';
        temp *= 10;
        temp += purchase[i][6] - '0';
        int temp2 = 0;
        for(int j = 0; j < temp - 1; j++)
            temp2 += mon[j];
        temp = purchase[i][8] - '0';
        temp *= 10;
        temp += purchase[i][9] - '0';
        temp2 += temp - 1;
        temp = purchase[i][11] - '0';
        for(int j = 12; j < purchase[i].size(); j++){
            temp *= 10;
            temp += purchase[i][j] - '0';
        }
        int min = (temp2 > 15) ? temp2 - 15 : 0;
        for(int i = min; i < temp2; i++)
            cal[i] += temp;
        int max = (temp2 > 365) ? 365 : temp2 + 15;
        for(int i = temp2; i < max; i++)
            cal[i] += temp;
    }
    
    int index = 0;
    int cur = 0;
    for(int i = 0; i < 365; i++){
        cur = cal[i];
        if(cur < 10000)
            index = 0;
        else if(9999 < cur && cur < 20000)
            index = 1;
        else if(19999 < cur && cur < 50000)
            index = 2;
        else if(49999 < cur && cur < 100000)
            index = 3;
        else
            index = 4;
        answer[index]++;
    }
    
    return answer;
}