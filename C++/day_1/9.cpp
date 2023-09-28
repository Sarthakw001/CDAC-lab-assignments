#include <iostream>

using namespace std;

bool isPalindrome(int N) {
    int original = N;
    int reversed = 0;

    while (N > 0) {
        int lastDigit = N % 10;
        reversed = reversed * 10 + lastDigit;
        N /= 10;
    }

    return original == reversed;
}

int main() {
    int N;
    cout << "Enter a positive integer: ";
    cin >> N;

    if (N <= 0) {
        cout << "Please enter a positive integer." << endl;
    } else {
        if (isPalindrome(N)) {
            cout << N << " is a palindrome number." << endl;
        } else {
            cout << N << " is not a palindrome number." << endl;
        }
    }

    return 0;
}
