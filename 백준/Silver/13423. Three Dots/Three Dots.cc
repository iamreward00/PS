#include <iostream>
#include <vector>
#include <algorithm> 
#include <unordered_set> 
using namespace std;

void solve() {
    int n;
    cin >> n;
    
    vector<int> arr(n);

    unordered_set<int> s; 

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        s.insert(arr[i]); // set에 값 넣기
    }

    sort(arr.begin(), arr.end());

    int cnt = 0;
    

    for (int i = 0; i < n; i++) {         // a 
        for (int j = i + 1; j < n; j++) { // b 
            int a = arr[i];
            int b = arr[j];
            
            // 2b - a = c
            int c = b * 2 - a;

            if (s.find(c) != s.end()) {
                cnt++;
            }
        }
    }
    
    cout << cnt << "\n";
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    
    return 0;
}