//Question No: 14939
//Title: 불 끄기
//Tier: Platinum IV
#include <bits/stdc++.h>
using namespace std;
#define MAX 10
#define INF 1e9

bool arr[15][15];
int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };
int ans = INF;

bool outrange(int x, int y) {
    return (x < 0 || x >= MAX || y < 0 || y >= MAX);
}

void toggle(int x, int y, bool tmp_arr[][15]) {
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (!outrange(nx, ny)) tmp_arr[nx][ny] = !tmp_arr[nx][ny];
    }
    tmp_arr[x][y] = !tmp_arr[x][y];
}

bool islight(bool tmp_arr[][15]) {
    for (int i = 0; i < MAX; i++)
        for (int j = 0; j < MAX; j++)
            if (tmp_arr[i][j]) return true;
    return false;
}

void init(bool t_arr1[][15], bool t_arr2[][15], bool t_arr[][15]) {
    for (int i = 0; i < MAX; i++)
        for (int j = 0; j < MAX; j++) {
            t_arr2[i][j] = t_arr[i][j];
            t_arr1[i][j] = t_arr[i][j];
        }
}

void firstLine(int x, int sum, bool t_arr[][15]) {
    if (x == MAX) {
        bool t_arr3[15][15] = { 0 };
        for (int i = 0; i < MAX; i++)
            for (int j = 0; j < MAX; j++)
                t_arr3[i][j] = t_arr[i][j];

        for (int i = 1; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (t_arr3[i - 1][j]) {
                    toggle(i, j, t_arr3);
                    sum++;
                }
            }
        }

        if (!islight(t_arr3))  ans = min(ans, sum);
        return;
    }

    bool t_arr1[15][15] = { 0 };
    bool t_arr2[15][15] = { 0 };
    init(t_arr1, t_arr2, t_arr);

    firstLine(x + 1, sum, t_arr1);

    toggle(0, x, t_arr2);
    firstLine(x + 1, sum + 1, t_arr2);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    for (int i = 0; i < MAX; i++) {
        for (int j = 0; j < MAX; j++) {
            char c; cin >> c;
            if (c == 'O') arr[i][j] = 1;
        }
    }

    firstLine(0, 0, arr);

    if (ans == INF) cout << -1;
    else cout << ans;
}