#include <iostream>
#include <queue>

using namespace std;

int N, K;
int visited[100001] = { 0, };
queue<int> q;

void bfs() {
	q.push(N);
	visited[N] = 1;
	while (!q.empty()) {
		int tmp = q.front();
		q.pop();
		if (tmp == K) {
			cout << visited[tmp] - 1 << endl;
			return;
		}
		if (tmp - 1 >= 0 && visited[tmp - 1] == 0) {
			visited[tmp - 1] = visited[tmp] + 1;
			q.push(tmp - 1);
		}
		if (tmp + 1 <= 100000 && visited[tmp + 1] == 0) {
			visited[tmp + 1] = visited[tmp] + 1;
			q.push(tmp + 1);
		}
		if (tmp * 2 <= 100000 && visited[tmp * 2] == 0) {
			visited[tmp * 2] = visited[tmp] + 1;
			q.push(2 * tmp);
		}
	}
}

int main() {
	cin >> N;
	cin >> K;
	bfs();
	return 0;
}