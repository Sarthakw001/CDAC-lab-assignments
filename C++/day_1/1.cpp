#include <iostream>
#include <vector>

using namespace std;

vector<int> findFactors(int N) {
    vector<int> factors;

    for (int i = 1; i <= N; i++) {
        if (N % i == 0) {
            factors.push_back(i);
        }
    }

    return factors;
}

int main() {
    int N;
    cout << "Enter a positive integer N: ";
    cin >> N;

    if (N <= 0) {
        cout << "Please enter a positive integer." << endl;
    } else {
        vector<int> factors = findFactors(N);

        cout << "Factors of " << N << " are: ";
        for (int factor : factors) {
            cout << factor << " ";
        }
        cout << endl;
    }

    return 0;
}
