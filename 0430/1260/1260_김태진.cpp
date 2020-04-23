#include <iostream>
#include <queue>

using namespace std;

int n, m, v;
int map[1001][1001];
int visited[1001];

void dfs(int cur) {
	cout << cur << " ";
	visited[cur] = 1;
	for (int i = 1; i < n + 1; i++) {
		if (visited[i] == 1 || map[cur][i] == 0)
			continue;
		dfs(i);
	}
}

void bfs(int cur) {
	queue<int> q;
	q.push(cur);
	visited[cur] = 0;
	while (!q.empty()) {
		cur = q.front();
		cout << q.front() << " ";
		q.pop();
		for (int i = 1; i < n + 1; i++) {
			if (visited[i] == 0 || map[cur][i] == 0)
				continue;
			q.push(i);
			visited[i] = 0;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	cin >> m;
	cin >> v;
	int x, y;
	for (int i = 0; i < m; i++) {
		cin >> x >> y;
		map[x][y] = map[y][x] = 1;
	}
	dfs(v);
	cout << "\n";
	bfs(v);
	return 0;
}