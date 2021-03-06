#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int const max_size = 7;
vector<vector<int>> map(max_size);
vector<vector<bool>> visited;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int cnt;


void bfs(int x, int y){
    visited[x][y] = true;
    cnt++;
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(0 < nx && nx < max_size && 0 < ny && ny < map[nx].size() && map[x][y] == map[nx][ny] && !visited[nx][ny])
            bfs(nx, ny);
    }
    visited[x][y] = false;
}
void dbfs(int x, int y){
    visited[x][y] = true;
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(0 < nx && nx < max_size && 0 < ny && ny < map[nx].size() && map[x][y] == map[nx][ny] && !visited[nx][ny])
            dbfs(nx, ny);
    }
    map[x][y] = 0;
    visited[x][y] = false;
}

vector<string> solution(vector<vector<int>> macaron) {
    vector<string> answer;
    for(int i = 0; i < max_size; i++){
        vector<bool> temp(max_size, false);
        visited.push_back(temp);
        map[i].push_back(0);
    }
    for(int i = 0; i < macaron.size(); i++){
        map[macaron[i][0]].push_back(macaron[i][1]);
        cnt = 0;
        bfs(macaron[i][0], map[macaron[i][0]].size() - 1);
        if(cnt > 2){
            dbfs(macaron[i][0], map[macaron[i][0]].size() - 1);
            for(int j = 1; j < max_size; j++){
                int tmp = 0;
                for(int k = 1; k < map[j].size(); k++)
                    if(map[j][k] == 0)
                        tmp++;
                if(tmp > 0){
                    int idx = 1;
                    while(1){
                        if(idx == map[j].size())
                            break;
                        if(map[j][idx] == 0)
                            map[j].erase(map[j].begin() + idx);
                        else
                            idx++;
                    }
                }
            }
            int max_cnt = 0;
            for (int a = 0; a < max_size; a++) {
                if (map[a].size() < 2)
                    continue;
                for (int b = 1; b < map[a].size() - 1; b++) {
                    cnt = 0;
                    bfs(macaron[a][0], b);
                    if (cnt > 2) {
                        dbfs(macaron[a][0], b);
                        for (int j = 1; j < max_size; j++) {
                            int tmp = 0;
                            for (int k = 1; k < map[j].size(); k++)
                                if (map[j][k] == 0)
                                    tmp++;
                            if (tmp > 0) {
                                int idx = 1;
                                while (1) {
                                    if (idx == map[j].size())
                                        break;
                                    if (map[j][idx] == 0)
                                        map[j].erase(map[j].begin() + idx);
                                    else
                                        idx++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    for (int i = 0; i < max_size; i++) {
        if (map[i].size() < max_size) {
            for (int j = map[i].size() - 1; j < max_size; j++)
                map[i].push_back(0);
        }
    }
    for (int i = max_size - 1; i > 0; i--) {
        string temp;
        for (int j = 1; j < max_size; j++) {
            temp += to_string(map[j][i]);
        }
        answer.push_back(temp);
    }
    return answer;
}

int main() {
    vector<vector<int>> macaron = { {1, 1}, {2, 1}, {1, 2}, {3, 3}, {6, 4}, {3, 1}, {3, 3}, {3, 3}, {3, 4}, {2, 1} };
    vector<string> answer = solution(macaron);

    for (int i = 0; i < answer.size(); i++) {
        cout << answer[i] << endl;
    }
    return 0;
}