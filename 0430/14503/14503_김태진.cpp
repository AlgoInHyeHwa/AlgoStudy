#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define MAX 50

int N, M;
int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };
int map[MAX][MAX];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M;
	int x, y, d; cin >> x >> y >> d;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> map[i][j];

	int ans = 0;
	map[x][y] = 2;
	ans++;
	int nx, ny, nd;
	while (1) {
		int td = d;
		bool clean = false;
		int nclean = 0;
		for (int i = 0; i < 4; i++) {
			if (d == 0)
				nd = 3;
			else
				nd = d - 1;
			nx = x + dx[nd];
			ny = y + dy[nd];

			if (map[nx][ny] == 0) {
				clean = true;
				break;
			}
			else if (map[nx][ny] == 1 || map[nx][ny] == 2 || (nx < 0 || ny < 0 || nx >= N || ny >= M)) {
				d = nd;
				nclean++;
			}
		}
		if (clean) {
			map[nx][ny] = 2;
			ans++;
			d = nd;
		}
		if (nclean == 4) {
			nx = x - dx[td];
			ny = y - dy[td];
			d = td;
			if ((nx < 0 || ny < 0 || nx >= N || ny >= M) || map[nx][ny] == 1)
				break;
		}
		x = nx;
		y = ny;
	}
	cout << ans << endl;
	return 0;
}