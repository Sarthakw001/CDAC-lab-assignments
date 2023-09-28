/*
In the given string, convert all lower case chanracters to upper case.
void ToUpper(char s[]);
*/

#include <iostream>
using namespace std;

void ToUpper(char s[]);

int main()
{
    char s[1000];
    cout << "Enter the string to convert to upper case" << endl;
    cin >> s;

    ToUpper(s);
    cout << "The new string is: " << s << endl;
    return 0;
}

void ToUpper(char s[])
{
    int i = 0;
    while (s[i] != '\0')
    {
        if (s[i] >= 'a' && s[i] <= 'z')
            s[i] = s[i] - 32;
        i++;
    }
}