#include <string>
#include <vector>
#include <cstring>

using namespace std;

const int MAX = 200;
int cnt = 0;
int map[MAX][MAX];
bool visited[MAX];

void dfs2(int x, int n) {
	visited[x] = true;

	for (int i = 0; i < n; i++) {
		if (map[x][i] == 1 && !visited[i])
			dfs2(i, n);
	}
}

void dfs(int x, int n) {
	visited[x] = true;
	cnt++;
	for (int i = 0; i < n; i++) {
		if (map[x][i] == 1 && !visited[i])
			dfs2(i, n);
	}
}

int solution(int n, vector<vector<int>> computers) {
	int answer = 0;
	memset(visited, false, sizeof(visited));

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			map[i][j] = computers[i][j];

	for (int i = 0; i < n; i++)
		if (!visited[i])
			dfs(i, n);

	answer = cnt;
	return answer;
}