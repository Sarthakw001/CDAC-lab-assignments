#include <iostream>
#include <cmath>

using namespace std;

int countDigits(int N) {
    int count = 0;
    while (N > 0) {
        count++;
        N /= 10;
    }
    return count;
}

bool isArmstrongNumber(int N) {
    int original = N;
    int sum = 0;
    int numDigits = countDigits(N);

    while (N > 0) {
        int digit = N % 10;
        sum += pow(digit, numDigits);
        N /= 10;
    }

    return sum == original;
}

int main() {
    int N;
    cout << "Enter a positive integer: ";
    cin >> N;

    if (N <= 0) {
        cout << "Please enter a positive integer." << endl;
    } else {
        if (isArmstrongNumber(N)) {
            cout << N << " is an Armstrong number." << endl;
        } else {
            cout << N << " is not an Armstrong number." << endl;
        }
    }

    return 0;
}
