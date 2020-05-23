#include<vector>
#include<iostream>

using namespace std;

int max_size;

vector<vector<int>> map(10);
vector<vector<bool>> visited(10);
int dx[] = {0, -1, 0, 1};
int dy[] = {-1, 0, 1, 0};
int cnt;

void clearmap(vector<vector<int> > board){
    for(int i = 0; i < map.size(); i++)
        map[i].clear();
    for(int i = 0; i < visited.size(); i++)
        visited[i].clear();
    visited.clear();
    for(int i = 0; i < board.size(); i++){
        vector<bool> temp(board.size(), false);
        visited.push_back(temp);
        for(int j = 0; j < board.size(); j++)
            map[i].push_back(0);
    }
}

void copymap(vector<vector<int> > board){
    for(int i = 0; i < board.size(); i++){
        for(int j = 0; j < board[i].size(); j++){
            map[i][j] = board[board.size() - j - 1][i];
        }
    }
}

void bfs(int x, int y){
    visited[x][y] = true;
    cnt++;
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(0 < nx && nx < max_size && 0 < ny && ny < map[nx].size()){
            if(map[x][y] == map[nx][ny] && !visited[nx][ny])
                bfs(nx, ny);
        }
    }
    visited[x][y] = false;
}
void dbfs(int x, int y){
    visited[x][y] = true;
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(0 < nx && nx < max_size && 0 < ny && ny < map[nx].size()){
            if(map[x][y] == map[nx][ny] && !visited[nx][ny])
                dbfs(nx, ny);
        }
    }
    map[x][y] = 0;
    visited[x][y] = false;
}

int solution(vector<vector<int> > board)
{
    int answer;
    int real_answer = 0;
    max_size = board.size();
    for(int i = 1; i < board.size(); i++){
        for(int j = 0; j < board[i].size(); j++){
            answer = 0;
            clearmap(board);
            copymap(board);
            map[j].erase(map[j].begin() + (map[i].size() - 1) - i);
            cnt = 0;
            bfs(j, map[j].size() - i);
            if(cnt > 2){
                dbfs(j, map[j].size() - i);
                answer += cnt;
                for(int a = 0; a < map.size(); a++){
                    int tmp = 0;
                    for(int b = 0; b < map[a].size(); b++){
                        if(map[a][b] == 0)
                            tmp++;
                        if(tmp > 0){
                            int idx = 0;
                            while(1){
                                if(idx == map[a].size())
                                    break;
                                if(map[a][idx] == 0)
                                    map[a].erase(map[a].begin() + idx);
                                else
                                    idx++;
                            }
                        }
                    }
                    int max_cnt = 0;
                    for(int a = 0; a < map.size(); a++){
                        if(map[a].size() < 1)
                            continue;
                        for(int b = 0; b < map[a].size(); b++){
                            cnt = 0;
                            bfs(a, b);
                            if(cnt > 2){
                                dbfs(a, b);
                                answer += cnt;
                                for(int c = 0; c < map.size(); c++){
                                    int tmp = 0;
                                    for(int d = 0; d < map[c].size(); d++){
                                        if(map[c][d] == 0)
                                            tmp++;
                                        if(tmp > 0){
                                            int idx = 0;
                                            while(1){
                                                if(idx == map[c].size())
                                                    break;
                                                if(map[c][idx] == 0)
                                                    map[c].erase(map[c].begin() + idx);
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
            }
            int ss = board.size() * board.size();
            if(ss - answer > real_answer && answer != 0)
                real_answer = ss - answer;
        }
    }
    
    return real_answer;
}