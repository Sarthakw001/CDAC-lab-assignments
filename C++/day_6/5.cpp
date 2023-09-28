/*
In the given string, convert all upper case chanracters to lower case.
void ToLower(char s[]);
*/

#include <iostream>
using namespace std;

void toLower(char s[]);

int main()
{
    char s[1000];
    cout << "Enter the string to convert to lower case" << endl;
    cin >> s;

    toLower(s);
    cout << "The new string is: " << s << endl;
    return 0;
}

void toLower(char s[])
{
    int i = 0;
    while (s[i] != '\0')
    {
        if (s[i] >= 'A' && s[i] <= 'Z')
            s[i] = s[i] + 32;
        i++;
    }
}