#include <string>
#include <set>
#include <vector>
#include <algorithm>

using namespace std;

const bool chckalpha(char c){
    return 65 <= c && c <= 90;
}

multiset<string> split(string s1){
    multiset<string> m1;
    for(int i = 0; i < s1.size() - 1; i++){
        if(!chckalpha(s1[i]) || !chckalpha(s1[i + 1]))
            continue;
        string s2;
        s2 += s1[i];
        s2 += s1[i + 1];
        m1.insert(s2);
    }
    return m1;
}

int solution(string str1, string str2) {
    int answer = 0;
    std::transform(str1.begin(), str1.end(), str1.begin(), ::toupper);
    std::transform(str2.begin(), str2.end(), str2.begin(), ::toupper);
    multiset<string> str1_vec = split(str1);
    multiset<string> str2_vec = split(str2);
    vector<string> uv(str1_vec.size() + str2_vec.size());
    const auto ub = std::set_union(str1_vec.begin(), str1_vec.end(), str2_vec.begin(), str2_vec.end(), uv.begin());
    uv.erase(ub, uv.end());
    vector<string> iv(str1_vec.size() + str2_vec.size());
    const auto ib = std::set_intersection(str1_vec.begin(), str1_vec.end(), str2_vec.begin(), str2_vec.end(), iv.begin());
    iv.erase(ib, iv.end());
    const pair<double, double> p = make_pair(uv.size(), iv.size());
    if(p.first == 0 && p.second == 0)
        answer = 65536;
    else
        answer = (p.second / p.first) * 65536;
    return answer;
}