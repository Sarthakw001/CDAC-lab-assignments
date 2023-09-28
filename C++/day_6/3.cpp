/*
Compare the two strings and return true if they are same else return false.
bool Compare(char s1[], char s2[]);
*/

#include <iostream>
using namespace std;

bool compare(char str1[], char str2[]);

int main()
{
    char str1[1000], str2[1000];
    cout << "Enter the Ist string" << endl;
    cin >> str1;
    cout << "Enter the 2nd string" << endl;
    cin >> str2;
    bool ans = compare(str1, str2);
    if (ans)
        cout << "Voila! strings are matched" << endl;
    else
        cout << "Strings don't match, try again" << endl;
    return 0;
}
bool compare(char str1[], char str2[])
{
    int i = 0;
    bool flag = true;
    while (1)
    {
        if (str1[i] == str2[i])
        {
            if (str1[i] == '\0')
                break;
            i++;
        }
        else
        {
            flag = false;
            break;
        }
    }
    return flag;
}