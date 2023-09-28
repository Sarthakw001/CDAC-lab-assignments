#include <iostream>

using namespace std;

int productOfDigits(int N) {
    int product = 1;

    while (N > 0) {
        int lastDigit = N % 10;
        product *= lastDigit;
        N /= 10;
    }

    return product;
}

int main() {
    int N;
    cout << "Enter a positive integer: ";
    cin >> N;

    if (N <= 0) {
        cout << "Please enter a positive integer." << endl;
    } else {
        int digitProduct = productOfDigits(N);

        cout << "The product of digits in " << N << " is: " << digitProduct << endl;
    }

    return 0;
}
