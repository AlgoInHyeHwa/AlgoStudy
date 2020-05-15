#include <string>
#include <vector>

using namespace std;

int solution(string dartResult) {
    int answer = 0;
    vector<int> arr;
    int cnt = 0;
    int index = 0;
    int len = dartResult.size();
    
    for(int i = 0; i < len; i++){
        if(cnt == 0){
            int n = dartResult[i] - 48;
            arr.push_back(n);
        }
        else if(cnt == 1){
            if(dartResult[i] == '0'){
                arr[index] *= 10;
                cnt--;
            }
            else if(dartResult[i] == 'D')
                arr[index] *= arr[index];
            else if(dartResult[i] == 'T'){
                int n = arr[index];
                arr[index] =  n * n * n;
            }
        }
        else{
            if(dartResult[i] == '*'){
                arr[index] *= 2;
                if(index > 0)
                    arr[index - 1] *= 2;
            }
            else if(dartResult[i] == '#'){
                arr[index] *= -1;
            }
            else
                i--;
            index++;
        }
        cnt++;
        cnt %= 3;
    }
    
    for(int i = 0; i < 3; i++)
        answer += arr[i];
    
    return answer;
}