#include <iostream>

using namespace std;

int countDigit(int number, int digit) {
    int count = 0;

    while (number > 0) {
        int lastDigit = number % 10;
        if (lastDigit == digit) {
            count++;
        }
        number /= 10;
    }

    return count;
}

int main() {
    int N, digit;
    cout << "Enter a positive integer: ";
    cin >> N;

    cout << "Enter the digit you want to count: ";
    cin >> digit;

    if (N <= 0 || digit < 0 || digit > 9) {
        cout << "Please enter a valid positive integer and a valid digit (0-9)." << endl;
    } else {
        int digitCount = countDigit(N, digit);

        cout << "The digit " << digit << " appears " << digitCount << " times in " << N << "." << endl;
    }

    return 0;
}
