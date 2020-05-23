#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> strs)
{
    sort(strs.begin(), strs.end());
    string temp = "";
    for(int i = 0; i < strs[0].size(); i++){
        if(strs[0][i] == strs[strs.size() - 1][i])
            temp += strs[0][i];
        else
            break;
    }
	return temp;
}