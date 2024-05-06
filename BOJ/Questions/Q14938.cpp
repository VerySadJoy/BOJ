//Question No: 14938
//Title: 서강그라운드
//Tier: Gold IV

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define INF 987654321
using namespace std;

struct Edge {
    int to;
    int weight;
};

vector<int> item;
vector<vector<Edge>> graph;
vector<int> value;

int Dijkstra(int start, int n, int m) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    vector<int> distance(n + 1, INF);
    distance[start] = 0;
    pq.push({0, start});

    while (!pq.empty()) {
        int dist = pq.top().first;
        int u = pq.top().second;
        pq.pop();

        if (dist > distance[u]) continue;

        for (const Edge& e : graph[u]) {
            int v = e.to;
            int w = e.weight;

            if (dist + w < distance[v]) {
                distance[v] = dist + w;
                pq.push({distance[v], v});
            }
        }
    }

    int sum = 0;
    for (int i = 1; i <= n; ++i) {
        if (distance[i] <= m) sum += item[i];
    }

    return sum;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, m, r;
    cin >> n >> m >> r;

    item.resize(n + 1);
    graph.resize(n + 1);
    value.resize(n + 1);

    for (int i = 1; i <= n; ++i) cin >> item[i];

    for (int i = 0; i < r; ++i) {
        int a, b, l;
        cin >> a >> b >> l;
        graph[a].push_back({b, l});
        graph[b].push_back({a, l});
    }

    int ans = 0;
    for (int i = 1; i <= n; ++i) {
        ans = max(ans, Dijkstra(i, n, m));
    }

    cout << ans << '\n';

    return 0;
}
