#include <bits/stdc++.h>
using namespace std;

void swap(int &, int &);
void swap(double &, double &);
void swap(char &, char &);

int main()
{
    cout << "1 to swap integers" << endl;
    cout << "2 to swap decimals" << endl;
    cout << "3 to swap characters" << endl;
    int choice;
    cin >> choice;

    if (choice == 1)
    {
        int a, b;
        cout << "Enter 2 integers to swap" << endl;
        cin >> a >> b;
        swap(a, b);
        cout << "Ist: " << a << " 2nd: " << b << endl;
    }
    else if (choice == 2)
    {
        double c, d;
        cout << "Enter 2 decimals to swap" << endl;
        cin >> c >> d;
        swap(c, d);
        cout << "Ist: " << c << " 2nd: " << d << endl;
    }
    else if (choice == 3)
    {
        char e, f;
        cout << "Enter 2 character to swap" << endl;
        cin >> e >> f;
        swap(e, f);
        cout << "Ist: " << e << " 2nd: " << f << endl;
    }
    else
        cout << "Invalid Choice" << endl;
}

void swap(int &num1, int &num2)
{
    num1 = num1 + num2;
    num2 = num1 - num2;
    num1 = num1 - num2;
}

void swap(double &num1, double &num2)
{
    double temp = num2;
    num2 = num1;
    num1 = temp;
}

void swap(char &a, char &b)
{
    char temp = b;
    b = a;
    a = temp;
}