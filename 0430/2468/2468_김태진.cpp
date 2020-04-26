#include <iostream>
#include <string.h>

using namespace std;

int map[101][101];
bool visited[101][101];
int N, max_num = 1;
int dx[] = { -1, 1, 0, 0, };
int dy[] = { 0, 0, -1, 1 };
int answer = 1;

void dfs(int i, int j, int height) {
	visited[i][j] = true;
	for (int k = 0; k < 4; k++) {
		int nx = i + dx[k];
		int ny = j + dy[k];
		if (nx < 0 || nx >= N || ny < 0 || ny >= N)
			continue;
		if (visited[nx][ny] || map[nx][ny] <= height)
			continue;
		dfs(nx, ny, height);
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
			if (map[i][j] > max_num)
				max_num = map[i][j];
		}
	}
	for (int height = 1; height < max_num; height++) {
		int cnt = 0;
		memset(visited, false, sizeof(visited));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > height && !visited[i][j]) {
					cnt++;
					dfs(i, j, height);
				}
				else
					visited[i][j] = true;
			}
		}
		if (cnt > answer)
			answer = cnt;
	}

	cout << answer << endl;
	return 0;
}