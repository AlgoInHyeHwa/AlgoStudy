#include <vector>
#include <math.h>
#include <iostream>
#define PI 3.1415926535

using namespace std;

int solution(int x, int y, int r, int d, vector<vector<int> > target)
{
    int answer = 0;
    
    int t1 = atan2(y, x) * 180 / PI + d;
    int t2 = atan2(y, x) * 180 / PI - d;
    for(int i = 0; i < target.size(); i++){
        if((abs(target[i][0]) + abs(target[i][1])) <= r && t2 < atan2(target[i][1], target[i][0]) * 180 / PI && atan2(target[i][1], target[i][0]) * 180 / PI < t1)
            answer++;
    }
    
    
    return answer;
}