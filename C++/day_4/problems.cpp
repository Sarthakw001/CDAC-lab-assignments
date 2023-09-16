#include <bits/stdc++.h>
using namespace std;

int reverse(int);
bool isPrime(int);

int reverse(int n)
{
    int ans = 0;
    while (n != 0)
    {
        int a = n % 10;
        ans = ans * 10 + a;
        n = n / 10;
    }
    return ans;
}

bool isPrime(int n)
{
    if (n == 1)
        return false;
    if (n == 2)
        return true;
    for (int i = 2; i <= n / 2; i++)
    {
        if (n % i == 0)
            return false;
    }
    return true;
}

int main()
{

    cout << "Please Select your choice " << endl;
    cout << "1 to reverse the number" << endl;
    cout << "2 to find the prime numbers between 2 numbers" << endl;
    cout << "3 to check whether the number is palindrome or not!" << endl;
    int choice;
    cin >> choice;

    if (choice == 1)
    {
        int num;
        cout << "Enter the number to reverse it" << endl;
        cin>>num;
        int ans = reverse(num);
        cout << "The reversed number is : " << ans << endl;
    }
    else if (choice == 2)
    {
        int first, second;
        cout << "Enter the 2 numbers to find the primes between them" << endl;
        cin >> first >> second;
        cout << "the numbers are : ";
        for (int i = first; i <= second; i++)
        {
            if (isPrime(i))
            {
                cout << i << " ";
            }
        }
        cout << endl;
    }
    else if (choice == 3)
    {
        int n;
        cout << "Enter the number to check whether its palindrome or not" << endl;
        cin >> n;
        int ans = reverse(n);
        if (ans == n)
            cout << "Voila! It's a Palindrome" << endl;
        else
            cout << "Nope It's not palindrome" << endl;
    }
    else
        cout << "Incorrect choice" << endl;

    return 0;
}
