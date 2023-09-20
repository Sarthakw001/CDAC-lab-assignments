/*
 Given a string, return its length.
int Strlen(char s[]);
*/
#include <iostream>
using namespace std;

int strlen(char s[]);

int main()
{
    char s[1000];
    cout << "Enter the string" << endl;
    cin >> s;
    int ans = strlen(s);
    cout << "The length of string is : " << ans << endl;
    return 0;
}

int strlen(char s[])
{
    int i = 0;
    while (s[i] != '\0')
    {
        i++;
    }
    return i;
}
