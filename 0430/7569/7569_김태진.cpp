#include <iostream>
#include <vector>
#include <queue>

using namespace std;

queue < pair<pair<int, int>, int>> q;
int map[101][101][101] = { 0 };
bool visit[101][101][101] = { false };
int dx[] = { -1, 1, 0, 0, 0, 0 };
int dy[] = { 0, 0, 0, 0, -1, 1 };
int dz[] = { 0, 0, -1, 1, 0, 0 };

int main() {
	int m; cin >> m;
	int n; cin >> n;
	int h; cin >> h;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				int temp; cin >> temp;
				map[j][k][i] = temp;
				if (temp == 1) {
					q.push(make_pair(make_pair(j, k), i));
					visit[j][k][i] = true;
				}
				else if (temp == -1)
					visit[j][k][i] = true;
			}
		}
	}
	int ans = -1;
	while (!q.empty()) {
		int s = q.size();
		ans++;
		while (s--) {
			pair<pair<int, int>, int> cur = q.front();
			q.pop();
			for (int i = 0; i < 6; i++) {
				int nx = cur.first.second + dx[i];
				int ny = cur.first.first + dy[i];
				int nz = cur.second + dz[i];
				if (nx < 0 || nx + 1 > m || ny < 0 || ny + 1 > n || nz < 0 || nz + 1 > h)
					continue;
				if (!visit[ny][nx][nz] && map[ny][nx][nz] == 0) {
					visit[ny][nx][nz] = true;
					q.push(make_pair(make_pair(ny, nx), nz));
				}
			}
		}
	}

	for (int i = 0; i < h; i++)
		for (int j = 0; j < n; j++)
			for (int k = 0; k < m; k++)
				if (!visit[j][k][i])
					ans = -1;
	cout << ans << endl;
	return 0;
}