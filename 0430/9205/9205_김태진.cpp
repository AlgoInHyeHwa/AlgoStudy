#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define INF 987654321
#define MAX_DIS 1000

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int N; cin >> N;
	while (N--) {
		int n; cin >> n;
		vector<pair<int, int>> v(n + 2);
		vector<vector<long long>> go(n + 2, vector<long long>(n + 2, 0));
		for (int i = 0; i < n + 2; i++) {
			int x, y; cin >> x >> y;
			v[i] = { x, y };
			go[i][i] = 1;
		}

		for (int i = 0; i < n + 2; i++) {
			for (int j = i + 1; j < n + 2; j++) {
				int x = abs(v[i].first - v[j].first);
				int y = abs(v[i].second - v[j].second);
				long long d = x + y;
				if (d <= MAX_DIS)
					go[i][j] = go[j][i] = 1;
			}
		}

		for (int i = 0; i < n + 2; i++)
			for (int j = 0; j < n + 2; j++)
				for (int k = 0; k < n + 2; k++)
					if (go[j][i] == 1 && go[i][k] == 1)
						go[j][k] = 1;

		cout << (go[0][n + 1] ? "happy\n" : "sad\n");
	}
	return 0;
}