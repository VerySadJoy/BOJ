//Question No: 1927
//Title: 최소 힙
//Tier: Silver II
#include <iostream>
#include <queue>
#include <functional>
int main() {
    std::cin.tie(0);
    std::cin.sync_with_stdio(0);

    int N, num;
    std::cin >> N;

    std::priority_queue<int, std::vector<int>, std::greater<int>> pq;

    for (int i = 0; i < N; i++) {
        std::cin >> num;
        if (num) {
            pq.push(num);
        }
        else {
            if (pq.empty())
                std::cout << 0 << "\n";
            else {
                std::cout << pq.top() << "\n";
                pq.pop();
            }
        }
    }
    return 0;
}

