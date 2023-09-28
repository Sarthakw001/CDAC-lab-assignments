#include <iostream>

using namespace std;

bool isPerfectNumber(int N) {
    int sum = 0;

    for (int i = 1; i < N; i++) {
        if (N % i == 0) {
            sum += i;
        }
    }

    return sum == N;
}

int main() {
    int N;
    cout << "Enter a positive integer: ";
    cin >> N;

    if (N <= 0) {
        cout << "Please enter a positive integer." << endl;
    } else {
        if (isPerfectNumber(N)) {
            cout << N << " is a perfect number." << endl;
        } else {
            cout << N << " is not a perfect number." << endl;
        }
    }

    return 0;
}
