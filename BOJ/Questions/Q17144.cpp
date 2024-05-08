//Question No: 17144
//Title: 미세먼지 안녕!
//Tier: Gold IV
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

int R, C, T;
int board[51][51];
int cleaner[2];

const int dx[] = {1, -1, 0, 0};
const int dy[] = {0, 0, 1, -1};

void spread_dust() {
    int temp[51][51] = {};

    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            if (board[i][j] > 0) {
                int cnt = 0;
                for (int k = 0; k < 4; ++k) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] != -1) {
                        temp[nx][ny] += board[i][j] / 5;
                        cnt++;
                    }
                }
                board[i][j] -= (board[i][j] / 5) * cnt;
            }
        }
    }

    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            board[i][j] += temp[i][j];
        }
    }
}

void operate_cleaner() {
    int x = cleaner[0] - 1;
    int y = 0;
    int dir = 0;
    int prev = 0;
    while (true) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || nx >= cleaner[0] || ny < 0 || ny >= C) {
            dir = (dir + 1) % 4;
            nx = x + dx[dir];
            ny = y + dy[dir];
        }
        if (nx == cleaner[0] && ny == 0) break;
        int temp = board[nx][ny];
        board[nx][ny] = prev;
        prev = temp;
        x = nx;
        y = ny;
    }
    x = cleaner[1] + 1;
    y = 0;
    dir = 0;
    prev = 0;
    while (true) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < cleaner[1] || nx >= R || ny < 0 || ny >= C) {
            dir = (dir + 1) % 4;
            nx = x + dx[dir];
            ny = y + dy[dir];
        }
        if (nx == cleaner[1] && ny == 0) break;
        int temp = board[nx][ny];
        board[nx][ny] = prev;
        prev = temp;
        x = nx;
        y = ny;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    cin >> R >> C >> T;

    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            cin >> board[i][j];
            if (board[i][j] == -1) {
                if (cleaner[0] == 0) cleaner[0] = i;
                else cleaner[1] = i;
            }
        }
    }

    while (T--) {
        spread_dust();
        operate_cleaner();
    }

    int answer = 0;
    for (int i = 0; i < R; ++i) {
        for (int j = 0; j < C; ++j) {
            if (board[i][j] > 0) {
                answer += board[i][j];
            }
        }
    }

    cout << answer << '\n';

    return 0;
}
