#include <string>
#include <vector>
#include <math.h>

using namespace std;

vector<long long> keep1;
vector<char> keep2;
vector<long long> v;
vector<char> o;

void add(){
    for(int i = 0; i < o.size();){
        if(o[i] == '+'){
            v[i] = v[i] + v[i + 1];
            o.erase(o.begin() + i);
            v.erase(v.begin() + i + 1);
        }
        else
            i++;
    }
}
void sub(){
    for(int i = 0; i < o.size();){
        if(o[i] == '-'){
            v[i] = v[i] - v[i + 1];
            o.erase(o.begin() + i);
            v.erase(v.begin() + i + 1);
        }
        else
            i++;
    }
}
void mul(){
    for(int i = 0; i < o.size();){
        if(o[i] == '*'){
            v[i] = v[i] * v[i + 1];
            o.erase(o.begin() + i);
            v.erase(v.begin() + i + 1);
        }
        else
            i++;
    }
}
long long fmax(){
    long long tmp = 0;
    add();
    sub();
    mul();
    tmp = v.front();
    tmp = abs(tmp);
    v.pop_back();
    long long tmp2 = 0;
    for(int i = 0; i < keep1.size(); i++)
        v.push_back(keep1[i]);
    for(int i = 0; i < keep2.size(); i++)
        o.push_back(keep2[i]);
    add();
    mul();
    sub();
    tmp2 = v.front();
    tmp2 = abs(tmp2);
    v.pop_back();
    if(tmp2 > tmp)
        tmp = tmp2;
    for(int i = 0; i < keep1.size(); i++)
        v.push_back(keep1[i]);
    for(int i = 0; i < keep2.size(); i++)
        o.push_back(keep2[i]);
    sub();
    add();
    mul();
    tmp2 = v.front();
    tmp2 = abs(tmp2);
    v.pop_back();
    if(tmp2 > tmp)
        tmp = tmp2;
    for(int i = 0; i < keep1.size(); i++)
        v.push_back(keep1[i]);
    for(int i = 0; i < keep2.size(); i++)
        o.push_back(keep2[i]);
    sub();
    mul();
    add();
    tmp2 = v.front();
    tmp2 = abs(tmp2);
    v.pop_back();
    if(tmp2 > tmp)
        tmp = tmp2;
    for(int i = 0; i < keep1.size(); i++)
        v.push_back(keep1[i]);
    for(int i = 0; i < keep2.size(); i++)
        o.push_back(keep2[i]);
    mul();
    sub();
    add();
    tmp2 = v.front();
    tmp2 = abs(tmp2);
    v.pop_back();
    if(tmp2 > tmp)
        tmp = tmp2;
    for(int i = 0; i < keep1.size(); i++)
        v.push_back(keep1[i]);
    for(int i = 0; i < keep2.size(); i++)
        o.push_back(keep2[i]);
    mul();
    add();
    sub();
    tmp2 = v.front();
    tmp2 = abs(tmp2);
    v.pop_back();
    if(tmp2 > tmp)
        tmp = tmp2;
    return tmp;
}
long long solution(string expression) {
    long long answer = 0;
    int fi = 0, ei = 0;
    for(int i = 0; i < expression.length(); i++){
        if('0' <= expression[i] && expression[i] <= '9')
            ei++;
        else if(expression[i] == '*' || expression[i] == '+' || expression[i] == '-'){
            string tmp = expression.substr(fi, ei - fi);
            fi = ++ei;
            v.push_back(atoi(tmp.c_str()));
            o.push_back(expression[i]);
        }
    }
    string tmp = expression.substr(fi, ei - fi);
    v.push_back(atoi(tmp.c_str()));
    for(int i = 0; i < v.size(); i++)
        keep1.push_back(v[i]);
    for(int i = 0; i < o.size(); i++)
        keep2.push_back(o[i]);
    answer = fmax();
    answer = abs(answer);
    return answer;
}