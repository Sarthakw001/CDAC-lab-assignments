#include <iostream>

using namespace std;

int sumBetween(int N, int M) {
    int sum = 0;

    for (int i = N; i <= M; i++) {
        sum += i;
    }

    return sum;
}

int main() {
    int N, M;
    cout << "Enter two positive integers N and M: ";
    cin >> N >> M;

    if (N <= 0 || M <= 0) {
        cout << "Please enter two positive integers." << endl;
    } else {
        int result = sumBetween(N, M);

        cout << "Sum of numbers between " << N << " and " << M << " is: " << result << endl;
    }

    return 0;
}
