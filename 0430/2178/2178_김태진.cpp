#include <iostream>
#include <algorithm>
#include <queue>
#include <math.h>

using namespace std;

const int MAX = 101;

int map[MAX][MAX];
int d[MAX][MAX];
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { -1, 1, 0, 0 };
int m, n;
int cnt;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	scanf("%d %d", &m, &n);
	cnt = 0;

	queue<pair<int, int>> q;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%1d", &map[i][j]);
			d[i][j] = -1;
		}
	}
	q.push({ 0, 0 });
	d[0][0] = 1;
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < m && 0 <= ny && ny < n) {
				if (map[nx][ny] == 1 && d[nx][ny] == -1) {
					d[nx][ny] = d[x][y] + 1;
					q.push({ nx, ny });
				}
			}
		}
	}

	printf("%d\n", d[m - 1][n - 1]);
	return 0;
}