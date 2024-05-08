//Question No: 16236
//Title: 아기 상어
//Tier: Gold III
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

int N;
int board[20][20];
int visited[20][20];
int shark_size = 2;
int eat_cnt = 0;
int ans = 0;

int dx[] = {-1, 0, 0, 1};
int dy[] = {0, -1, 1, 0};

struct Fish {
    int x, y, dist;
};

vector<Fish> fishes;

bool compare(Fish a, Fish b) {
    if (a.dist == b.dist) {
        if (a.x == b.x) {
            return a.y < b.y;
        }
        return a.x < b.x;
    }
    return a.dist < b.dist;
}

void bfs(int x, int y) {
    memset(visited, 0, sizeof(visited));
    queue<pair<int, int>> q;
    q.push({x, y});
    visited[x][y] = 1;

    while (!q.empty()) {
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();

        for (int i = 0; i < 4; ++i) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] <= shark_size) {
                visited[nx][ny] = visited[cx][cy] + 1;
                q.push({nx, ny});

                if (board[nx][ny] != 0 && board[nx][ny] < shark_size) {
                    fishes.push_back({nx, ny, visited[nx][ny] - 1});
                }
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    int shark_x, shark_y;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            cin >> board[i][j];
            if (board[i][j] == 9) {
                shark_x = i;
                shark_y = j;
                board[i][j] = 0;
            }
        }
    }

    while (true) {
        fishes.clear();
        bfs(shark_x, shark_y);

        if (fishes.empty()) break;

        sort(fishes.begin(), fishes.end(), compare);

        shark_x = fishes[0].x;
        shark_y = fishes[0].y;
        ans += fishes[0].dist;
        ++eat_cnt;
        board[shark_x][shark_y] = 0;

        if (eat_cnt == shark_size) {
            ++shark_size;
            eat_cnt = 0;
        }
    }

    cout << ans << '\n';

    return 0;
}
