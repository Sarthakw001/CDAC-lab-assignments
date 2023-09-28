#include <iostream>
#include <string>

using namespace std;

const string onesWords[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
const string teensWords[] = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
const string tensWords[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

string numberToWords(int N) {
    if (N == 0) {
        return "Zero";
    }

    string result = "";

    int thousands = N / 1000;
    if (thousands > 0) {
        result += onesWords[thousands] + " Thousand ";
    }

    int hundreds = (N % 1000) / 100;
    if (hundreds > 0) {
        result += onesWords[hundreds] + " Hundred ";
    }

    int tensAndOnes = N % 100;
    if (tensAndOnes >= 11 && tensAndOnes <= 19) {
        result += teensWords[tensAndOnes - 10];
    } else {
        int tens = tensAndOnes / 10;
        if (tens > 0) {
            result += tensWords[tens] + " ";
        }
        int ones = tensAndOnes % 10;
        if (ones > 0) {
            result += onesWords[ones];
        }
    }

    return result;
}

int main() {
    int N;
    cout << "Enter a positive integer: ";
    cin >> N;

    if (N <= 0) {
        cout << "Please enter a positive integer." << endl;
    } else {
        string words = numberToWords(N);
        cout << "Number in words: " << words << endl;
    }

    return 0;
}
