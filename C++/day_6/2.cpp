/*

Copy the source string "src" into destination string "dest".
void StrCpy(char dest[], char src[]);
*/

#include <iostream>
using namespace std;

void strcpy(char dest[], char src[]);

int main()
{
    char src[1000], dest[1000];
    cout << "Enter the source string" << endl;
    cin >> src;
    strcpy(dest,src);
    cout << "The copied string is : " << dest << endl;
    return 0;
}

void strcpy(char dest[],char src[])
{
    int i=0;
    while(src[i]!='\0'){
        dest[i] = src[i];
        i++;
    }
}
