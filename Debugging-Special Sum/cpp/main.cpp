#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

long long SpecialSum(int N, int M, const vector<int>& A, const vector<int>& B, const vector<int>& K) {
    long long specialSum = 0;

    for (int i = 0; i < N; ++i) {
        long long maxProduct = LLONG_MIN;

        int left = max(1, i + 1 - K[i]);   // 1-based indexing
        int right = min(M, i + 1 + K[i]);

        for (int j = left; j <= right; ++j) {
            maxProduct = max(maxProduct, 1LL * A[i] * B[j - 1]); // Convert j to 0-based
        }

        specialSum += maxProduct;
    }

    return specialSum;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;
    while (T--) {
        int N, M;
        cin >> N >> M;

        vector<int> A(N), B(M), K(N);

        for (int i = 0; i < N; ++i) cin >> A[i];
        for (int i = 0; i < M; ++i) cin >> B[i];
        for (int i = 0; i < N; ++i) cin >> K[i];

        cout << SpecialSum(N, M, A, B, K) << '\n';
    }

    return 0;
}
