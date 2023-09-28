#include <iostream>

using namespace std;

int sumOfDigits(int N) {
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
    cout << "Enter a positive integer: ";
    cin >> N;

    if (N <= 0) {
        cout << "Please enter a positive integer." << endl;
    } else {
        int digitSum = sumOfDigits(N);

        cout << "The sum of digits in " << N << " is: " << digitSum << endl;
    }

    return 0;
}
