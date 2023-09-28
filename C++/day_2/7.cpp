#include <iostream>

using namespace std;

int sumOfDigits(int N) {
    // Take the absolute value of N
    N = abs(N);

    int sum = 0;

    while (N > 0) {
        int lastDigit = N % 10;
        sum += lastDigit;
        N /= 10;
    }

    return sum;
}

int main() {
    int N;
    cout << "Enter an integer: ";
    cin >> N;

    int digitSum = sumOfDigits(N);

    cout << "The sum of digits in " << N << " is: " << digitSum << endl;

    return 0;
}
