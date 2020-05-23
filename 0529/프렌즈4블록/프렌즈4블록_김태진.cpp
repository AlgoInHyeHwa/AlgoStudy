#include <string>
#include <vector>

using namespace std;

vector<vector<int>> map;
vector<vector<bool>> visited;

int check(int x, int y){
    char c = map[x][y];
    if(map[x + 1].size() < y + 2)
        return 0;
    if((map[x][y + 1] == c) && (map[x + 1][y] == c) && (map[x + 1][y + 1] == c)){
        int sum = 0;
        if(!visited[x][y]){
            sum++;
            visited[x][y] = true;
        }
        if(!visited[x + 1][y]){
            sum++;
            visited[x + 1][y] = true;
        }
        if(!visited[x][y + 1]){
            sum++;
            visited[x][y + 1] = true;
        }
        if(!visited[x + 1][y + 1]){
            sum++;
            visited[x + 1][y + 1] = true;
        }
        return sum;
    }
    else
        return 0;
}

int solution(int m, int n, vector<string> board) {
    int answer = 0;
    map.resize(n);
    visited.resize(n);
    for(int i = m - 1; i > -1; i--){
        for(int j = 0; j < n; j++){
            map[j].push_back(board[i][j]);
            visited[j].push_back(false);
        }
    }
    int cnt;
    do{
        cnt = 0;
        for(int i = 0; i < (int)map.size() - 1; i++){
            for(int j = 0; j < (int)map[i].size() - 1; j++)
                cnt += check(i, j);
        }
        answer += cnt;
        for(int i = 0; i < visited.size(); i++){
            for(int j = visited[i].size() - 1; j > -1; j--){
                if(visited[i][j]){
                    visited[i][j] = false;
                    map[i].erase(map[i].begin() + j);
                }
            }
        }
    }while(cnt != 0);
    return answer;
}