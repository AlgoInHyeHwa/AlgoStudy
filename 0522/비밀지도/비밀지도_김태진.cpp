#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<string> arrchange(vector<int> arr, int n){
    vector<string> temp;
    for(int i = 0; i < n; i++){
        string temp1 = "";
        string temp2 = "";
        int j = arr[i];
        while(j != 0){
            if(j % 2 == 0)
                temp1 += " ";
            else
                temp1 += "#";
            j /= 2;
        }
        for(int k = temp1.size(); k < n; k++)
            temp2 += " ";
        for(int k = temp1.size() - 1; k > - 1; k--)
            temp2 += temp1[k];
        temp.push_back(temp2);
    }
    return temp;
}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    vector<string> atemp1;
    vector<string> atemp2;
    atemp1 = arrchange(arr1, n);
    atemp2 = arrchange(arr2, n);
    for(int i = 0; i < n; i++){
        string temp = "";
        for(int j = 0; j < n; j++){
            if(atemp1[i][j] == '#' || atemp2[i][j] == '#')
                temp += "#";
            else
                temp += " ";
        }
        answer.push_back(temp);
    }
    return answer;
}