#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> part_times) {
    int ans = 0;
    for(int i = 0; i < part_times.size() - 2; i++){
        vector<int> days(101, 0);
        int tmp = part_times[i][2];
        for(int a = part_times[i][0]; a < part_times[i][1]; a++)
            days[a] += 1;
        for(int j = i + 1; j < part_times.size() - 1; j++){
            tmp += part_times[j][2];
            for(int a = part_times[j][0]; a < part_times[j][1]; a++)
                days[a] += 1;
            for(int k = j + 1; k < part_times.size(); k++){
                for(int a = part_times[k][0]; a < part_times[k][1]; a++)
                    days[a] += 1;
                bool check = true;
                for(int a = 0; a < 102; a++){
                    if(days[a] > 1)
                        check = false;
                }
                if(check){
                    tmp += part_times[k][2];
                    if(tmp > ans)
                        ans = tmp;
                    tmp -= part_times[k][2];
                }
                for(int a = part_times[k][0]; a < part_times[k][1]; a++)
                    days[a] -= 1;
            }
            for(int a = part_times[j][0]; a < part_times[j][1]; a++)
                days[a] -= 1;
            tmp -= part_times[j][2];
        }
    }
    return ans;
}