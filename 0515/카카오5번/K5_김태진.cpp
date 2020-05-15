#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

vector<vector<int>> v1;
vector<int> v2;

void findpath(int here) {
    for (int there = 1; there < v1.size(); there++) {
        while (v1[here][there] > 0) {
            cout << here << " " << there << endl;
            v1[here][there]--;
            v1[there][here]--;
            findpath(there);
        }
    }
    v2.push_back(here);
}

bool solution(int n, vector<vector<int>> path, vector<vector<int>> order) {
    v1 = vector<vector<int>>(n, vector<int>(n, 0));
    v2.clear();
    for (int i = 0; i < path.size(); i++)
        v1[path[i][0]][path[i][1]] = v1[path[i][1]][path[i][0]] = 1;
    findpath(0);
    for (int i : v2)
        cout << i << " ";
    cout << endl;
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