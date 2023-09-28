#include <iostream>

using namespace std;

int reverseInteger(int N) {
    int reversed = 0;

    while (N > 0) {
        int lastDigit = N % 10;
        reversed = reversed * 10 + lastDigit;
        N /= 10;
    }

    return reversed;
}

int main() {
    int N;
    cout << "Enter a positive integer N: ";
    cin >> N;

    if (N <= 0) {
        cout << "Please enter a positive integer." << endl;
    } else {
        int reversed = reverseInteger(N);

        cout << "Reverse of " << N << " is: " << reversed << endl;
    }

    return 0;
}
