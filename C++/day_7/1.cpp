#include <iostream>
#include <string>
using namespace std;

class BigInt
{
private:
    string value;

public:
    BigInt(const string &str) : value(str) {}

    bool operator<(const BigInt &other) const
    {
        return value < other.value;
    }

    bool operator<=(const BigInt &other) const
    {
        return value <= other.value;
    }

    bool operator==(const BigInt &other) const
    {
        return value == other.value;
    }

    bool operator!=(const BigInt &other) const
    {
        return value != other.value;
    }

    bool operator>(const BigInt &other) const
    {
        return value > other.value;
    }

    bool operator>=(const BigInt &other) const
    {
        return value >= other.value;
    }

    string toString() const
    {
        return value;
    }
};

int main()
{
    BigInt bigint1("123456789012345678901234567890");
    BigInt bigint2("987654321098765432109876543210");

    cout << (bigint1 < bigint2) << endl;  // true
    cout << (bigint1 <= bigint2) << endl; // true
    cout << (bigint1 == bigint2) << endl; // false
    cout << (bigint1 != bigint2) << endl; // true
    cout << (bigint1 > bigint2) << endl;  // false
    cout << (bigint1 >= bigint2) << endl; // false

    return 0;
}
