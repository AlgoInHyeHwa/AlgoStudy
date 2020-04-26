#include <iostream>
#include <queue>

using namespace std;

int F, S, G, U, D;
int visited[1000001] = { 0, };
queue<pair<int, int>> q;


int main() {
	cin >> F >> S >> G >> U >> D;
	visited[S] = true;
	q.push(make_pair(S, 0));

	int ans = -1, stair = 0, cnt = 0;
	while (!q.empty()) {
		stair = q.front().first;
		cnt = q.front().second;
		q.pop();
		if (stair == G) {
			ans = cnt;
			break;
		}
		if (stair + U <= F && !visited[stair + U]) {
			q.push(make_pair(stair + U, cnt + 1));
			visited[stair + U] = true;
		}
		if (stair - D > 0 && !visited[stair - D]) {
			q.push(make_pair(stair - D, cnt + 1));
			visited[stair - D] = true;
		}
	}
	if (ans != -1)
		cout << ans << endl;
	else
		cout << "use the stairs" << endl;
	return 0;
}