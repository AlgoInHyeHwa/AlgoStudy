#include <string>
#include <vector>

using namespace std;

int map[25][25] = {0, };
bool visited[25][25] = {false, };
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};
int ans = 999999999;

void bfs(int x, int y, int n, int cnt, int dir){
    visited[x][y] = true;
    if(ans < cnt + 100){
        visited[x][y] = false;
        return;
    }
    if(x == n && y == n){
        if(ans > cnt)
            ans = cnt;
        visited[x][y] = false;
        return;
    }
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(-1 < nx && nx < n + 1 && -1 < ny && ny < n + 1){
            if(!visited[nx][ny] && map[nx][ny] == 0){
                if(dir == i)
                    bfs(nx, ny, n, cnt + 100, i);
                else
                    bfs(nx, ny, n, cnt + 600, i);
            }
        }
    }
    visited[x][y] = false;
}
void start(int x, int y, int n, int cnt, int dir){
    visited[x][y] = true;
    if(map[x + 1][y] == 0)
        bfs(x + 1, y, n, cnt + 100, 1);
    if(map[x][y + 1] == 0)
        bfs(x, y + 1, n, cnt + 100, 3);
}

int solution(vector<vector<int>> board) {
    for(int i = 0 ; i < board.size(); i++)
        for(int j = 0; j < board.size(); j++)
            map[i][j] = board[i][j];
    start(0, 0, board.size() - 1, 0, 0);
    return ans;
}