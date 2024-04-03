#include <iostream>
#include <queue>

using namespace std;

void popPQ(priority_queue<int>& pq) {
    if(pq.empty()) {
        cout << 0 << '\n';
    } else {
        cout << pq.top() << '\n';
        pq.pop();
    }
}

void pushPQ(priority_queue<int>& pq, int v) {
    pq.push(v);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    int N;
    cin >> N;
    
    priority_queue<int> pq;

    for(int i = 0; i < N; i++) {
        int k;
        cin >> k;
        if(k == 0) 
            popPQ(pq);
        else 
            pushPQ(pq, k);
    }
    
    return 0;
}
