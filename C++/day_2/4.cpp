#include <iostream>
#include <vector>

using namespace std;

bool isPrime(int number) {
    if (number <= 1) {
        return false;
    }

    if (number <= 3) {
        return true;
    }

    if (number % 2 == 0 || number % 3 == 0) {
        return false;
    }

    for (int i = 5; i * i <= number; i += 6) {
        if (number % i == 0 || number % (i + 2) == 0) {
            return false;
        }
    }

    return true;
}

vector<int> findPrimesBetween(int N, int M) {
    vector<int> primes;

    for (int i = N; i <= M; i++) {
        if (isPrime(i)) {
            primes.push_back(i);
        }
    }

    return primes;
}

int main() {
    int N, M;
    cout << "Enter two positive integers N and M: ";
    cin >> N >> M;

    if (N <= 0 || M <= 0) {
        cout << "Please enter two positive integers." << endl;
    } else {
        vector<int> primeNumbers = findPrimesBetween(N, M);

        cout << "Prime numbers between " << N << " and " << M << " are: ";
        for (int prime : primeNumbers) {
            cout << prime << " ";
        }
        cout << endl;
    }

    return 0;
}
