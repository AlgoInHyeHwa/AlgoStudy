#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> v;
vector<int> v2;

int main() {
	int m; cin >> m;
	int a; cin >> a;
	int b; cin >> b;
	int n; cin >> n;
	v.resize(m + 1);
	v2.resize(m + 1);
	for (int i = 0; i < n; i++) {
		int c; cin >> c;
		int d; cin >> d;
		v[c].push_back(d);
		v[d].push_back(c);
	}

	queue<int> q;
	q.push(a);
	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		if (cur == b) {
			cout << v2[b] << endl;
			return 0;
		}
		for (int i = 0; i < v[cur].size(); i++) {
			int next = v[cur][i];
			if (v2[next] == 0) {
				q.push(next);
				v2[next] = v2[cur] + 1;
			}
		}
	}
	cout << -1 << endl;
	return 0;
}