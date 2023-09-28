#include <iostream>
#include <string>
#include <cmath>

using namespace std;

class BigInt
{
private:
    string value;

public:
    BigInt(const string &str) : value(str) {}

    BigInt(int num) : value(to_string(num)) {}

    BigInt operator+(const BigInt &other) const
    {
        string result;
        int carry = 0;
        int i = value.length() - 1;
        int j = other.value.length() - 1;

        while (i >= 0 || j >= 0 || carry)
        {
            int digit1 = (i >= 0) ? value[i] - '0' : 0;
            int digit2 = (j >= 0) ? other.value[j] - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            sum %= 10;

            result.insert(result.begin(), '0' + sum);

            i--;
            j--;
        }

        return BigInt(result);
    }

    BigInt operator-(const BigInt &other) const
    {
        string result;
        int borrow = 0;
        int i = value.length() - 1;
        int j = other.value.length() - 1;

        while (i >= 0)
        {
            int digit1 = value[i] - '0';
            int digit2 = (j >= 0) ? other.value[j] - '0' : 0;

            int diff = digit1 - digit2 - borrow;
            if (diff < 0)
            {
                diff += 10;
                borrow = 1;
            }
            else
            {
                borrow = 0;
            }

            result.insert(result.begin(), '0' + diff);

            i--;
            j--;
        }

        size_t pos = result.find_first_not_of('0');
        if (pos != string::npos)
        {
            result = result.substr(pos);
        }
        else
        {
            result = "0";
        }

        return BigInt(result);
    }

    BigInt operator*(const BigInt &other) const
    {
        int len1 = value.length();
        int len2 = other.value.length();
        int lenResult = len1 + len2;
        string result(lenResult, '0');

        for (int i = len1 - 1; i >= 0; i--)
        {
            int carry = 0;
            int digit1 = value[i] - '0';

            for (int j = len2 - 1; j >= 0; j--)
            {
                int digit2 = other.value[j] - '0';
                int product = digit1 * digit2 + (result[i + j + 1] - '0') + carry;
                carry = product / 10;
                result[i + j + 1] = '0' + (product % 10);
            }

            result[i] += carry;
        }

        size_t pos = result.find_first_not_of('0');
        if (pos != string::npos)
        {
            result = result.substr(pos);
        }
        else
        {
            result = "0";
        }

        return BigInt(result);
    }

    BigInt operator/(const BigInt &other) const
    {
        BigInt quotient("0");
        BigInt remainder(*this);

        while (remainder >= other)
        {
            BigInt temp = other;
            int shift = 0;

            while (remainder >= (temp * 10))
            {
                temp = temp * 10;
                shift++;
            }

            while (remainder >= temp)
            {
                remainder = remainder - temp;
                quotient = quotient + BigInt(1) * pow(10, shift);
            }
        }

        return quotient;
    }

    BigInt operator++()
    {
        *this = *this + BigInt(1);
        return *this;
    }

    BigInt operator++(int)
    {
        BigInt temp(*this);
        *this = *this + BigInt(1);
        return temp;
    }

    BigInt operator--()
    {
        *this = *this - BigInt(1);
        return *this;
    }

    BigInt operator--(int)
    {
        BigInt temp(*this);
        *this = *this - BigInt(1);
        return temp;
    }

    bool operator<(const BigInt &other) const
    {
        return value < other.value;
    }

    bool operator<=(const BigInt &other) const
    {
        return value <= other.value;
    }

    bool operator>(const BigInt &other) const
    {
        return value > other.value;
    }

    bool operator>=(const BigInt &other) const
    {
        return value >= other.value;
    }

    bool operator==(const BigInt &other) const
    {
        return value == other.value;
    }

    bool operator!=(const BigInt &other) const
    {
        return value != other.value;
    }

    string toString() const
    {
        return value;
    }

    int toInt() const
    {
        return stoi(value);
    }
};

int main()
{
    BigInt a("123456789012345678901234567890");
    BigInt b(12345);

    cout << "a: " << a.toString() << endl;
    cout << "b: " << b.toString() << endl;

    BigInt sum = a + b;
    BigInt diff = a - b;
    BigInt product = a * b;
    BigInt division = a / b;

    cout << "a + b = " << sum.toString() << endl;
    cout << "a - b = " << diff.toString() << endl;
    cout << "a * b = " << product.toString() << endl;
    cout << "a / b = " << division.toString() << endl;

    BigInt c("999");
    cout << "c: " << c.toString() << endl;

    c++;
    cout << "c++ (prefix): " << c.toString() << endl;

    BigInt d = c++;
    cout << "c++ (postfix): " << c.toString() << endl;
    cout << "d: " << d.toString() << endl;

    c--;
    cout << "c-- (prefix): " << c.toString() << endl;

    BigInt e = c--;
    cout << "c-- (postfix): " << c.toString() << endl;
    cout << "e: " << e.toString() << endl;

    return 0;
}
