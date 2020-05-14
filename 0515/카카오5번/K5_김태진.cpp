#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

vector<vector<int>> v1;
vector<bool> v2;
int N;

bool check(int n) {
    for (int i = 0; i < v2.size(); i++) {
        if (v2[i] == n)
            return false;
    }
    return true;
}

bool bfs(int a, int b, vector<int> v) {
    v2[v[v.size() - 1]] = true;
    for (int i = 0; i < v1[v[v.size() - 1]].size(); i++) {
        if (v2[v1[v[v.size() - 1]][i]])
            continue;
        v.push_back(v1[v[v.size() - 1]][i]);
        if (v[v.size() - 1] == b)
            return true;
        if (v[v.size() - 1] == a)
            return false;
        if (bfs(a, b, v))
            return true;
    }
    v2[v[v.size() - 1]] = false;
    return false; 
}

bool fpath(int a, int b) {
    v2[0] = true;
    for (int i = 0; i < v1[0].size(); i++) {
        vector<int> tmp;
        tmp.push_back(v1[0][i]);
        if (bfs(a, b, tmp))
            return true;
    }
    return false;
}

bool solution(int n, vector<vector<int>> path, vector<vector<int>> order) {
    v1.resize(n);
    v2.resize(n, false);
    N = n;
    for (int i = 0; i < path.size(); i++) {
        v1[path[i][0]].push_back(path[i][1]);
        v1[path[i][1]].push_back(path[i][0]);
    }
    for (int i = 0; i < order.size(); i++) {
        cout << order[i][0] << " " << order[i][1] << endl;
        if (fpath(order[i][0], order[i][1]))
            return false;
    }
    return true;
}

int main() {
    vector<vector<int>> path = { {0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5} };
    vector<vector<int>> order = { {8, 5}, {6, 7}, {4, 1} };
    if (solution(9, path, order))
        cout << "true" << endl;
    else
        cout << "false" << endl;
    path = { {8, 1}, {0, 1}, {1, 2}, {0, 7}, {4, 7}, {0, 3}, {7, 5}, {3, 6} };
    order = { {4, 1}, {5, 2} };
    if (solution(9, path, order))
        cout << "true" << endl;
    else
        cout << "false" << endl;
    path = { {0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5} };
    order = { {4, 1}, {8, 7}, {6, 5} };
    if (solution(9, path, order))
        cout << "true" << endl;
    else
        cout << "false" << endl;

    return 0;
}