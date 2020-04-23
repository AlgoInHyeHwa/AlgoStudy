#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> v;
vector<bool> visited;
int answer = 0;

void dfs(int n) {
	answer++;
	visited[n] = true;
	for (int i = 0; i < v[n].size(); i++)
		if (!visited[v[n][i]])
			dfs(v[n][i]);
	return;
}

int main() {
	int m; cin >> m;
	int n; cin >> n;
	visited.resize(m + 1);
	v.resize(m + 1);
	
	for (int i = 0; i < n; i++) {
		int a; cin >> a;
		int b; cin >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	dfs(1);

	cout << answer - 1;
	return 0;
}