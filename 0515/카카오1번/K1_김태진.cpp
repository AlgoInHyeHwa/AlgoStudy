#include <string>
#include <vector>
#include <math.h>

using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int lx = 0, ly = 3, rx = 2, ry = 3;
    for(int i = 0; i < numbers.size(); i++){
        if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
            lx = 0;
            answer += "L";
            if(numbers[i] == 1)
                ly = 0;
            else if(numbers[i] == 4)
                ly = 1;
            else
                ly = 2;
        }
        else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
            rx = 2;
            answer += "R";
            if(numbers[i] == 3)
                ry = 0;
            else if(numbers[i] == 6)
                ry = 1;
            else
                ry = 2;
        }
        else{
            int x = 1, y = 0;
            if(numbers[i] == 2)
                y = 0;
            else if(numbers[i] == 5)
                y = 1;
            else if(numbers[i] == 8)
                y = 2;
            else
                y = 3;
            if((abs(rx - x) + abs(ry - y)) > (abs(lx - x) + abs(ly - y))){
                answer += "L";
                lx = x;
                ly = y;
            }
            else if((abs(rx - x) + abs(ry - y)) < (abs(lx - x) + abs(ly - y))){
                answer += "R";
                rx = x;
                ry = y;
            }
            else{
                if(hand == "right"){
                    answer += "R";
                    rx = x;
                    ry = y;
                }
                else{
                    answer += "L";
                    lx = x;
                    ly = y;
                }
            }
        }
    }
    return answer;
}