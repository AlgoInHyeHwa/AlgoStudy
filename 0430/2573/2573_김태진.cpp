#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int map[300][300];
int map2[300][300];
bool visited[300][300];
int N, M;
int dx[] = { -1, 1, 0, 0, };
int dy[] = { 0, 0, -1, 1 };

void bfs(int i, int j) {
	queue<pair<int, int>> q;
	q.push(make_pair(i, j));
	visited[i][j] = true;
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (-1 < nx && nx < N && -1 < ny && ny < M) {
				if (!visited[nx][ny] && map[nx][ny] != 0) {
					visited[nx][ny] = true;
					q.push(make_pair(nx, ny));
				}
			}
		}
	}
}

int melt(int x, int y) {
	int cnt = 0;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (map[nx][ny] == 0)
			cnt++;
	}
	return cnt;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> map[i][j];

	int ans = 0;
	while (1) {
		int cnt = 0;
		memset(visited, false, sizeof(visited));
		memset(map2, 0, sizeof(map2));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		if (cnt > 1) {
			cout << ans << endl;
			return 0;
		}
		if (cnt == 0) {
			cout << 0 << endl;
			return 0;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					map2[i][j] = map[i][j] - melt(i, j);
					if (map2[i][j] < 0)
						map2[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = map2[i][j];
		ans++;
	}

	return 0;
}