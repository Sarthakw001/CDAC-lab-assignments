#include <iostream>

using namespace std;

void printDigitAsWord(int digit) {
    if (digit == 0) {
        cout << "Zero ";
    } else if (digit == 1) {
        cout << "One ";
    } else if (digit == 2) {
        cout << "Two ";
    } else if (digit == 3) {
        cout << "Three ";
    } else if (digit == 4) {
        cout << "Four ";
    } else if (digit == 5) {
        cout << "Five ";
    } else if (digit == 6) {
        cout << "Six ";
    } else if (digit == 7) {
        cout << "Seven ";
    } else if (digit == 8) {
        cout << "Eight ";
    } else if (digit == 9) {
        cout << "Nine ";
    }
}

void printDigitsAsWords(int N) {
    if (N < 0) {
        cout << "Negative ";
        N = -N;
    }

    int reverseN = 0;

    while (N > 0) {
        int digit = N % 10;
        reverseN = reverseN * 10 + digit;
        N /= 10;
    }

    while (reverseN > 0) {
        int digit = reverseN % 10;
        printDigitAsWord(digit);
        reverseN /= 10;
    }

    cout << endl;
}

int main() {
    int N;
    cout << "Enter a positive integer: ";
    cin >> N;

    if (N <= 0) {
        cout << "Please enter a positive integer." << endl;
    } else {
        cout << "Digits in " << N << " as words: ";
        printDigitsAsWords(N);
    }

    return 0;
}
