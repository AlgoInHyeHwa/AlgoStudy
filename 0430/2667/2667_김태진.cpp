#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

const int MAX = 30;

int map[MAX][MAX];
bool visited[MAX][MAX];
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { -1, 1, 0, 0 };
int N;
int cnt;
int v[1010];


void dfs(int x, int y){
	visited[x][y] = true;
	v[cnt]++;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (0 <= nx && nx < N && 0 <= ny && ny < N)
			if (map[nx][ny] && !visited[nx][ny])
				dfs(nx, ny);
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	scanf(" %d", &N);
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			scanf(" %1d", &map[i][j]);
	
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			if (map[i][j] && !visited[i][j])
				dfs(i, j), cnt++;

	sort(v, v + cnt);

	printf("%d\n", cnt);
	for (int i = 0; i < cnt; i++)
		printf("%d\n", v[i]);
	return 0;
}