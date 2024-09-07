//Question No: 21874
//Title: 모자 게임
//Tier: Gold II
#include "hat.h"
#include <vector>
using namespace std;
 
int n;
void init(int N){
    n = N;
}
 
int call(vector<int> F, vector<int> B, int num){
    if(num == n-1){
        int ret = 0;
        for(int i: F) ret ^= i;
        return ret;
    }
    int ret = B[n-1];
    for(int i=0 ;i<num; i++){
        ret ^= F[i];
    }
    for(int i = num+1; i<n-1; i++){
        ret ^= B[i];
    }
    
    return ret;
}