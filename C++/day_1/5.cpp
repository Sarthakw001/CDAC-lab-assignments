#include <iostream>

using namespace std;

int findFirstDigit(int N) {
    while (N >= 10) {
        N /= 10;
    }
    return N;
}

int main() {
    int N;
    cout << "Enter a positive integer: ";
    cin >> N;

    if (N <= 0) {
        cout << "Please enter a positive integer." << endl;
    } else {
        int firstDigit = findFirstDigit(N);

        cout << "The first digit of " << N << " is: " << firstDigit << endl;
    }

    return 0;
}
