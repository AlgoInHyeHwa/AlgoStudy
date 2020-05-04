#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> registered_list, string new_id) {
    string answer = "";
    int index = 1;
    sort(registered_list.begin(), registered_list.end());
    for(int i = 0; i < registered_list.size(); i++){
        if(new_id.compare(registered_list[i]) == 0){
            string S = "";
            int N = 0;
            for(int j = 0; j < new_id.size(); j++){
                if('0' <= new_id[j] && new_id[j] <= '9'){
                    N += new_id[j] - '0';
                    N *= 10;
                }
                else{
                    string temp(1, new_id[j]);
                    S.append(temp);
                }
            }
            N /= 10;
            N += 1;
            S.append(to_string(N));
            new_id = S;
        }
    }
    if(answer.compare("") == 0)
        return new_id;
    return answer;
}